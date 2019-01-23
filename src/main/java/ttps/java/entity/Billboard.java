package ttps.java.entity;

import javax.persistence.Entity;

@Entity
public class Billboard extends GenericPersistentClass {
		
	public Billboard() {
		super();
	}

	String nameBillboard;

	public String getNombreCartelera() {
		return nameBillboard;
	}

	private void setNameBillboard(String nombreCartelera) {
		this.nameBillboard = nombreCartelera;
	}

	public void editNameBillboard(String nombreCartelera) {
		this.setNameBillboard(nombreCartelera);
	}

	public Billboard(String nombreCartelera) {
		super();
		this.editNameBillboard(nombreCartelera);
	}
	
	public Billboard(Long id, String nombreCartelera) {
		super();
		this.editNameBillboard(nombreCartelera);
		this.editId(id);
	}

	
	
}
