package com.oocl.cultivation;

import exceptions.NoParkingTicketException;
import exceptions.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    public void should_return_a_parking_ticket_when_parking_given_a_car_to_parking_boy() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    public void should_return_car_when_fetched_given_a_correct_parking_ticket() {
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
    public void should_return_cars_when_fetched_given_a_correct_parking_tickets() {
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
    public void should_return_no_car_when_fetched_given_a_wrong_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car fetchedCar = parkingBoy.fetch(parkingTicket);

        //then
        assertNull(fetchedCar);
    }
    
    @Test
    public void should_return_no_car_when_fetched_given_no_ticket(){
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        assertThrows(NoParkingTicketException.class, () -> {
            parkingBoy.fetch(null);
        });
    }

    @Test
    public void should_return_no_car_when_fetched_given_a_used_parking_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //when
        parkingBoy.fetch(parkingTicket);

        //then
        assertNull(parkingBoy.fetch(parkingTicket));
    }

    @Test
    public void should_return_park_fail_and_no_ticket_when_parking_given_parking_lot_has_1_capacity_and_is_already_taken() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);

        //when
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);

        //then
        assertNull(parkingTicket2);
    }
}
