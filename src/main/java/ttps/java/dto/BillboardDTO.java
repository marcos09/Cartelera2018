package ttps.java.dto;

import java.util.ArrayList;
import java.util.List;

public class BillboardDTO extends GenericDTO{

	Long id;
	String nameBillboard;
	
	List<UserDTO> writeUsers;
	List<PublicationDTO> publications;
	
	public List<UserDTO> getWriteUsers() {
		return writeUsers;
	}
	public void setWriteUsers(List<UserDTO> writeUsers) {
		this.writeUsers = writeUsers;
	}
	public List<PublicationDTO> getPublications() {
		return publications;
	}
	public void setPublications(List<PublicationDTO> publications) {
		this.publications = publications;
	}
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
		this.setPublications(new ArrayList<PublicationDTO>());
		this.setWriteUsers(new ArrayList<UserDTO>());
		
	}
	
	public BillboardDTO() {
		super();
		this.setPublications(new ArrayList<PublicationDTO>());
		this.setWriteUsers(new ArrayList<UserDTO>());
	}
	
	
	
}
