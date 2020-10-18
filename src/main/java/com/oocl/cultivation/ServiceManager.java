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
}
