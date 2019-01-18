package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.transformer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.entity.Cartelera;

public interface Transformer <Entity, DTO> {
	DTO toDTO(Entity e);
	Entity toEntity(DTO dto);
	List<DTO> toListDTO(List<Entity> list);
	Collection<DTO> toCollectionDTO(List<Entity> list);
	List<Entity> toListEntity(Set<DTO> list);
	Collection<Cartelera> toCollection(Set<DTO> list);
	
}