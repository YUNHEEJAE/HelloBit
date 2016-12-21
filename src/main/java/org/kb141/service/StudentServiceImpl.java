package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.StudentVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.persistence.StudentDAO;
import org.kb141.persistence.TakeProgramDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Inject
	private StudentDAO studentDAO;
	
	@Inject
	private TakeProgramDAO takeprogramDAO;
		
	@Override
	public void register(StudentVO vo) {
		try {
			studentDAO.create(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public StudentVO view(String sid) {
		
		StudentVO result = null;
		
		try {
			result = studentDAO.read(sid);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public void modify(StudentVO vo) {
		try {
			studentDAO.update(vo);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String sid) {
		try {
			studentDAO.delete(sid);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public List<StudentVO> getStudentList() {
		
		List<StudentVO> result = null;
		
		try {
			result = studentDAO.allList();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return result;	
	}

	@Override
	public void joinTakeProgram(TakeProgramVO vo) {
		try {
			takeprogramDAO.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public TakeProgramVO viewStudentTakeProgram(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTakeProgram(TakeProgramVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTakeProgram(String sid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TakeProgramVO> getAllTakeProgramList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TakeProgramVO> getTakeProgramList(Integer pno) {
		// TODO Auto-generated method stub
		return null;
	}

}
