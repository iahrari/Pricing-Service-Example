package com.github.iahrari.pricingservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.github.iahrari.pricingservice.dto.PriceDTO;
import com.github.iahrari.pricingservice.exception.PriceRequestFieldsException;

import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    private static final Map<String, Map<String, BigDecimal>> prices =
        Map.of(
            "vanak", Map.of(
                "azadi", BigDecimal.valueOf(500),
                "tehran pars", BigDecimal.valueOf(300),
                "shohada", BigDecimal.valueOf(400)
            ),
            "azadi", Map.of(
                "vanak", BigDecimal.valueOf(500),
                "tehran pars", BigDecimal.valueOf(700),
                "shohada", BigDecimal.valueOf(800)
            ),
            "tehran pars", Map.of(
                "vanak", BigDecimal.valueOf(300),
                "azadi", BigDecimal.valueOf(700),
                "shohada", BigDecimal.valueOf(1200)
            ),
            "shohada", Map.of(
                "vanak", BigDecimal.valueOf(400),
                "azadi", BigDecimal.valueOf(800),
                "tehran pars", BigDecimal.valueOf(1200)
            )
        );

    @Override
    public PriceDTO getPrice(String source, String destination) {
        var sourcePrices = prices.get(source.toLowerCase());
        if(sourcePrices != null) {
            var price = sourcePrices.get(destination.toLowerCase());
            if(price != null) 
                return new PriceDTO(source, destination, price);
        }

        throw checkWrongFields(source, destination);
    }

    private PriceRequestFieldsException checkWrongFields(String source, String destination) {
        Map<String, String> fields = new HashMap<>();
        var isSourceValid = prices.keySet().stream()
            .noneMatch(address -> source.equalsIgnoreCase(address));
        if(isSourceValid) 
            fields.put("source", source);

        var isDestinationValid = prices.keySet().stream()
            .noneMatch(address -> destination.equalsIgnoreCase(address));

        if(isDestinationValid) 
            fields.put("destination", destination);

        if(source.equalsIgnoreCase(destination)) {
            fields.put("source", source);
            fields.put("destination", destination);
        }
        
        return new PriceRequestFieldsException(fields);
    }
    
}
