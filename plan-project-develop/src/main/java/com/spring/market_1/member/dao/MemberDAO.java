package com.spring.market_1.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.market_1.ObjectDAO;
import com.spring.market_1.member.dto.MemberDTO;


@Repository("memberDAO")
public class MemberDAO implements ObjectDAO 
{

	@Override
	public List ListObjects() throws DataAccessException {
	
		return null;
	}

	@Override
	public String SelectObjects() throws DataAccessException {
	
		return null;
	}

	@Override
	public int AddObject() throws DataAccessException {
	
		return 0;
	}

	@Override
	public int RemoveObject() throws DataAccessException {
	
		return 0;
	}

	@Override
	public int ModObject() throws DataAccessException {
	
		return 0;
	}

	@Override
	public int UpdateObject() throws DataAccessException {
	
		return 0;
	}

	@Override
	public int SearchObject() throws Exception {
	
		return 0;
	}
	
	
}
