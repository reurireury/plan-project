package com.spring.market_1.schedule.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("scheduleDTO")
public class ScheduleDTO { 
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
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
	public Date getStart1() {
		return start1;
	}
	public void setStart1(Date start1) {
		this.start1 = start1;
	}
	public Date getEnd1() {
		return end1;
	}
	public void setEnd1(Date end1) {
		this.end1 = end1;
	}
	public String getAllday() {
		return allday;
	}
	public void setAllday(String allday) {
		this.allday = allday;
	}
	public String getTextcolor() {
		return textcolor;
	}
	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}
	public String getBackgroundcolor() {
		return backgroundcolor;
	}
	public void setBackgroundcolor(String backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}
	public String getBordercolor() {
		return bordercolor;
	}
	public void setBordercolor(String bordercolor) {
		this.bordercolor = bordercolor;
	}
	
	
	
}
	
	
	
	