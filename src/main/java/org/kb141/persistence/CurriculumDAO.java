package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.CurriculumVO;

public interface CurriculumDAO {

	public void create(CurriculumVO vo) throws Exception;
	
	public CurriculumVO read(Integer uno) throws Exception;
	
	public void update(CurriculumVO vo) throws Exception;
	
	public void delete(Integer uno) throws Exception;
	
	public List<CurriculumVO> allList() throws Exception;
	
	public List<CurriculumVO> list(Integer pno) throws Exception;
	
	public void deletePnoList(Integer pno) throws Exception;
	
	public void reCreate(CurriculumVO vo) throws Exception;
	
}
