package in.bookmycars.server.repository;

public interface TestDBRepository {

    String GET_CURRENT_DATE = "select now()";

    String getCurrentTime();
}
