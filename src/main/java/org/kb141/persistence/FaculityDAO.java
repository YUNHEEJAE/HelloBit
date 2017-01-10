package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.FaculityVO;

//HJ
public interface FaculityDAO {
	
public void create(FaculityVO vo) throws Exception;
	
	public FaculityVO read(String fid) throws Exception;
	
	public void update(FaculityVO vo) throws Exception;
	
	public void delete(String fid) throws Exception;
	
	public List<FaculityVO> getList() throws Exception;

	
	
	
}
