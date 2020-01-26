package in.bookmycars.server.repository.impl;

import in.bookmycars.server.repository.TestDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDBRepositoryImpl implements TestDBRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getCurrentTime() {
        return jdbcTemplate.queryForObject(GET_CURRENT_DATE,String.class);
    }
}
