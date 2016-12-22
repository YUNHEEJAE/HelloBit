package org.kb141.service;

import java.util.List;

import org.kb141.domain.TeacherSubjectVO;

public interface TeacherSubjectService {	//HJ
	
	public void register(TeacherSubjectVO vo);
	
	public TeacherSubjectVO view(Integer tsno);
	
	public void modify(TeacherSubjectVO vo);
	
	public void remove(Integer tsno);
	
	public List<TeacherSubjectVO> getTeacherSubjectList();

}