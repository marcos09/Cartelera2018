package ttps.java.dto;

import java.util.List;

public class BillboardDTO extends GenericDTO{

	Long id;
	String nameBillboard;
	
	List<UserDTO> writeUsers;
	List<PublicationDTO> publications;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameBillboard() {
		return nameBillboard;
	}
	public void setNameBillboard(String nameBillboard) {
		this.nameBillboard = nameBillboard;
	}
	
	public BillboardDTO(Long id, String nameBillboard) {
		super();
		this.id = id;
		this.setNameBillboard(nameBillboard);
	}
	
	public BillboardDTO() {
		super();
	}
	
}
