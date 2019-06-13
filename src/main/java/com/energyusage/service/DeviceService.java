package com.energyusage.service;

import com.energyusage.model.Device;

import java.util.List;

public interface DeviceService {
    Device createDevice(Device device);
    Device editDevice(Device device);
    Device getDevice(Long id);
    void deleteDevice(Device device);
    List<Device> getAllDevices();
    void deleteAllDevices();
    double calculateUsage();
}
