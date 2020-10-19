package com.oocl.cultivation;

import exceptions.NoParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    private Map<ParkingTicket, Automobile> ticketCarMap;
    private double capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.ticketCarMap = new HashMap<>();
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
        this.ticketCarMap = new HashMap<>();
    }

    ParkingTicket park(Automobile automobile) {
        ParkingTicket parkingTicket = new ParkingTicket();
        ticketCarMap.put(parkingTicket, automobile);
        return parkingTicket;
    }

    Automobile fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("No Parking Ticket!");
        }

        Automobile automobile = ticketCarMap.get(parkingTicket);
        ticketCarMap.remove(parkingTicket);
        return automobile;
    }

    boolean isParkingLotFull() {
        return ticketCarMap.size() < capacity;
    }

    public double getParkingLotCapacity() {
        return capacity - ticketCarMap.size();
    }

    double getPositionRate() {
        return (capacity - ticketCarMap.size()) / capacity;
    }

}
