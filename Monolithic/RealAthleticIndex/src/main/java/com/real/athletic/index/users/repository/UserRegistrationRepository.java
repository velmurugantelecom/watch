package com.real.athletic.index.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.real.athletic.index.users.model.Users;

@Repository
public interface UserRegistrationRepository extends JpaRepository<Users, String> {

	@Query("FROM Users users WHERE users.oid=:id")
	Users findOneById(@Param("id") String id);
}
