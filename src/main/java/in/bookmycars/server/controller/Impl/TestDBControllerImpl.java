package in.bookmycars.server.controller.Impl;

import in.bookmycars.server.controller.TestDBController;
import in.bookmycars.server.service.TestDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testDB")
public class TestDBControllerImpl implements TestDBController {

    @Autowired
    TestDBService service;

    @GetMapping("/time")
    @Override
    public String getCurrentTime() {
        return service.getCurrentTime();
    }
}
