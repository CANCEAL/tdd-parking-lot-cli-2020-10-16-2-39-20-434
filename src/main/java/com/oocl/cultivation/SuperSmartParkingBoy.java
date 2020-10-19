package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;

import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
        this.parkingLots = Collections.singletonList(parkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(ParkingLot -> ParkingLot.isParkingLotFull())
                .reduce((current, next) -> (current.getPositionRate()) > next.getPositionRate() ? current : next)
                .orElse(null);

        if (parkingLot == null) {
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION);
        }
        return parkingLot.park(car);
    }
}
