package com.presidio.movieBooking.controllers;

import java.util.*;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.presidio.movieBooking.models.BookingCompositeKey;
import com.presidio.movieBooking.models.Bookings;
import com.presidio.movieBooking.models.Login;
import com.presidio.movieBooking.models.Movie;
import com.presidio.movieBooking.models.User;
import com.presidio.movieBooking.services.BookingRepositoryService;
import com.presidio.movieBooking.services.MovieService;
import com.presidio.movieBooking.services.UserService;


@Controller
public class MovieController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	BookingRepositoryService bookingService;
	
	
	@RequestMapping("/login")
	public ModelAndView login(Login login) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		if((login.getEmail() !=null) && (login.getPassword() != null)) {
			if(userService.getUserByEmail(login.getEmail()) != null && userService.getUserByEmail(login.getEmail()).getPassword().equals(login.getPassword())) {
				userService.setLogin(login.getEmail());
				String redicect_url = "redirect:/moviehome-"+userService.getUserByEmail(login.getEmail()).getUserId();
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
		mv.setViewName("/register");
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
	
	@RequestMapping("/moviehome-{id}")
	//@ResponseBody
	public ModelAndView moviehome(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		if(userService.getUserById(id)==null) {
			mv.setViewName("redirect:/register");
		}else {
			if(userService.getUserById(id).isLogin()) {
				mv.setViewName("moviehome");
				mv.addObject("id", id);
				mv.addObject("username",userService.getUserById(id).getUserName());
				List<Movie> movies = movieService.getAllMovies();
				mv.addObject("movies", movies);
			}else {
				mv.setViewName("redirect:/login");
			}
		}
		
		
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
	
	@RequestMapping("/logout-{id}")
	public ModelAndView logout(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		userService.setLogout(id);
		mv.setViewName("redirect:/login");
		return mv;
	}
	
	
	@RequestMapping("/booking-{id}-{movie_no}")
	public ModelAndView book(@PathVariable("id") int id,@PathVariable("movie_no") int movie_no, Integer noOfTickets) {
		System.out.println("hello  ......"+id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book");
		mv.addObject("id",id);
		mv.addObject("movie_no",movie_no);
		if(noOfTickets != null) {
			
			if(noOfTickets.intValue()>0) {
				System.out.println(id);
				System.out.println(movie_no);
				System.out.println(noOfTickets.intValue());
				Bookings booking = new Bookings(new BookingCompositeKey(movie_no,id),noOfTickets.intValue());
				System.out.println(booking.getNoOfTickets());
				System.out.println(booking.getId());
				bookingService.saveBooking(booking);
				mv.setViewName("redirect:/moviehome-"+id);
			}
		}		
		return mv;
	}
	
	@RequestMapping("mybookings-{id}")
	public ModelAndView mybookings(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mybookings");
		List<Bookings> bookings =  bookingService.getAllUserBookings(id);
		mv.addObject("bookings",bookings);
		return mv;
	}
	
	@RequestMapping("cancelbooking-{userId}-{movie_no}")
	public ModelAndView cancelbooking(@PathVariable("userId") int userId,@PathVariable("movie_no") int movie_no) {
		ModelAndView mv = new ModelAndView();
		bookingService.cancelBooking(userId, movie_no);
		mv.setViewName("redirect:/mybookings-"+userId);
		return mv;
	}
}
