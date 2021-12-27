package com.github.iahrari.pricingservice.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class PriceDTO {
    @NotBlank
    private String source;
    @NotBlank
    private String destination;
    private BigDecimal price;
    
    public PriceDTO(String source, String destination, BigDecimal price){
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public String getSource(){
        return source;
    }

    public String getDestination(){
        return destination;
    }

    public BigDecimal getPrice(){
        return price;
    }
}