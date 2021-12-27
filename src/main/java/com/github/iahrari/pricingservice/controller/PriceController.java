package com.github.iahrari.pricingservice.controller;

import javax.validation.Valid;

import com.github.iahrari.pricingservice.dto.PriceDTO;
import com.github.iahrari.pricingservice.service.PriceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    
    @PostMapping
    public ResponseEntity<PriceDTO> getPrice(@Valid @RequestBody PriceDTO price) {
        return ResponseEntity.ok(priceService.getPrice(
            price.getSource(), price.getDestination()));
    } 
}
