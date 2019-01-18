package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.entity;

import javax.persistence.Entity;


@Entity
public class Cartelera extends GenericPersistentClass {
		
	public Cartelera() {
		super();
	}

	String nombreCartelera;

	public String getNombreCartelera() {
		return nombreCartelera;
	}

	private void setNombreCartelera(String nombreCartelera) {
		this.nombreCartelera = nombreCartelera;
	}

	public void editNombreCartelera(String nombreCartelera) {
		this.setNombreCartelera(nombreCartelera);
	}

	public Cartelera(String nombreCartelera) {
		super();
		this.editNombreCartelera(nombreCartelera);
	}
	
	public Cartelera(Long id, String nombreCartelera) {
		super();
		this.editNombreCartelera(nombreCartelera);
		this.editId(id);
	}

	
	
}
