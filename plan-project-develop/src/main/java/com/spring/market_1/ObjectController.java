package com.spring.market_1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ObjectController 
{
	public ModelAndView ListObjects() throws Exception; //목록
	public ModelAndView SelectObjects() throws Exception; //목록 세분화(하나만 선택)
	public ModelAndView AddObject() throws Exception; //추가
	public ModelAndView RemoveObject() throws Exception; //삭제
	public ModelAndView ModObject() throws Exception; //수정1 이전 값 가져오기
	public ModelAndView UpdateObject() throws Exception;//수정2 수정한 값 업데이트
	public ModelAndView SearchObject() throws Exception; //검색

	public ModelAndView Form() throws Exception; //폼페이지 로딩
	
 
}
