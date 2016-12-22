package org.kb141.service;

import java.util.List;

import org.kb141.domain.FaculityVO;

//HJ
public interface FaculityService {
	
	public void register(FaculityVO vo);
	
	public FaculityVO view(String fid);
	
	public void modify(FaculityVO vo);
	
	public void remove(String fid);
	
	public List<FaculityVO> getFaculityList();
}
