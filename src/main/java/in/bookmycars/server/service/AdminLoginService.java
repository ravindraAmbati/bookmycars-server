package in.bookmycars.server.service;

import in.bookmycars.server.component.AdminLogin;

import java.util.List;

public interface AdminLoginService extends Service<AdminLogin> {
    String valid = "VALID";
    String inValid = "INVALID";
    String error = "ERROR";

    String validate(String username, String password);

    List<AdminLogin> create();
}
