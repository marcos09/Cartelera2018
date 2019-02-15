package ttps.java.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ttps.java.dto.BillboardDTO;
import ttps.java.dto.UserDTO;
import ttps.java.entity.Billboard;
import ttps.java.entity.User;
import ttps.java.repository.UserRepository;
import ttps.java.service.UserService;
import ttps.java.transformer.Transformer;

@Component
public class AppUserDetailsService extends GenericServiceImpl<UserRepository, User, UserDTO> implements  UserService,  UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private Transformer<Billboard,BillboardDTO> billboardsTransform;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

    //Corroborar si este método es necesario. Puede que no se pueda refactorizar o inutilizar. 
	@Override
	public UserDTO getLoginUser() {
		User activeUser;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		
		System.out.println(username);
		
	    activeUser = this.getRepository().findByUsername(username);
	    // Validación que debería hacer spring cuando se requiera autenticación
	    if(activeUser == null) {
	    	return null;
	    }
		return this.getTransformer().toDTO(activeUser);
	}

	@Override
	public Collection<BillboardDTO> getBillboardsSubscriptions() {
		return this.getBillboardsTransform().toCollectionDTO(this.getCurrentUser().getBillboards());
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Transformer<Billboard, BillboardDTO> getBillboardsTransform() {
		return billboardsTransform;
	}

	public void setBillboardsTransform(Transformer<Billboard, BillboardDTO> billboardsTransform) {
		this.billboardsTransform = billboardsTransform;
	}
}
