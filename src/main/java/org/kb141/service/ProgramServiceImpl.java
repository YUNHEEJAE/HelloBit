package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CurriculumVO;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.ProgramVO;
import org.kb141.persistence.CurriculumDAO;
import org.kb141.persistence.ProgramDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {

	@Inject
	private ProgramDAO programDAO;
	
	@Inject
	private CurriculumDAO curriculumDAO;

	@Override
	public void register(ProgramVO vo, String tsnolist) {
		try {
			programDAO.create(vo);

			String[] listTsno = tsnolist.split(",");
			for(int i = 0 ; i < listTsno.length ; i ++) {
				CurriculumVO currVO = new CurriculumVO();
				currVO.setTsno(Integer.parseInt(listTsno[i]));
				curriculumDAO.create(currVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProgramVO view(Integer pno) {
		ProgramVO result = null;

		try {
			result = programDAO.read(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(ProgramVO vo) {
		try {
			programDAO.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer pno) {
		try {
			programDAO.delete(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProgramVO> getProgramList() {
		List<ProgramVO> result = null;
		try {
			result = programDAO.allList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<ProgramVO> getCategoryList(String category) {
		List<ProgramVO> result = null;
		try {
			result = programDAO.categoryList(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<JoinTeacherSubjectVO> getTeacherSubjectList(Integer pno) {
		List<JoinTeacherSubjectVO> result = null;
		try {
			result = programDAO.joinList(pno);
		} catch (Exception e) {
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

}
