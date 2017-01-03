package org.kb141.service;

import java.util.List;

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
	
	public Integer getcheckAttendanceCnt(Integer pno);
}
