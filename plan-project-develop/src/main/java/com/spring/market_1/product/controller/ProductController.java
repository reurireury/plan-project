package com.spring.market_1.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.product.dto.ProductDTO;

public interface ProductController 
{
	public ModelAndView listProducts(HttpServletRequest requset, HttpServletResponse response) throws Exception;
	public ModelAndView addProduct(ProductDTO product, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeProduct(int p_no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateProduct(ProductDTO productDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
