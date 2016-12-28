package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.TakeProgramVO;
import org.springframework.stereotype.Repository;

//HJ, IH
@Repository
public class TakeProgramDAOImpl implements TakeProgramDAO {	

	@Inject
	private SqlSession sqlsession;
	
	private final String NAME = "org.kb141.mapper.TakeProgramMapper.";
	
	@Override
	public void create(TakeProgramVO vo) throws Exception {
		sqlsession.insert(NAME +"create",vo);
	}

	@Override
	public TakeProgramVO read(String sid) throws Exception {
		return sqlsession.selectOne(NAME+"read",sid);
	}

	@Override
	public void update(TakeProgramVO vo) throws Exception {
		sqlsession.update(NAME+"update",vo);

	}

	@Override
	public void delete(String sid) throws Exception {
		sqlsession.delete(NAME+"delete", sid);
	}

	@Override
	public List<TakeProgramVO> allList() throws Exception {	
		return sqlsession.selectList(NAME+"allList");
	}

	@Override
	public List<TakeProgramVO> list(Integer pno) throws Exception {
		return sqlsession.selectList(NAME+"list",pno);
	}

	@Override
	public void admission(String sid) throws Exception {
		sqlsession.update(NAME + "admission", sid);
		
	}

	@Override
	public Integer stateCount(Integer pno) throws Exception {		
		return sqlsession.selectOne(NAME + "stateCount" , pno);
	}

	@Override
	public List<TakeProgramVO> stateList(TakeProgramVO vo) throws Exception {	
		return sqlsession.selectList(NAME + "stateList",vo);
	}

	@Override
	public void updatePersonId(TakeProgramVO vo) throws Exception {
		sqlsession.update(NAME + "updatePersonId", vo);
		
	}

}
