package com.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.service.QuoteService;

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
		return "home";
	}
	
	@RequestMapping("/openInputView")
	public String showInputView(Model model) {
		System.out.println("in HC-> showInputView()");
		String quote = quoteService.getQuote();
		model.addAttribute("qod", quote);
		return "input";
	}
	
}
