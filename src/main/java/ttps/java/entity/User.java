package ttps.java.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "User")
public class User extends GenericPersistentClass implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "followers")
    private List<Billboard> billboards = new ArrayList<Billboard>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

    
    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    private void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public void editFirstName(String firstname) {
    	this.setFirstName(firstname);
    }
    
    public void editLastName(String lastname) {
    	this.setLastName(lastname);
    }

    public void editPassword(String password) {
    	this.setPassword(password);
    }

    public void editUsername(String username) {
    	this.setUsername(username);    
    }

    public void editRoles(List<Role> roles) {
    	this.setRoles(roles); 
    }

    
	public User() {
		super();
	}

	public User(Long id, String username, String password, String firstName, String lastName) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setUsername(username);
		this.editId(id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<Billboard> getBillboards() {
		return billboards;
	}

	private void setBillboards(List<Billboard> billboards) {
		this.billboards = billboards;
	}
	
	public void editBillboards(List<Billboard> billboards) {
		this.setBillboards(billboards);
	}
    
	
}

