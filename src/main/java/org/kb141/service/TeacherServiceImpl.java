package org.kb141.service;

import java.util.List;

import javax.inject.Inject;


import org.kb141.domain.TeacherVO;
import org.kb141.persistence.TeacherDAO;
import org.kb141.persistence.TeacherSubjectDAO;
import org.springframework.stereotype.Service;


@Service		//HJ
public class TeacherServiceImpl implements TeacherService {

	@Inject
	private TeacherDAO TeacherDAO;
	
	@Inject
	private TeacherSubjectDAO teachersubjectDAO;
	
	@Override
	public void register(TeacherVO vo) {
		try {
			TeacherDAO.create(vo);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public TeacherVO view(String tid) {
		
		TeacherVO result = null;
		
		try {
			result = TeacherDAO.read(tid);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void modify(TeacherVO vo) {
		try {
			TeacherDAO.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void remove(String tid) {
		try {
			TeacherDAO.delete(tid);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherVO> getTeacherList() {
		
		List<TeacherVO> result = null;
		
		try {
			result = TeacherDAO.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

}
