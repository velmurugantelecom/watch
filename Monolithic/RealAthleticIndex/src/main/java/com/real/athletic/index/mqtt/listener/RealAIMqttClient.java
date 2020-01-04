package com.real.athletic.index.mqtt.listener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.inject.Inject;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.real.athletic.index.constant.RealAIConstants;

/**
 * provides method to get mqttclient for processReceived message and subscribe
 * 
 * @author Aathitya Prabu A S
 *
 */
@Component
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application-${spring.profiles.active}.properties")
public class RealAIMqttClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(RealAIMqttClient.class);
	private static final String MESSAGE = "started publishing the content to the topic  {} with the message {}";
	private static final String MESSAGE1 = "content has been published to the topic";
	private static final String ERROR_MSG = "Error while publishing to mqtt broker for the topic :: ";
	private static MqttClient mqttClient = null;
	private static String brokerUrl;
	private static String clientId;
	private static boolean started = false;
	private static int connectionTimeout;
	private static int aliveInterval;
	private static int qos;
	private static boolean connectionLost = false;
	private static String caFilePath;
	private static String clientCrtFilePath;
	private static String clientKeyFilePath;
	private static boolean sslEnable;

	@Inject
	RealAIMqttClient(@Value("${mqtt.broker-url}") final String bUrl, @Value("${mqtt.client-id}") final String client,
			@Value("${mqtt.client.connection.timeout}") final int timeout,
			@Value("${mqtt.client.alive.interval}") final int alive, @Value("${mqtt.client.qos}") final int qosVal,
			@Value("${mqtt.cacert.path}") final String caCert,
			@Value("${mqtt.client.cert.path}") final String clientCert,
			@Value("${mqtt.client.key.path}") final String clientKey, @Value("${ssl.enable}") final boolean sslEnable) {
		brokerUrl = bUrl;
		clientId = client;
		connectionTimeout = timeout;
		aliveInterval = alive;
		qos = qosVal;
		caFilePath = caCert;
		clientCrtFilePath = clientCert;
		clientKeyFilePath = clientKey;
		this.sslEnable = sslEnable;
		mqttClient = getMqttClient();
		subscribe();
	}

	RealAIMqttClient() {

	}

	public static boolean getConnectionLostDetails() {
		return connectionLost;
	}

	/**
	 * returns mqttclient instance for the subscriber and publisher for the broker
	 * and random clientId
	 * 
	 * @return {@link MqttAsynClient}
	 * @throws InterruptedException
	 */
	public static MqttClient getMqttClient() {
		LOGGER.info("Started connecting to MQTT client");
		try {
			mqttClient = new MqttClient(brokerUrl, clientId, new MemoryPersistence());
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(false);
			connOpts.setAutomaticReconnect(true);
			connOpts.setConnectionTimeout(connectionTimeout);
			connOpts.setKeepAliveInterval(aliveInterval);
			connOpts.setMaxInflight(60);
			// connOpts.setWill()
			if (sslEnable) {
				SSLSocketFactory socketFactory = getSocketFactory(caFilePath, clientCrtFilePath, clientKeyFilePath, "");
				connOpts.setSocketFactory(socketFactory);
			}

			mqttClient.setCallback(new MqttCallbackExtended() {
				@Override
				public void connectionLost(Throwable cause) {
					connectionLost = true;
					LOGGER.info("Connection to the broker has been lost {} ", cause.getMessage());
					if (started) {
						/*
						 * try { token = mqttClient.checkPing(null, new IMqttActionListener() {
						 * 
						 * @Override public void onSuccess(IMqttToken asyncActionToken) {
						 * LOGGER.info("AsyncActionToken:: {} ", asyncActionToken);
						 * 
						 * }
						 * 
						 * @Override public void onFailure(IMqttToken asyncActionToken, Throwable
						 * exception) { LOGGER.info("Check Ping is failed {} ", exception);
						 * 
						 * } }); } catch (MqttException e) {
						 * LOGGER.error("Error while doing checkping to mqtt :{} ", e.getMessage());
						 * errorLogService.addErrorLog(IBMSUtilService.buildErrorLog(IBMSCommonUtils.
						 * SOURCE_MQTT, e)); }
						 * 
						 * if (Objects.nonNull(token)) { getMqttClient(); subscribe(); }
						 */
					}

				}

				/**
				 * called when the message arrived from the server to the subscriber
				 */
				@Override
				public void messageArrived(String topic, MqttMessage message) throws Exception {
					LOGGER.info("Message received for the topic :{} with message {}", topic, message);

					processReceivedMessage(topic, message);
					LOGGER.info("Arrived message has been successfully processed and persisted");

				}

				/**
				 * Called when a outgoing publish is complete
				 * 
				 */
				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					LOGGER.info(MESSAGE1);
				}

				@Override
				public void connectComplete(boolean reconnect, String serverURI) {
					if (reconnect) {
						subscribe();
						connectionLost = false;
					}
				}
			});
			mqttClient.connect(connOpts);
			started = true;
			LOGGER.info("Mqtt Client has been connected");
		} catch (MqttException me) {
			LOGGER.error("Error while connecting to mqtt broker : {} ", me.getMessage());
			StringBuilder builder = new StringBuilder();
			StackTraceElement[] trace = me.getStackTrace();
			for (StackTraceElement traceElement : trace)
				builder.append(traceElement + "\n");
			LOGGER.error("Error {} while connecting to broker with reasoncode {} ", builder, me.getReasonCode());

		} catch (Exception e) {
			LOGGER.error("Exception Occured while loading the cert files {}", e);
		}

		return mqttClient;
	}

	/**
	 * @param topic
	 * @param message
	 * @throws MqttException
	 */
	private static void processReceivedMessage(String topic, MqttMessage message) {
//		try {
		// processReceivedMessage logic have to implement
//			if (MqttConstants.TOPIC_ERROR.concat("/").concat(clientId).equalsIgnoreCase(topic)) {
//				mqttService.getAndSaveCetusError(new String(message.getPayload()));
//			}
//
//			else {
//				LOGGER.error("Message received from message broker is not valid. Please check.. ");
//
//			}
//		} catch (MqttException me) {
//			LOGGER.error(ERROR_MSG, topic + "::", me.getMessage());
//			StringBuilder builder = new StringBuilder();
//			StackTraceElement[] trace = me.getStackTrace();
//			for (StackTraceElement traceElement : trace)
//				builder.append(traceElement + "\n");
//			LOGGER.error("Error {} while processsing the input payload{} ", builder, me.getReasonCode());

//		}
	}

	/**
	 * publishes the message to the given topic
	 * 
	 * @param topic
	 * @param outMsg
	 */
	public static void publish(String topic, String outMsg) {
		LOGGER.info("started publishing the content to the topic  {} with the message {} ", topic, outMsg);
		MqttMessage message = new MqttMessage(outMsg.getBytes());
		message.setQos(qos);
		try {
			mqttClient.publish(topic, message);
		} catch (MqttException e) {
			LOGGER.error(ERROR_MSG, topic + "::", e.getMessage());
			StringBuilder builder = new StringBuilder();
			StackTraceElement[] trace = e.getStackTrace();
			for (StackTraceElement traceElement : trace)
				builder.append(traceElement + "\n");
			LOGGER.error("Error {} while publishing to broker with reasoncode {} ", builder, e.getReasonCode());

		}
		LOGGER.info(MESSAGE1);
	}

	public static void subscribe() {
		LOGGER.info("started subscribing to the topic");
		// try {
		// mqttClient.subscribe(MqttConstants.TOPIC_DISCOVER_ALL.concat("/").concat(clientId),
		// qos);
		// mqttClient.subscribe(MqttConstants.TOPIC_ALARM_CALLBACK, qos);
//		} catch (MqttException me) {
//
//			LOGGER.error("Error while subscribing {} :::::: {} ", me.getMessage(), me.getReasonCode());
//			StringBuilder builder = new StringBuilder();
//			StackTraceElement[] trace = me.getStackTrace();
//			for (StackTraceElement traceElement : trace)
//				builder.append(traceElement + "\n");
//			LOGGER.error("Error {} while subscribing to broker with reasoncode {}", builder, me.getReasonCode());
//
//		}
	}

	private static SSLSocketFactory getSocketFactory(final String caCrtFile, final String crtFile, final String keyFile,
			final String password) throws IOException, CertificateException, KeyStoreException,
			NoSuchAlgorithmException, KeyManagementException, UnrecoverableKeyException {
		Security.addProvider(new BouncyCastleProvider());

		// load CA certificate
		X509Certificate caCert = null;
		X509Certificate cert = null;

		try (FileInputStream fis = new FileInputStream(caCrtFile);

				BufferedInputStream bis = new BufferedInputStream(fis)) {

			// An X.509 certificate is a digital certificate that uses the widely accepted
			// international X.509 public key infrastructure (PKI) standard to verify that a
			// public key belongs to the user, computer or service identity contained within
			// the certificate.
			CertificateFactory cf = CertificateFactory.getInstance(RealAIConstants.CERT_TYPE);

			while (bis.available() > 0) {
				caCert = (X509Certificate) cf.generateCertificate(bis);
			}

			// load client certificate
			try (BufferedInputStream bs = new BufferedInputStream(new FileInputStream(crtFile))) {

				while (bs.available() > 0) {
					cert = (X509Certificate) cf.generateCertificate(bs);
				}
			}
		}
		// load client private key
		KeyPair key;
		try (PEMParser pemParser = new PEMParser(new FileReader(keyFile))) {
			Object object = pemParser.readObject();
			PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
			JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(RealAIConstants.PROVIDER_NAME);

			if (object instanceof PEMEncryptedKeyPair) {
				LOGGER.info("Encrypted key - we will use provided password");
				key = converter.getKeyPair(((PEMEncryptedKeyPair) object).decryptKeyPair(decProv));
			} else {
				LOGGER.info("Unencrypted key - no password needed");
				key = converter.getKeyPair((PEMKeyPair) object);
			}
		}
		// CA certificate is used to authenticate server
		KeyStore caKs = KeyStore.getInstance(KeyStore.getDefaultType());
		caKs.load(null, null);
		caKs.setCertificateEntry(RealAIConstants.CA_CERTIFICATE, caCert);
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(RealAIConstants.TRUST_MANAGER_FACTORY);
		tmf.init(caKs);

		// client key and certificates are sent to server so it can authenticate
		// us
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		ks.load(null, null);
		ks.setCertificateEntry(RealAIConstants.CLIENT_CERTIFICATE, cert);
		ks.setKeyEntry(RealAIConstants.CLIENT_PRIVATE_KEY, key.getPrivate(), password.toCharArray(),
				new java.security.cert.Certificate[] { cert });
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		kmf.init(ks, password.toCharArray());

		// finally, create SSL socket factory
		SSLContext context = SSLContext.getInstance(RealAIConstants.TLS_VERSION);
		context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
		return context.getSocketFactory();
	}

	public static void sendFeedDetails(String outMsg, String topic) {
		LOGGER.info(MESSAGE, topic, outMsg);
		MqttMessage message = new MqttMessage(outMsg.getBytes());
		message.setQos(qos);
		message.setRetained(true);
		try {
			if (mqttClient != null && mqttClient.isConnected())
				mqttClient.publish(topic, message);
		} catch (MqttException e) {
			LOGGER.error(ERROR_MSG, topic + "::", e.getMessage());
		}
		LOGGER.info(MESSAGE1);
	}

}