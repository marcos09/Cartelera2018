package ttps.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ttps.java.entity.Billboard;
import ttps.java.repository.BillboardRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
@Autowired
private BillboardRepository personRepository;

@Override
public void run(final ApplicationArguments args) throws Exception {
	getPersonRepository().save(new Billboard("Cartelera 1"));

	getPersonRepository().save(new Billboard("Cartelera 2"));

}
private BillboardRepository getPersonRepository() {
return personRepository;
}

}