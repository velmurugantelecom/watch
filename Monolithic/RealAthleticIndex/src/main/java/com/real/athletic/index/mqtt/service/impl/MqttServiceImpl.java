package com.real.athletic.index.mqtt.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.real.athletic.index.constant.RealAIConstants;
import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;
import com.real.athletic.index.mqtt.listener.RealAIMqttClient;
import com.real.athletic.index.mqtt.mapper.MqttRequestMapper;
import com.real.athletic.index.mqtt.payload.FeedDetailsPayload;
import com.real.athletic.index.mqtt.service.MqttService;

/**
 * 
 * implementation for MqttService interface, to process the json response
 * received from device team(AX box), convert the json to java object and
 * persist in database.
 * 
 * @author Aathitya Prabu A S
 */
@Service
public class MqttServiceImpl implements MqttService {

	private final Logger logger = LoggerFactory.getLogger(MqttServiceImpl.class);

	@Override
	public void sendFeedDetails(List<FeedDetailsDTO> feedDeatilsDTOList, String mqttTopicSubscription) {
		logger.info("Start MqttServiceImpl sendFeedDetails");

		RealAIMqttClient.sendFeedDetails(
				MqttRequestMapper.readJsonFromFeedDetailsObject(getPayloadFeedDetails(feedDeatilsDTOList)),
				mqttTopicSubscription);

	}

	private FeedDetailsPayload getPayloadFeedDetails(List<FeedDetailsDTO> feedDeatilsDTOList) {
		FeedDetailsPayload feedDeatilsPayload = new FeedDetailsPayload();
		feedDeatilsPayload.setStatus(RealAIConstants.STATUS_200);
		feedDeatilsPayload.setData(feedDeatilsDTOList);
		return feedDeatilsPayload;
	}

}
