package com.real.athletic.index.mqtt.payload;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;

/**
 * represents the payload sent to mqtt for FeedDetailsPayload
 * 
 * @author Aathitya Prabu A S
 *
 */
public class FeedDetailsPayload implements Serializable {

	private static final long serialVersionUID = -7182546209511966054L;

	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("status")
	private String status;

	@JsonInclude(Include.NON_EMPTY)
	@JsonProperty("data")
	private List<FeedDetailsDTO> data;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public List<FeedDetailsDTO> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<FeedDetailsDTO> data) {
		this.data = data;
	}

}
