package com.oocl.cultivation;

import exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.ticketCarMap = new HashMap<>();
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.ticketCarMap = new HashMap<>();
    }

    ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        ticketCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    Car fetch(ParkingTicket parkingTicket) {
        Car carTicket;
        carTicket = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);

        if (carTicket == null) {
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket!");
        }
        return carTicket;
    }

    boolean isParkingLotFull() {
        return ticketCarMap.size() >= capacity;
    }

}
