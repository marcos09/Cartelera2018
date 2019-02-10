package ttps.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.java.dto.UserDTO;
import ttps.java.service.GenericOriginalService;

@RestController
@RequestMapping("/users")
@CrossOrigin

public class UserController {
	
    @Autowired
    private GenericOriginalService userService;

    @RequestMapping(value ="/usersProfesor", method = RequestMethod.GET)
    public List<UserDTO> getProfesorUsers(){
        return userService.findProfesorUsers();
    }

}
