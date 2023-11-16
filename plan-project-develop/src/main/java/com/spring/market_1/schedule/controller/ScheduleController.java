package com.spring.market_1.schedule.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.market_1.ObjectController;
import com.spring.market_1.member.dto.MemberDTO;
import com.spring.market_1.schedule.dto.ScheduleDTO;
import com.spring.market_1.schedule.service.ScheduleService;


@Controller("scheduleController")
public class ScheduleController implements ObjectController{

	@Autowired
    private ScheduleService scheduleService;
	
	@Autowired
    private ScheduleDTO scheduleDTO;
	
	
	@Override
	public ModelAndView ListObjects() throws Exception {
		
		return null;
	}
		/* 캘린더 일정보기 */
	/*
	@RequestMapping(value="/schedule/ListObjects.do", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>>  ListObjects(HttpServletRequest request) throws Exception {
	    String uri = request.getRequestURI();
	    System.out.println(uri); 

	    List<Map<String, Object>> scheduleList = scheduleService.ListObjects();
	    if(scheduleList.isEmpty()) {
	    	System.out.println("값 없음");
	    }
	    JSONObject jsonObj=new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	   
	    Map<String, Object> hash = new HashMap<String, Object>();
    	
	    for (int i=0;i<scheduleList.size();i++) {
	    	
	    		hash.put("title", ((ScheduleDTO) scheduleList.get(i)).getTitle());
	    		hash.put("start", ((ScheduleDTO) scheduleList.get(i)).getStart1());
	    		hash.put("end", ((ScheduleDTO) scheduleList.get(i)).getEnd1());
	    		
	    		//7hash.put("title",scheduleList.get(i).get("title"));
	    		//7hash.put("start1",scheduleList.get(i).get("start1"));
	    		//7hash.put("end1",scheduleList.get(i).get("end1"));
	    		
	    		jsonObj=new JSONObject(hash); //{}
	    		jsonArray.add(jsonObj); //[]
	    	    
		 }
	    System.out.println("jsonArrCheck:"+jsonArray);
	    return jsonArray;
	}
*/
	@RequestMapping(value="/schedule/ListObjects.do", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> listObjects(HttpServletRequest request) throws Exception {
	    String uri = request.getRequestURI();
	    System.out.println(uri);

	    List<Map<String, Object>> scheduleList = scheduleService.ListObjects();
	    if(scheduleList.isEmpty()) {
	        System.out.println("값 없음");
	    }
		JSONObject jsonObj = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    Map<String, Object> hash = new HashMap<>();
	    
	    for (int i = 0; i < scheduleList.size(); i++) {
		    
				hash.put("title", ((ScheduleDTO) scheduleList.get(i)).getTitle());
	    		hash.put("start", ((ScheduleDTO) scheduleList.get(i)).getStart1());
	    		hash.put("end", ((ScheduleDTO) scheduleList.get(i)).getEnd1());

	    		jsonObj=new JSONObject(hash);
	        jsonArray.add(jsonObj); 
	    }

	    System.out.println("jsonArrCheck:" + jsonArray);
	    return jsonArray;
	}

	@Override
	public ModelAndView SelectObjects() throws Exception {
		
		return null;
	}

	/*일정추가*/

	@Override
	public ModelAndView AddObject() throws Exception {
		
		
		
		return null;
	}
	@RequestMapping(value="/schedule/AddObject.do", method=RequestMethod.POST)
	@ResponseBody 
	public ModelAndView AddObject(ScheduleDTO scheduleDTO,HttpServletRequest request) throws Exception {
		   String uri = request.getRequestURI();
		    System.out.println(uri);
		    
		    System.out.println("title"+scheduleDTO.getTitle());
		    System.out.println("content"+scheduleDTO.getContent());
		    System.out.println("start1"+scheduleDTO.getStart1());
		    System.out.println("end1"+scheduleDTO.getEnd1());
		    
		    System.out.println(scheduleDTO);
		    scheduleService.AddObject(scheduleDTO);
		return null;
	}

	@Override
	public ModelAndView RemoveObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView ModObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView UpdateObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView SearchObject() throws Exception {
		
		return null;
	}

	@Override
	public ModelAndView Form() throws Exception {
		
		return null;
	}
	
	
	/* 페이지 불러오기*/
	@RequestMapping(value = {"/schedule/Myschedule.do",
		},method = RequestMethod.GET)
	public ModelAndView Form(@RequestParam(value = "type", required = false) String type, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
	
		String uri = request.getRequestURI();
		System.out.println(uri); ///plan/schedule/Myschedule.do 
		
	
		if(uri.endsWith("Myschedule.do")) {
			mav.setViewName("/schedule/Myschedule");
			
		}else if(uri.endsWith("LoginForm.do")) {
			mav.setViewName("/member/LoginForm");
		}
		
		
		return mav;
	}
	
	
}
