package com.real.athletic.index.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.athletic.index.users.dto.UserInterestsDTO;
import com.real.athletic.index.users.service.UserRegistrationService;
import com.real.athletic.index.utils.RealAIUtilService;

/**
 * UserRegistrationController controller layer where user related api will be
 * invoked
 * 
 * @author Aathitya Prabu A S
 *
 */
@RestController
@RequestMapping("/users")
public class UserRegistrationController {

	private final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private UserRegistrationService userRegistrationService;

	@PostMapping(value = "/saveUserInterest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "X-API-VERSION=1")
	public ResponseEntity<Map<String, Object>> saveUserInterest(
			@NonNull @RequestBody UserInterestsDTO userInterestsDtos) {
		logger.info("Start UserRegistrationController saveUserInterests {}", userInterestsDtos);
		UserInterestsDTO userInterestsDTO = userRegistrationService.saveUserInterest(userInterestsDtos);
		logger.info("End UserRegistrationController saveUserInterests ");
		return ResponseEntity.status(HttpStatus.OK).body(RealAIUtilService.successJson(userInterestsDTO));
	}

}
