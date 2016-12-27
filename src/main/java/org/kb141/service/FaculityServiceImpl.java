package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.FaculityVO;
import org.kb141.persistence.FaculityDAO;
import org.springframework.stereotype.Service;

@Service // HJ
public class FaculityServiceImpl implements FaculityService {

	@Inject
	private FaculityDAO FaculityDAO;

	@Override
	public void register(FaculityVO vo) {
		try {
			FaculityDAO.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public FaculityVO view(String fid) {

		FaculityVO result = null;

		try {
			result = FaculityDAO.read(fid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void modify(FaculityVO vo) {
		try {
			FaculityDAO.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String fid) {
		try {
			FaculityDAO.delete(fid);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FaculityVO> getFaculityList() {

		List<FaculityVO> result = null;
		try {
			result = FaculityDAO.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
