package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.ClassroomVO;
import org.springframework.stereotype.Repository;

@Repository
public class ClassroomDAOImpl implements ClassroomDAO {


	@Inject
	private SqlSession sqlSession;
	
	private final String NAME = "org.kb141.mapper.ClassroomMapper.";
	
	@Override
	public void create(ClassroomVO vo) throws Exception {
		sqlSession.insert(NAME+"create", vo);
	}

	@Override
	public ClassroomVO read(String roomname) throws Exception {
		return sqlSession.selectOne(NAME+"read", roomname);
	}

	@Override
	public void update(ClassroomVO vo) throws Exception {
		sqlSession.update(NAME+"update", vo);
	}

	@Override
	public void delete(String roomname) throws Exception {
		sqlSession.delete(NAME+"delete", roomname);	
	}

	@Override
	public List<ClassroomVO> allList() throws Exception {
		return sqlSession.selectList(NAME+"allList");
	}

	
	
}
