package org.kb141.service;

import java.util.List;

import org.kb141.domain.StudentVO;

public interface StudentService {

	public void register(StudentVO vo , String fileName);
	
	public StudentVO view(String sid);
	
	public void modify(StudentVO vo);
	
	public void remove(String sid);
	
	public List<StudentVO> getStudentList();

	
}
