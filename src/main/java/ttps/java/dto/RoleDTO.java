package ttps.java.dto;

public class RoleDTO extends GenericDTO{

    private String roleName;
    private String description;
    
    
    public RoleDTO(Long id, String roleName, String description) {
		super();
		this.roleName = roleName;
		this.description = description;
		this.id = id;
		
	}
    public RoleDTO() {
		super();		
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
