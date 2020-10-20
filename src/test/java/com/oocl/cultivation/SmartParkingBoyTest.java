package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest extends ParkingBoyTest {

    @Test
    void should_park_to_parking_lot_which_has_more_empty_space_when_parking_given_parking_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1);
        parkMultipleCars(smartParkingBoy, 4);

        smartParkingBoy = new SmartParkingBoy(parkingLot2);
        parkMultipleCars(smartParkingBoy, 8);

        smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);

        //when
        Automobile automobile1 = new Automobile();
        smartParkingBoy.park(automobile1);

        //then
        assertEquals(5, parkingLot1.getParkingLotCapacity());
    }
}
