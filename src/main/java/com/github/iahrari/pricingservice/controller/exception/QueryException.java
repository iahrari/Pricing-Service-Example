package com.github.iahrari.pricingservice.controller.exception;

import com.github.iahrari.pricingservice.domain.QueryError;

public class QueryException extends RuntimeException {
    private final QueryError error;

    public QueryException(QueryError error) {
        this.error = error;
    }

    public QueryError getError() {
        return error;
    }
}
