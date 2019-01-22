package ttps.java.transformer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Transformer <Entity, DTO> {
	DTO toDTO(Entity e);
	Entity toEntity(DTO dto);
	List<DTO> toListDTO(List<Entity> list);
	Collection<DTO> toCollectionDTO(List<Entity> list);
	List<Entity> toListEntity(Set<DTO> list);
	Collection<Entity> toCollection(Set<DTO> list);
	
}