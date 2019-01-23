package ttps.java.dto;

public class BillboardDTO implements GenericDTO{

	Long id;
	String nameBillboard;
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
