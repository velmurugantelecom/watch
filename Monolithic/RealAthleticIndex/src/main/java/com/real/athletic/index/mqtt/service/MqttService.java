package com.real.athletic.index.mqtt.service;

import java.util.List;

import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;

/**
 * interface for MqttService
 * 
 * @author Aathitya Prabu A S
 *
 */

public interface MqttService {

	void sendFeedDetails(List<FeedDetailsDTO> feedDeatilsDTOList, String mqttTopicSubscription);

}
