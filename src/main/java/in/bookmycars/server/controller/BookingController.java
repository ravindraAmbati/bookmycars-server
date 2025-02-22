package in.bookmycars.server.controller;

import in.bookmycars.server.component.Booking;

import java.util.List;

public interface BookingController extends Controller<Booking> {

    String welcome = "WELCOME ";

    String test();

    List<Booking> bookings();

    String book(Booking booking);

    String bookAndReturnId(Booking booking);

    String bookingsView();
}
