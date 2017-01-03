package org.kb141.service;

import java.util.List;

import org.kb141.domain.TakeProgramVO;

public interface TakeProgramService {
	
	// 강의 신청
	public void join(TakeProgramVO vo); 
	
	// 회원별 강의 정보 보기 (sid)
	public TakeProgramVO view(String sid);

	// 강의 변경
	public void modify(TakeProgramVO vo);
	
	// 수강 취소
	public void remove(String sid);
	
	// 전체 강의 정보 보기
	public List<TakeProgramVO> getAllList();
	
	// 강의별 학생 정보 보기 (pno)
	public List<TakeProgramVO> getList(Integer pno);
	
	public void admission(String sid);
	
	public Integer getstateTotal(Integer pno);
	
	public List<TakeProgramVO> getstateList(TakeProgramVO vo);
	
	
	// 수강 신청 OK 됐을 때, personid 만들어서 줄거에요. 까먹지 말자.
	public void updatePersonId(TakeProgramVO vo);
	

	
	

}
