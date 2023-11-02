package com.spring.market_1.product.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.market_1.product.dto.ProductDTO;

public interface ProductService 
{
	public List listProducts() throws DataAccessException;
	public int addProduct(ProductDTO productDTO) throws DataAccessException;
	public int removeProduct(int p_no) throws DataAccessException;
	public int updateProduct(int p_no) throws DataAccessException;
}
