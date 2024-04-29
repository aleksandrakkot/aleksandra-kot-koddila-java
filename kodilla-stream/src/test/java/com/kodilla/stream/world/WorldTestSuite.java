package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        // Given
        List<Country> europeCountries = new ArrayList<>();
        europeCountries.add(new Country(new BigDecimal("1000000")));
        europeCountries.add(new Country(new BigDecimal("2000000")));
        europeCountries.add(new Country(new BigDecimal("1500000")));

        List<Country> asiaCountries = new ArrayList<>();
        asiaCountries.add(new Country(new BigDecimal("5000000")));
        asiaCountries.add(new Country(new BigDecimal("3000000")));

        List<Continent> continents = new ArrayList<>();
        continents.add(new Continent(europeCountries));
        continents.add(new Continent(asiaCountries));

        World world = new World(continents);

        // When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        // Then
        assertEquals(new BigDecimal("12500000"), totalPopulation);
    }
}