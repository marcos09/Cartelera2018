package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.dto.CarteleraDTO;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.entity.Cartelera;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.repository.CarteleraRepository;

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
