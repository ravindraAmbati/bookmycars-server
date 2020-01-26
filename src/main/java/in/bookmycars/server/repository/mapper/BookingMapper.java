package in.bookmycars.server.repository.mapper;

import in.bookmycars.server.component.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Booking booking = new Booking();
        booking.setId(rs.getLong("id"));
        booking.setSource(rs.getString("source"));
        booking.setDestination(rs.getString("destination"));
        booking.setStartDate(rs.getString("startDate"));
        booking.setEndDate(rs.getString("endDate"));
        booking.setPickupTime(rs.getString("pickupTime"));
        booking.setName(rs.getString("name"));
        booking.setContactNo(rs.getString("contactNo"));
        return booking;
    }
}
