package org.kb141.service;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.ImageVO;
import org.kb141.domain.ProgramVO;
import org.kb141.persistence.ImageDAO;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

	@Inject
	private ImageDAO imageDAO;

	@Override
	public void register(ImageVO vo) {
		try {
			imageDAO.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(ImageVO vo) {
		try {
			imageDAO.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer ino) {
		try {
			imageDAO.delete(ino);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ImageVO> getImageList() {
		List<ImageVO> result = null;
		try {
			result = imageDAO.allList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
