package com.real.athletic.index.mqtt.mapper;

import com.google.gson.Gson;
import com.real.athletic.index.mqtt.payload.FeedDetailsPayload;

/**
 * 
 * builds the json request for the java object received from ui/scheduler. Uses
 * gson for parsing the json response.
 * 
 * @author Aathitya Prabu A S
 *
 */
public class MqttRequestMapper {

	private MqttRequestMapper() {

	}

	public static String readJsonFromFeedDetailsObject(FeedDetailsPayload payloadFeedDetails) {
		Gson gson = new Gson();
		return gson.toJson(payloadFeedDetails);
	}

}
