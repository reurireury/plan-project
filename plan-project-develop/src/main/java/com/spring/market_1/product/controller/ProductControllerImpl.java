package com.spring.market_1.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.product.dto.ProductDTO;
import com.spring.market_1.product.service.ProductServiceImpl;

@Controller("productController")
public class ProductControllerImpl implements ProductController 
{
	@Autowired
	private ProductServiceImpl productService;
	@Autowired
	private ProductDTO productDTO;
	@Override
	@RequestMapping(value="/product/listProducts.do", method=RequestMethod.GET)
	public ModelAndView listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String viewName = getViewName(request);
		List productsList = productService.listProducts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productsList", productsList);
		return mav;
	}
	@Override
	public ModelAndView addProduct(ProductDTO product, HttpServletRequest requset, HttpServletResponse response)
			throws Exception 
	{
		return null;
	}
	@Override
	public ModelAndView removeProduct(int p_no, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		return null;
	}
	@Override
	public ModelAndView updateProduct(ProductDTO productDTO, HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		return null;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception 
	{
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
