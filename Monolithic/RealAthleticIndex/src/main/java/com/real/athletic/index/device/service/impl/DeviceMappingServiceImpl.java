package com.real.athletic.index.device.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.athletic.index.device.dto.DeviceMappingDTO;
import com.real.athletic.index.device.model.DeviceMapping;
import com.real.athletic.index.device.repository.DeviceMappingRepository;
import com.real.athletic.index.device.service.DeviceMappingService;

@Service
public class DeviceMappingServiceImpl implements DeviceMappingService {

	private final Logger logger = LoggerFactory.getLogger(DeviceMappingServiceImpl.class);

	@Autowired
	DeviceMappingRepository deviceMappingRepository;

	@Override
	public DeviceMappingDTO findOneByDeviceId(String deviceId) {
		logger.info("Start DeviceMappingServiceImpl findOneByDeviceId {} ", deviceId);
		DeviceMappingDTO deviceMappingDTO = new DeviceMappingDTO();
		if (Objects.nonNull(deviceId)) {
			DeviceMapping deviceMapping = deviceMappingRepository.findOneByDeviceId(deviceId);
			if (Objects.nonNull(deviceMapping)) {
				BeanUtils.copyProperties(deviceMapping, deviceMappingDTO);
			} else {
				logger.error("Device mapping deatils not found for {}", deviceId);
			}
		}
		return deviceMappingDTO;
	}

}
