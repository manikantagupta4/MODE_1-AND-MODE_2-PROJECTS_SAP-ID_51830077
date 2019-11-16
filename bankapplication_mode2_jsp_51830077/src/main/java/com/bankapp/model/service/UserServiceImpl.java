package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.exceptions.AccountNotFoundException;
import com.bankapp.model.exceptions.UserNotFoundException;
import com.bankapp.model.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepository;
	@Override
	public AppUser addUser(AppUser appUser) {
		userRepository.save(appUser);
		return appUser;
	}

	@Override
	public void blockUser(String email) {
		AppUser appUser=userRepository.findByEmail(email);
		appUser.setActive(false);
		userRepository.save(appUser);
	}

	@Override
	public List<AppUser> findAll() {
		List<AppUser> appUsers=userRepository.findAll();
		return appUsers;
	}

	@Override
	public AppUser findByEmail(String email) {
		AppUser appUser=userRepository.findByEmail(email);
		return appUser;
	}

	@Override
	public AppUser findById(Long id) {
	
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this email"));
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public AppUser update(Long id, AppUser appUser) {
		AppUser appUser2=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this email"));
		appUser2.setActive(appUser.getActive());
		userRepository.save(appUser2);
		return appUser2;
	}

}
