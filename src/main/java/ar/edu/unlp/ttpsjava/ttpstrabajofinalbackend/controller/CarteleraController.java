package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.dto.CarteleraDTO;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.service.CarteleraService;

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
