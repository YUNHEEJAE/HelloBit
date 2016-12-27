package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.CurriculumVO;
import org.springframework.stereotype.Repository;

@Repository
public class CurriculumDAOImpl implements CurriculumDAO {

	@Inject
	private SqlSession sqlSession;
	
	private final String NAME = "org.kb141.mapper.CurriculumMapper.";
		
	@Override
	public void create(CurriculumVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);

	}

	@Override
	public CurriculumVO read(Integer uno) throws Exception {
		return sqlSession.selectOne(NAME + "read", uno);
	}

	@Override
	public void update(CurriculumVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);

	}

	@Override
	public void delete(Integer uno) throws Exception {
		sqlSession.delete(NAME + "delete", uno);

	}

	@Override
	public List<CurriculumVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

	@Override
	public List<CurriculumVO> list(Integer pno) throws Exception {
		return sqlSession.selectList(NAME + "list", pno);
	}

	@Override
	public void deletePnoList(Integer pno) throws Exception {
		sqlSession.delete(NAME + "deletePnoList" , pno);
	}

	@Override
	public void reCreate(CurriculumVO vo) throws Exception {
		sqlSession.insert(NAME + "reCreate", vo);
		
	}

}
