package com.github.iahrari.pricingservice.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.iahrari.pricingservice.dto.Price;
import com.github.iahrari.pricingservice.exception.PriceRequestFieldsException;

import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {
    private final List<String> addresses = Arrays.asList(
        "Vanak", "Azadi", "Tehran Pars", "Shohada"
    );

    @Override
    public Price getPrice(String source, String destination) {
        if(ifAnyEquals(source, destination, addresses.get(0)) 
                    && ifAnyEquals(source, destination, addresses.get(1))) {
            return new Price(source, destination, BigDecimal.valueOf(1500d));
        } else if(ifAnyEquals(source, destination, addresses.get(0)) 
                    && ifAnyEquals(source, destination, addresses.get(2))) {
            return new Price(source, destination, BigDecimal.valueOf(2000d));
        } else if(ifAnyEquals(source, destination, addresses.get(1)) 
                    && ifAnyEquals(source, destination, addresses.get(2))) {
            return new Price(source, destination, BigDecimal.valueOf(1000d));
        } else if(ifAnyEquals(source, destination, addresses.get(2)) 
                    && ifAnyEquals(source, destination, addresses.get(3))) {
            return new Price(source, destination, BigDecimal.valueOf(1900d));
        } else if(ifAnyEquals(source, destination, addresses.get(3)) 
                    && ifAnyEquals(source, destination, addresses.get(1))) {
            return new Price(source, destination, BigDecimal.valueOf(2600d));
        } else if(ifAnyEquals(source, destination, addresses.get(3)) 
                    && ifAnyEquals(source, destination, addresses.get(0))) {
            return new Price(source, destination, BigDecimal.valueOf(3000d));
        } else {
            throw checkWrongFields(source, destination);
        }
    }

    private boolean ifAnyEquals(String source, String destination, String target) {
        return source.equalsIgnoreCase(target) || destination.equalsIgnoreCase(target);
    }

    private PriceRequestFieldsException checkWrongFields(String source, String destination) {
        Map<String, String> fields = new HashMap<>();
        var isSourceValid = addresses.stream()
            .allMatch(address -> !source.equalsIgnoreCase(address));
        if(isSourceValid) 
            fields.put("source", source);

        var isDestinationValid = addresses.stream()
            .allMatch(address -> !destination.equalsIgnoreCase(address));

        if(isDestinationValid) 
            fields.put("destination", destination);

        if(source.equalsIgnoreCase(destination)) {
            fields.put("source", source);
            fields.put("destination", destination);
        }
        
        return new PriceRequestFieldsException(fields);
    }
    
}
