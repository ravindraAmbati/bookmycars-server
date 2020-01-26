package in.bookmycars.server.controller.Impl;

import in.bookmycars.server.component.Booking;
import in.bookmycars.server.controller.BookingController;
import in.bookmycars.server.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
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
}
