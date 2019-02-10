package ttps.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ttps.java.entity.Billboard;
import ttps.java.entity.User;
import ttps.java.repository.BillboardRepository;
import ttps.java.repository.UserRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {

@Autowired
private BillboardRepository billboardRepository;

@Autowired
private UserRepository userRepository;


@Override
public void run(final ApplicationArguments args) throws Exception {
	getBillboardRepository().save(new Billboard("Cartelera 1"));
	Billboard b = new Billboard("Cartelera 2");
	User u = new User(null, "username", "password", "firstname", "lastname");
	userRepository.save(u);
	b.addWriteUser(u);
	getBillboardRepository().save(new Billboard("Cartelera 2 con usuario"));

}
private BillboardRepository getBillboardRepository() {
	return billboardRepository;
}

}