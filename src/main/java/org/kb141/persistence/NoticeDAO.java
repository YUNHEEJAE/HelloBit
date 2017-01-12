package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.Criteria;
import org.kb141.domain.NoticeVO;

public interface NoticeDAO {

	public void create(NoticeVO vo) throws Exception;

	public NoticeVO read(Integer nno) throws Exception;

	public void update(NoticeVO vo) throws Exception;

	public void delete(Integer nno) throws Exception;

	public List<NoticeVO> allList() throws Exception;

	// public List<NoticeVO> listPage(int page) throws Exception;

	public List<NoticeVO> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<NoticeVO> search(Criteria cri) throws Exception;
	
	public int searchCount(Criteria cri) throws Exception;

}
