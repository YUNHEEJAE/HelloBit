package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.ClassroomVO;
import org.kb141.persistence.ClassroomDAO;
import org.kb141.service.ClassroomService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ClassroomDAOTest {

	@Inject
	private ClassroomDAO dao;

	@Inject
	private ClassroomService service;

	@Test
	public void createTest() throws Exception {
		ClassroomVO vo = new ClassroomVO();
		vo.setRoomname("503");
		dao.create(vo);
	}

	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read("501"));
	}

	@Test
	public void updateTest() throws Exception {
		ClassroomVO vo = new ClassroomVO();
		vo.setRoomname("504");
		vo.setRempty(true);
		dao.update(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		dao.delete("503");
	}

	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
	}

	// ======================SERVICE TEST======================

	@Test
	public void RegisterTest() throws Exception {
		ClassroomVO vo = new ClassroomVO();
		vo.setRoomname("503");
		service.register(vo);
	}

	@Test
	public void ViewTest() throws Exception {
		System.out.println(service.view("503"));
	}

	@Test
	public void ModifyTest() throws Exception {
		ClassroomVO vo = new ClassroomVO();
		vo.setRoomname("503");
		vo.setRempty(false);
		service.modify(vo);
	}

	@Test
	public void RemoveTest() throws Exception {
		service.remove("503");
	}

	@Test
	public void AllListTest() throws Exception {
		System.out.println(service.getClassroomList());

	}

}
