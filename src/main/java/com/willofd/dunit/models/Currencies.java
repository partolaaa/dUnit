package com.willofd.dunit.models;

import lombok.RequiredArgsConstructor;

/**
 * @author Ivan Partola
 */
@RequiredArgsConstructor
public enum Currencies {
    UAH("UAH"),
    USD("USD"),
    PLN("PLN");

    private final String currency;

    public String getValue() {
        return currency;
    }
}
