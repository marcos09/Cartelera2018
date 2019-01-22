package ttps.java.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ttps.java.dto.CarteleraDTO;
import ttps.java.entity.Cartelera;

@Component
public class CarteleraTransformer implements Transformer<Cartelera, CarteleraDTO> {

	@Override
	public CarteleraDTO toDTO(Cartelera e) {
		return new CarteleraDTO(e.getId(), e.getNombreCartelera());
	}

	@Override
	public Cartelera toEntity(CarteleraDTO dto) {
		return new Cartelera(dto.getId(), dto.getNombreCartelera());
	}

	@Override
	public List<CarteleraDTO> toListDTO(List<Cartelera> list) {
		List<CarteleraDTO> lista = new ArrayList<CarteleraDTO>();
		for (Cartelera c : list) {
			lista.add(this.toDTO(c));
		}
		return lista;

	}

	@Override
	public Collection<CarteleraDTO> toCollectionDTO(List<Cartelera> list) {
		return (Collection<CarteleraDTO>) this.toListDTO(list);
		}

	@Override
	public List<Cartelera> toListEntity(Set<CarteleraDTO> list) {
		List<Cartelera> lista = new ArrayList<Cartelera>();
		for (CarteleraDTO c : list) {
			lista.add(this.toEntity(c));
		}
		return lista;

	}
	
	@Override
	public Collection<Cartelera> toCollection(Set<CarteleraDTO> list) {
		return (Collection<Cartelera>) this.toListEntity(list);

	}

}
