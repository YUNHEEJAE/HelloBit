package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.TeacherSubjectVO;
import org.springframework.stereotype.Repository;

//IH
@Repository
public class TeacherSubjectDAOImpl implements TeacherSubjectDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private final String NAME = "org.kb141.mapper.TeacherSubjectMapper.";
	

	@Override
	public void create(TeacherSubjectVO vo) throws Exception {
		sqlsession.insert(NAME+"create", vo);
	}

	@Override
	public TeacherSubjectVO read(Integer tsno) throws Exception {
		return sqlsession.selectOne(NAME+"read", tsno);
	}

	@Override
	public void update(TeacherSubjectVO vo) throws Exception {
		sqlsession.update(NAME+"update", vo);
	}

	@Override
	public void delete(Integer tsno) throws Exception {
		sqlsession.delete(NAME + "delete", tsno);
	}

	@Override
	public List<TeacherSubjectVO> allList() throws Exception {
		return sqlsession.selectList(NAME+"allList");
	}

	

}
