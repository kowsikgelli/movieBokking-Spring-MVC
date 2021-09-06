package com.presidio.movieBooking.controllers;

import java.util.ArrayList;

import javax.persistence.Id;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.presidio.movieBooking.models.Login;
import com.presidio.movieBooking.models.Register;
import com.presidio.movieBooking.models.User;
import com.presidio.movieBooking.services.UserRepository;
import com.presidio.movieBooking.services.UserService;

import antlr.collections.List;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Controller
public class MovieController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/login")
	public ModelAndView login(Login login) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/loginv2");
		if((login.getEmail() !=null) && (login.getPassword() != null)) {
			if(userService.getUserById(login.getEmail()) != null && userService.getUserById(login.getEmail()).getPassword().equals(login.getPassword())) {
				System.out.print("entered valid");
				mv.setViewName("redirect:/moviehome");
				return mv;
			}else {
				mv.addObject("invalidCredentials", "Invalid credentials");
			}
		}
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(User user) {
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("/registerv2");
		if(user.getUserName()!=null &&  user.getEmail()!=null && user.getPassword() != null) {
			ArrayList<String> emails = new ArrayList<String>();
			for(User u:userService.getAllUsers()) {
				emails.add(u.getEmail());
			}
			if(emails.contains(user.getEmail())) {
				mv.addObject("userexists","User already exists click login to continue");
				return mv;	
			}
			else {
				userService.saveUser(user);
				mv.setViewName("redirect:/login");
				return mv;
			}
		}
		return mv;
	}
	
	@RequestMapping("/moviehome")
	public ModelAndView moviehome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("moviehome");
		return mv;
 	}
}
