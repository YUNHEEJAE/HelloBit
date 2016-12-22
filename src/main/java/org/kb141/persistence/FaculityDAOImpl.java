package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.FaculityVO;
import org.kb141.persistence.FaculityDAO;
import org.springframework.stereotype.Repository;

@Repository 	//HJ
public class FaculityDAOImpl implements FaculityDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NAME = "org.kb141.mapper.FaculityMapper.";

	@Override
	public void create(FaculityVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);
		
	}

	@Override
	public FaculityVO read(String fid) throws Exception {
		return sqlSession.selectOne(NAME + "read", fid);
	}

	@Override
	public void update(FaculityVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
		
	}

	@Override
	public void delete(String fid) throws Exception {
		sqlSession.delete(NAME + "delete", fid);
		
	}

	@Override
	public List<FaculityVO> getList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}
	
	
}
