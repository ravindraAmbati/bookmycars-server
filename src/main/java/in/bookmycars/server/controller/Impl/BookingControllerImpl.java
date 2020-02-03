package in.bookmycars.server.controller.Impl;

import in.bookmycars.server.component.Booking;
import in.bookmycars.server.controller.BookingController;
import in.bookmycars.server.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin("http://localhost:3000")
public class BookingControllerImpl implements BookingController {

    @Autowired
    BookingService service;

    @Override
    @GetMapping("/test")
    public String test() {
        return welcome+this.getClass().getSimpleName();
    }

    @Override
    @GetMapping("/bookings")
    public List<Booking> bookings() {
        return service.findAll();
    }

    @Override
    @PostMapping(path = "/book",consumes = "application/json",produces = "application/json")
    public String book(@RequestBody Booking booking) {
        return service.book(booking);
    }

    @Override
    @PostMapping(path = "/bookAndReturnId",consumes = "application/json",produces = "application/json")
    public String bookAndReturnId(@RequestBody Booking booking) {
        return service.bookAndReturnId(booking);
    }

    @Override
    @GetMapping("/view")
    public String bookingsView() {
        String bookingBody = "";
        for (Booking booking: bookings()){
            String row = "<tr>" +
                    "<td>"+booking.getId()+"</td>" +
                    "<td>"+booking.getSource()+"</td>" +
                    "<td>"+booking.getDestination()+"</td>" +
                    "<td>"+booking.getStartDate()+"</td>" +
                    "<td>"+booking.getEndDate()+"</td>" +
                    "<td>"+booking.getPickupTime()+"</td>" +
                    "<td>"+booking.getName()+"</td>" +
                    "<td>"+booking.getContactNo()+"</td>" +
                    "</tr>";
            bookingBody = bookingBody+""+row;
        }
        return "<html>" +
                "<head></head>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th>ID</th>" +
                "<th>Source</th>" +
                "<th>Destination</th>" +
                "<th>Journey Date</th>" +
                "<th>Return Date</th>" +
                "<th>Pick Time</th>" +
                "<th>Name</th>" +
                "<th>Contact Number</th>" +
                "</tr>" +
                bookingBody +
                "<table>" +
                "</body>" +
                "</html>";
    }

    @Override
    @GetMapping("/create")
    public List<Booking> create(){
        return service.create();
    }

    @Override
    @GetMapping("/drop")
    public String drop() {
        return service.drop();
    }

    @Override
    @GetMapping("/read")
    public List<Booking> readAllData() {
        return service.readAllData();
    }

}
