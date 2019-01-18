package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.service;

import java.util.List;

public interface GenericService<DTO> {
	boolean existsById(Long id);
	
	void create(DTO persistentDTO);

	void update(DTO persistentDTO);

	void delete(Long id);

	DTO retrive(Long id);

	List<DTO> list();
	
	
}
