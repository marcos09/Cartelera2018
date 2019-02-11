package ttps.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.java.service.BillboardService;


@RestController
@CrossOrigin
@RequestMapping("/publications")
public class PublicationController {

	@Autowired
	private BillboardService billboardService;

	
	// Recupero un cartelera con el id
	@GetMapping(path = "/billboard/{id}", produces = "application/json")
	public Object show(@PathVariable(value = "id") Long id){
		return this.getBillboardService().publications(id);
	}

	
	public BillboardService getBillboardService() {
		return billboardService;
	}
	public void setBillboardService(BillboardService billboardService) {
		this.billboardService = billboardService;
	}
	
	

}
