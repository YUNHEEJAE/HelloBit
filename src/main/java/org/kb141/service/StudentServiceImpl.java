package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ImageVO;
import org.kb141.domain.StudentVO;
import org.kb141.persistence.ImageDAO;
import org.kb141.persistence.StudentDAO;
import org.kb141.persistence.TakeProgramDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Inject 
	private StudentDAO studentDAO;
	
	@Inject
	private ImageDAO imageDAO;
	
	@Inject
	private TakeProgramDAO takeprogramDAO;
		
	@Override
	public void register(StudentVO vo , String fileName) {
		
		String sid = vo.getSid();
		
		ImageVO ivo = new ImageVO();
		
		ivo.setSid(sid);
		ivo.setFilename(fileName);
		
		try {
			studentDAO.create(vo);
			imageDAO.create(ivo);
			
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
		System.out.println(vo);
		try{
			System.out.println("Student Modify Execute............");
			studentDAO.update(vo);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String sid) {
		try {
			studentDAO.delete(sid);
			takeprogramDAO.delete(sid);
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

	
}
