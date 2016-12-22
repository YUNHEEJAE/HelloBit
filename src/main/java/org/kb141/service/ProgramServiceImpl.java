package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ProgramVO;
import org.kb141.persistence.ProgramDAO;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Inject
	private ProgramDAO programDAO;

	@Override
	public void register(ProgramVO vo) {
		try {
			programDAO.create(vo);
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

}