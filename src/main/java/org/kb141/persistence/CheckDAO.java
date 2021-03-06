package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.CheckLateManVO;
import org.kb141.domain.CheckTimeVO;
import org.kb141.domain.CheckVO;
/**
 * CheckDAO 클래스 입니다.
 * @author camellia
 * 실험중입니다
 *
 */
import org.kb141.domain.CheckWeekVO;
import org.kb141.domain.Criteria;
import org.kb141.domain.OverViewVO;
import org.kb141.domain.StudentCheckKLogVO;
public interface CheckDAO {

	/**
	 * 출석하면 로그를 남겨줍니다.
	 * @param vo
	 * @throws Exception
	 */
	public void create(CheckVO vo) throws Exception;
	
	
	/**
	 * 출석 로그 리스트입니다.
	 * @return
	 * @throws Exception
	 */
	public List<StudentCheckKLogVO> checkList() throws Exception;
	
	public Integer checkMember(Integer pno) throws Exception;
	
	public Integer checkDate(Integer pno) throws Exception;
	
	public Integer checkLate(Integer pno) throws Exception;
	
	public CheckWeekVO checkWeek(Integer pno) throws Exception;
	
	public List<CheckLateManVO> checkLateMan(Integer pno) throws Exception;

	public List<Integer> checkLaterCnt(Integer pno) throws Exception;
	
	public List<CheckTimeVO> checkStudent(String sid) throws Exception;
	
	public Integer checkAttendanceCnt(Integer pno) throws Exception;
	
	
	// 오늘 데이터 가져오기. by Senyo
	public List<CheckTimeVO> todayCheck(Integer pno) throws Exception;
	
	// 내 최근 5개 로그 데이터 가져오기 by Senyo
	public List<CheckVO> checkMyList(String sid) throws Exception;
	
	// 교직원페이지에서 전체 학생 log 중 이번주 만 뽑은것 by LJP
	public CheckWeekVO allCheckWeek() throws Exception;
	
	// pno별로 수강생 출석 로그 10개씩
	public List<StudentCheckKLogVO> studentCheckLog(Integer pno) throws Exception;
	
	public Integer allTodayCheck() throws Exception;
	
	public OverViewVO allCheck() throws Exception;
	
	public List<CheckTimeVO> allTodayemotion() throws Exception;
	
	public List<CheckTimeVO> allTodayChecktime(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
}
