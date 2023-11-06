package com.spring.market_1.member.dao;

import java.util.HashMap;
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
	/* 마이바티스 : sql의 실행결과를 빈즈, map등의 객체에 매핑시켜주는 역할 sql소스관리를 xml을 통해서 한다*/
	/*  List selectList(query_id)id에 대한 select 문을 실행한 후 여러 레코드를 List로 반환
		List selectList(query_id, 조건)id에 대한 select 문을 실행하면서 사용되는 조건도 전달
		T selectOne(query_id)id에 대한 select 문을 실행한 후 지정된 타입으로 한 개의 레코드 반환
		T selectOne(query_id, 조건)id에 대한 select 문을 실행하면서 사용되는 조건도 전달
		Map<K,V> selectMap(query_id, 조건)id에 대한 select 문을 실행하면서 사용되는 조건도 전달. Map 타입으로 레코드 반환
		int insert(query_id, Object obj)id에 대한 insert문을 실행하면서 객체의 값을 테이블에 추가
		int update(query_id, Object obj)obj 객체의 값을 조건문의 수정 값으로 사용해 id데 대한 update문 실행
		int delete(query_id, Object obj)obj 객체의 값을 조건문의 조건 값으로 사용해 id데 대한 delete문 실행
	 * */
	@Autowired
	private SqlSession sqlSession;
	String namespace = "mapper.member.";
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
	/* 회원가입 */
	public void AddObject(MemberDTO member) {
		sqlSession.insert(namespace+"AddMember",member);
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

	/* 로그인 */
	public MemberDTO login(String id, String pwd) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		data.put("pwd", pwd);
		return sqlSession.selectOne(namespace+"LoginCheck",data);
		
	}

	
	
}
