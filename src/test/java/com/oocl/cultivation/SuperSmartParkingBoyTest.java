package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartParkingBoyTest extends ParkingBoyTest{

    @Test
    public void should_part_to_parking_lot_which_has_larger_position_rate_when_parking_given_parking_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(15);
        ParkingLot parkingLot2 = new ParkingLot(20);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot1);
        parkMultipleCars(superSmartParkingBoy, 3);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot2);
        parkMultipleCars(superSmartParkingBoy, 5);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        Automobile automobile = new Automobile();
        ParkingTicket parkingTicket = superSmartParkingBoy.park(automobile);

        //then
        assertEquals(11, parkingLot1.getParkingLotCapacity());

    }
}
