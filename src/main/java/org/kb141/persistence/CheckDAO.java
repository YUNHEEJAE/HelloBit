package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.CheckVO;
/**
 * CheckDAO 클래스 입니다.
 * @author camellia
 * 실험중입니다
 *
 */
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
	
	public Integer checkList(Integer pno) throws Exception;
}
