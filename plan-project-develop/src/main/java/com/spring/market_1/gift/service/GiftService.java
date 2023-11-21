package com.spring.market_1.gift.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.spring.market_1.ObjectService;
import com.spring.market_1.gift.dao.GiftDAO;
import org.springframework.stereotype.Service;

@Service("giftService")
public class GiftService implements ObjectService{
	@Autowired
	private GiftDAO giftDAO;
	
	@Override
	public List ListObjects() throws DataAccessException {
		List giftList = null;
		giftList = giftDAO.ListObjects();
		return giftList;
	}
	public List searchGifts(String category1, String category2, String item_brand, String item_name) throws DataAccessException {
		
        return giftDAO.searchGifts(category1, category2, item_brand, item_name);
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
