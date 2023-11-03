package com.spring.market_1.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.market_1.product.dto.ProductDTO;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List selectAllProductsList() throws DataAccessException 
	{
		List<ProductDTO> productsList = null;
		productsList = sqlSession.selectList("mapper.product.selectAllProductList");
		return productsList;
	}

	@Override
	public int insertProduct(ProductDTO productDTO) throws DataAccessException 
	{
		return 0;
	}

	@Override
	public int deleteProduct(int p_no) throws DataAccessException 
	{
		return 0;
	}

	@Override
	public int updateProduct(int p_no) throws DataAccessException 
	{
		return 0;
	}
	
}
