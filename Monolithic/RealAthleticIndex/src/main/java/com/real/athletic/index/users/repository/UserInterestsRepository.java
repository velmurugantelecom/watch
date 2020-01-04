package com.real.athletic.index.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.athletic.index.users.model.UserInterests;

@Repository
public interface UserInterestsRepository extends JpaRepository<UserInterests, String> {

}
