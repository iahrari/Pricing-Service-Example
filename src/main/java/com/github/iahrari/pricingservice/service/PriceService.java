package com.github.iahrari.pricingservice.service;

import com.github.iahrari.pricingservice.dto.Price;

public interface PriceService {
    Price getPrice(String source, String destination);
}
