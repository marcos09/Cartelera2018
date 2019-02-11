package ttps.java.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Billboard extends GenericPersistentClass {
		
	public Billboard() {
		super();
		this.setPublications(new ArrayList<Publication>());
		this.setWriteUsers(new ArrayList<User>());
	}

	String nameBillboard;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Publication> publications;
	
	@ManyToMany
	List<User> writeUsers;
	
	public List<Publication> getPublications() {
		return publications;
	}

	private void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
	public void editPublications(List<Publication> publications) {
		this.setPublications(publications);
	}

	public void addPublication(Publication publication){
		this.getPublications().add(publication);
	}
	
	public void addWriteUser(User u) {
		this.getWriteUsers().add(u);
	}
	
	

	public List<User> getWriteUsers() {
		return writeUsers;
	}

	private void setWriteUsers(List<User> writeUsers) {
		this.writeUsers = writeUsers;
	}

	public String getNameBillboard() {
		return nameBillboard;
	}

	private void setNameBillboard(String nombreCartelera) {
		this.nameBillboard = nombreCartelera;
	}

	public void editNameBillboard(String nombreCartelera) {
		this.setNameBillboard(nombreCartelera);
	}

	public void editWriteUsers(List<User> writeUsers) {
		this.setWriteUsers(writeUsers);
	}
	
	public Billboard(String nombreCartelera) {
		super();
		this.editNameBillboard(nombreCartelera);
		this.setPublications(new ArrayList<Publication>());
		this.setWriteUsers(new ArrayList<User>());
		
	}
	
	public Billboard(Long id, String nombreCartelera) {
		super();
		this.editNameBillboard(nombreCartelera);
		this.editId(id);
		this.setPublications(new ArrayList<Publication>());
		this.setWriteUsers(new ArrayList<User>());

	}

	public Billboard(String nameBillboard, List<Publication> publications, List<User> writeUsers) {
		super();
		this.nameBillboard = nameBillboard;
		this.publications = publications;
		this.writeUsers = writeUsers;
	}

	public Billboard(Long id, String nameBillboard, List<Publication> publications, List<User> writeUsers) {
		super();
		this.nameBillboard = nameBillboard;
		this.publications = publications;
		this.writeUsers = writeUsers;
	}
		
	public Billboard(Long id, String nameBillboard, List<User> writeUsers) {
		super();
		this.nameBillboard = nameBillboard;
		this.writeUsers = writeUsers;
	}

	public Billboard(String nameBillboard, List<User> writeUsers) {
		super();
		this.nameBillboard = nameBillboard;
		this.writeUsers = writeUsers;
	}

	public void removeWriteUserById(Long id) {
		Predicate<User> userPredicate = u-> u.getId()  == id;
		this.getWriteUsers().removeIf(userPredicate);
	}

	public void removePublicationById(Long id) {
		Predicate<Publication> predicate = p-> p.getId()  == id;
		this.getPublications().removeIf(predicate);
	}

	
	
}
