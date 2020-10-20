package com.oocl.cultivation;

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

    //TODO : might as well use stream API
//    parkingLots
//            .stream()
//            .filter(parkingLot1 -> parkingLot1.containsTicket(ticket))
//            .findFirst()
//                .orElseThrow(() -> new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET))
//            .fetch(ticket);
    //method containsTicket -> ticketCarMap.containsKey(ticket);

    public Automobile fetch(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Automobile automobile = parkingLot.fetch(parkingTicket);
            if (automobile != null) {
                return automobile;
            }
        }
        throw new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET);
    }

}
