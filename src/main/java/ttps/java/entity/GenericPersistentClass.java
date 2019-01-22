package ttps.java.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract class GenericPersistentClass {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}
	
	public void editId(Long id) {
		this.setId(id);
	}

}
