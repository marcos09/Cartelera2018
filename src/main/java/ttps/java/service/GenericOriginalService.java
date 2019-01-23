package ttps.java.service;

import java.util.List;

import ttps.java.entity.RandomCity;
import ttps.java.entity.User;


public interface GenericOriginalService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
