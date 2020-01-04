package com.real.athletic.index.feed.details.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.real.athletic.index.device.dto.DeviceMappingDTO;
import com.real.athletic.index.feed.details.dto.FeedDetailsDTO;
import com.real.athletic.index.feed.details.model.FeedDetails;
import com.real.athletic.index.feed.details.repository.FeedDetailsRepository;
import com.real.athletic.index.feed.details.service.FeedDetailsService;

@Service
public class FeedDetailsServiceImpl implements FeedDetailsService {

	private final Logger logger = LoggerFactory.getLogger(FeedDetailsServiceImpl.class);

	@Autowired
	private FeedDetailsRepository feedDetailsRepository;

	@Override
	public List<FeedDetailsDTO> getAllFeedDetailsByCategory(String interestedSports,
			DeviceMappingDTO deviceMappingDTO) {
		logger.info("Start FeedDetailsServiceImpl getAllFeedDetailsByCategory {}", interestedSports);
		List<FeedDetailsDTO> feedDetailsDTOList = new ArrayList<>();
		if (StringUtils.isNotEmpty(interestedSports)) {
			List<String> categoryList = new ArrayList<>();
			if (interestedSports.contains(",")) {
				categoryList = Arrays.asList(interestedSports.split(","));
			} else {
				categoryList.add(interestedSports);
			}
			PageRequest page = PageRequest.of(0, 100, Sort.by(Direction.DESC, "publishedDate"));
			List<FeedDetails> feedDetailsList = feedDetailsRepository.findAllByCategoryListAndParentOid(page,categoryList,
					deviceMappingDTO.getPlayerOid());
			if (CollectionUtils.isNotEmpty(feedDetailsList)) {
				feedDetailsList.stream().filter(Objects::nonNull).forEach(feeds -> {
					FeedDetailsDTO feedDetailsDTO = new FeedDetailsDTO();
					BeanUtils.copyProperties(feeds, feedDetailsDTO);
					feedDetailsDTOList.add(feedDetailsDTO);
				});
			} else {
				logger.error("No feed is avaiable for an category {}", interestedSports);
			}
		}
		return feedDetailsDTOList;
	}

	@Override
	public FeedDetails saveFeedDetails(FeedDetails feedDetails) {
		return feedDetailsRepository.save(feedDetails);
	}

}
