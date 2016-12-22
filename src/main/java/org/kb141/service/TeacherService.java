package org.kb141.service;

import java.util.List;


import org.kb141.domain.TeacherVO;

public interface TeacherService {   //HJ
	
	public void register(TeacherVO vo);
	
	public TeacherVO view(String tid);
	
	public void modify(TeacherVO vo);
	
	public void remove(String tid);
	
	public List<TeacherVO> getTeacherList();
	
}
