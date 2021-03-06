package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    static final String NOT_ENOUGH_POSITION = "Not Enough Position!";
    static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized Parking Ticket!";

    public ParkingBoy(ParkingLot... parkingLot) {
            this.parkingLots = Arrays.asList(parkingLot);
        }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Automobile automobile) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(ParkingLot::isParkingLotFull)
                .findFirst()
                .orElseThrow(() -> new NotEnoughPositionException(NOT_ENOUGH_POSITION));
        return parkingLot.park(automobile);
    }

    public Automobile fetch(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new NoParkingTicketException("No Parking Ticket!");
        }
        return parkingLots
            .stream()
            .filter(parkingLot1 -> parkingLot1.containsTicket(parkingTicket))
            .findFirst()
            .orElseThrow(() -> new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET))
            .fetch(parkingTicket);
    }

}
