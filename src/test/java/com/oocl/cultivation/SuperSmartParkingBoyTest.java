package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest extends ParkingBoyTest{

    @Test
    public void should_part_to_parking_lot_which_has_larger_position_rate_when_parking_given_parking_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(15);
        ParkingLot parkingLot2 = new ParkingLot(20);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1);
        parkMultipleCars(superSmartParkingBoy, 3);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot2);
        parkMultipleCars(superSmartParkingBoy, 5);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1, parkingLot2);

        //when
        Automobile automobile = new Automobile();
        superSmartParkingBoy.park(automobile);

        //then
        assertEquals(11, parkingLot1.getParkingLotCapacity());
    }
}
