package com.customerapp.web.controller;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerapp.model.persistance.User;
import com.customerapp.model.persistance.UserNotFoundException;
import com.customerapp.model.service.UserService;
@Controller
public class UserMgtController {

	@Autowired
	private UserService userService;

	//@PostConstruct
	public void init() {
		userService.addUser(new User("manikanta", "mani@gmail.com", "gupta", "admin",
				true));
		userService.addUser(new User("ekta", "ekta@raj.com", "ekta123", "mgr",
				true));
		userService.addUser(new User("gunika", "gunika@raj.com", "gunika123",
				"emp", true));
	}


	@RequestMapping(value = "login")
	public String loginGet(HttpServletRequest req, ModelMap map) {
		map.addAttribute("userbean", new UserFormBean());
		map.addAttribute("error", req.getParameter("error"));
		return "login";
	}
	
	

	@RequestMapping(value = "logout")
	public String logout(ModelMap map) {
		map.addAttribute("userbean", new UserFormBean());
		map.addAttribute("message", "you are successfully logged out!");
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req,
			@Valid @ModelAttribute(value = "userbean") UserFormBean userbean,
			BindingResult bindingResult) {

		User user = null;
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			try {
				user = userService.getUser(userbean.getEmail(),
						userbean.getPassword());
			} catch (UserNotFoundException e) {
				return "redirect:login?error=login failed";
			}
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", user);
		}
		return "redirect:allcustomers";

	}
	@RequestMapping(value="create")
	public String createaccGet(ModelMap map){
		map.addAttribute("user", new User());
		return "createaccount";
	}
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createaccPost(User user){
		userService.addUser(user);
		return "redirect:login";
	}
	@ModelAttribute(value="profileList")
	public List<String> getProfile(){
	return	Arrays.asList("admin","mgr","emp");
	}
	@ModelAttribute(value="activeList")
	public List<String> getActive(){
	return	Arrays.asList("true","false");
	}

}
