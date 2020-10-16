package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.NotEnoughPositionException;
import exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetched_given_a_correct_parking_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertSame(car, fetchedCar);
    }

    @Test
    void should_return_cars_when_fetched_given_a_correct_parking_tickets() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);

        //when
        Car fetchedCar1 = parkingBoy.fetch(parkingTicket1);
        Car fetchedCar2 = parkingBoy.fetch(parkingTicket2);

        //then
        assertSame(car1, fetchedCar1);
        assertSame(car2, fetchedCar2);
    }

    @Test
    void should_return_no_car_when_fetched_given_a_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(car);
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
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        parkingBoy.park(car);

        //then
        assertThrows(NoParkingTicketException.class, () -> {

            //when
            parkingBoy.fetch(null);
        });
    }

    @Test
    void should_return_no_car_when_fetched_given_a_used_parking_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

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
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        //then
        assertThrows(NotEnoughPositionException.class, () -> {

            //when
            parkingBoy.park(car1);
            parkingBoy.park(car2);
        });
    }
}
