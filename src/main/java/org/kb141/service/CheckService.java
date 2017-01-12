package org.kb141.service;

import java.util.List;

import org.kb141.domain.CheckLateManVO;
import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
import org.kb141.domain.CheckWeekVO;
import org.kb141.domain.Criteria;
import org.kb141.domain.OverViewVO;
import org.kb141.domain.StudentCheckKLogVO;

public interface CheckService {

	public void create(CheckVO vo);

	public List<StudentCheckKLogVO> checkList();

	public Integer getcheckMember(Integer pno);

	public Integer getcheckDate(Integer pno);

	public Integer getcheckLate(Integer pno);

	public CheckWeekVO getCheckWeek(Integer pno);

	public List<CheckLateManVO> getcheckLateMan(Integer pno);

	public List<Integer> getcheckLaterCnt(Integer pno);

	public List<CheckTimeVO> checkStudent(String sid);

	public Integer getAttendanceCnt(Integer pno);
	
	// 오늘 데이터만 가져와서 JAVA에서 정제 해 보자
	public List<CheckTimeVO> getTodayCheck(Integer pno);
	
	public List<CheckVO> getMyList(String sid);

	public CheckWeekVO getAllCheckWeek();
	
	public List<StudentCheckKLogVO> getstudentCheckLog(Integer pno);
	
	public Integer getAllTodayCheck();
	
	public OverViewVO getAllCheck();
	
	public List<CheckTimeVO> getAllTodayEmotion();
	
	public List<CheckTimeVO> getAllTodayCheckTime(Criteria cri);
	
	public Integer listCountCriteria(Criteria cri);
	
}