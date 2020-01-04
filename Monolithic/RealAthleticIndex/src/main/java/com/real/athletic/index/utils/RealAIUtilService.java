package com.real.athletic.index.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;

import com.real.athletic.index.constant.RealAIConstants;

/**
 * RealAIUtilService frame the api request and response JSON standard structure
 * 
 * @author Aathitya Prabu A S
 *
 */
public class RealAIUtilService {

	private RealAIUtilService() {

	}

	public static Map<String, Object> errorJson(HttpStatus responseCode, boolean status, Response responses) {
		Map<String, Object> map = new HashMap<>();
		map.put(RealAIConstants.STATUS, status);
		map.put(RealAIConstants.RESPONSECODE, responseCode.value());
		map.put(RealAIConstants.RESPONSE, responses);
		return map;
	}

	public static Map<String, Object> successJsonList(List<?> dataList) {
		Map<String, Object> map = new HashMap<>();
		map.put(RealAIConstants.STATUS, true);
		map.put(RealAIConstants.RESPONSECODE, RealAIConstants.STATUS_200);
		Map<String, Object> response = new HashMap<>();
		response.put(RealAIConstants.DATA_RESPONSE, dataList.toArray());
		map.put(RealAIConstants.RESPONSE, (Object) response);
		return map;
	}

	public static Map<String, Object> successJsonArray(Object[] dataArray) {
		Map<String, Object> map = new HashMap<>();
		map.put(RealAIConstants.STATUS, true);
		map.put(RealAIConstants.RESPONSECODE, RealAIConstants.STATUS_200);
		Map<String, Object> response = new HashMap<>();
		response.put(RealAIConstants.DATA_RESPONSE, dataArray);
		map.put(RealAIConstants.RESPONSE, (Object) response);
		return map;
	}

	public static Map<String, Object> successJson(Object dataList) {
		Map<String, Object> map = new HashMap<>();
		map.put(RealAIConstants.STATUS, true);
		map.put(RealAIConstants.RESPONSECODE, RealAIConstants.STATUS_200);
		Map<String, Object> response = new HashMap<>();
		response.put(RealAIConstants.DATA_RESPONSE, dataList);
		map.put(RealAIConstants.RESPONSE, (Object) response);
		return map;
	}

	public static Map<String, Map<String, Object>> successMessage(String message) {
		Map<String, Map<String, Object>> dataResponse = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		map.put(RealAIConstants.STATUS, RealAIConstants.STATUS_OK);
		map.put(RealAIConstants.MESSAGE, message);
		dataResponse.put(RealAIConstants.DATA_RESPONSE, map);
		return dataResponse;
	}

	/**
	 * to generate one time password
	 * 
	 * @return String
	 */
	public static String generateOTP() {
		Random rand = new Random();
		int randomPin = rand.nextInt(10000);
		return String.valueOf(randomPin);
	}
}
