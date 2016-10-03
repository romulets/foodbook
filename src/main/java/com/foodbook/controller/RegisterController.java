package com.foodbook.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.UserService;
import com.foodbook.modelview.RegisterForm;
import com.foodbook.modelview.RegisterFormValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addValidators(new RegisterFormValidator());
	}	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		RegisterForm register = new RegisterForm();
		model.addAttribute("register", register);
		return "register/form";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(
			@Valid @ModelAttribute("register") RegisterForm register, 
			BindingResult result) {
		
		if(result.hasErrors())
			return "register/form";
		
		service.saveUser(register.getUser());
		return "redirect:/timeline";			
	}
	
}