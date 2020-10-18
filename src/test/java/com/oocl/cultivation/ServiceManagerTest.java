package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceManagerTest extends ParkingBoyTest{
    @Test
    public void should_add_to_management_list_when_managing_given_parking_boys() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);

        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingBoy parkingBoy2 = new ParkingBoy(parkingLot2);
        ParkingBoy parkingBoy3 = new ParkingBoy(parkingLot3);
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        parkingBoys.add(parkingBoy1);
        parkingBoys.add(parkingBoy2);
        parkingBoys.add(parkingBoy3);

        //when
        Car car1 = new Car();
        ServiceManager serviceManager = new ServiceManager(parkingLots, parkingBoys);
        ParkingTicket parkingTicket1 = serviceManager.park(car1);

        //then
        assertNotNull(parkingBoy1.fetch(parkingTicket1));
    }
}
