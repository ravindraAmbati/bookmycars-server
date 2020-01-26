package in.bookmycars.server.controller;

import in.bookmycars.server.component.AdminLogin;

public interface AdminLoginController extends Controller<AdminLogin> {

    String welcome = "WELCOME ";

    String test();

    String isValidUser(AdminLogin loginUser);
}
