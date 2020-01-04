package com.real.athletic.index.device.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO class file for DeviceMapping
 * 
 * @author Aathitya Prabu A S
 *
 */

public class DeviceMappingDTO implements Serializable {

	private static final long serialVersionUID = 1455913985434415363L;

	private String oid;

	private String deviceId;

	private String playerOid;

	private String status;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

	private String createdBy;

	private String updatedBy;

	private Boolean deleted;

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
	 * @return the playerOid
	 */
	public String getPlayerOid() {
		return playerOid;
	}

	/**
	 * @param playerOid the playerOid to set
	 */
	public void setPlayerOid(String playerOid) {
		this.playerOid = playerOid;
	}

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

	@Override
	public String toString() {
		return "DeviceMapping [oid=" + oid + ", deviceId=" + deviceId + ", playerOid=" + playerOid + ", status="
				+ status + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", deleted=" + deleted + "]";
	}

}
