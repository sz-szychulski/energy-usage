package com.energyusage.service;

import com.energyusage.model.Device;
import com.energyusage.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device createDevice(Device device) {
       return deviceRepository.save(device);
    }

    @Override
    public Device getDevice(Long id) {
        return deviceRepository.getOne(id);
    }

    @Override
    public Device editDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(Device device) {
        deviceRepository.delete(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public long countDevices() {
        return deviceRepository.count();
    }

    @Override
    public void deleteAllDevices() {
        deviceRepository.deleteAll();
    }

    @Override
    public double calculateUsage() {
        double sum = 0;
        for (Device device : getAllDevices()) {
            int energy_consumption = device.getEnergy_consumption();
            double time = device.getTime();
            sum = sum + energy_consumption * (time * 1/60) / 1000;
        }
        return sum;
    }
}
