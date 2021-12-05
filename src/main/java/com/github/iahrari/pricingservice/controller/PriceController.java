package com.github.iahrari.pricingservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.iahrari.pricingservice.controller.exception.QueryException;
import com.github.iahrari.pricingservice.domain.Price;
import com.github.iahrari.pricingservice.domain.QueryError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final List<String> addresses = Arrays.asList("Vanak", "Azadi", "Tehran Pars", "Shohada");
    
    @GetMapping
    public Price getPrice(@RequestParam String source, @RequestParam String destination) {
        if(ifAnyEquals(source, destination, addresses.get(0)) 
                    && ifAnyEquals(source, destination, addresses.get(1))) {
            return new Price(source, destination, 1500d);
        } else if(ifAnyEquals(source, destination, addresses.get(0)) 
                    && ifAnyEquals(source, destination, addresses.get(2))) {
            return new Price(source, destination, 2000d);
        } else if(ifAnyEquals(source, destination, addresses.get(1)) 
                    && ifAnyEquals(source, destination, addresses.get(2))) {
            return new Price(source, destination, 1000d);
        } else if(ifAnyEquals(source, destination, addresses.get(2)) 
                    && ifAnyEquals(source, destination, addresses.get(3))) {
            return new Price(source, destination, 1900d);
        } else if(ifAnyEquals(source, destination, addresses.get(3)) 
                    && ifAnyEquals(source, destination, addresses.get(1))) {
            return new Price(source, destination, 2600d);
        } else if(ifAnyEquals(source, destination, addresses.get(3)) 
                    && ifAnyEquals(source, destination, addresses.get(0))) {
            return new Price(source, destination, 3000d);
        } else {
            throw checkWrongFields(source, destination);
        } 
    }

    private boolean ifAnyEquals(String source, String destination, String target) {
        return source.equalsIgnoreCase(target) || destination.equalsIgnoreCase(target);
    }

    private QueryException checkWrongFields(String source, String destination) {
        List<String> fields = new ArrayList<>();
            List<String> values = new ArrayList<>();
            var isSourceValid = addresses.stream()
                .allMatch(address -> !source.equalsIgnoreCase(address));
            if(isSourceValid) {
                fields.add("source");
                values.add(source);
            }

            var isDestinationValid = addresses.stream()
                .allMatch(address -> !destination.equalsIgnoreCase(address));

            if(isDestinationValid) {
                fields.add("destination");
                values.add(destination);
            }
            return new QueryException(new QueryError(fields, values));
    }
}
