package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.service;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.dto.GenericDTO;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.entity.GenericPersistentClass;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.repository.GenericRepository;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.transformer.Transformer;

public abstract class GenericServiceImpl<T extends GenericRepository<entityType> , entityType extends GenericPersistentClass, dtoType extends GenericDTO> {
	
	@Autowired
	private Transformer<entityType, dtoType> transformer;
	
	@Autowired
	private T repository;
	
	
	protected T getRepository() {
		return repository;
	}

	protected void setRepository(T repository) {
		this.repository = repository;
	}

	protected Transformer<entityType, dtoType> getTransformer() {
		return transformer;
	}

	protected void setTransformer(Transformer<entityType, dtoType> transformer) {
		this.transformer = transformer;
	}

	protected GenericServiceImpl() {
		super();
	}
	
}
