package com.oocl.cultivation;

import exceptions.NoParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private Map<ParkingTicket, Car> ticketCarMap;
    private double capacity;

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

        if (parkingTicket == null) {
            throw new NoParkingTicketException("No Parking Ticket!");
        }
        return carTicket;
    }

    boolean isParkingLotFull() {
        return ticketCarMap.size() < capacity;
    }

    public double getParkingLotCapacity() {
        return capacity - ticketCarMap.size();
    }

    public double getPositionRate() {
        return (capacity - ticketCarMap.size()) / capacity;
    }

}
