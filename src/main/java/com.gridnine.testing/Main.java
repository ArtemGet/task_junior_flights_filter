package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights);
        //Фильруем вылеты до текущего момента времени
        System.out.println(new FlightFilter(flights).filter(new FilterDepartureBeforeNow()));

        //Фильтруем вылеты содержащие сегменты с датой прилета раньше даты ввылета
        System.out.println(new FlightFilter(flights).filter(new FilterArrivalBeforeDeparture()));

        //Фильтруем вылеты с общим временем пересадок более двух часов
        System.out.println(new FlightFilter(flights).filter(new FilterLongTransferTime()));

    }
}
