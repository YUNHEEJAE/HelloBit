package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.ProgramVO;
import org.kb141.persistence.ProgramDAO;
import org.kb141.service.ProgramService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ProgramDAOTest {

	@Inject
	private ProgramDAO dao;

	@Inject
	private ProgramService service;

	@Test
	public void createTest() throws Exception {
		ProgramVO vo = new ProgramVO();
		vo.setPcourse("Test");
		vo.setRoomname("402");
		vo.setTorder("3");
		vo.setOpendate("2016-12-22");
		vo.setClosedate("2016-12-23");
		vo.setMaximum(30);
		System.out.println(vo);

		dao.create(vo);
	}

	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read(1));
	}

	@Test
	public void updateTest() throws Exception {
		ProgramVO vo = new ProgramVO();
		vo.setPcourse("서인효바보");
		vo.setRoomname("503");
		vo.setTorder("80");
		vo.setOpendate("2016-12-22");
		vo.setClosedate("2016-12-23");
		vo.setMaximum(5);
		vo.setPno(12);

		dao.update(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		dao.delete(13);
	}

	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
	}

	// =========================SERVICE=========================
	@Test
	public void createServiceTest() throws Exception {
		ProgramVO vo = new ProgramVO();
		vo.setPcourse("Test");
		vo.setRoomname("402");
		vo.setTorder("3");
		vo.setOpendate("2016-12-22");
		vo.setClosedate("2016-12-23");
		vo.setMaximum(30);
		System.out.println(vo);

		service.register(vo);
	}

	@Test
	public void readServiceTest() throws Exception {
		System.out.println(service.view(1));
	}

	@Test
	public void updateSerivceTest() throws Exception {
		ProgramVO vo = new ProgramVO();
		vo.setPcourse("서인효바보");
		vo.setRoomname("503");
		vo.setTorder("80");
		vo.setOpendate("2016-12-22");
		vo.setClosedate("2016-12-23");
		vo.setMaximum(5);
		vo.setPno(14);

		service.modify(vo);
	}

	@Test
	public void deleteServiceTest() throws Exception {
		service.remove(14);
	}

	@Test 
	public void listServiceTest() throws Exception {
		System.out.println(service.getProgramList());
	}

}
