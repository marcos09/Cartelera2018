package ttps.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.PublicationDTO;
import ttps.java.dto.UserDTO;
import ttps.java.service.BillboardService;

@RestController
@CrossOrigin
@RequestMapping("/billboards")
public class BillboardController {
	@Autowired
	private BillboardService carteleraService;
	
	@GetMapping(path ="/helloWorld")
	public String hello() {
		return "Hello world";
	}
	
	public BillboardService getCarteleraService() {
		return carteleraService;
	}
	
	@GetMapping(path = "/list")
	public List<BillboardDTO> list() {
		return this.getCarteleraService().list();
	}

	// Alta de cartelera
	@PutMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public void create(@RequestBody @Valid BillboardDTO billboard) {
		this.getCarteleraService().create(billboard);
	}

	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public void update(@RequestBody @Valid BillboardDTO billboard) {
		this.getCarteleraService().update(billboard);
	}

	// Recupero un cartelera con el id
	@GetMapping(path = "/{id}", produces = "application/json")
	public Object show(@PathVariable(value = "id") Long id){
		return this.getCarteleraService().retrive(id);
	}

	// Elimino una cartelera con el id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		this.getCarteleraService().delete(id);
	}
	
	
	@PutMapping(path = "/{id}/addWriteUser", consumes = "application/json", produces = "application/json")
	public void addWriteUser(@RequestBody  UserDTO userDTO, @PathVariable(value = "id") Long id) {
		this.getCarteleraService().addWriteUser(userDTO, id);	
	}

	@PutMapping(path = "/{id}/removeWriteUser", consumes = "application/json", produces = "application/json")
	public void removeWriteUser(@RequestBody  UserDTO userDTO, @PathVariable(value = "id") Long id) {
		this.getCarteleraService().removeWriteUser(userDTO, id);
	}

	
	@PutMapping(path = "/{id}/addPublication", consumes = "application/json", produces = "application/json")
	public void addPublication(@RequestBody  PublicationDTO publicationDTO, @PathVariable(value = "id") Long id) {
		this.getCarteleraService().addPublication(publicationDTO, id);
	}

	
	@PutMapping(path = "/{id}/removePublication", consumes = "application/json", produces = "application/json")
	public void removePublication(@RequestBody  PublicationDTO publicationDTO, @PathVariable(value = "id") Long id) {
		this.getCarteleraService().removePublication(publicationDTO, id);
	}


}
