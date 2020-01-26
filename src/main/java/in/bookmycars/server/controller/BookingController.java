package in.bookmycars.server.controller;

import in.bookmycars.server.component.Booking;

import java.util.List;

public interface BookingController {

    String welcome = "WELCOME ";

    String test();

    List<Booking> bookings();

    String book(Booking booking);
}
