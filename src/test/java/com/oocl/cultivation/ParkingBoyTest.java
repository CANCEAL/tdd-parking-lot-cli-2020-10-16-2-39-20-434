package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //given
        Automobile automobile = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket parkingTicket = parkingBoy.park(automobile);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetched_given_a_correct_parking_ticket() {
        //given
        Automobile automobile = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(automobile);

        //when
        Automobile fetchedAutomobile = parkingBoy.fetch(parkingTicket);

        //then
        assertSame(automobile, fetchedAutomobile);
    }

    @Test
    void should_return_cars_when_fetched_given_a_correct_parking_tickets() {
        //given
        Automobile automobile1 = new Automobile();
        Automobile automobile2 = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(automobile1);
        ParkingTicket parkingTicket2 = parkingBoy.park(automobile2);

        //when
        Automobile fetchedAutomobile1 = parkingBoy.fetch(parkingTicket1);
        Automobile fetchedAutomobile2 = parkingBoy.fetch(parkingTicket2);

        //then
        assertSame(automobile1, fetchedAutomobile1);
        assertSame(automobile2, fetchedAutomobile2);
    }

    @Test
    void should_return_no_car_when_fetched_given_a_wrong_ticket() {
        //given
        Automobile automobile = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(automobile);
        ParkingTicket parkingTicket = new ParkingTicket();

        //then
        assertThrows(UnrecognizedParkingTicketException.class, () -> {

            //when
            parkingBoy.fetch(parkingTicket);
        });
    }

    @Test
    void should_return_no_car_when_fetched_given_no_ticket(){
        //given
        Automobile automobile = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(automobile);

        //then
        assertThrows(NoParkingTicketException.class, () -> {

            //when
            parkingBoy.fetch(null);
        });
    }

    @Test
    void should_return_no_car_when_fetched_given_a_used_parking_ticket() {
        //given
        Automobile automobile = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(automobile);

        //then
        assertThrows(UnrecognizedParkingTicketException.class, () -> {

            //when
            parkingBoy.fetch(parkingTicket);
            parkingBoy.fetch(parkingTicket);
        });
    }

    @Test
    void should_return_park_fail_and_no_ticket_when_parking_given_parking_lot_has_1_capacity_and_is_already_taken() {
        //given
        Automobile automobile1 = new Automobile();
        Automobile automobile2 = new Automobile();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        //then
        assertThrows(NotEnoughPositionException.class, () -> {

            //when
            parkingBoy.park(automobile1);
            parkingBoy.park(automobile2);
        });
    }

    void parkMultipleCars(ParkingBoy parkingBoy, int maxCar) {
        Automobile automobile = new Automobile();
        for (int numberOfCars=1; numberOfCars<=maxCar; numberOfCars++) {
            parkingBoy.park(automobile);
        }
    }

    @Test
    void should_park_to_parking_lot_2_when_parking_given_parking_lot_1_is_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        //when
        parkMultipleCars(parkingBoy, 10);
        Automobile automobile11 = new Automobile();
        parkingBoy.park(automobile11);

        //then
        assertEquals(9, parkingLot2.getParkingLotCapacity());
    }
}
