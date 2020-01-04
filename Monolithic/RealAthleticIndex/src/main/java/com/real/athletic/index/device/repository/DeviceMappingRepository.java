package com.real.athletic.index.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.real.athletic.index.device.model.DeviceMapping;

@Repository
public interface DeviceMappingRepository extends JpaRepository<DeviceMapping, String> {

	@Query("FROM DeviceMapping device WHERE device.deviceId=:deviceId")
	DeviceMapping findOneByDeviceId(@Param("deviceId") String deviceId);

}
