package com.stk.car.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stk.car.model.UserEntity;
import com.stk.car.repository.UserRepository;

 
@Service("userServiceAut")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		UserEntity userEntity = userRepository.findUserByUsername(username);

		user = null;
		
		if(userEntity==null) {
			throw new UsernameNotFoundException("User doesn't exists.");
		} else {
			
			Profile profile = new Profile();
			profile.setProfileName("ROLE_USER");
		
			List<Profile> listProfiles = new ArrayList<Profile>();
			listProfiles.add(profile);
		
			user = new User();
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			user.setCredentialsNonExpired(true);
			user.setEnabled(true);
			user.setUserId(userEntity.getId());
			user.setPassword(userEntity.getPassword().trim());
			user.setUsername(userEntity.getUsername().trim());
			user.setProfiles(listProfiles);
			user.setUserEntity(userEntity);
		}
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}