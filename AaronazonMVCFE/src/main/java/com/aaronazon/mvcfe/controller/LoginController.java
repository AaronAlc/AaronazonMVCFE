package com.aaronazon.mvcfe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aaronazon.mvcfe.manager.LoginManager;
import com.aaronazon.mvcfe.view.UserView;

@Controller
@RequestMapping("/")
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginManager loginManager;
	
	@RequestMapping(value = "login")
	public ModelAndView getLoginPage() {
		ModelAndView mav = new ModelAndView("login/login");
		mav.addObject("userView", new UserView());
		return mav;
	}
	
	@RequestMapping(value = "registeruser", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute UserView userView,HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Attribute " + userView);
		ModelAndView mav = new ModelAndView("home/welcome");
		userView = loginManager.validateUser(userView);
		if(userView == null) {
			mav = new ModelAndView("register");
			mav.addObject("userView", new UserView());
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView registerUser() {
		ModelAndView mav = new ModelAndView("login/register");
		mav.addObject("userView", new UserView());
		return mav;
	}
	
}
