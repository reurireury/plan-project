package com.spring.market_1;

import java.util.List;

import org.springframework.dao.DataAccessException;


public interface ObjectService 
{
	public List ListObjects() throws DataAccessException; //목록
	public String SelectObjects() throws DataAccessException;//목록 상세보기
	public int AddObject() throws DataAccessException; //추가
	public int RemoveObject() throws DataAccessException; //삭제
	public int ModObject() throws DataAccessException; //수정1 이전 값 가져오기
	public int UpdateObject() throws DataAccessException; // 수정2 수정한 값 db업데이트
	public int SearchObject() throws Exception; //검색

	

}
