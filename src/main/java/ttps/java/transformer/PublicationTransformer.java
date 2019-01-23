package ttps.java.transformer;

import ttps.java.dto.PublicationDTO;
import ttps.java.entity.Publication;

public class PublicationTransformer extends TransformerImpl<Publication, PublicationDTO>{

	@Override
	public PublicationDTO toDTO(Publication e) {
		return new PublicationDTO();
	}

	@Override
	public Publication toEntity(PublicationDTO dto) {
		return null;
	}

}
