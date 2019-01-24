package ttps.java.dto;

public class PublicationDTO extends GenericDTO {

	String title;
	String description;
	Boolean coments;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getComents() {
		return coments;
	}
	public void setComents(Boolean coments) {
		this.coments = coments;
	}
	public PublicationDTO(String title, String description, Boolean coments) {
		super();
		this.setTitle(title);
		this.setDescription(description);
		this.setComents(coments);
	}

	public PublicationDTO(Long id, String title, String description, Boolean coments) {
		super();
		this.setTitle(title);
		this.setDescription(description);
		this.setComents(coments);
		this.setId(id);
	}

}
