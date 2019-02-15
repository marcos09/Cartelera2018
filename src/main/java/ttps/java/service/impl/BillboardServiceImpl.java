package ttps.java.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.PublicationDTO;
import ttps.java.dto.UserDTO;
import ttps.java.entity.Billboard;
import ttps.java.entity.Publication;
import ttps.java.entity.User;
import ttps.java.repository.BillboardRepository;
import ttps.java.repository.UserRepository;
import ttps.java.service.BillboardService;
import ttps.java.transformer.Transformer;

@Service
@Transactional
public class BillboardServiceImpl extends GenericServiceImpl<BillboardRepository, Billboard, BillboardDTO> implements BillboardService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Transformer<Publication,PublicationDTO> publicationsTransform;

	@Override
	public void addWriteUser(UserDTO user, Long id) {
		Optional<Billboard> optional = this.getRepository().findById(id);
		Optional<User> optionalUser = this.userRepository.findById(user.getId());
		
		if(optional.isPresent() && optionalUser.isPresent()) {
			Billboard b = optional.get();
			b.addWriteUser(optionalUser.get());
			this.getRepository().save(b);
		}
	}
	
	@Override
	public void removeWriteUser(UserDTO user, Long id) {
		Optional<Billboard> optional = this.getRepository().findById(id);
		//Optional<User> optionalUser = this.userRepository.findById(user.getId());
		
		if(optional.isPresent() ) {
			Billboard b = optional.get();
			b.removeWriteUserById(user.getId());
			this.getRepository().save(b);
		}
	}
	
	@Override 
	public void addPublication(PublicationDTO dto, Long id) {
		Optional<Billboard> optional = this.getRepository().findById(id);
		
		if(optional.isPresent() ) {
			Billboard b = optional.get();
			b.addPublication(this.publicationsTransform.toEntity(dto));
			this.getRepository().save(b);
		}
	}

	@Override 
	public void removePublication(PublicationDTO dto, Long id) {
		Optional<Billboard> optional = this.getRepository().findById(id);
		
		if(optional.isPresent() ) {
			Billboard b = optional.get();
			b.removePublicationById(dto.getId());
			this.getRepository().save(b);
		}
	}

	@Override
	public Collection<PublicationDTO> publications(Long id) {
		Optional<Billboard> optional = this.getRepository().findById(id);
		if(optional.isPresent()) {
			return this.getPublicationsTransform().toCollectionDTO(optional.get().getPublications());
		}
		
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Transformer<Publication, PublicationDTO> getPublicationsTransform() {
		return publicationsTransform;
	}

	public void setPublicationsTransform(Transformer<Publication, PublicationDTO> publicationsTransform) {
		this.publicationsTransform = publicationsTransform;
	}

	@Override
	public void subscribe(Long idBillboard) {
		User u = this.getCurrentUser();
		Optional<Billboard> opt = this.getRepository().findById(idBillboard);
		if(opt.isPresent()) {
			opt.get().subscribe(u);
		}
		
	}
	

	@Override
	public void unsubscribe(Long idBillboard) {
		User u = this.getCurrentUser();
		Optional<Billboard> opt = this.getRepository().findById(idBillboard);
		if(opt.isPresent()) {
			opt.get().unsuscribe(u.getId());
		}
		
	}

	
}
