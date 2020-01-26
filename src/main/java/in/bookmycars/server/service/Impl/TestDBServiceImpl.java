package in.bookmycars.server.service.Impl;

import in.bookmycars.server.repository.TestDBRepository;
import in.bookmycars.server.service.TestDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDBServiceImpl implements TestDBService {

    @Autowired
    private TestDBRepository repo;

    @Override
    public String getCurrentTime() {
        return repo.getCurrentTime();
    }
}
