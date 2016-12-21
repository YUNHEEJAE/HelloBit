package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.TeacherVO;

//HJ
public interface TeacherDAO {
	public void create(TeacherVO vo) throws Exception;
	
	public TeacherVO read(String tid) throws Exception;
	
	public void update(TeacherVO vo) throws Exception;
	
	public void delete(String tid) throws Exception;
	
	public List<TeacherVO> allList() throws Exception;
}
