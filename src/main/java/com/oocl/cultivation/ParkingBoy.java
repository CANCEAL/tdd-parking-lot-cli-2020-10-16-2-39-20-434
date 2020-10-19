package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;

import java.util.Collections;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public final String NOT_ENOUGH_POSITION = "Not Enough Position!";
    public final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized Parking Ticket!";

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = Collections.singletonList(parkingLot);
    }

    public List<ParkingLot> getParkingLot() {
        return this.parkingLots;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Automobile automobile) {
        ParkingLot parkingLot = parkingLots.stream().filter(ParkingLot::isParkingLotFull).findFirst().orElse(null);

        if (parkingLot == null) {
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION);
        }
        return parkingLot.park(automobile);
    }

    public Automobile fetch(ParkingTicket parkingTicket) {
        Automobile automobile = getCarFromParkingLots(parkingTicket);
        if (automobile == null) {
            throw new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET);
        }
        return automobile;
    }

    public Automobile getCarFromParkingLots(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.fetch(parkingTicket);
        }
        return null;
    }
}
