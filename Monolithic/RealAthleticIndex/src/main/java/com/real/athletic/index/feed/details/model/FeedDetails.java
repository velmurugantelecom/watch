package com.real.athletic.index.feed.details.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * model class file for FeedDetails
 * 
 * @author Aathitya Prabu A S
 *
 */
@Entity
@Table(name = "feed_details")
public class FeedDetails implements Serializable {

	private static final long serialVersionUID = -2499056848804990575L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "oid")
	private String oid;

	@Column(name = "parent_oid")
	private String parentOid;

	@Column(name = "rss_feed_source")
	private String rssFeedSource;

	@Column(name = "rss_feed_url")
	private String rssFeedUrl;

	@Column(name = "rss_version")
	private String rssVersion;

	@Column(name = "rss_feed_language")
	private String rssFeedLanguage;

	@Column(name = "category")
	private String category;

	@Column(name = "description")
	private String description;

	@Column(name = "client_details")
	private String clientDetails;

	@Column(name = "published_date")
	private Timestamp publishedDate;

	@Column(name = "status")
	private String status;

	@Column(name = "deleted")
	private Boolean deleted;

	@Column(name = "title")
	private String title;

	@Column(name = "mediaContent")
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the publishedDate
	 */
	public Timestamp getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
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
		return "FeedDetails [oid=" + oid + ", parentOid=" + parentOid + ", rssFeedSource=" + rssFeedSource
				+ ", rssFeedUrl=" + rssFeedUrl + ", rssVersion=" + rssVersion + ", rssFeedLanguage=" + rssFeedLanguage
				+ ", category=" + category + ", description=" + description + ", clientDetails=" + clientDetails
				+ ", publishedDate=" + publishedDate + ", status=" + status + ", deleted=" + deleted + "]";
	}

}
