package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
import org.kb141.domain.WeekDataVO;
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
			result = checkDAO.checkList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Integer getcheckMember(Integer pno) {
		Integer checkMember = 0;

		try {
			checkMember = checkDAO.checkMember(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkMember;
	}

	@Override
	public Integer getcheckDate(Integer pno) {
		Integer checkDate = null;

		try {
			checkDate = checkDAO.checkDate(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkDate;
	}

	@Override
	public WeekDataVO getcheckWeek(Integer pno) {
		WeekDataVO checkWeek = null;
		try {
			checkWeek = checkDAO.checkWeek(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkWeek;
	}

	@Override
	public Integer getcheckLate(Integer pno) {
		Integer checkLate = null;

		try {
			checkLate = checkDAO.checkLate(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkLate;
	}

	@Override
	public List<String> getcheckLaterMan(Integer pno) {
		List<String> result = null;
		try {
			result = checkDAO.checkLaterMan(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Integer> getcheckLaterCnt(Integer pno) {
		List<Integer> result = null;
		try {
			result = checkDAO.checkLaterCnt(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<CheckTimeVO> checkStudent(String sid) {

		List<CheckTimeVO> result = null;
		try {
			result = checkDAO.checkStudent(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
