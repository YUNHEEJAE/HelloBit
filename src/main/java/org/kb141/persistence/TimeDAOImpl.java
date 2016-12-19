package org.kb141.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeDAOImpl implements TimeDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	@Override
	public String getTime() throws Exception {
		
		return sqlsession.selectOne("org.kb141.TimeMapper.getTime");
	}

}
