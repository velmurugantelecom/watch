package com.real.athletic.index.rest.template.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.real.athletic.index.rest.template.service.RestTemplateService;

/**
 * Component layer for Rest template Communication between another jar through
 * Controller Level and also external api comminucation
 * 
 * @author Aathitya Prabu A S
 */

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

	private final Logger logger = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

	@Value("${otp.api.key}")
	private String otpApikey;

	@Value("${otp.send.url}")
	private String otpSendUrl;

	@Value("${otp.verify.url}")
	private String otpVerifyUrl;

	@Override
	public String sendOTPSMS(String otp, String mobileNumber) {
		logger.info("Start RestTemplateServiceImpl - getStringByHttpPostWithoutHeader,{}", otp);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = null;
		result = restTemplate.getForEntity(otpSendUrl, String.class, otpApikey, mobileNumber, otp);
		return result.getBody();
	}

	@Override
	public String verifyOTPSMS(String otp, String sessionId) {
		logger.info("Start RestTemplateServiceImpl - getStringByHttpPostWithoutHeader,{}", otp);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = null;
		result = restTemplate.getForEntity(otpVerifyUrl, String.class, otpApikey, sessionId, otp);
		return result.getBody();
	}
}
