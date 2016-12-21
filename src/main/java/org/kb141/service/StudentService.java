package org.kb141.service;

import java.util.List;

import org.kb141.domain.StudentVO;
import org.kb141.domain.TakeProgramVO;

public interface StudentService {

	public void register(StudentVO vo);
	
	public StudentVO view(String sid);
	
	public void modify(StudentVO vo);
	
	public void remove(String sid);
	
	public List<StudentVO> getStudentList();
	
	
	// 강의 신청
	public void joinTakeProgram (TakeProgramVO vo); 
	
	// 회원별 강의 정보 보기 (sid)
	public TakeProgramVO viewStudentTakeProgram(String sid);

	// 강의 변경
	public void modifyTakeProgram(TakeProgramVO vo);
	
	// 수강 취소
	public void removeTakeProgram(String sid);
	
	// 전체 강의 정보 보기
	public List<TakeProgramVO> getAllTakeProgramList();
	
	// 강의별 학생 정보 보기 (pno)
	public List<TakeProgramVO> getTakeProgramList(Integer pno);
	
}
