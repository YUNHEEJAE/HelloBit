package org.kb141.service;

import java.util.List;

import org.kb141.domain.SubjectVO;
//copyright by zetsubou
public interface SubjectService {
	
		public void register(SubjectVO vo) ;
		
		public SubjectVO view(Integer subno);
		
		public void  modify (SubjectVO vo);
		
		public void remove(Integer subno);
		
		public List<SubjectVO> getSubjectList();
		

}
