package in.bookmycars.server.service;

import in.bookmycars.server.component.Booking;

import java.util.List;

public interface BookingService {

    String booked = "BOOKED";
    String notBooked = "NOT BOOKED";
    String error = "ERROR";

    List<Booking> findAll();

    String book(Booking booking);

    String bookAndReturnId(Booking booking);
}
