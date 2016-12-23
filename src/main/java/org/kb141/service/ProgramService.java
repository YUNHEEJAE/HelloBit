package org.kb141.service;

import java.util.List;

import org.kb141.domain.ProgramVO;

public interface ProgramService {
	public void register(ProgramVO vo);

	public ProgramVO view(Integer pno);

	public void modify(ProgramVO vo);

	public void remove(Integer pno);

	public List<ProgramVO> getProgramList();
	
	public List<ProgramVO> getCategoryList(String category);
}
