package com.github.iahrari.pricingservice.exception;

import java.util.Map;


public class PriceRequestFieldsException extends RuntimeException {
    private final Map<String, String> fields;

    public PriceRequestFieldsException(Map<String, String> fields) {
        this.fields = fields;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
