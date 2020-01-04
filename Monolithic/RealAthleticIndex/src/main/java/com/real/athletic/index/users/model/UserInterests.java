package com.real.athletic.index.users.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * model class file for UserInterests
 * 
 * @author Aathitya Prabu A S
 *
 */
@Entity
@Table(name = "user_interests")
public class UserInterests implements Serializable {

	private static final long serialVersionUID = 6617854842920812326L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "oid")
	private String oid;

	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "interested_sports")
	private String interestedSports;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "device_category")
	private String deviceCategory;

	@Column(name = "deleted")
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

}
