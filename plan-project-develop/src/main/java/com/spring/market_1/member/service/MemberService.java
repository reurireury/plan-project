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
	@Autowired
	private MemberDAO memberDAO;
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
	/*회원가입*/
	public void AddObject(MemberDTO member) {
		memberDAO.AddObject(member);
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
	/* 회원정보 수정 */
	public void UpdateObject(MemberDTO member) throws DataAccessException {
		memberDAO.UpdateObject(member);
	}

	
	@Override
	public int SearchObject() throws Exception {
	
		return 0;
	}

	/* 로그인 */
	public MemberDTO Login(String id, String pwd) {
		return 	memberDAO.Login(id,pwd);
	}

	/* 아이디 중복 검사*/
	public String IdCheck(String id) {
		return memberDAO.IdCheck(id);
	}

	
}
