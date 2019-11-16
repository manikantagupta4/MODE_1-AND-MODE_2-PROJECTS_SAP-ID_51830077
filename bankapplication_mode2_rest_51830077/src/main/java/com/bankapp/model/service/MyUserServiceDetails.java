package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.config.SecUser;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.repo.UserRepository;
@Service
public class MyUserServiceDetails implements UserDetailsService{
	@Autowired
private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser=userRepository.findByEmail(email);
		if(appUser==null){
			throw new UsernameNotFoundException("user not found");
		}
		else{
			return new SecUser(appUser);
		}
		
	}

}
