package main.java.datastructures.graph;

import java.util.*;

public class CurrencyExchange {

    static class ExchangeRate {
        String source, target;
        double rate;

        public ExchangeRate(String source, String target, double rate) {
            this.source = source;
            this.target = target;
            this.rate = rate;
        }
    }

    public static double findHighestExchangeRate(String baseCurrency, String targetCurrency, List<ExchangeRate> exchangeRates, Set<String> currencies) {
        // Step 1: Initialize the exchange rates with -1 for all currencies
        Map<String, Double> maxRates = new HashMap<>();

        // Set the base currency exchange rate to 1 (since we start from there)
        maxRates.put(baseCurrency, 1.0);

        // Step 2: Relax edges (exchange rates) N-1 times, where N is the number of currencies
        for (int i = 0; i < currencies.size() - 1; i++) {
            boolean updated = false;
            for (ExchangeRate rate : exchangeRates) {
                // Relax the edge: check if we can improve the exchange rate to the target
                if (maxRates.containsKey(rate.source)) {
                    double newRate = maxRates.get(rate.source) * rate.rate;
                    if (newRate > maxRates.getOrDefault(rate.target, 0.0)) {
                        maxRates.put(rate.target, newRate);
                        updated = true;
                    }
                }
            }
            if (!updated) {
                break; // Stop if no updates occur in an iteration
            }
        }

        // Step 3: Return the exchange rate to the target currency
        return maxRates.getOrDefault(targetCurrency, -1.0);
    }

    public static void main(String[] args) {


        // List to store exchange rate data
        List<ExchangeRate> exchangeRates = List.of(
                new ExchangeRate("A", "B", 5.0),
                new ExchangeRate("A", "C", 1.0),
                new ExchangeRate("B", "D", 2.0),
                new ExchangeRate("C", "E", 20.0),
                new ExchangeRate("D", "E", 1),
                new ExchangeRate("D", "B", 1)
        );

        // Set to store all unique currencies
        Set<String> currencies = Set.of("A", "B", "C", "D", "E");

        // Finding the highest exchange rate from baseCurrency to targetCurrency
        double result = findHighestExchangeRate("A", "E", exchangeRates, currencies);

        // Output the result rounded to 5 decimal places
        System.out.printf("%.5f\n", result);
    }
}
