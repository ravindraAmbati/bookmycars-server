package in.bookmycars.server.service;

public interface AdminLoginService {
    String valid = "VALID";
    String inValid = "INVALID";
    String error = "ERROR";
    public String validate(String username, String password);
}
