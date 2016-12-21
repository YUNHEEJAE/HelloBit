package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CheckVO;
import org.kb141.persistence.CheckDAO;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

	@Inject
	private CheckDAO checkDAO;

	@Override
	public void create(CheckVO vo) {
		try {
			checkDAO.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CheckVO> checkList() {
		List<CheckVO> result = null;
		try {
			result =  checkDAO.checkList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
