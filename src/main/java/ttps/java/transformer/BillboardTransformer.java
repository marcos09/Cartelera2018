package ttps.java.transformer;

import org.springframework.stereotype.Component;

import ttps.java.dto.BillboardDTO;
import ttps.java.entity.Billboard;

@Component
public class BillboardTransformer extends TransformerImpl<Billboard, BillboardDTO> {

	@Override
	public BillboardDTO toDTO(Billboard e) {
		return new BillboardDTO(e.getId(), e.getNameBillboard());
	}

	@Override
	public Billboard toEntity(BillboardDTO dto) {
		return new Billboard(dto.getId(), dto.getNameBillboard());
	}

}
