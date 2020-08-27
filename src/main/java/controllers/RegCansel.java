package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.LoginUser;

@Controller
public class RegCansel {

	@Autowired
	public SessionFactory sf;
	
	
	@RequestMapping(value="/regCansel",method = RequestMethod.POST)
	public ModelAndView regCansel() {
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginUser", new LoginUser());
		return modelAndView;
	}
	
}
