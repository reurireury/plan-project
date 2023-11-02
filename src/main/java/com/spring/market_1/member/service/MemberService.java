package com.spring.market_1.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.market_1.ObjectService;
import com.spring.market_1.member.dao.MemberDAO;
import com.spring.market_1.member.dto.MemberDTO;

@Service("memberService")
public class MemberService implements ObjectService 
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
