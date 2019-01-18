package ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.entity.Cartelera;
import ar.edu.unlp.ttpsjava.ttpstrabajofinalbackend.repository.CarteleraRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
@Autowired
private CarteleraRepository personRepository;

@Override
public void run(final ApplicationArguments args) throws Exception {
	getPersonRepository().save(new Cartelera("Cartelera 1"));

	getPersonRepository().save(new Cartelera("Cartelera 2"));

}
private CarteleraRepository getPersonRepository() {
return personRepository;
}

}