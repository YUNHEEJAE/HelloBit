package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.Criteria;
import org.kb141.domain.NoticeVO;
import org.kb141.persistence.NoticeDAO;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	NoticeDAO noticedao;

	@Override
	public void register(NoticeVO vo) {
		try {
			noticedao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public NoticeVO view(Integer nno) {
		NoticeVO result = null;
		try {
			result = noticedao.read(nno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void modify(NoticeVO vo) {
		try {
			noticedao.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer nno) {
		try {
			noticedao.delete(nno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> result = null;
		try {
			result = noticedao.allList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<NoticeVO> listCriteria(Criteria cri) {
		List<NoticeVO> result = null;

		try {
			result = noticedao.listCriteria(cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int listCountCriteria(Criteria cri) {
		int result = 0;
		try {
			result = noticedao.countPaging(cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<NoticeVO> getsearach(Criteria cri) {
		List<NoticeVO> result = null;

		try {
			result = noticedao.search(cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getsearachCount(Criteria cri) {
		int result = 0;
		try {
			result = noticedao.searchCount(cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
