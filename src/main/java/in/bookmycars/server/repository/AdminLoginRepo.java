package in.bookmycars.server.repository;

import in.bookmycars.server.component.AdminLogin;

public interface AdminLoginRepo extends Repo<AdminLogin> {

    String createSQL = "create table admin_login(\n" +
            "\tid SERIAL,\n" +
            "\tusername varchar(50) not null primary key,\n" +
            "\tpassword varchar(50) not null\n" +
            ")";
    String dropSQL = "drop table admin_login";
    String insertTestDataSQL = "insert into admin_login(username,password) values('testUsername','testPassword')";
    String selectTestDataSQL = "select * from admin_login";

    String readUsernameSQL = "select 1 from admin_login where username = :username";
    String readUserSQL = "select 1 from admin_login where username = :username and password = :password";

    boolean isValidUsername(String username);

    boolean isValidUser(String username, String password);
}
