package com.spring.market_1.product.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.market_1.product.dto.ProductDTO;

public interface ProductDAO 
{
	public List selectAllProductsList() throws DataAccessException;
	public int insertProduct(ProductDTO productDTO) throws DataAccessException;
	public int deleteProduct(int p_no) throws DataAccessException;
	public int updateProduct(int p_no) throws DataAccessException;
}
