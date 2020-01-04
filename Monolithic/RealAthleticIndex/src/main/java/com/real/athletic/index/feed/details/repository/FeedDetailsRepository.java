package com.real.athletic.index.feed.details.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.real.athletic.index.feed.details.model.FeedDetails;

@Repository
public interface FeedDetailsRepository extends JpaRepository<FeedDetails, String> {

	@Query("FROM FeedDetails feed WHERE feed.category in (:categoryList) and feed.parentOid=:parentOid")
	List<FeedDetails> findAllByCategoryListAndParentOid(Pageable pageable,
			@Param("categoryList") List<String> categoryList, @Param("parentOid") String parentOid);

}
