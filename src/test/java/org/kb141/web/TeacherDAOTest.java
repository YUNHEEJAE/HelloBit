package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.TeacherVO;
import org.kb141.persistence.TeacherDAO;
import org.kb141.service.TeacherService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TeacherDAOTest { // HJ

	@Inject
	private TeacherDAO dao;
	
	@Inject
	private TeacherService service;

	@Test
	public void createTest() throws Exception {
		TeacherVO obj = new TeacherVO();
		obj.setTname("핫초코");
		obj.setTid("hot");
		obj.setTpw("hot");
		dao.create(obj);

	}

	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read("hot"));
	}

	@Test
	public void updateTest() throws Exception {
		TeacherVO obj = new TeacherVO();
		obj.setTname("쇼콜라");
		obj.setTid("hot");
		obj.setTpw("choco");

		dao.update(obj);
	}

	@Test
	public void deleteTest() throws Exception {
		dao.delete("hot");
	}

	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());

	}
		
	// =================== SERVICE =====================  //
	
	@Test
	public void registerTest() throws Exception{
		
		TeacherVO obj = new TeacherVO();
		obj.setTname("토마스");
		obj.setTid("thomas");
		obj.setTpw("thomas");
		
		service.register(obj);
	}
	
	@Test
	public void viewTest() throws Exception{
		System.out.println(service.view("thomas"));
	}
	
	@Test
	public void modifyTest() throws Exception{
		
		TeacherVO  obj = new TeacherVO();
		obj.setTid("thomas");
		obj.setTname("나는야토마스");
		obj.setTpw("Thomas");
		
		service.modify(obj);
	}
	
	@Test
	public void removeTest() throws Exception {
		service.remove("thomas");
	}
	
	@Test
	public void getTeacherListTest() throws Exception {
		System.out.println(service.getTeacherList());
	}
}
