package com.presidio.movieBooking.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/imagedata";
	
	
	@RequestMapping("/login")
	public ModelAndView login(Login login) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
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
		mv.setViewName("index");
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
		if(userService.getUserById(id).isLogin()) {
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
		}else {
			mv.setViewName("redirect:/login");
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
	
	
	@RequestMapping("/booking-{id}-{movie_no}-{movieName}")
	public ModelAndView book(@PathVariable("id") int id,@PathVariable("movie_no") int movie_no, @PathVariable("movieName")  String movieName,Integer noOfTickets) {
		ModelAndView mv = new ModelAndView();
		if(userService.getUserById(id).isLogin()) {
		mv.setViewName("book");
		mv.addObject("id",id);
		mv.addObject("movie_no",movie_no);
		mv.addObject("movieName",movieName);
		Movie movie = movieService.getMovieById(movie_no);
		mv.addObject("movie",movie);
		if(noOfTickets != null) {
			if(movie.noOfTicketsAvailable>= noOfTickets.intValue()) {
				mv.addObject("ticketMessage", movie.noOfTicketsAvailable+" Tickets Available");
				movie.setNoOfTicketsAvailable(movie.getNoOfTicketsAvailable()-noOfTickets);
				movie.setNoOfTicketsBooked(movie.getNoOfTicketsBooked()+noOfTickets);
				int previouslyBooked = 0;
				if(bookingService.getBookingById(id, movie_no)!=null) {
					previouslyBooked = bookingService.getTotalNoOfTiketsBookedForAMovie(id, movieName);
				}
				System.out.println(previouslyBooked);
				Bookings booking = new Bookings(new BookingCompositeKey(movie_no,id),previouslyBooked+noOfTickets.intValue(),movieName,((previouslyBooked+noOfTickets.intValue())*movie.getPrice()));
				bookingService.saveBooking(booking);
				mv.setViewName("redirect:/moviehome-"+id);
			}else if(movie.noOfTicketsAvailable==0) {
				mv.addObject("ticketMessage", "Soory House Full");
			}else {
				mv.addObject("ticketMessage","Only "+ (movie.noOfTicketsAvailable)+" availabe");
			}
		}
		}else {
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping("mybookings-{id}")
	public ModelAndView mybookings(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mybookings");
		List<Bookings> bookings =  bookingService.getAllUserBookings(id);
		if(bookings.size()>0) {
			double totalPrice = bookingService.getTotalPriceForAUser(id);
			mv.addObject("totalPrice",totalPrice);
			mv.addObject("bookings",bookings);
		}else {
			mv.addObject("message","No Bookings Available");
			mv.addObject("totalPrice", 0);
		}
		return mv;
	}
	
	@RequestMapping("cancelbooking-{userId}-{movie_no}")
	public ModelAndView cancelbooking(@PathVariable("userId") int userId,@PathVariable("movie_no") int movie_no) {
		ModelAndView mv = new ModelAndView();
		Bookings booking =  bookingService.getBookingById(userId, movie_no);
		Movie movie = movieService.getMovieById(movie_no);
		movie.setNoOfTicketsAvailable(movie.getNoOfTicketsAvailable()+booking.getNoOfTickets());
		movie.setNoOfTicketsBooked(movie.getNoOfTicketsBooked()-booking.getNoOfTickets());
		bookingService.cancelBooking(userId, movie_no);
		mv.setViewName("redirect:/mybookings-"+userId);
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView admin(@RequestParam(value="movieName",required = false)String movieName,@RequestParam(value="author",required = false) String author,@RequestParam(value="trailerLink",required = false) String trailerLink,@RequestParam(value="noOfTicketsAvailable",required = false)Integer noOfTicketsAvailable,@RequestParam(value="price",required = false)Double price,@RequestParam(value="description",required = false) String description,@RequestParam(value="file",required = false) MultipartFile file)throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin");
		if(movieName!=null && author!=null && description!=null) {
			Movie movie = new Movie();
			movie.setMovieName(movieName);
			movie.setAuthor(author);
			movie.setDescription(description);
			movie.setTrailerLink(trailerLink);
			movie.setPrice(price.doubleValue());
			movie.setNoOfTicketsBooked(0);
			movie.setNoOfTicketsAvailable(noOfTicketsAvailable.intValue());
			String filename = movie.getMovieName()+file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
			Path fileNameAndPath = Paths.get(uploadDirectory,filename);
		
			Files.write(fileNameAndPath, file.getBytes());
			
			movie.setMoviePhotoName(filename);
			movieService.saveMovie(movie);
		}
		return mv;
	}

}

