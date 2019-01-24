package ttps.java.transformer;

import org.springframework.stereotype.Component;

import ttps.java.dto.PublicationDTO;
import ttps.java.entity.Publication;

@Component
public class PublicationTransformer extends TransformerImpl<Publication, PublicationDTO>{

	@Override
	public PublicationDTO toDTO(Publication e) {
		return 	new PublicationDTO(e.getId(), e.getTitle(), e.getDescription(), e.getComents());

	}

	@Override
	public Publication toEntity(PublicationDTO dto) {
		return new Publication(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getComents());
	}

}
