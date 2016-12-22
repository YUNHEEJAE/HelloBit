package org.kb141.service;

import java.util.List;

import org.kb141.domain.ImageVO;
import org.springframework.stereotype.Service;


public interface ImageService {

	public void register(ImageVO vo);

	public void modify(ImageVO vo);

	public void remove(Integer ino);

	//추후 검색조건 추가 필요
	public List<ImageVO> getImageList();
}
