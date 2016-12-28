package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.TeacherSubjectVO;
import org.kb141.persistence.ProgramDAO;
import org.kb141.persistence.TeacherSubjectDAO;
import org.springframework.stereotype.Service;


@Service		//HJ
public class TeacherSubjectServiceImpl implements TeacherSubjectService {
	
	@Inject
	private TeacherSubjectDAO TeacherSubjectDAO;
	
	@Inject
	private ProgramDAO programDAO;
	
	@Override
	public void register(TeacherSubjectVO vo) {
		try {
			TeacherSubjectDAO.create(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public TeacherSubjectVO view(Integer tsno) {
		
		TeacherSubjectVO result = null;
		
		try {
			result = TeacherSubjectDAO.read(tsno);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	@Override
	public void modify(TeacherSubjectVO vo) {
		try {
			TeacherSubjectDAO.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer tsno) {
		
		try {
			TeacherSubjectDAO.delete(tsno);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherSubjectVO> getTeacherSubjectList() {
		
		List<TeacherSubjectVO> result = null;
		
		try {
			result = TeacherSubjectDAO.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

	@Override
	public List<JoinTeacherSubjectVO> getAllTeacherSubjectList() {
		List<JoinTeacherSubjectVO> result = null;
		try {
			result = programDAO.joinAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public JoinTeacherSubjectVO getTeacherSubject(Integer tsno) {

		JoinTeacherSubjectVO vo = null;
		
		try {
			vo = TeacherSubjectDAO.getTeacherSubject(tsno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
