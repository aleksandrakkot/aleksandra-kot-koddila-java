package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    private Map<String, Boolean> flightMap;

    public FlightSearch() {
        flightMap = new HashMap<>();
        flightMap.put("Warszawa", true);
        flightMap.put("Kraków", true);
        flightMap.put("Gdańsk", false);
        flightMap.put("Wrocław", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String arrivalAirport = flight.getArrivalAirport();
        Boolean isAirportAvailable = flightMap.get(arrivalAirport);
        if (isAirportAvailable == null) {
            throw new RouteNotFoundException("Brak lotów do lotniska: " + arrivalAirport);
        } else if (!isAirportAvailable) {
            throw new RouteNotFoundException("Brak możliwości lotu do lotniska: " + arrivalAirport);
        } else {
            System.out.println("Znaleziono lot do lotniska: " + arrivalAirport);
        }
    }

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Warszawa", "Radom");

        try {
            flightSearch.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
