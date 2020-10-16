package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.NotEnoughPositionException;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (parkingLot.isParkingLotFull()) {
            throw new NotEnoughPositionException("Not Enough Position!");
        } else {
            return parkingLot.park(car);
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("No Parking Ticket!");
        } else {
            return parkingLot.fetch(parkingTicket);
        }
    }

}
