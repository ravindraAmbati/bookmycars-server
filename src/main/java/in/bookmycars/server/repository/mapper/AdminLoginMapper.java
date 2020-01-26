package in.bookmycars.server.repository.mapper;

import in.bookmycars.server.component.AdminLogin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginMapper implements RowMapper<AdminLogin> {

    @Override
    public AdminLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setId(rs.getLong("id"));
        adminLogin.setUsername(rs.getString("username"));
        adminLogin.setPassword(rs.getString("password"));
        return adminLogin;
    }
}
