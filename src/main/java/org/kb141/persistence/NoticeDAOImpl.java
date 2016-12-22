package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.NoticeVO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Inject
	private SqlSession sqlSession;
	
	private final String NAME = "org.kb141.mapper.NoticeMapper.";
	
	@Override
	public void create(NoticeVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);
	}

	@Override
	public NoticeVO read(Integer nno) throws Exception {
		return sqlSession.selectOne(NAME + "read", nno);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
	}

	@Override
	public void delete(Integer nno) throws Exception {
		sqlSession.delete(NAME + "delete", nno);
	}

	@Override
	public List<NoticeVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

}
