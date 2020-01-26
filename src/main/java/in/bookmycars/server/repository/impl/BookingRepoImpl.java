package in.bookmycars.server.repository.impl;

import in.bookmycars.server.component.Booking;
import in.bookmycars.server.repository.BookingRepo;
import in.bookmycars.server.repository.mapper.AdminLoginMapper;
import in.bookmycars.server.repository.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class BookingRepoImpl implements BookingRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Booking> readAll() {
        return jdbcTemplate.query(readAllSQL, new BookingMapper());
    }

    @Override
    public boolean save(Booking booking) {
        return 1 == jdbcTemplate.update(saveSQL,booking.getSource(),booking.getDestination(),booking.getStartDate(),booking.getEndDate(),booking.getPickupTime(),booking.getName(),booking.getContactNo());
    }

    @Override
    public String saveAndReturnId(Booking booking) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(saveAndReturnIdSQL, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, booking.getSource());
                statement.setString(2, booking.getDestination());
                statement.setString(3, booking.getStartDate());
                statement.setString(4, booking.getEndDate());
                statement.setString(5, booking.getPickupTime());
                statement.setString(6, booking.getName());
                statement.setString(7, booking.getContactNo());
                return statement;
            }
        }, holder);

        return holder.getKey().toString();
    }

    @Override
    public List<Booking> create() {
        jdbcTemplate.execute(createSQL);
        jdbcTemplate.execute(insertTestDataSQL);
        return jdbcTemplate.query(selectTestDataSQL,new BookingMapper());
    }

    @Override
    public String drop() {
        jdbcTemplate.execute(dropSQL);
        return drop;
    }

}
