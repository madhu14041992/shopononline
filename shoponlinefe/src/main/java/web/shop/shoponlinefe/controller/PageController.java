package web.shop.shoponlinefe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "welcome to Spring mvc");
		mv.addObject("title", "Home");
		mv.addObject("userClickhome",true);
		return mv;

	}
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "welcome to Spring mvc");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;

	}
	/*@RequestMapping(value = "/listProducts")
	public ModelAndView listOfProducts() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "welcome to Spring mvc");
		mv.addObject("title", "P");
		mv.addObject("userClickAbout",true);
		return mv;

	}*/
	@RequestMapping(value = "/contact")
	public ModelAndView listOfProducts() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "welcome to Spring mvc");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;

	}
	
/*	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting){
	if(greeting==null){
		greeting="HELLO THERE";
	}
		ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting",greeting);
	return mv;
}*/
	
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting")String greeting){
	if(greeting==null){
		greeting="HELLO THERE";
	}
		ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting",greeting);
	return mv;
	}*/
}