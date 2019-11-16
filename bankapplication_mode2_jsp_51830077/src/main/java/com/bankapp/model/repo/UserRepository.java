package com.bankapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.model.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long> {
public AppUser findByEmail(String email);
}
