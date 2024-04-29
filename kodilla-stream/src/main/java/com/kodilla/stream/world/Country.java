package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final BigDecimal peopleQuantity;

    public Country(BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }
}