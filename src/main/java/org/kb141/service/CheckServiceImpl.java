package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CheckLateManVO;
import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
import org.kb141.domain.CheckWeekVO;
import org.kb141.domain.StudentCheckKLogVO;
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
	public List<StudentCheckKLogVO> checkList() {
		List<StudentCheckKLogVO> result = null;
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
	public CheckWeekVO getCheckWeek(Integer pno) {
		CheckWeekVO checkWeek = null;
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
	public List<CheckLateManVO> getcheckLateMan(Integer pno) {
		List<CheckLateManVO> result = null;
		try {
			result = checkDAO.checkLateMan(pno);
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
	public Integer getAttendanceCnt(Integer pno) {
		Integer getcheckAttendanceCnt = null;

		try {
			getcheckAttendanceCnt = checkDAO.checkAttendanceCnt(pno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getcheckAttendanceCnt;
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

	@Override
	public List<CheckTimeVO> getTodayCheck(Integer pno) {
		List<CheckTimeVO> result = null;
		try {
			result = checkDAO.todayCheck(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<CheckVO> getMyList(String sid) {
		List<CheckVO> result = null;
		try {
			result = checkDAO.checkMyList(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<StudentCheckKLogVO> getstudentCheckLog(Integer pno) {
		List<StudentCheckKLogVO> result = null;
		try {
			result = checkDAO.studentCheckLog(pno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
