package in.bookmycars.server.repository;

import in.bookmycars.server.component.Booking;

import java.util.List;

public interface BookingRepo extends Repo<Booking>{

    String createSQL = "CREATE TABLE booking(\n" +
            "\tid SERIAL PRIMARY KEY,\n" +
            "\tsource VARCHAR NOT NULL,\n" +
            "\tdestination VARCHAR NOT NULL,\n" +
            "\tstartDate VARCHAR NOT NULL,\n" +
            "\tendDate VARCHAR,\n" +
            "\tpickupTime VARCHAR,\n" +
            "\tname VARCHAR NOT NULL,\n" +
            "\tcontactNo VARCHAR NOT NULL\n" +
            ");";

    String dropSQL = "drop table booking";

    String insertTestDataSQL = "insert into booking (source,destination,startDate,endDate,pickupTime,name,contactNo)\n" +
            "values ('sourceTest','destinationTest','startDateTest','endDateTest','pickupTimeTest','nameTest','contactNoTest');";

    String selectTestDataSQL = "select * from booking";

    String readAllSQL = "select * from booking";
    String saveSQL = "insert into booking (source,destination,startDate,endDate,pickupTime,name,contactNo)\n" +
            "values (?,?,?,?,?,?,?);";
    String saveAndReturnIdSQL = "insert into booking (source,destination,startDate,endDate,pickupTime,name,contactNo)\n" +
            "values (?,?,?,?,?,?,?)\n" +
            "returning id;";

    String bookingId = "Booking id";

    List<Booking> readAll();

    boolean save(Booking booking);

    String saveAndReturnId(Booking booking);
}
