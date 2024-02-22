package org.jsp.usermvcdemo.controller;

import org.hibernate.annotations.AttributeAccessor;
import org.jsp.usermvcdemo.dao.UserDao;
import org.jsp.usermvcdemo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/open-register")
	public ModelAndView openregister(ModelAndView view) {
		view.setViewName("register");
		view.addObject("u",new User());
		return view;
	}
	@RequestMapping("/open-update")
	public ModelAndView openupdate(ModelAndView view) {
		view.setViewName("update");
		view.addObject("u",new User());
		return view;
	}
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User u ,ModelAndView view) {
		u=dao.saveUser(u);
		view.setViewName("display");
		view.addObject("message", "User saved with Id:" + u.getId());
		return view;
	}
	public ModelAndView update(@ModelAttribute User u,ModelAndView view) {
		u=dao.updateUser(u);
		if(u==null) {
			view.setViewName("display");
			view.addObject("message","user updated");
		}
		else {
			view.setViewName("display");
			view.addObject("message","user cannot be updated");
		}
		return view;
	}
	

	

}