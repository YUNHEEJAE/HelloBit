package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.CheckVO;
/**
 * CheckDAO 클래스 입니다.
 * @author camellia
 * 실험중입니다
 *
 */
import org.kb141.domain.WeekDataVO;
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
	public List<CheckVO> checkList() throws Exception;
	
	public Integer checkMember(Integer pno) throws Exception;
	
	public Integer checkDate(Integer pno) throws Exception;
	
	public Integer checkLate(Integer pno) throws Exception;
	
	public WeekDataVO checkWeek(Integer pno) throws Exception;
	
	public List<String> checkLaterMan(Integer pno) throws Exception;

	public List<Integer> checkLaterCnt(Integer pno) throws Exception;
	
	public Integer checkAttendanceCnt(Integer pno) throws Exception;
	
	
}
