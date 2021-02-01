package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilderTesting extends FlightBuilder {
    private static Flight createNormalFlight(LocalDateTime threeDaysFromNow) {
        //A normal flight with two hour duration
        return createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    }

    private static Flight createNormalMultiSegmentFlight(LocalDateTime threeDaysFromNow) {
        //A normal multi segment flight
        return createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5));
    }

    private static Flight createFlightDepartingInPast(LocalDateTime threeDaysFromNow) {
        //A flight departing in the past
        return createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow);
    }

    private static Flight createFlightArrivalBeforeDeparture(LocalDateTime threeDaysFromNow) {
        //A flight that departs before it arrives
        return createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6));
    }

    private static Flight createFlightLongGroundTime(LocalDateTime threeDaysFromNow) {
        //A flight with more than two hours ground time
        return createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6));
    }

    private static Flight createAnotherFlightLongGroundTime(LocalDateTime threeDaysFromNow) {
        //Another flight with more than two hours ground time
        return createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7));
    }

    static List<Flight> createFlights(LocalDateTime now) {
        final LocalDateTime threeDaysFromNow = now.plusDays(3);
        return Arrays.asList(
                createNormalFlight(threeDaysFromNow),
                createNormalMultiSegmentFlight(threeDaysFromNow),
                createFlightDepartingInPast(threeDaysFromNow),
                createFlightArrivalBeforeDeparture(threeDaysFromNow),
                createFlightLongGroundTime(threeDaysFromNow),
                createAnotherFlightLongGroundTime(threeDaysFromNow)
        );
    }

    static List<Flight> createFlightsWithoutDepartureBeforeNow(LocalDateTime now) {
        final LocalDateTime threeDaysFromNow = now.plusDays(3);
        return Arrays.asList(
                createNormalFlight(threeDaysFromNow),
                createNormalMultiSegmentFlight(threeDaysFromNow),
                createFlightArrivalBeforeDeparture(threeDaysFromNow),
                createFlightLongGroundTime(threeDaysFromNow),
                createAnotherFlightLongGroundTime(threeDaysFromNow));
    }

    static List<Flight> createFlightsWithoutArrivalBeforeDeparture(LocalDateTime now) {
        final LocalDateTime threeDaysFromNow = now.plusDays(3);
        return Arrays.asList(
                createNormalFlight(threeDaysFromNow),
                createNormalMultiSegmentFlight(threeDaysFromNow),
                createFlightDepartingInPast(threeDaysFromNow),
                createFlightLongGroundTime(threeDaysFromNow),
                createAnotherFlightLongGroundTime(threeDaysFromNow));
    }

    static List<Flight> createFlightsWithoutLongTransferTime(LocalDateTime now) {
        final LocalDateTime threeDaysFromNow = now.plusDays(3);
        return Arrays.asList(
                createNormalFlight(threeDaysFromNow),
                createNormalMultiSegmentFlight(threeDaysFromNow),
                createFlightDepartingInPast(threeDaysFromNow),
                createFlightArrivalBeforeDeparture(threeDaysFromNow));
    }

    static List<Flight> createNormalFlights(LocalDateTime now) {
        final LocalDateTime threeDaysFromNow = now.plusDays(3);
        return Arrays.asList(
                createNormalFlight(threeDaysFromNow),
                createNormalMultiSegmentFlight(threeDaysFromNow));
    }
}
