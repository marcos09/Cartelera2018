package ttps.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ttps.java.dto.GenericDTO;
import ttps.java.entity.GenericPersistentClass;
import ttps.java.repository.GenericRepository;
import ttps.java.transformer.Transformer;


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
