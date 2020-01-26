package in.bookmycars.server.repository;

import in.bookmycars.server.component.Booking;

import java.util.List;

public interface BookingRepo {

    String readAll = "select * from booking";
    String save = "insert into booking (source,destination,startDate,endDate,pickupTime,name,contactNo)\n" +
            "values (?,?,?,?,?,?,?);";
    String saveAndReturnId = "insert into booking (source,destination,startDate,endDate,pickupTime,name,contactNo)\n" +
            "values (?,?,?,?,?,?,?)\n" +
            "returning id;";

    String bookingId = "Booking id";

    List<Booking> readAll();

    boolean save(Booking booking);

    String saveAndReturnId(Booking booking);
}
