package ttps.java.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import ttps.java.dto.GenericDTO;
import ttps.java.entity.GenericPersistentClass;
import ttps.java.entity.User;
import ttps.java.repository.GenericRepository;
import ttps.java.repository.UserRepository;
import ttps.java.service.GenericService;
import ttps.java.transformer.TransformerImpl;


public class GenericServiceImpl<T extends GenericRepository<entityType> , entityType extends GenericPersistentClass, dtoType extends GenericDTO> implements GenericService<dtoType> {
	
	@Autowired
	private TransformerImpl<entityType, dtoType> transformer;
	
	@Autowired
	private T repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	protected T getRepository() {
		return repository;
	}

	protected void setRepository(T repository) {
		this.repository = repository;
	}

	protected TransformerImpl<entityType, dtoType> getTransformer() {
		return transformer;
	}

	protected void setTransformer(TransformerImpl<entityType, dtoType> transformer) {
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
	
	protected User getCurrentUser() {
		User activeUser;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
	    activeUser = this.getUserRepository().findByUsername(username);
		return activeUser;

	}



}
