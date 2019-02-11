package ttps.java.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.java.dto.UserDTO;
import ttps.java.entity.User;
import ttps.java.repository.UserRepository;
import ttps.java.service.UserService;

@Service
@Transactional
public class UserServiceImpl  extends GenericServiceImpl<UserRepository, User, UserDTO> implements  UserService {

}
