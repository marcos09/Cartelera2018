package ttps.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="Role")
public class Role extends GenericPersistentClass implements  GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Column(name="role_name")
    private String roleName;

    @Column(name="description")
    private String description;

    
    public Role(String roleName, String description) {
		super();
		this.setDescription(description);
		this.setRoleName(roleName);
	}
    
    public Role(Long id, String roleName, String description) {
		super();
		this.setDescription(description);
		this.setRoleName(roleName);
		this.editId(id);
	}


	public Role() {
		super();
	}

	public String getRoleName() {
        return roleName;
    }

    private void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
    
    public void editRoleName(String roleName) {
        this.setRoleName(roleName);
    }

    public void editDescription(String description) {
        this.editDescription(description); 
    }

	@Override
	public String getAuthority() {
		return this.getRoleName();
	}

}
