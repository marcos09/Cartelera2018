package ttps.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ttps.java.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
    User findByUsername(String username);
    
    /*
    @Query(value = "SELECT "
    		+ "new ttps.java.entity.User("
    		+ "SELECT User.ID, User.USERNAME, User.PASSWORD, User.FIRST_NAME, User.LAST_NAME)"
    		+ "FROM User inner join USER_ROLE ON(User.ID = USER_ROLE.USER_ID) "
    		+ "inner join Role  ON (USER_ROLE.ROLE_ID = Role.ID) WHERE ROLE_NAME = 'STANDARD_USER' "
    		, nativeQuery = true)
    */
    @Query("SELECT u FROM User u INNER JOIN fetch u.roles  as r  WHERE r.roleName = 'STANDARD_USER'")
    List<User> findProfesorRole();
    
    
}
