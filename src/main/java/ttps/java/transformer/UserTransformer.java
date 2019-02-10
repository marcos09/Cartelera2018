package ttps.java.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ttps.java.dto.RoleDTO;
import ttps.java.dto.UserDTO;
import ttps.java.entity.Role;
import ttps.java.entity.User;

@Component
public class UserTransformer extends TransformerImpl<User, UserDTO> {

	@Autowired
	private Transformer<Role, RoleDTO> roleTransformer;
	
	public UserDTO toDTO(User e) {
		UserDTO dto = new UserDTO(e.getId(), e.getUsername(), e.getFirstName(), e.getLastName());
		dto.setRoles(this.roleTransformer.toListDTO(e.getRoles()));
		return dto;
	}

	public User toEntity(UserDTO dto) {
		User u = new User();
		u.editId(dto.getId());
		u.editFirstName(dto.getFirstName());
		u.editLastName(dto.getLastName());
		u.editRoles(this.roleTransformer.toListEntity(dto.getRoles()));
		u.editUsername(dto.getUsername());
		return u;
	}

}
