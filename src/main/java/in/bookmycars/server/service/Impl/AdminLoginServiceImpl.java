package in.bookmycars.server.service.Impl;

import in.bookmycars.server.component.AdminLogin;
import in.bookmycars.server.repository.AdminLoginRepo;
import in.bookmycars.server.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    AdminLoginRepo repo;

    @Override
    public String validate(String username, String password) {
        boolean isValid;
        try {
            isValid = repo.isValidUsername(username) ? repo.isValidUser(username, password) : false;
        } catch (Exception e) {
            return error;
        }
        return isValid ? valid : inValid;
    }

    @Override
    public List<AdminLogin> create() {
        return repo.create();
    }

    @Override
    public String drop() {
        return repo.drop();
    }

    @Override
    public List<AdminLogin> readAllData() {
        return repo.readAllData();
    }


}
