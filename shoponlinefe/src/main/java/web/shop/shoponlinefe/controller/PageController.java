package web.shop.shoponlinefe.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.shop.shoponlinebackend.dao.CategoryDAO;
import web.shop.shoponlinebackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories",categoryDAO.listOfCategory());
		mv.addObject("userClickhome",true);
		return mv;

	}
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;

	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;

	}
	
	/*
	 *    Methods To Load All the products  
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories",categoryDAO.listOfCategory());
		mv.addObject("userClickAllProducts",true);
		return mv;

	}
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable ("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		//CategoryDAO to fetch single category
		Category category=null;
		category=categoryDAO.getCategoryById(id);
		
		mv.addObject("title",category.getName());
		//passing list of categories
		mv.addObject("categories",categoryDAO.listOfCategory());
		//passing the single  category
		mv.addObject("category",category);
	
		mv.addObject("userClickCategoryProducts",true);
		return mv;

	}
	
	

}