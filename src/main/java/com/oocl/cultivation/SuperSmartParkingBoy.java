package com.oocl.cultivation;

import java.util.Collections;
import java.util.Comparator;
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
    public ParkingTicket park(Automobile automobile) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getPositionRate))
                .get();
        return parkingLot.park(automobile);
    }
}
