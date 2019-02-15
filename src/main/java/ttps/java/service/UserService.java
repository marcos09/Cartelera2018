package ttps.java.service;

import java.util.Collection;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.UserDTO;

public interface UserService extends GenericService<UserDTO>{
	public UserDTO getLoginUser();
	
	public Collection<BillboardDTO> getBillboardsSubscriptions();
}
