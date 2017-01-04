package org.kb141.service;

import java.util.List;

import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
import org.kb141.domain.WeekDataVO;

public interface CheckService {

	public void create(CheckVO vo);

	public List<CheckVO> checkList();

	public Integer getcheckMember(Integer pno);

	public Integer getcheckDate(Integer pno);

	public Integer getcheckLate(Integer pno);

	public WeekDataVO getcheckWeek(Integer pno);

	public List<String> getcheckLaterMan(Integer pno);

	public List<Integer> getcheckLaterCnt(Integer pno);

	public List<CheckTimeVO> checkStudent(String sid);

	public Integer getcheckAttendanceCnt(Integer pno);
	
	// 오늘 데이터만 가져와서 JAVA에서 정제 해 보자
	public List<CheckTimeVO> getTodayCheck(Integer pno);

}