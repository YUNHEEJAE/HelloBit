package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.JoinTeacherSubjectVO;
// IH
import org.kb141.domain.TeacherSubjectVO;

public interface TeacherSubjectDAO {

	public void create(TeacherSubjectVO vo) throws Exception;
	
	public TeacherSubjectVO read(Integer tsno) throws Exception;
	
	public void update(TeacherSubjectVO vo) throws Exception;
	
	public void delete(Integer tsno) throws Exception;
	
	public List<TeacherSubjectVO> allList() throws Exception;
	

	
}
