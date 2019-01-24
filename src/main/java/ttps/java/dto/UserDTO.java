package ttps.java.dto;

public class UserDTO extends GenericDTO{
    private String username;
    private String firstName;
    private String lastName;
    
    
	public UserDTO() {
		super();
	}
	
	public UserDTO(Long id, String username, String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setId(id);
	}

	public UserDTO(String username, String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
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
