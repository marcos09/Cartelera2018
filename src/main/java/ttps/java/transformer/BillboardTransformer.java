package ttps.java.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ttps.java.dto.BillboardDTO;
import ttps.java.entity.Billboard;

@Component
public class BillboardTransformer implements Transformer<Billboard, BillboardDTO> {

	@Override
	public BillboardDTO toDTO(Billboard e) {
		return new BillboardDTO(e.getId(), e.getNombreCartelera());
	}

	@Override
	public Billboard toEntity(BillboardDTO dto) {
		return new Billboard(dto.getId(), dto.getNameBillboard());
	}

	@Override
	public List<BillboardDTO> toListDTO(List<Billboard> list) {
		List<BillboardDTO> lista = new ArrayList<BillboardDTO>();
		for (Billboard c : list) {
			lista.add(this.toDTO(c));
		}
		return lista;

	}

	@Override
	public Collection<BillboardDTO> toCollectionDTO(List<Billboard> list) {
		return (Collection<BillboardDTO>) this.toListDTO(list);
		}

	@Override
	public List<Billboard> toListEntity(Set<BillboardDTO> list) {
		List<Billboard> lista = new ArrayList<Billboard>();
		for (BillboardDTO c : list) {
			lista.add(this.toEntity(c));
		}
		return lista;

	}
	
	@Override
	public Collection<Billboard> toCollection(Set<BillboardDTO> list) {
		return (Collection<Billboard>) this.toListEntity(list);

	}

}
