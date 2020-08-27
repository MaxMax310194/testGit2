package controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import daoImplUser.DaoImplUser;
import model.LoginUser;
import model.User;

@Controller
public class DeleteController {

	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value = "/deleteUserTese",method = RequestMethod.POST)
	public ModelAndView deleteUserTese(@SessionAttribute("userSession")User userSession) {
		
		
		ModelAndView modelAndView = null;
		DaoImplUser daoImplUser = new DaoImplUser(sf);
		daoImplUser.delUser(userSession);
		modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginUser", new LoginUser());
		
	
		return modelAndView;
	}
}
