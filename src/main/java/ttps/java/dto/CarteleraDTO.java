package ttps.java.dto;

public class CarteleraDTO implements GenericDTO{

	Long id;
	String nombreCartelera;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreCartelera() {
		return nombreCartelera;
	}
	public void setNombreCartelera(String nombreCartelera) {
		this.nombreCartelera = nombreCartelera;
	}
	
	public CarteleraDTO(Long id, String nombreCartelera) {
		super();
		this.id = id;
		this.nombreCartelera = nombreCartelera;
	}
	public CarteleraDTO() {
		super();
	}
	
}
