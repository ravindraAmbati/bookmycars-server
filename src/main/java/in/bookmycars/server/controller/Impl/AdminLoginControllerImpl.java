package in.bookmycars.server.controller.Impl;

import in.bookmycars.server.component.AdminLogin;
import in.bookmycars.server.controller.AdminLoginController;
import in.bookmycars.server.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminLogin")
@CrossOrigin("http://localhost:3000")
public class AdminLoginControllerImpl implements AdminLoginController {

    @Autowired
    AdminLoginService service;

    @Override
    @GetMapping("/test")
    public String test() {
        return welcome+this.getClass().getSimpleName();
    }

    @Override
    @PostMapping(path = "/validate", consumes = "application/json", produces = "application/json")
    public String isValidUser(@RequestBody AdminLogin adminLogin) {
        return service.validate(adminLogin.getUsername(), adminLogin.getPassword());
    }

    @Override
    @GetMapping("/create")
    public List<AdminLogin> create(){
        return service.create();
    }

    @Override
    @GetMapping("/drop")
    public String drop() {
        return service.drop();
    }

    @Override
    @GetMapping("/read")
    public List<AdminLogin> readAllData() {
        return service.readAllData();
    }
}
