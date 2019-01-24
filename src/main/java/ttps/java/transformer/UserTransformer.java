package ttps.java.transformer;

import org.springframework.stereotype.Component;

import ttps.java.dto.UserDTO;
import ttps.java.entity.User;

@Component
public class UserTransformer extends TransformerImpl<User, UserDTO> {

	public UserDTO toDTO(User e) {
		return new UserDTO(e.getId(), e.getUsername(), e.getFirstName(), e.getLastName());
	}

	public User toEntity(UserDTO dto) {
		User u = new User();
		u.editId(dto.getId());
		u.editFirstName(dto.getFirstName());
		u.editLastName(dto.getLastName());
		//u.editRoles(roles);
		u.editUsername(dto.getUsername());
		return u;
	}


}
