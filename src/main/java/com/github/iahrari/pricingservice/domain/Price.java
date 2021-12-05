package com.github.iahrari.pricingservice.domain;

public class Price {
    private String source;
    private String destination;
    private Double price;
    
    public Price(String source, String destination, Double price){
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

    public Double getPrice(){
        return price;
    }
}