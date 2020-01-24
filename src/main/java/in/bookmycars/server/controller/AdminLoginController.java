package in.bookmycars.server.controller;

import in.bookmycars.server.component.AdminLogin;

public interface AdminLoginController {

    String welcome = "WELCOME ";

    public String test();

    public String isValidUser(AdminLogin loginUser);
}
