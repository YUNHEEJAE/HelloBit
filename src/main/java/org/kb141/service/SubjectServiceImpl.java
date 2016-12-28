package org.kb141.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.SubjectVO;
import org.kb141.persistence.SubjectDAO;
import org.kb141.persistence.TeacherSubjectDAO;
import org.springframework.stereotype.Service;
//copyright by zetsubou
@Service
public class SubjectServiceImpl implements SubjectService {

	@Inject
	private SubjectDAO subjectDao;
	
	@Inject
	private TeacherSubjectDAO teachersubjectDAO;
	
	@Override
	public void register(SubjectVO vo) {
			try{
					subjectDao.create(vo);
				}catch(Exception e){
					e.printStackTrace();
				}
	}

	@Override
	public SubjectVO view(Integer subno) {
		SubjectVO vo = null;
			try{
				vo = subjectDao.read(subno);
			}catch(Exception e){
				e.printStackTrace();
			}
			return vo;
	}

	@Override
	public void modify(SubjectVO vo) {
			try{
				subjectDao.update(vo);
			}catch(Exception e){
				e.printStackTrace();
			}

	}

	@Override
	public void remove(Integer subno) {
			try{
				subjectDao.delete(subno);
				
			}catch(Exception e){
				e.printStackTrace();
			}

	}

	@Override
	public List<SubjectVO> getSubjectList() {
		List<SubjectVO> list = null;
				try{
					list = subjectDao.allList();
				}catch(Exception e){
					e.printStackTrace();
				}
		return list;
	}

}
