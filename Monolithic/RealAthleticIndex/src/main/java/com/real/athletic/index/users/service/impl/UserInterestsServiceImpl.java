package com.real.athletic.index.users.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.athletic.index.users.model.UserInterests;
import com.real.athletic.index.users.repository.UserInterestsRepository;
import com.real.athletic.index.users.service.UserInterestsService;

@Service
public class UserInterestsServiceImpl implements UserInterestsService {

	private final Logger logger = LoggerFactory.getLogger(UserInterestsServiceImpl.class);

	@Autowired
	UserInterestsRepository userInterestsRepository;

	@Override
	public UserInterests saveUserInterest(UserInterests userInterests) {
		logger.info("Start to save UserInterestsRepository saveUserInterest");
		return userInterestsRepository.save(userInterests);
	}

}
