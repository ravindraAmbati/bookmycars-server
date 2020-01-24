package in.bookmycars.server.repository;

public interface AdminLoginRepo {

    String readUsername = "select 1 from admin_login where username = :username";
    String readUser = "select 1 from admin_login where username = :username and password = :password";

    public boolean isValidUsername(String username);

    public boolean isValidUser(String username, String password);
}
