package com.real.athletic.index.scheduler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.real.athletic.index.constant.RealAIConstants;
import com.real.athletic.index.feed.details.model.Feed;
import com.real.athletic.index.feed.details.model.FeedDetails;
import com.real.athletic.index.feed.details.model.FeedMessage;
import com.real.athletic.index.feed.details.model.RSSFeedParser;
import com.real.athletic.index.feed.details.service.FeedDetailsService;

@Component
public class FeedReaderScheduler {

	private static final Logger logger = LoggerFactory.getLogger(FeedReaderScheduler.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	private FeedDetailsService feedDetailsService;

	@Scheduled(fixedDelay = 1800000)
	public void scheduleTaskWithFixedDelay() {
		logger.error("RssFeedReaderScheduler Starts >>>ExecutionTime - {}",
				dateTimeFormatter.format(LocalDateTime.now()));
		String[] feedUrls = { "https://www.thestar.com.my/rss/pSport/Badminton",
				"https://www.thestar.com.my/rss/Sport/Football", "https://www.thestar.com.my/rss/Sport/Golf" };
		for (String feedUrl : feedUrls) {
			readExtractAndSaveRssFeeds(feedUrl);
		}
	}

	private void readExtractAndSaveRssFeeds(String feedUrl) {
		RSSFeedParser feedParser = new RSSFeedParser(feedUrl);
		Feed feed = feedParser.readFeed();
		List<FeedMessage> feedMsgs = feed.getMessages();
		for (FeedMessage feedMsg : feedMsgs) {
			logger.error("Updated feedMsg Title>>>>{}", feedMsg.getTitle());
			FeedDetails feedDetails = new FeedDetails();
			feedDetails.setParentOid("p001p001");
			feedDetails.setTitle(feedMsg.getTitle());
			feedDetails.setMediaContent(feedMsg.getMediaContent());
			feedDetails.setRssFeedSource(feedParser.getUrl().getHost());
			feedDetails.setRssFeedUrl(feedParser.getUrl().getHost() + feedParser.getUrl().getPath());
			feedDetails.setRssFeedLanguage(feed.getLanguage());
			feedDetails.setRssVersion("2.0");
			feedDetails.setCategory(
					feedParser.getUrl().getPath().substring(feedParser.getUrl().getPath().lastIndexOf("/") + 1,
							feedParser.getUrl().getPath().length()).toUpperCase());
			feedDetails.setDescription(feedMsg.getDescription());
			feedDetails.setClientDetails("");
			feedDetails.setPublishedDate(new Timestamp(System.currentTimeMillis()));
			feedDetails.setStatus(RealAIConstants.ACT);
			feedDetailsService.saveFeedDetails(feedDetails);
		}
	}
}
