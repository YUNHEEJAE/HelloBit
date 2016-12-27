package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CurriculumVO;
import org.kb141.persistence.CurriculumDAO;
import org.springframework.stereotype.Service;

@Service
public class CurriculumServiceImpl implements CurriculumService {
	
	@Inject
	private CurriculumDAO curriculumDAO;

	@Override
	public void register(CurriculumVO vo) {
		try {
			curriculumDAO.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CurriculumVO> view(Integer pno) {
		
		List<CurriculumVO> result = null;
		
		try {
			result = curriculumDAO.list(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(CurriculumVO vo) {
		try {
			curriculumDAO.update(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer uno) {
		try {
			curriculumDAO.delete(uno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CurriculumVO> getAllCurriculumList() {
		
		List<CurriculumVO> result = null;
		try {
			result = curriculumDAO.allList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void deletePnoList(Integer pno) {
		try {
			curriculumDAO.deletePnoList(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void reCreate(CurriculumVO vo) {
		try {
			curriculumDAO.reCreate(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
