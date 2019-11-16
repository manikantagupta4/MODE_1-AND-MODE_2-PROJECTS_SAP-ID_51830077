package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.AppUser;

public interface UserService {
public AppUser addUser(AppUser appUser);
public void blockUser(String email);
public List<AppUser> findAll();
public AppUser findByEmail(String email);
public AppUser findById(Long id);
public void deleteById(Long id);
public AppUser update(Long id,AppUser appUser);
}
