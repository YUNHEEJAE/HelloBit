package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.ClassroomVO;

public interface ClassroomDAO {

	// C R U D allList 
	
	
	public void create(ClassroomVO vo) throws Exception;
	
	public ClassroomVO read(String roomname) throws Exception;
	
	public void update(ClassroomVO vo) throws Exception;
	
	public void delete(String roomname) throws Exception;
	
	public List<ClassroomVO> allList() throws Exception;
	
	
	
}
