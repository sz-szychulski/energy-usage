package com.energyusage.model;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    public Price() {
    }

    public Price(double priceValue) {
        this.priceValue = priceValue;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "price_value")
    private double priceValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(double priceValue) {
        this.priceValue = priceValue;
    }
}
