package com.springmvc.config;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.service.QuoteService;

import Domain.User;

@Controller
public class HomeController {
	
	@Autowired
	private QuoteService quoteService=null;

	public HomeController() {
		System.out.println("in HC no-rgs constructor");
	}
	
//	@RequestMapping("/")
//	public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("in HC-> showHome()");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
//		return mv;
//	}
	
	@RequestMapping({"/home", "/"})
	public String showHome() {
		System.out.println("in HC-> showHome()");
		return "home";
	}
	
	@RequestMapping("/openInputView")
	public String showInputView(Model model) {
		System.out.println("in HC-> showInputView()");
		
		System.out.println("HC showInputView-> invoking quoteService.getQuote()");
		String quote = quoteService.getQuote();
		System.out.println("HC showInputView-> after quoteService.getQuote() quote = " + quote);
		model.addAttribute("qod", quote);
		model.addAttribute("user", new User());
		return "input";
	}
	
	@RequestMapping("/openWelcome")
	public String showWelcome(@ModelAttribute("user") @Valid User userBean, BindingResult result) {
		System.out.println("in HC->showWelcome() uname = " + userBean.getUname() + " email = " + userBean.getEmail());
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "input";
		}
		else {
			return "welcome";
		}
	}
}
