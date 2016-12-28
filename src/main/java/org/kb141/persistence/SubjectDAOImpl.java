package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.SubjectVO;
import org.kb141.domain.TeacherSubjectVO;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDAOImpl implements SubjectDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	
	private final String NAME = "org.kb141.mapper.SubjectMapper.";
	
	

	@Override
	public void create(SubjectVO vo) throws Exception {
			sqlSession.insert(NAME + "create" , vo);
	}

	@Override
	public SubjectVO read(Integer subno) throws Exception {
		return sqlSession.selectOne(NAME + "read" , subno);
	}

	@Override
	public void update(SubjectVO vo) throws Exception {
			sqlSession.update(NAME + "update" , vo);
	}

	@Override
	public void delete(Integer subno) throws Exception {
			sqlSession.delete(NAME+"delete" , subno);
	}

	@Override
	public List<SubjectVO> allList() throws Exception {
		return sqlSession.selectList(NAME+"allList");
	}



}
