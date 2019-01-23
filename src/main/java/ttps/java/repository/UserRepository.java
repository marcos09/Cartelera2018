package ttps.java.repository;

import org.springframework.data.repository.CrudRepository;

import ttps.java.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
