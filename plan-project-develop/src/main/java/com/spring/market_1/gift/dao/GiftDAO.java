package com.spring.market_1.gift.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.market_1.ObjectDAO;
import com.spring.market_1.gift.dto.GiftDTO;
@Repository("giftDAO")
public class GiftDAO implements ObjectDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List ListObjects() throws DataAccessException {
		List<GiftDTO> giftList = null;
		giftList = sqlSession.selectList("mapper.gift.selectAllGift");
		return giftList;
	}

	@Override
	public String SelectObjects() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int AddObject() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int RemoveObject() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ModObject() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateObject() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SearchObject() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
