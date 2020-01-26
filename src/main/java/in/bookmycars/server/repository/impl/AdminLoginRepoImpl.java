package in.bookmycars.server.repository.impl;

import in.bookmycars.server.component.AdminLogin;
import in.bookmycars.server.repository.AdminLoginRepo;
import in.bookmycars.server.repository.mapper.AdminLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminLoginRepoImpl implements AdminLoginRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean isValidUsername(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return 1 == namedParameterJdbcTemplate.queryForObject(readUsernameSQL, paramMap, Long.class);
    }

    @Override
    public boolean isValidUser(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        return 1 == namedParameterJdbcTemplate.queryForObject(readUserSQL, paramMap, Long.class);
    }

    @Override
    public List<AdminLogin> create() {
        jdbcTemplate.execute(createSQL);
        jdbcTemplate.execute(insertTestDataSQL);
        return jdbcTemplate.query(selectTestDataSQL,new AdminLoginMapper());
    }

    @Override
    public String drop() {
        jdbcTemplate.execute(dropSQL);
        return drop;
    }

}
