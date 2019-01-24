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
@RequestMapping("/usuarios")
@CrossOrigin

public class UserController {
	
    @Autowired
    private GenericOriginalService userService;

    @RequestMapping(value ="/usersProfesor", method = RequestMethod.GET)
   // @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<UserDTO> getProfesorUsers(){
    	System.out.println("Entre en el controlador");
        return userService.findProfesorUsers();
    }

}
