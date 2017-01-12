package org.kb141.service;

import java.util.List;

import org.kb141.domain.NoticeVO;
import org.kb141.domain.Criteria;

public interface NoticeService {

	public void register(NoticeVO vo);

	public NoticeVO view(Integer nno);

	public void modify(NoticeVO vo);

	public void remove(Integer nno);

	public List<NoticeVO> getNoticeList();
	
	public List<NoticeVO> listCriteria(Criteria cri);
	
	public int listCountCriteria(Criteria cri);
	
	public List<NoticeVO> getsearach(Criteria cri);
	
	public int getsearachCount(Criteria cri);
}
