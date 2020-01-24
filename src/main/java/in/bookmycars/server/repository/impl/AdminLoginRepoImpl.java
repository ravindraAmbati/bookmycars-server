package in.bookmycars.server.repository.impl;

import in.bookmycars.server.repository.AdminLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
        return 1 == namedParameterJdbcTemplate.queryForObject(readUsername, paramMap, Long.class);
    }

    @Override
    public boolean isValidUser(String username, String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        return 1 == namedParameterJdbcTemplate.queryForObject(readUser, paramMap, Long.class);
    }

}
