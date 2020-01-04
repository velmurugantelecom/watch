package com.real.athletic.index.users.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "real_user")
public class Users implements Serializable {

	private static final long serialVersionUID = 8752553615176300576L;

	@Id
	@Column(name = "oid")
	private String oid;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "club_oid")
	private String clubOid;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "geo_code")
	private String geoCode;

	@Column(name = "dob")
	private LocalDateTime dateOfBirth;

	@Column(name = "sex")
	private String sex;

	@Column(name = "height")
	private Double height;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "identification_mark")
	private String identificationMark;

	@Column(name = "identification_position")
	private String identificationPosition;

	@Column(name = "proof_type")
	private String proofType;

	@Column(name = "proof_id")
	private String proofId;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "social_media_id")
	private String socialMediaId;

	@Column(name = "social_media_type")
	private String socialMediaType;

	@Column(name = "password")
	private String loginKey;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@Column(name = "current_designation")
	private String currentDesignation;

	@Column(name = "coach_oid")
	private String coachOid;

	@Column(name = "user_status")
	private String userStatus;

	@Column(name = "deleted")
	private Boolean deleted;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getClubOid() {
		return clubOid;
	}

	public void setClubOid(String clubOid) {
		this.clubOid = clubOid;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getGeoCode() {
		return geoCode;
	}

	public void setGeoCode(String geoCode) {
		this.geoCode = geoCode;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getIdentificationMark() {
		return identificationMark;
	}

	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}

	public String getIdentificationPosition() {
		return identificationPosition;
	}

	public void setIdentificationPosition(String identificationPosition) {
		this.identificationPosition = identificationPosition;
	}

	public String getProofType() {
		return proofType;
	}

	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	public String getProofId() {
		return proofId;
	}

	public void setProofId(String proofId) {
		this.proofId = proofId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSocialMediaId() {
		return socialMediaId;
	}

	public void setSocialMediaId(String socialMediaId) {
		this.socialMediaId = socialMediaId;
	}

	public String getSocialMediaType() {
		return socialMediaType;
	}

	public void setSocialMediaType(String socialMediaType) {
		this.socialMediaType = socialMediaType;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public String getCoachOid() {
		return coachOid;
	}

	public void setCoachOid(String coachOid) {
		this.coachOid = coachOid;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Users [oid=" + oid + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", clubOid=" + clubOid + ", userType="
				+ userType + ", geoCode=" + geoCode + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", height="
				+ height + ", weight=" + weight + ", identificationMark=" + identificationMark
				+ ", identificationPosition=" + identificationPosition + ", proofType=" + proofType + ", proofId="
				+ proofId + ", fatherName=" + fatherName + ", socialMediaId=" + socialMediaId + ", socialMediaType="
				+ socialMediaType + ", loginKey=" + loginKey + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", currentDesignation=" + currentDesignation
				+ ", coachOid=" + coachOid + ", userStatus=" + userStatus + ", deleted=" + deleted + "]";
	}

}
