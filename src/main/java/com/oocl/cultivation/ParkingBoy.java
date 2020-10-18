package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> parkingBoys;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = Collections.singletonList(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        this.parkingLots = parkingLots;
        this.parkingBoys = parkingBoys;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().filter(ParkingLot -> ParkingLot.isParkingLotFull()).findFirst().orElse(null);

        if (parkingLot == null) {
            throw new NotEnoughPositionException("Not Enough Position!");
        }
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = getCarFromParkingLots(parkingTicket);
        if (car == null) {
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket!");
        }
        return car;
    }

    public Car getCarFromParkingLots(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.fetch(parkingTicket);
        }
        return null;
    }
}
