package org.kb141.persistence;

import java.util.List;

import org.kb141.domain.ImageVO;

public interface ImageDAO {
	public void create(ImageVO vo) throws Exception;

	public void update(ImageVO vo) throws Exception;

	public void delete(Integer ino) throws Exception;

	//나중에 검색에서 조건 추가 필요하다.
	public List<ImageVO> allList() throws Exception;
	
}
