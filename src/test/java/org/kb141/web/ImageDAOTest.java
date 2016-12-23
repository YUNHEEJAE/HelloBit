package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.ImageVO;
import org.kb141.persistence.ImageDAO;
import org.kb141.service.ImageService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ImageDAOTest {

	@Inject
	private ImageDAO dao;

	@Inject
	private ImageService service;

	@Test
	public void createTest() throws Exception {
		ImageVO vo = new ImageVO();
		vo.setSid("sih");
		vo.setFilename("sih_0");
		dao.create(vo);
	}

	@Test
	public void updateTest() throws Exception {
		ImageVO vo = new ImageVO();
		vo.setFilename("sih_1");
		vo.setIno(2);
		dao.update(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		dao.delete(2);
	}

	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
	}

	// =======================SERVICE========================

	@Test
	public void registerTest() throws Exception {
		ImageVO vo = new ImageVO();
		vo.setSid("sih");
		vo.setFilename("sih_1");
		service.register(vo);
	}

	@Test
	public void modifyTest() throws Exception {
		ImageVO vo = new ImageVO();
		vo.setFilename("sih_2");
		vo.setIno(3);
		service.modify(vo);
	}

	@Test
	public void removeTest() throws Exception {    
		service.remove(3);
	}

	@Test
	public void getImageListTest() throws Exception {
		System.out.println(service.getImageList());
	}
	
	

}
