package com.real.athletic.index.feed.details.service;

import java.util.List;

import com.real.athletic.index.device.dto.DeviceMappingDTO;
import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;
import com.real.athletic.index.feed.details.model.FeedDetails;

/**
 * Interface layer for FeedDetailsService
 * 
 * @author Aathitya Prabu A S
 *
 */
public interface FeedDetailsService {

	List<FeedDetailsDTO> getAllFeedDetailsByCategory(String interestedSports, DeviceMappingDTO deviceMappingDTO);

	FeedDetails saveFeedDetails(FeedDetails feedDetails);

}
