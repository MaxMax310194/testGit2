package controllers;


import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import daoImplUser.DaoImplUser;
import model.LoginUser;
import model.User;




@Controller
@SessionAttributes(value = {"userSession"})
public class LoginController {

	
	@Autowired
	public SessionFactory sf;
	
	
	
	public User checkUser(LoginUser loginUser) {
		
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		User user = daoImplUser.getUserByNameAnDPassword(loginUser.getName(), loginUser.getPassword());
		if (user!=null) {
			
			return user;
		}else {
			return null;
		}
		
		
	}
	
	@RequestMapping(value="/startLogin",method = RequestMethod.GET)
	public ModelAndView startLogin() {
		
		return new ModelAndView("login","loginUser",new LoginUser());
		
	}
	@RequestMapping(value="/enterLogin",method = RequestMethod.POST)
	public ModelAndView enterLogin(@Valid @ModelAttribute("loginUser")LoginUser loginUser,BindingResult br) {
		ModelAndView modelAndView = null;
		
		
		if (br.hasErrors()) {
			return new ModelAndView("login","loginUser", loginUser);
		}else {
			User user = checkUser(loginUser);
			if (user!=null) {
				modelAndView = new ModelAndView("user");
				modelAndView.addObject("user",user);
				
			}else {
				modelAndView = new ModelAndView("login");
			}
			
			if (user == null) {
				br.rejectValue("password", "error.LoginUser", "An incorrect login or password");
			}
			if (br.hasErrors()) {
				return new ModelAndView("login","loginUser", loginUser);
			}
			modelAndView = new ModelAndView("user");
			modelAndView.addObject("userSession",user);
			return modelAndView;
		}
		
		
	}
	
}
