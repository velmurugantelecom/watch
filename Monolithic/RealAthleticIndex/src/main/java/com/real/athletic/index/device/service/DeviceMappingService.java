package com.real.athletic.index.device.service;

import com.real.athletic.index.device.dto.DeviceMappingDTO;

public interface DeviceMappingService {

	DeviceMappingDTO findOneByDeviceId(String deviceId);

}
