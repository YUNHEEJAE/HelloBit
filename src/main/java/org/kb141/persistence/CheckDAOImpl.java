package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.CheckVO;
import org.springframework.stereotype.Repository;

@Repository
public class CheckDAOImpl implements CheckDAO {
	@Inject
	private SqlSession sqlSession;

	private final String NAME = "org.kb141.mapper.CheckMapper.";

	@Override
	public void create(CheckVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);
	}

	@Override
	public List<CheckVO> checkList() throws Exception {
		return sqlSession.selectList(NAME + "checkList");
	}

	@Override
	public Integer checkList(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "checkMember", pno);
	}
}
