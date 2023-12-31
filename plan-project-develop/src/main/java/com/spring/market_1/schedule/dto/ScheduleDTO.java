package com.spring.market_1.schedule.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component("scheduleDTO")
public class ScheduleDTO { 
	
	/*
	private String id; //로그인
	private String groupid; //미정
	private String title; //제목
	private String content; //내용
	private Date start1;//시작일
	private Date end1;//종료일
	private String allday;//하루종일
	private String textcolor;
	private String backgroundcolor;
	private String bordercolor;
	
	
	
	*/
	
	private String id; //로그인
	private String title; //제목
	private String content; //내용
	@JsonProperty("formattedStart")
	private String start1;//시작일
	@JsonProperty("formattedEnd")
	private String end1;//종료일
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStart1() {
		return start1;
	}
	public void setStart1(String start1) {
		this.start1 = start1;
	}
	public String getEnd1() {
		return end1;
	}
	public void setEnd1(String end1) {
		this.end1 = end1;
	}
	
	
	
}
	
	
	
	