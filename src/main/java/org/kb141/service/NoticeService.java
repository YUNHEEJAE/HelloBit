package org.kb141.service;

import java.util.List;

import org.kb141.domain.NoticeVO;

public interface NoticeService {

	public void register(NoticeVO vo);

	public NoticeVO view(Integer nno);

	public void modify(NoticeVO vo);

	public void remove(Integer nno);

	public List<NoticeVO> getNoticeList();
	
}
