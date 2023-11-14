package com.spring.market_1.schedule.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.spring.market_1.ObjectDAO;
import com.spring.market_1.schedule.dto.ScheduleDTO;





@Controller("scheduleDAO")
public class ScheduleDAO implements ObjectDAO{
	@Autowired
	private SqlSession sqlSession;
	String namespace = "mapper.schedule.";
	
	/* 캘린더 일정보기(전체) */
	@Override
	public List ListObjects() throws DataAccessException {
		System.out.println("dao");
		List<ScheduleDTO> schedule=null;
		schedule=sqlSession.selectList("scheduleList");
		return schedule;
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
