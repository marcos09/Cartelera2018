package ttps.java.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.UserDTO;
import ttps.java.entity.Billboard;
import ttps.java.entity.User;

@Component
public class BillboardTransformer extends TransformerImpl<Billboard, BillboardDTO> {

	@Autowired
	private Transformer<User, UserDTO> userTransformer;
	
	@Override
	public BillboardDTO toDTO(Billboard e) {
		BillboardDTO billboard = new BillboardDTO(e.getId(), e.getNameBillboard());
		billboard.setWriteUsers(this.userTransformer.toListDTO(e.getWriteUsers()));
		return billboard;
				
	}

	@Override
	public Billboard toEntity(BillboardDTO dto) {
		Billboard billboard = new Billboard(dto.getId(), dto.getNameBillboard());
		billboard.editWriteUsers(this.userTransformer.toListEntity(dto.getWriteUsers()));
		return 	billboard;
				
	}


}
