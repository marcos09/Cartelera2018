package ttps.java.service;

import java.util.Collection;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.PublicationDTO;
import ttps.java.dto.UserDTO;

public interface BillboardService extends GenericService<BillboardDTO> {
	void addWriteUser(UserDTO user, Long id);

	void removeWriteUser(UserDTO user, Long id);

	void addPublication(PublicationDTO dto, Long id);

	void removePublication(PublicationDTO dto, Long id);
	
	Collection<PublicationDTO> publications(Long id);
}

		 

