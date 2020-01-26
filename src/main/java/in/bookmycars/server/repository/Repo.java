package in.bookmycars.server.repository;

import java.util.List;

public interface Repo<T> {

    String drop = "DB Table deleted successfully";
    String error = "ERROR";

    List<T> create();

    String drop();
}
