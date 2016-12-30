package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.CheckVO;
import org.kb141.domain.WeekDataVO;
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
	public Integer checkMember(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "checkMember", pno);
	}

	@Override
	public Integer checkDate(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "checkDate" ,pno);
	}
	
	@Override
	public Integer checkLate(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "checkLate", pno);
	}
	
	@Override
	public WeekDataVO checkWeek(Integer pno) throws Exception {
		return sqlSession.selectOne(NAME + "checkWeek" ,pno);
	}

	
	


}
