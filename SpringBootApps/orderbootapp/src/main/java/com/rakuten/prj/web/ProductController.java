/**
 * 
 */
package com.rakuten.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rakuten.prj.entity.Product;
import com.rakuten.prj.service.OrderService;

/**
 * @author nishanth
 *
 */
@Controller
public class ProductController {
	@Autowired
	private OrderService service;
	
	@RequestMapping("productlist.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", service.getProducts());
		mav.setViewName("list.jsp");
		return mav;
	}
	
	@RequestMapping("productform.do")
	public ModelAndView getProductFrom() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new Product());
		mav.setViewName("form.jsp");
		return mav;
	}
	
	@RequestMapping("addproduct.do")
	public String addProduct(@ModelAttribute("product") Product p) {
		service.addProduct(p);
		return "index.jsp";
	}
}
