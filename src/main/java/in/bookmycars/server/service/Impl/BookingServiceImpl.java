package in.bookmycars.server.service.Impl;

import in.bookmycars.server.component.Booking;
import in.bookmycars.server.repository.BookingRepo;
import in.bookmycars.server.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    public BookingRepo repo;

    @Override
    public List<Booking> findAll() {
        return repo.readAll();
    }

    @Override
    public String book(Booking booking) {
        try{
            return repo.save(booking)?booked:notBooked;
        } catch (Exception e){
            return error;
        }
    }
}
