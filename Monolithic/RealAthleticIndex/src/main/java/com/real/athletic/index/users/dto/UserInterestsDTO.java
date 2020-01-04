package com.real.athletic.index.users.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DTO layer file for UserInterests
 * 
 * @author Aathitya Prabu A S
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInterestsDTO implements Serializable {

	private static final long serialVersionUID = 1124001765236273072L;

	private String oid;

	private String deviceId;

	private String interestedSports;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

	private String createdBy;

	private String updatedBy;

	private String deviceCategory;

	private Boolean deleted;

	private String mqttBrokerUrl;

	private String mqttClientQos;

	private String mqttTopicSubscription;

	private List<Object> interestedSportsList;

	/**
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the interestedSports
	 */
	public String getInterestedSports() {
		return interestedSports;
	}

	/**
	 * @param interestedSports the interestedSports to set
	 */
	public void setInterestedSports(String interestedSports) {
		this.interestedSports = interestedSports;
	}

	/**
	 * @return the createdOn
	 */
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the deviceCategory
	 */
	public String getDeviceCategory() {
		return deviceCategory;
	}

	/**
	 * @param deviceCategory the deviceCategory to set
	 */
	public void setDeviceCategory(String deviceCategory) {
		this.deviceCategory = deviceCategory;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the mqttBrokerUrl
	 */
	public String getMqttBrokerUrl() {
		return mqttBrokerUrl;
	}

	/**
	 * @param mqttBrokerUrl the mqttBrokerUrl to set
	 */
	public void setMqttBrokerUrl(String mqttBrokerUrl) {
		this.mqttBrokerUrl = mqttBrokerUrl;
	}

	/**
	 * @return the mqttClientQos
	 */
	public String getMqttClientQos() {
		return mqttClientQos;
	}

	/**
	 * @param mqttClientQos the mqttClientQos to set
	 */
	public void setMqttClientQos(String mqttClientQos) {
		this.mqttClientQos = mqttClientQos;
	}

	/**
	 * @return the mqttTopicSubscription
	 */
	public String getMqttTopicSubscription() {
		return mqttTopicSubscription;
	}

	/**
	 * @param mqttTopicSubscription the mqttTopicSubscription to set
	 */
	public void setMqttTopicSubscription(String mqttTopicSubscription) {
		this.mqttTopicSubscription = mqttTopicSubscription;
	}

	/**
	 * @return the interestedSportsList
	 */
	public List<Object> getInterestedSportsList() {
		return interestedSportsList;
	}

	/**
	 * @param interestedSportsList the interestedSportsList to set
	 */
	public void setInterestedSportsList(List<Object> interestedSportsList) {
		this.interestedSportsList = interestedSportsList;
	}

	@Override
	public String toString() {
		return "UserInterestsDTO [oid=" + oid + ", deviceId=" + deviceId + ", interestedSports=" + interestedSports
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", deviceCategory=" + deviceCategory + ", deleted=" + deleted + "]";
	}

}
