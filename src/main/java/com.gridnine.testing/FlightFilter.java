package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightFilter {
    private final List<Flight> flights;

    public FlightFilter(final List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> filter(Predicate<Flight>... predicate) {
        Optional<Predicate<Flight>> allPredicates = Arrays.stream(predicate).reduce(Predicate::and);
        return allPredicates
                .map(flightPredicate -> flights.stream()
                        .filter(flightPredicate)
                        .collect(Collectors.toList()))
                .orElse(flights);
    }
}
