package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest extends ParkingBoyTest {

    @Test
    void should_park_to_parking_lot_which_has_more_empty_space_when_parking_given_parking_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1);
        parkMultipleCars(smartParkingBoy, 4);

        smartParkingBoy = new SmartParkingBoy(parkingLot2);
        parkMultipleCars(smartParkingBoy, 8);

        smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Car car1 = new Car();
        smartParkingBoy.park(car1);

        //then
        assertEquals(5, parkingLot1.getParkingLotCapacity());
    }
}
