package ttps.java.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class TransformerImpl <Entity, DTO> implements Transformer<Entity, DTO> {

	public List<DTO> toListDTO(List<Entity> list) {
		List<DTO> listDTO = new ArrayList<DTO>();
		for(Entity e: list) {
			listDTO.add(this.toDTO(e));
		}
		return listDTO;
	}

	public Collection<DTO> toCollectionDTO(List<Entity> list) {
		return (Collection<DTO>) this.toListDTO(list);

	}
	
	@Override
	public List<Entity> toListEntity(List<DTO> list) {
		List<Entity> entityList = new ArrayList<Entity>();
		for(DTO u: list) {
			entityList.add(this.toEntity(u));
		}
		return entityList;

	}

	@Override
	public Collection<Entity> toCollection(List<DTO> list) {
		return (Collection<Entity>) this.toListEntity(list);
	}

	
}