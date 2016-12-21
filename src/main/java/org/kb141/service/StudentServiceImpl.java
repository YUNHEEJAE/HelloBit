package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.StudentVO;
import org.kb141.persistence.StudentDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Inject
	private StudentDAO dao;
		
	@Override
	public void register(StudentVO vo) {
		try {
			dao.create(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public StudentVO view(String sid) {
		
		StudentVO result = null;
		
		try {
			result = dao.read(sid);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public void modify(StudentVO vo) {
		try {
			dao.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String sid) {
		try {
			dao.delete(sid);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public List<StudentVO> getStudentList() {
		
		List<StudentVO> result = null;
		
		try {
			result = dao.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

}
