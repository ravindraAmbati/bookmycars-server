package in.bookmycars.server.controller;

import java.util.List;

public interface Controller<T> {

    List<T> create();

    String drop();
}
