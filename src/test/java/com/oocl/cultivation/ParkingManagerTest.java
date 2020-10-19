package com.oocl.cultivation;

import exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest extends ParkingBoyTest{
    private ParkingLot parkingLot1 = new ParkingLot();
    private ParkingLot parkingLot2 = new ParkingLot();
    private Automobile automobile1 = new Automobile();

    @Test
    void should_parking_manager_add_to_management_list_when_managing_given_parking_boys() {
        //given
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLot1);
        parkingManager.addParkingBoy(parkingBoy1);

        //when
        ParkingTicket parkingTicket1 = parkingManager.park(parkingBoy1, automobile1);

        //then
        assertNotNull(parkingManager.fetch(parkingBoy1, parkingTicket1));
    }
    
    @Test
    void should_park_car_on_parking_lots_when_managing_given_service_manager() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        //when
        ParkingTicket parkingTicket = parkingManager.park(automobile1);

        //then
        assertNotNull(parkingManager.fetch(parkingTicket));
    }
    
    @Test
    void should_return_error_message_when_operation_failed_given_parking_boy_fetch_car() {
        //given
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLot1);
        parkingManager.addParkingBoy(parkingBoy1);

        //when
        ParkingTicket parkingTicket1 = parkingManager.park(parkingBoy1, automobile1);
        ParkingTicket parkingTicket2 = new ParkingTicket();

        //then
        assertNotNull(parkingManager.fetch(parkingBoy1, parkingTicket1));
        assertThrows(UnrecognizedParkingTicketException.class, () ->

                //when
                parkingManager.fetch(parkingBoy1, parkingTicket2)
        );
    }
}
