package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.TeacherVO;
import org.springframework.stereotype.Repository;

@Repository // HJ
public class TeacherDAOImpl implements TeacherDAO {

	@Inject
	private SqlSession sqlSession;

	private final String NAME = "org.kb141.mapper.TeacherMapper.";

	@Override
	public void create(TeacherVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);

	}

	@Override
	public TeacherVO read(String tid) throws Exception {
		return sqlSession.selectOne(NAME + "read", tid);
	}

	@Override
	public void update(TeacherVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
	}

	@Override
	public void delete(String tid) throws Exception {
		sqlSession.delete(NAME + "delete", tid);
	}

	@Override
	public List<TeacherVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

}
