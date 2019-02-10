package ttps.java.transformer;

import org.springframework.stereotype.Component;

import ttps.java.dto.RoleDTO;
import ttps.java.entity.Role;

@Component
public class RoleTransformer extends TransformerImpl<Role, RoleDTO>{

	@Override
	public RoleDTO toDTO(Role e) {
		return new RoleDTO(e.getId(), e.getRoleName(), e.getDescription());
	}

	@Override
	public Role toEntity(RoleDTO dto) {
		return new Role(dto.getId(), dto.getRoleName(), dto.getDescription());
	}

}
