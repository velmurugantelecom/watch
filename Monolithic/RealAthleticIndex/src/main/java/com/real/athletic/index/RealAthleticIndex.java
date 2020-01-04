package com.real.athletic.index;
/**
 * 
 * Main class for Real Athletic index project
 * @author Aathitya Prabu A S
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = { "com.real.athletic.index.users.repository","com.real.athletic.index.feed.details.repository"
		,"com.real.athletic.index.device.repository"})
public class RealAthleticIndex {

	private static final Logger logger = LoggerFactory.getLogger(RealAthleticIndex.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(RealAthleticIndex.class);
		ConfigurableApplicationContext applicationContext = app.run(args);
		Environment env = applicationContext.getEnvironment();
		logger.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}\n\t"
						+ "External: \thttp://{}:{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));

		String configServerStatus = env.getProperty("configserver.status");
		String status = null;
		if (configServerStatus == null) {
			status = "Not found or not setup for this application";
		} else {
			status = configServerStatus;
		}
		logger.info("\n----------------------------------------------------------\n\t"
				+ "Config Server: \t{}\n----------------------------------------------------------", status);
	}
}
