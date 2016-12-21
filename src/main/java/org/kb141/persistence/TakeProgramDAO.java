package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.TakeProgramVO;

public interface TakeProgramDAO {		//HJ
		
	public void create(TakeProgramVO vo) throws Exception;
	
	public TakeProgramVO read(String sid) throws Exception;
	
	public void update(TakeProgramVO vo) throws Exception;
	
	public void delete(String sid) throws Exception;
	
	public List<TakeProgramVO> allList() throws Exception;
	
	public List<TakeProgramVO> list(Integer pno) throws Exception; 
	
}

