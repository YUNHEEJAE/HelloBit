package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.CheckDateVO;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;

public interface StudentDAO {
	
	public void create(StudentVO vo) throws Exception;
	
	public StudentVO read(String sid) throws Exception;
	
	public void update(StudentVO vo) throws Exception;
	
	public void delete(String sid) throws Exception;
	
	public List<StudentVO> allList() throws Exception;

	public ProgramVO getViewProgram(String sid) throws Exception;
	
	//personId 에 대한 이름 가져오기 
	public StudentVO readSname(String personId) throws Exception;

	public CheckDateVO checkDateCount(String sid) throws Exception;
	
	
}
