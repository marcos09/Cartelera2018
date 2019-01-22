package ttps.java.service;

import java.util.List;

import ttps.java.entity.RandomCity;
import ttps.java.entity.User;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface GenericOriginalService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
