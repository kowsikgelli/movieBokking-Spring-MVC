package com.presidio.movieBooking.controllers;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.presidio.movieBooking.models.Login;
import com.presidio.movieBooking.models.Movie;
import com.presidio.movieBooking.models.User;
import com.presidio.movieBooking.services.MovieService;
import com.presidio.movieBooking.services.UserService;


@Controller
public class MovieController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieService movieService;
	
	
	@RequestMapping("/login")
	public ModelAndView login(Login login) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/loginv2");
		if((login.getEmail() !=null) && (login.getPassword() != null)) {
			if(userService.getUserById(login.getEmail()) != null && userService.getUserById(login.getEmail()).getPassword().equals(login.getPassword())) {
				System.out.print("entered valid");
				String redicect_url = "redirect:/moviehome-"+login.getEmail();
				mv.setViewName(redicect_url);
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
	
	@RequestMapping("/moviehome-{email}")
	public ModelAndView moviehome(@PathVariable("email") String email) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("moviehome");
		List<Movie> movies = movieService.getAllMovies();
		mv.addObject("movies", movies);
		for(Movie m:movies) {
			System.out.println(m.getMovieName());
		}
		System.out.println(email);
		return mv;
 	}
	
	@RequestMapping("/admin")
	public ModelAndView admin(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin");
		if(movie.getMovieName()!=null && movie.getAuthor()!=null && movie.getDescription()!=null) {
			movieService.saveMovie(movie);
		}
		return mv;
	}
}
