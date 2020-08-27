package controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import model.RegUser;
import model.User;

@Controller
public class GoToUpUser {

	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value ="/goToUpUser",method = RequestMethod.POST)
	public ModelAndView goToUpUser(@SessionAttribute("userSession")User userSession,@ModelAttribute("regUser")RegUser regUser) {
		
		ModelAndView modelAndView =  new ModelAndView("updateUser");
		
		modelAndView.addObject("regUser",new RegUser(userSession.getName(), userSession.getPassword(), userSession.getEmail(), userSession.getCountry(), 
				userSession.getStateProv()));
		Map<String,String> countrys = new LinkedHashMap<>();
		Map<String,String> states = new LinkedHashMap<>();
		Map<String,String> citys = new LinkedHashMap<>();
		countrys.put("USA","USA");
		countrys.put("Canada","Canada");
		states.put("Idaho","Idaho");
		states.put("Iowa","Iowa");
		states.put("Alabama","Alabama");
		states.put("Colorado","Colorado");
		states.put("Minnesota" ,"Minnesota");
		citys.put("Calgary","Calgary");
		citys.put("Toronto","Toronto");
		citys.put("Ontario","Ontario");
		citys.put("Montreal","Montreal");
		citys.put("Quebec","Quebec");
		modelAndView.addObject("countrys", countrys);
		modelAndView.addObject("states", states);
		modelAndView.addObject("citys", citys);
		
		return modelAndView;
	}
}
