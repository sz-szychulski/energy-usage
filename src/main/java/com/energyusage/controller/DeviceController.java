package com.energyusage.controller;

import com.energyusage.model.Device;
import com.energyusage.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String showIndex(ModelMap model) {
        model.addAttribute("deviceList", deviceService.getAllDevices());
        model.addAttribute("usage", deviceService.calculateUsage());
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDevice(ModelMap model) {
        return "add";
    }

    @RequestMapping(value = "/added", method = RequestMethod.POST)
    public String added(@RequestParam("name") String name,
                        @RequestParam("energy_consumption") int energy_consumption,
                        @RequestParam("time") int time,
                        ModelMap model) {
        Device device = new Device(name, energy_consumption, time);
        deviceService.createDevice(device);
        return "redirect:/device/" + device.getId();
    }


    @RequestMapping(value = "/device/{id}", method = RequestMethod.GET)
    public String showDevice(@PathVariable("id") Long id, ModelMap model){
        Device device = deviceService.getDevice(id);
        model.addAttribute("id", device.getId());
        model.addAttribute("name", device.getName());
        model.addAttribute("energy_consumption", device.getEnergy_consumption());
        model.addAttribute("time", device.getTime());
        return "device";
    }

    @RequestMapping(value = "/delete_all", method = RequestMethod.GET)
    public String deleteDevices(ModelMap model){
        deviceService.deleteAllDevices();
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteDevice(@PathVariable("id") Long id, ModelMap model){
        Device device = deviceService.getDevice(id);
        deviceService.deleteDevice(device);
        return "redirect:/";
    }

}
