package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class FilterDepartureBeforeNow implements Predicate<Flight> {
    private  final LocalDateTime now;
    public FilterDepartureBeforeNow() {
        now = LocalDateTime.now();
    }

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(now));
    }
}
