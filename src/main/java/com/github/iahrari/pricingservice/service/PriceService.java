package com.github.iahrari.pricingservice.service;

import com.github.iahrari.pricingservice.dto.PriceDTO;

public interface PriceService {
    PriceDTO getPrice(String source, String destination);
}
