package com.oocl.cultivation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    @Override
    public ParkingTicket park(Automobile automobile) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getPositionRate))
                .get();
        return parkingLot.park(automobile);
    }
}
