package com.energyusage.service;

import com.energyusage.model.Price;

import java.util.List;

public interface PriceService {
    Price createPrice(Price price);
    List<Price> getPrice();
    void deletePrice();
}
