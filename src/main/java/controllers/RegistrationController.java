package controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import daoImplUser.DaoImplUser;
import model.LoginUser;
import model.RegUser;
import model.User;


@Controller
public class RegistrationController {

	@Autowired
	public SessionFactory sf;
	

	
	@RequestMapping(value="/jumpToRegForm",method = RequestMethod.GET)
	public ModelAndView jumpToRegForm() {
		
		ModelAndView modelAndView = new ModelAndView("registration","regUser" , new RegUser());
		Map<String,String> countrys = new LinkedHashMap<>();
		Map<String,String> states = new LinkedHashMap<>();
		Map<String,String> citys= new LinkedHashMap<>();
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
	@RequestMapping(value= "/startFormReg",method = RequestMethod.POST)
	public ModelAndView regUser(@Valid @ModelAttribute("regUser")RegUser regUser, BindingResult br) {
	
		
		  ModelAndView modelAndView = new ModelAndView("login","loginUser",new LoginUser()); 
		  DaoImplUser daoImplUser = new DaoImplUser(sf); 
		  User user = daoImplUser.getUserByName(regUser.getName());
		  if (user!=null) {
				br.rejectValue("name", "error.RegistrationVoter", "An account already exists for this name");
				return new ModelAndView("registration","regUser" , regUser);
			}else if (br.hasErrors()) {
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
				modelAndView = new ModelAndView("registration","regUser" , regUser);
				modelAndView.addObject("countrys", countrys);
				modelAndView.addObject("states", states);
				modelAndView.addObject("citys", citys);
				
				return modelAndView;
			}else {
				user = new User(regUser.getName(),regUser.getPassword(),regUser.getEmail(),regUser.getCountry(),
						regUser.getStateProv());
				 daoImplUser.addUser(user);
				 
			}
			
			return modelAndView;
		
		
		
		
	}
	
}
