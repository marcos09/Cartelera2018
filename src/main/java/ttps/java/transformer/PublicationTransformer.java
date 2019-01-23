package ttps.java.transformer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ttps.java.dto.PublicationDTO;
import ttps.java.entity.Publication;

public class PublicationTransformer implements Transformer<Publication, PublicationDTO>{

	@Override
	public PublicationDTO toDTO(Publication e) {
		return new PublicationDTO();
	}

	@Override
	public Publication toEntity(PublicationDTO dto) {
		return null;
	}

	@Override
	public List<PublicationDTO> toListDTO(List<Publication> list) {
		return null;
	}

	@Override
	public Collection<PublicationDTO> toCollectionDTO(List<Publication> list) {
		return null;
	}

	@Override
	public List<Publication> toListEntity(Set<PublicationDTO> list) {
		return null;
	}

	@Override
	public Collection<Publication> toCollection(Set<PublicationDTO> list) {
		return null;
	}

}
