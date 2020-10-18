package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;

import java.util.List;

public class ServiceManager extends ParkingBoy{
    List<ParkingLot> parkingLots;
    List<ParkingBoy> parkingBoys;

    public ServiceManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots, parkingBoys);
        this.parkingLots = parkingLots;
        this.parkingBoys = parkingBoys;
    }

    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().filter(ParkingLot -> ParkingLot.isParkingLotFull()).findFirst().orElse(null);;

        if (parkingLot == null) {
            throw new NotEnoughPositionException("Not Enough Position!");
        }
        return parkingLot.park(car);
    }
}
