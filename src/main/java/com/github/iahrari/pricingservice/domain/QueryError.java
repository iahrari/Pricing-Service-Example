package com.github.iahrari.pricingservice.domain;

import java.util.List;

public class QueryError {
    private List<String> fields;
    private List<String> values;

    public QueryError(List<String> fields, List<String> values) {
        this.fields = fields;
        this.values = values;
    }

    public List<String> getField() {
        return fields;
    }

    public List<String> getValue() {
        return values;
    }
}
