package org.kb141.service;

import java.util.List;

import org.kb141.domain.CurriculumVO;

public interface CurriculumService {
	
	public void register(CurriculumVO vo);
	
	public List<CurriculumVO> view(Integer pno);
	
	public void modify(CurriculumVO vo);
	
	public void remove(Integer uno);
	
	public List<CurriculumVO> getAllCurriculumList();

}
