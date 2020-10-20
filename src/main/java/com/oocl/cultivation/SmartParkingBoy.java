package com.oocl.cultivation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    @Override
    public ParkingTicket park(Automobile automobile) {
        ParkingLot parkingLot = parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getParkingLotCapacity))
                .get();
        return parkingLot.park(automobile);
    }
}
