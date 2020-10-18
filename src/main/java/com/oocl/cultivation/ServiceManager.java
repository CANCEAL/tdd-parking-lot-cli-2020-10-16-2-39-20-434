package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;

import java.util.List;

public class ServiceManager extends ParkingBoy{
    List<ParkingLot> parkingLots;
    List<ParkingBoy> parkingBoys;


    public ServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ServiceManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots, parkingBoys);
        this.parkingLots = parkingLots;
        this.parkingBoys = parkingBoys;
    }

    @Override
    public Car fetch(ParkingTicket parkingTicket) {
        Car car = getCarFromParkingLots(parkingTicket);
        if (car == null) {
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket!");
        }
        return car;
    }

    @Override
    public Car getCarFromParkingLots(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.fetch(parkingTicket);
        }
        return null;
    }
}
