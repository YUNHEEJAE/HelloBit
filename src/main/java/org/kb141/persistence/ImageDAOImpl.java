package org.kb141.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kb141.domain.ImageVO;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAOImpl implements ImageDAO {
	@Inject
	private SqlSession sqlSession;

	private final String NAME = "org.kb141.mapper.ImageMapper.";

	@Override
	public void create(ImageVO vo) throws Exception {
		sqlSession.insert(NAME + "create", vo);
	}

	@Override
	public void update(ImageVO vo) throws Exception {
		sqlSession.update(NAME + "update", vo);
	}

	@Override
	public void delete(Integer ino) throws Exception {
		sqlSession.delete(NAME + "delete", ino);
	}

	@Override
	public List<ImageVO> allList() throws Exception {
		return sqlSession.selectList(NAME + "allList");
	}

}
