package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class FlightFilterTest {

    @Test
    public void filterNone() {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightsExpected = FlightBuilderTesting.createFlights(now);
        List<Flight> flightsActual = new FlightFilter(FlightBuilderTesting.createFlights(now))
                .filter();
        assertEquals(flightsExpected.toString(), flightsActual.toString());
    }

    @Test
    public void filterDepartureBeforeNow() {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightsExpected = FlightBuilderTesting.createFlightsWithoutDepartureBeforeNow(now);
        List<Flight> flightsActual = new FlightFilter(FlightBuilderTesting.createFlights(now))
                .filter(new FilterDepartureBeforeNow());

        assertEquals(flightsActual.toString(), flightsExpected.toString());

    }

    @Test
    public void filterArrivalBeforeDeparture() {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightsExpected = FlightBuilderTesting
                .createFlightsWithoutArrivalBeforeDeparture(now);

        List<Flight> flightsActual = new FlightFilter(FlightBuilderTesting.createFlights(now))
                .filter(new FilterArrivalBeforeDeparture());

        assertEquals(flightsExpected.toString(), flightsActual.toString());
    }

    @Test
    public void filterLongTransferTime() {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightsExpected = FlightBuilderTesting
                .createFlightsWithoutLongTransferTime(now);

        List<Flight> flightsActual = new FlightFilter(FlightBuilderTesting.createFlights(now))
                .filter(new FilterLongTransferTime());

        assertEquals(flightsExpected.toString(), flightsActual.toString());
    }

    @Test
    public void filterByMultipleFilters() {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> flightsExpected = FlightBuilderTesting
                .createNormalFlights(now);

        List<Flight> flightsActual = new FlightFilter(FlightBuilderTesting.createFlights(now))
                .filter(new FilterLongTransferTime(), new FilterArrivalBeforeDeparture(), new FilterDepartureBeforeNow());

        assertEquals(flightsExpected.toString(), flightsActual.toString());
    }

}