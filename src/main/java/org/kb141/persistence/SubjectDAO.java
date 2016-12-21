package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.SubjectVO;

public interface SubjectDAO {
	
	public void create(SubjectVO vo) throws Exception;
	
	public SubjectVO read(Integer subno) throws Exception;
	
	public void update (SubjectVO vo) throws Exception;
	
	public void delete (Integer subno) throws Exception;
	
	public List<SubjectVO> allList() throws Exception;
	
	

}
