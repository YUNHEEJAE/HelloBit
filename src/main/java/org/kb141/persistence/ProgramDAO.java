package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.ProgramVO;

public interface ProgramDAO {

	public void create(ProgramVO vo) throws Exception;

	public ProgramVO read(Integer pno) throws Exception;

	public void update(ProgramVO vo) throws Exception;

	public void delete(Integer pno) throws Exception;

	public List<ProgramVO> allList() throws Exception;
	
	public List<ProgramVO> categoryList(String category) throws Exception;
	
	public List<JoinTeacherSubjectVO> joinList(Integer pno)throws Exception;

	public List<JoinTeacherSubjectVO> joinAllList()throws Exception;
	
	
	
}
