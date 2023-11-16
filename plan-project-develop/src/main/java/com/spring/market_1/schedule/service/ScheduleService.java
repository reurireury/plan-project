package com.spring.market_1.schedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.spring.market_1.ObjectService;
import com.spring.market_1.schedule.dao.ScheduleDAO;
import com.spring.market_1.schedule.dto.ScheduleDTO;
@Controller("scheduleService")
public class ScheduleService  implements ObjectService{

	@Autowired
    private ScheduleDAO scheduleDAO;
	
	/* 캘린더 보기(전체) */
	@Override
	public  List<Map<String, Object>> ListObjects() throws DataAccessException {
		System.out.println("sevice");
		return scheduleDAO.ListObjects();
	}

	@Override
	public String SelectObjects() throws DataAccessException {
		
		return null;
	}

	
	@Override
	public int AddObject() throws DataAccessException {
		return 0;
	}
	/*일정추가*/
	public int AddObject(ScheduleDTO scheduleDTO) throws DataAccessException {
		scheduleDAO.AddObject(scheduleDTO);
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
