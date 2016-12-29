package org.kb141.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("/login")
	public void login() {
		logger.info("LOGIN");
	}
	
	@GetMapping("/forStudent")
	@Secured({"ROLE_STUDENT"})
	public void doForStudent() {
		logger.info("Student");
	}
	
	@Secured({"ROLE_TEACHER"})
	@GetMapping("/forTeacher")
	public void doForTeacher() {
		logger.info("Teacher");
	}

	
	@Secured({"ROLE_FACULITY"})
	@GetMapping("/forFaculity")
	public void doForFaculity() {
		logger.info("Faculity");
	}
	
	@GetMapping("/myLogout")
	public void logout(HttpServletResponse response) {
		logger.info("logout get");
		Cookie cookie = new Cookie("LOGIN", "SuperSenyo");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	@PostMapping("/myLogout")
	public void logoutPost() {
		logger.info("logout post");
	}
	
	
	@GetMapping("/forAll")
	public void doForAll() {
		logger.info("ALL");
	}
	
	@PostMapping("/forAll2")
	public void doForAll2() {
		logger.info("ALL2");
	}
	
	@GetMapping("/myPage")
	public String myPage(HttpServletResponse response){
		logger.info("LOGIN SUCCESS");
		Cookie cookie = new Cookie("LOGIN", "SuperSenyo");
		cookie.setMaxAge(24*60*60);
		
		response.addCookie(cookie);
		
		return "redirect:forStudent";
	}
	
}
