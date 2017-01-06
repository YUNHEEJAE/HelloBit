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
	private TeacherSubjectDAO teacherSubjectDAO;
	
	@Override
	public void register(TeacherSubjectVO vo) {
		try {
			teacherSubjectDAO.create(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public TeacherSubjectVO view(Integer tsno) {
		
		TeacherSubjectVO result = null;
		
		try {
			result = teacherSubjectDAO.read(tsno);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	

	
	@Override
	public void modify(TeacherSubjectVO vo) {
		try {
			teacherSubjectDAO.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer tsno) {
		
		try {
			teacherSubjectDAO.delete(tsno);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherSubjectVO> getTeacherSubjectList() {
		
		List<TeacherSubjectVO> result = null;
		
		try {
			result = teacherSubjectDAO.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

	@Override
	public JoinTeacherSubjectVO getTeacherSubject(Integer tsno) {

		JoinTeacherSubjectVO vo = null;
		
		try {
			vo = teacherSubjectDAO.getTeacherSubject(tsno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	@Override
	public List<JoinTeacherSubjectVO> getJoinAllList() {
		List<JoinTeacherSubjectVO> result = null;
		try {
			result = teacherSubjectDAO.joinAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<JoinTeacherSubjectVO> getJoinList(Integer pno) {
		List<JoinTeacherSubjectVO> result = null;
		try {
			result = teacherSubjectDAO.joinList(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
