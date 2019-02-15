package ttps.java.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.UserDTO;
import ttps.java.service.GenericOriginalService;
import ttps.java.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin

public class UserController {
	
    @Autowired
    private GenericOriginalService userOriginalService;
    
    @Autowired
    private UserService userService;

    
    public GenericOriginalService getUserOriginalService() {
		return userOriginalService;
	}

	public void setUserOriginalService(GenericOriginalService userOriginalService) {
		this.userOriginalService = userOriginalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value ="/usersProfesor", method = RequestMethod.GET)
    public List<UserDTO> getProfesorUsers(){
        return userOriginalService.findProfesorUsers();
    }
    
	@GetMapping(path = "/{id}", produces = "application/json")
	public Object show(@PathVariable(value = "id") Long id){
		return this.userService.retrive(id);
	}
	
	
	@GetMapping(path = "/getCurrentUser", produces = "application/json")
	public Object getUser(){
		return this.userService.getLoginUser();
	}

	
	@GetMapping(path = "/subscriptions", produces = "application/json")
	public Collection<BillboardDTO> billboardSubscriptions(){
		return this.getUserService().getBillboardsSubscriptions();

	}

	


}
