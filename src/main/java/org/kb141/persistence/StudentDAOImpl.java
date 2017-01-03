package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Inject
	private SqlSession sqlSession;

	private final String NAME = "org.kb141.mapper.StudentMapper.";

	@Override
	public void create(StudentVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);

	}

	@Override
	public StudentVO read(String sid) throws Exception {
		return sqlSession.selectOne(NAME + "read", sid);
	}

	@Override
	public void update(StudentVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
	}

	@Override
	public void delete(String sid) throws Exception {
		sqlSession.delete(NAME + "delete", sid);

	}

	@Override
	public List<StudentVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

	@Override
	public ProgramVO getViewProgram(String sid) throws Exception {
		return sqlSession.selectOne(NAME + "getViewProgram", sid);
	}
	
	@Override
	public StudentVO readSname(String personId) throws Exception {		
		return sqlSession.selectOne(NAME + "getSname" , personId);	
	}


}
