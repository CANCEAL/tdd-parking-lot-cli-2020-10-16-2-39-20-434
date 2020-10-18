package com.oocl.cultivation;

import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;
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
    
    @Test
    public void should_park_car_on_parking_lots_when_managing_given_service_manager() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingLot parkingLot3 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);

        ServiceManager serviceManager = new ServiceManager(parkingLots);

        //when
        parkMultipleCars(serviceManager, 10);
        Car car11 = new Car();
        ParkingTicket parkingTicket = serviceManager.park(car11);

        //then
        assertNull(parkingLot1.fetch(parkingTicket));
        assertNotNull(parkingLot2.fetch(parkingTicket));
        assertNull(parkingLot3.fetch(parkingTicket));
    }
    
    @Test
    public void should_return_error_message_when_operation_failed_given_parking_boy_fetch_car() {
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

        Car car1 = new Car();
        ServiceManager serviceManager = new ServiceManager(parkingLots, parkingBoys);
        ParkingTicket parkingTicket1 = serviceManager.park(car1);

        //then
        assertThrows(UnrecognizedParkingTicketException.class, () ->

                //when
                parkingBoy2.fetch(parkingTicket1)
        );
    }
}
