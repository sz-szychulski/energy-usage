package com.energyusage.service;

import com.energyusage.model.Price;
import com.energyusage.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public List<Price> getPrice() {
        return priceRepository.findAll();
    }

    @Override
    public void deletePrice() {
        priceRepository.deleteAll();
    }

}
