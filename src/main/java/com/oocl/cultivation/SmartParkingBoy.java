package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        this.parkingLots = Collections.singletonList(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getParkingLotCapacity))
                .get();
        return parkingLot.park(car);
    }
}
