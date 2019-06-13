package com.energyusage.controller;

import com.energyusage.model.Device;
import com.energyusage.model.Price;
import com.energyusage.service.DeviceService;
import com.energyusage.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    PriceService priceService;

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public String showIndex(ModelMap model) {
        model.addAttribute("deviceList", deviceService.getAllDevices());
        model.addAttribute("usage", deviceService.calculateUsage());

        if (priceService.getPrice().size() > 0) {
            model.addAttribute("price", priceService.getPrice().get(0).getPriceValue());
        }
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
        return "redirect:/";
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

    @RequestMapping(value = "modify/{id}", method = RequestMethod.GET)
    public String modifyDevice(@PathVariable("id") Long id, ModelMap model){
        Device device = deviceService.getDevice(id);
        model.addAttribute("name", device.getName());
        model.addAttribute("energy_consumption", device.getEnergy_consumption());
        model.addAttribute("time", device.getTime());
        return "modify";
    }

    @RequestMapping(value = "modified/{id}", method = RequestMethod.POST)
    public String modified(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("energy_consumption") int energy_consumption,
                           @RequestParam("time") int time,
                           ModelMap model){
        Device device = deviceService.getDevice(id);
        device.setName(name);
        device.setEnergy_consumption(energy_consumption);
        device.setTime(time);
        deviceService.editDevice(device);
        return "redirect:/";
    }

    @RequestMapping(value = "set_price", method = RequestMethod.POST)
    public String setPrice(@RequestParam("price") Double priceValue,
                           ModelMap model) {
        priceService.deletePrice();
        Price price = new Price(priceValue);
        priceService.createPrice(price);
        return "redirect:/";
    }

}
