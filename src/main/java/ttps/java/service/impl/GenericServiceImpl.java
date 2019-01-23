package ttps.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ttps.java.dto.GenericDTO;
import ttps.java.entity.GenericPersistentClass;
import ttps.java.repository.GenericRepository;
import ttps.java.service.GenericService;
import ttps.java.transformer.Transformer;


public class GenericServiceImpl<T extends GenericRepository<entityType> , entityType extends GenericPersistentClass, dtoType extends GenericDTO> implements GenericService<dtoType> {
	
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

	@Override
	public boolean existsById(Long id) {
		return this.getRepository().existsById(id);
		
	}

	@Override
	public void create(dtoType persistentDTO) {
		this.getRepository().save(this.getTransformer().toEntity(persistentDTO));
	}

	@Override
	public void update(dtoType persistentDTO) {
		this.getRepository().save(this.getTransformer().toEntity(persistentDTO));
	}

	@Override
	public void delete(Long id) {
		this.getRepository().deleteById(id);
	}

	@Override
	public dtoType retrive(Long id) {
		Optional<entityType> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			return this.getTransformer().toDTO(optional.get());
		}
		return null;
		
		
	}

	@Override
	public List<dtoType> list() {
		return this.getTransformer().toListDTO(this.getRepository().findAll());

	}


}
