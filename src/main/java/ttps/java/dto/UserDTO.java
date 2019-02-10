package ttps.java.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends GenericDTO{
    private String username;
    private String firstName;
    private String lastName;
    private List<RoleDTO> roles;
    
    
	public UserDTO() {
		super();
		this.roles = new ArrayList<RoleDTO>();
	}
	
	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public UserDTO(Long id, String username, String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setId(id);
		this.roles = new ArrayList<RoleDTO>();
	}

	public UserDTO(String username, String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.roles = new ArrayList<RoleDTO>();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    

}
