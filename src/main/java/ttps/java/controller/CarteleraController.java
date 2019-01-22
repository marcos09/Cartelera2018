package ttps.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.java.dto.CarteleraDTO;
import ttps.java.service.CarteleraService;

@RestController
@RequestMapping("/cartelera")
public class CarteleraController {
	@Autowired
	private CarteleraService carteleraService;
	
	@GetMapping(path ="/helloWorld")
	public String hello() {
		return "Hello world";
	}
		
	@GetMapping(path = "/list")
	public List<CarteleraDTO> list() {
		return this.getCarteleraService().list();
	}

	public CarteleraService getCarteleraService() {
		return carteleraService;
	}


}
