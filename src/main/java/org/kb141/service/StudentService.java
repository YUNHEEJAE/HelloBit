package org.kb141.service;

import java.util.List;

import org.kb141.domain.CheckDateVO;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;

public interface StudentService {

	public void register(StudentVO vo , String fileName);
	
	public StudentVO view(String sid);
	
	public void modify(StudentVO vo);
	
	public void remove(String sid);
	
	public List<StudentVO> getStudentList();

	public ProgramVO getViewProgram(String sid);
	
	//sname 가져오기 
	public StudentVO viewSname(String personId) ;
	
	//학생별 출석, 지각, 결석  수
	public CheckDateVO getcheckDateCount(String sid);
	
}
