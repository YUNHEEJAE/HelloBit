package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.ProgramVO;
import org.springframework.stereotype.Repository;

@Repository
public class ProgramDAOImpl implements ProgramDAO {

	@Inject
	private SqlSession sqlSession;

	private final String NAME = "org.kb141.mapper.ProgramMapper.";

	@Override
	public void create(ProgramVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);
	}

	@Override
	public ProgramVO read(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "read", pno);
	}

	@Override
	public void update(ProgramVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
	}

	@Override
	public void delete(Integer pno) throws Exception {
		sqlSession.delete(NAME + "delete", pno);
	}

	@Override
	public List<ProgramVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

}
