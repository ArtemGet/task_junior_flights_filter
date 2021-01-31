package com.gridnine.testing;

import java.time.Duration;
import java.util.function.Predicate;

public class FilterLongTransferTime implements Predicate<Flight> {

    @Override
    public boolean test(Flight flight) {
        Duration res = Duration.ZERO;
        for (int i = 0; i < flight.getSegments().size() - 1; i++) {
            res = res.plus(Duration.between(
                    flight.getSegments().get(i).getArrivalDate()
                    , flight.getSegments().get(i + 1).getDepartureDate()));
        }
        return res.toHours() <= 2;
    }

}
