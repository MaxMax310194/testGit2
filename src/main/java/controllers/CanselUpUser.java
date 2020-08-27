package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CanselUpUser {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/canselUpUse",method = RequestMethod.POST)
	public ModelAndView canselUpUserWithUser() {
		
		ModelAndView modelAndView = new ModelAndView("user");
		
		return modelAndView;
	}
	
}
