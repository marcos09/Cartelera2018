package ttps.java.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.java.dto.CarteleraDTO;
import ttps.java.entity.Cartelera;
import ttps.java.repository.CarteleraRepository;
import ttps.java.service.CarteleraService;

@Service
@Transactional
public class CarteleraServiceImpl extends GenericServiceImpl<CarteleraRepository, Cartelera, CarteleraDTO> implements CarteleraService {

	@Override
	public boolean existsById(Long id) {
		return false;
	}

	@Override
	public void create(CarteleraDTO persistentDTO) {
		
	}

	@Override
	public void update(CarteleraDTO persistentDTO) {
		
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public CarteleraDTO retrive(Long id) {
		return null;
	}

	@Override
	public List<CarteleraDTO> list() {
		return this.getTransformer().toListDTO(this.getRepository().findAll());
	}
	
}
