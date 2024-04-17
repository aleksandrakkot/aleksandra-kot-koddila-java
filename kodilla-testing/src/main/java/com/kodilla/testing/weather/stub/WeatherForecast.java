package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        if (temps.isEmpty()) return 0;
        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }
        return sum / temps.size();
    }

    public double calculateMedianTemperature() {
        List<Double> temps = new ArrayList<>(temperatures.getTemperatures().values());
        if (temps.isEmpty()) return 0;
        Collections.sort(temps);
        int size = temps.size();
        if (size % 2 == 0) {
            return (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2.0;
        } else {
            return temps.get(size / 2);
        }
    }
}