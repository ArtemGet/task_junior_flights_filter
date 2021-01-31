package com.gridnine.testing;

import java.util.function.Predicate;

public class FilterArrivalBeforeDeparture implements Predicate<Flight> {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }
}
