package com.oocl.cultivation;

import exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest extends ParkingBoyTest{
    @Test
    public void should_parking_manager_add_to_management_list_when_managing_given_parking_boys() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLot1);
        parkingManager.addParkingBoy(parkingBoy1);

        //when
        Automobile automobile1 = new Automobile();
        ParkingTicket parkingTicket1 = parkingManager.park(parkingBoy1, automobile1);

        //then
        assertNotNull(parkingManager.fetch(parkingBoy1, parkingTicket1));
    }
    
    @Test
    public void should_park_car_on_parking_lots_when_managing_given_service_manager() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingManager parkingManager = new ParkingManager(parkingLots);

        //when
        Automobile automobile1 = new Automobile();
        ParkingTicket parkingTicket = parkingManager.park(automobile1);

        //then
        assertNotNull(parkingManager.fetch(parkingTicket));
    }
    
    @Test
    public void should_return_error_message_when_operation_failed_given_parking_boy_fetch_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingBoy parkingBoy1 = new ParkingBoy(parkingLot1);
        ParkingManager parkingManager = new ParkingManager(parkingLot1);
        parkingManager.addParkingBoy(parkingBoy1);

        //when
        Automobile automobile1 = new Automobile();
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
