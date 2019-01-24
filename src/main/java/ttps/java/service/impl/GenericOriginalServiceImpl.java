package ttps.java.service.impl;

import ttps.java.dto.UserDTO;
import ttps.java.entity.RandomCity;
import ttps.java.entity.User;
import ttps.java.repository.RandomCityRepository;
import ttps.java.repository.UserRepository;
import ttps.java.service.GenericOriginalService;
import ttps.java.transformer.Transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenericOriginalServiceImpl implements GenericOriginalService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Transformer<User, UserDTO> transformer;
    
    @Autowired
    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }

	@Override
	public List<UserDTO> findProfesorUsers() {
		List<User> list = userRepository.findProfesorRole();
				return this.getTransformer().toListDTO(list);
	}

	public Transformer<User, UserDTO> getTransformer() {
		return transformer;
	}    
	
    
}
