package com.spring.market_1.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.market_1.product.dao.ProductDAOImpl;
import com.spring.market_1.product.dto.ProductDTO;

@Service("productService")
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDAOImpl productDAO;

	@Override
	public List listProducts() throws DataAccessException 
	{
		List productList = null;
		productList = productDAO.selectAllProductsList();
		return productList;
	}

	@Override
	public int addProduct(ProductDTO productDTO) throws DataAccessException 
	{
		return 0;
	}

	@Override
	public int removeProduct(int p_no) throws DataAccessException 
	{
		return 0;
	}

	@Override
	public int updateProduct(int p_no) throws DataAccessException 
	{
		return 0;
	}
	
	
}
