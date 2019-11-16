package com.bankapp.model.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity@Table(name="user_table")
public class AppUser {
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String name;
@Column(unique=true)
private String email;
@JsonIgnore
private String password;
private String[]roles;
private Boolean active;
private String phoneNumber;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = encoder.encode(password);
}
public String[] getRoles() {
	return roles;
}
public void setRoles(String[] roles) {
	this.roles = roles;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public AppUser(String name, String email, String password, String[] roles, Boolean active, String phoneNumber) {
	super();
	this.name = name;
	this.email = email;
	setPassword(password);
	this.roles = roles;
	this.active = active;
	this.phoneNumber = phoneNumber;
}

public AppUser() {
	
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
			+ Arrays.toString(roles) + ", active=" + active + ", phoneNumber=" + phoneNumber + "]";
}


}
