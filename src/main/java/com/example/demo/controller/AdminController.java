package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.ViewModels.CreateItemViewModel;
import com.example.demo.ViewModels.LoginViewModel;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Size;

@Controller
public class AdminController {
	
	@GetMapping({"/login","/login"})
	public String showLoginForm(Model model) {
		LoginViewModel loginViewModel=new LoginViewModel();
		model.addAttribute("model",loginViewModel);	
		return "login";
	}
	
	
	
	@PostMapping({"/login","/home"})
	public String Login(@Validated @ModelAttribute("model") LoginViewModel loginModel,
						HttpServletRequest request,
		      			BindingResult result,
		      			Model model) {
		if(result.hasErrors())
			return "redirect:/home";
		
		if(!loginModel.getUsername().equals("Admin1122??") || !loginModel.getPassword().equals("Admin1122??"))
			return "redirect:/home";
		
        HttpSession session = request.getSession();
        session.setAttribute("IsAuthenticated",true);

        
		return "redirect:/home";
	}
	
	@PostMapping({"/home/logot","/home"})
	public String Logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/home";
	}
	
	
}
