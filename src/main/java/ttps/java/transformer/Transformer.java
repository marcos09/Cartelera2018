package ttps.java.transformer;

import java.util.Collection;
import java.util.List;

public interface Transformer <Entity, DTO> {
	DTO toDTO(Entity e);
	Entity toEntity(DTO dto);
	List<DTO> toListDTO(List<Entity> list);
	Collection<DTO> toCollectionDTO(List<Entity> list);
	List<Entity> toListEntity(List<DTO> list);
	Collection<Entity> toCollection(List<DTO> list);
	
}