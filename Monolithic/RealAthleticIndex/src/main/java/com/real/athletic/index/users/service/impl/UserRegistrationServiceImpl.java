package com.real.athletic.index.users.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.athletic.index.constant.RealAIConstants;
import com.real.athletic.index.device.dto.DeviceMappingDTO;
import com.real.athletic.index.device.service.DeviceMappingService;
import com.real.athletic.index.exception.utils.BusinessException;
import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;
import com.real.athletic.index.feed.details.service.FeedDetailsService;
import com.real.athletic.index.mqtt.service.MqttService;
import com.real.athletic.index.rest.template.service.RestTemplateService;
import com.real.athletic.index.users.dto.UserInterestsDTO;
import com.real.athletic.index.users.model.UserInterests;
import com.real.athletic.index.users.repository.UserRegistrationRepository;
import com.real.athletic.index.users.service.UserInterestsService;
import com.real.athletic.index.users.service.UserRegistrationService;

/**
 * UserRegistrationServiceImpl for userRegistration and free news feed with
 * device input and sports interest
 * 
 * 
 * @author Aathitya Prabu A S
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private final Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

	@Autowired
	private UserRegistrationRepository userRepository;

	@Autowired
	private UserInterestsService userInterestsService;

	@Autowired
	private DeviceMappingService deviceMappingService;

	@Autowired
	private FeedDetailsService feedDetailsService;

	@Autowired
	private RestTemplateService template;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MqttService mqttService;

	@Value("${mqtt.broker-url}")
	private String mqttBrokerUrl;

	@Value("${mqtt.client.qos}")
	private String mqttClientQos;

	@Value("${mqtt.topic.subscription}")
	private String mqttTopicSubscription;

	@Override
	public UserInterestsDTO saveUserInterest(UserInterestsDTO userInterestsDTO) {
		logger.info("Start UserRegistrationServiceImpl saveUserInterest");
		UserInterests userInterests = new UserInterests();
		userInterests.setDeviceId(userInterestsDTO.getDeviceId());
		userInterests.setInterestedSports(String.join(",",
				String.valueOf(userInterestsDTO.getInterestedSportsList()).replace("[", "").replace("]", "")));
		userInterests.setCreatedOn(LocalDateTime.now());
		userInterests.setUpdatedOn(LocalDateTime.now());
		userInterests.setDeleted(true);
		UserInterests newUserInterests = userInterestsService.saveUserInterest(userInterests);
		BeanUtils.copyProperties(newUserInterests, userInterestsDTO);
		userInterestsDTO.setMqttBrokerUrl(mqttBrokerUrl);
		userInterestsDTO.setMqttClientQos(mqttClientQos);
		String topicToPublish = mqttTopicSubscription.concat("/").concat(userInterestsDTO.getDeviceId());
		userInterestsDTO.setMqttTopicSubscription(topicToPublish);
		//
		DeviceMappingDTO deviceMappingDTO = deviceMappingService.findOneByDeviceId(userInterestsDTO.getDeviceId());
		// FeedAllFeedDeatils based on category
		List<FeedDetailsDTO> feedDeatilsDTOList = feedDetailsService
				.getAllFeedDetailsByCategory(userInterestsDTO.getInterestedSports(), deviceMappingDTO);

		mqttService.sendFeedDetails(feedDeatilsDTOList, topicToPublish);
		return userInterestsDTO;
	}

	@SuppressWarnings("unchecked")
	public boolean otpSendStatus(String decryptOTP, String mobileNumber) {
		try {
			String otpSession = template.sendOTPSMS(decryptOTP, mobileNumber);
			Map<String, String> otpJson;
			Map<String, String> verifyOtpJson;
			otpJson = mapper.readValue(otpSession, Map.class);
			if (otpJson.containsKey(RealAIConstants.DETAILS)) {
				String sendOtpverification = template.verifyOTPSMS(decryptOTP, otpJson.get(RealAIConstants.DETAILS));
				verifyOtpJson = mapper.readValue(sendOtpverification, Map.class);
				if (verifyOtpJson.containsKey(RealAIConstants.STATUS)) {
					if (verifyOtpJson.get(RealAIConstants.STATUS).equalsIgnoreCase(RealAIConstants.SUCCESS)) {
						return true;
					} else {
						throw new BusinessException(RealAIConstants.OTP_MISMATCH);
					}
				}
			} else {
				throw new BusinessException(RealAIConstants.OTP_NOT_SENT);
			}

		} catch (IOException exception) {
			throw new BusinessException(RealAIConstants.OTP_NOT_SENT);
		}
		return false;
	}

}
