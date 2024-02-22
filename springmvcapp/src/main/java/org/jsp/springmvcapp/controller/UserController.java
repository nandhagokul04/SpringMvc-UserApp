package org.jsp.springmvcapp.controller;

import org.jsp.springmvcapp.dao.UserDao;
import org.jsp.springmvcapp.dto.User;
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
   private UserDao userDao;

	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView view) {
		view.setViewName("register");
		view.addObject("u", new User());
		return view;
	}

	@RequestMapping("/open-update")
	public ModelAndView openUpdate(ModelAndView view) {
		view.setViewName("update");
		view.addObject("u", new User());
		return view;
	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping(value = "/register")
	public ModelAndView register(@ModelAttribute User u, ModelAndView view) {
		u = userDao.Saveuser(u);
		view.setViewName("print");
		view.addObject("message", "User saved with Id:" + u.getId());
		return view;
	}

	@PostMapping(value = "/update")
	public ModelAndView update(@ModelAttribute User u, ModelAndView view) {
		u = userDao.updateUser(u);
		if (u != null) {
			view.setViewName("print");
			view.addObject("message", "User Updated");
			return view;
		}
		view.setViewName("print");
		view.addObject("message", " Cannot update User as Id is invalid");
		return view;
	}

	@RequestMapping("/open-view")
	public String openView(String view) {
		return view;
	}

	@GetMapping(value = "/find-by-id")
	public ModelAndView findById(@RequestParam int id, ModelAndView view) {
		User u = userDao.findById(id);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid User Id");
		return view;
	}

	@GetMapping(value = "/verify-by-id")
	public ModelAndView verifyById(@RequestParam int id, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUser(id, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid User Id or Password");
		return view;
	}

	@GetMapping(value = "/verify-by-phone")
	public ModelAndView verifyByPhone(@RequestParam long phone, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUser(phone, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Phone Number or Password");
		return view;
	}

	@GetMapping(value = "/verify-by-email")
	public ModelAndView verifyByEmail(@RequestParam String email, @RequestParam String password, ModelAndView view) {
		User u = userDao.verifyUser(email, password);
		if (u != null) {
			view.setViewName("display");
			view.addObject("u", u);
			return view;
		}
		view.setViewName("print");
		view.addObject("message", "Invalid Email Id or Password");
		return view;
	}

	
	@RequestMapping("/delete-by-id")
	public ModelAndView delete(@RequestParam int id, ModelAndView view) {
		boolean deleted = userDao.deleteUser(id);
		if (deleted) {
			view.setViewName("print");
			view.addObject("message", "User deleted");
			return view;
		}
		
		
		view.setViewName("print");
		view.addObject("message", "Cannot delete user as Id is Invalid");
		return view;
	}
}
