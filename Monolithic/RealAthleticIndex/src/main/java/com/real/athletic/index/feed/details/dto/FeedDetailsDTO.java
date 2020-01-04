package com.real.athletic.index.feed.details.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * DTO layer file for FeedDetails
 * 
 * @author Aathitya Prabu A S
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedDetailsDTO implements Serializable {

	private static final long serialVersionUID = -7085726627783052182L;

	private String oid;

	private String parentOid;

	private String rssFeedSource;

	private String rssFeedUrl;

	private String rssVersion;

	private String rssFeedLanguage;

	private String category;

	private String description;

	private String clientDetails;

	private LocalDateTime publishedDate;

	private String status;

	private Boolean deleted;

	private String title;

	private String mediaContent;

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
	 * @return the parentOid
	 */
	public String getParentOid() {
		return parentOid;
	}

	/**
	 * @param parentOid the parentOid to set
	 */
	public void setParentOid(String parentOid) {
		this.parentOid = parentOid;
	}

	/**
	 * @return the rssFeedSource
	 */
	public String getRssFeedSource() {
		return rssFeedSource;
	}

	/**
	 * @param rssFeedSource the rssFeedSource to set
	 */
	public void setRssFeedSource(String rssFeedSource) {
		this.rssFeedSource = rssFeedSource;
	}

	/**
	 * @return the rssFeedUrl
	 */
	public String getRssFeedUrl() {
		return rssFeedUrl;
	}

	/**
	 * @param rssFeedUrl the rssFeedUrl to set
	 */
	public void setRssFeedUrl(String rssFeedUrl) {
		this.rssFeedUrl = rssFeedUrl;
	}

	/**
	 * @return the rssVersion
	 */
	public String getRssVersion() {
		return rssVersion;
	}

	/**
	 * @param rssVersion the rssVersion to set
	 */
	public void setRssVersion(String rssVersion) {
		this.rssVersion = rssVersion;
	}

	/**
	 * @return the rssFeedLanguage
	 */
	public String getRssFeedLanguage() {
		return rssFeedLanguage;
	}

	/**
	 * @param rssFeedLanguage the rssFeedLanguage to set
	 */
	public void setRssFeedLanguage(String rssFeedLanguage) {
		this.rssFeedLanguage = rssFeedLanguage;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the clientDetails
	 */
	public String getClientDetails() {
		return clientDetails;
	}

	/**
	 * @param clientDetails the clientDetails to set
	 */
	public void setClientDetails(String clientDetails) {
		this.clientDetails = clientDetails;
	}

	/**
	 * @return the publishedDate
	 */
	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the mediaContent
	 */
	public String getMediaContent() {
		return mediaContent;
	}

	/**
	 * @param mediaContent the mediaContent to set
	 */
	public void setMediaContent(String mediaContent) {
		this.mediaContent = mediaContent;
	}

	@Override
	public String toString() {
		return "FeedDetailsDTO [oid=" + oid + ", parentOid=" + parentOid + ", rssFeedSource=" + rssFeedSource
				+ ", rssFeedUrl=" + rssFeedUrl + ", rssVersion=" + rssVersion + ", rssFeedLanguage=" + rssFeedLanguage
				+ ", category=" + category + ", description=" + description + ", clientDetails=" + clientDetails
				+ ", publishedDate=" + publishedDate + ", status=" + status + ", deleted=" + deleted + ", title="
				+ title + ", mediaContent=" + mediaContent + "]";
	}

}
