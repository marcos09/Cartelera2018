package ttps.java.entity;

import javax.persistence.Entity;

@Entity
public class Publication extends GenericPersistentClass{
	String title;
	String description;
	Boolean coments;
	
	
	
	public Publication() {
		super();
	}
	
	
	public Publication(String title, String description, Boolean comemnts) {
		super();
		this.title = title;
		this.description = description;
		this.coments = comemnts;
	}

	public Publication(Long id, String title, String description, Boolean comemnts) {
		super();
		this.editId(id);
		this.title = title;
		this.description = description;
		this.coments = comemnts;
	}


	public String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	
	public void editTitle(String title) {
		this.setTitle(title);
	}

	public String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	
	public void editDescription(String description) {
		this.setDescription(title);
	}

	public Boolean getComents() {
		return coments;
	}
	private void setCoemnts(Boolean comemnts) {
		this.coments = comemnts;
	}
	
	public void editTitle(Boolean coments) {
		this.setCoemnts(coments);
	}

}
