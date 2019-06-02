package com.energyusage.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "devices")
public class Device {

    public Device() {

    }

    public Device(@NotEmpty(message = "*Please provide name of device") String name,
                  @NotEmpty(message = "*Please provide energy consumption of device") int energy_consumption,
                  @NotEmpty(message = "*Please provide time of device usage") int time) {
        this.name = name;
        this.energy_consumption = energy_consumption;
        this.time = time;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name of device")
    private String name;

    @Column(name = "energy_consumption")
    @Min(1)
    private int energy_consumption;

    @Column(name = "time")
    @Min(1)
    private int time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy_consumption() {
        return energy_consumption;
    }

    public void setEnergy_consumption(int energy_consumption) {
        this.energy_consumption = energy_consumption;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
