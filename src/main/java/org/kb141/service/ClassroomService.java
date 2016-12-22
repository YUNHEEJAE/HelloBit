package org.kb141.service;

import java.util.List;

import org.kb141.domain.ClassroomVO;

public interface ClassroomService {

	
	public void register(ClassroomVO vo);

	public ClassroomVO view(String roomname);
	
	public void modify(ClassroomVO vo);
	
	public void remove(String roomname);
	
	public List<ClassroomVO> getClassroomList();
	
}
