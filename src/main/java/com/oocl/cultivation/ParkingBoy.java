package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.UnrecognizedParkingTicketException;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        return parkingLot.isParkingLotFull() ? null : parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("Unrecognized Parking Ticket!");
        } else {
            return parkingLot.fetch(parkingTicket);
        }
    }

}
