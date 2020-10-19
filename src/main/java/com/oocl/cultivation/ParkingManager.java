package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    List<ParkingBoy> parkingBoys;
    //private final String NOT_ENOUGH_POSITION = "Not Enough Position!";
    //private final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized Parking Ticket!";

    public ParkingManager(ParkingLot parkingLot) {
        super(parkingLot);
        parkingBoys = new ArrayList<>();
    }

    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingBoys = new ArrayList<>();
    }

    public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public ParkingTicket park(ParkingBoy parkingBoy, Automobile automobile) {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.park(automobile);
        }
        throw new NotEnoughPositionException(NOT_ENOUGH_POSITION);
    }

    public Automobile fetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.fetch(parkingTicket);
        }
        throw new NotEnoughPositionException(UNRECOGNIZED_PARKING_TICKET);
    }
}
