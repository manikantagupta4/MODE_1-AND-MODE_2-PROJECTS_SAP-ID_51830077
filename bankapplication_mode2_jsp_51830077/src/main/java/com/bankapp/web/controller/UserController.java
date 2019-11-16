package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="allusers")
	public String getUsers(ModelMap map){
		map.addAttribute("users", userService.findAll());
		return "allusers";
	}
	
	@GetMapping(path="create")
	public String createUser(ModelMap map){
		map.addAttribute("user",new AppUser());
		return "createUser";
	}
	@PostMapping(path="create")
	public String createUserPost(ModelMap map,AppUser user){
		userService.addUser(user);
		return "redirect:allusers";
	}
	
	/*@GetMapping(path="/user")
	public List<AppUser> getUsers(){
		List<AppUser> appUsers=userService.findAll();
		return appUsers;
	}
	
	@GetMapping(path="/user/{id}")
	public AppUser getUserById(@PathVariable(name="id")Long id){
		AppUser appUser=userService.findById(id);
		return appUser;
	}
	
	@DeleteMapping(path="/user/{id}")
	public void deleteUserById(@PathVariable(name="id")Long id){
		userService.deleteById(id);
		
	}
	@PutMapping(path="/user/{id}")
	public AppUser updateUser(@PathVariable(name="id")Long id,@RequestBody AppUser appUser){
		userService.update(id, appUser);
		return appUser;
	}
	@PostMapping(path="/user")
	public AppUser create(@RequestBody AppUser appUser){
		userService.addUser(appUser);
		return appUser;
	}
	*/
}
