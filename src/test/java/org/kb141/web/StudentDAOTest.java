package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.StudentVO;
import org.kb141.persistence.StudentDAO;
import org.kb141.service.StudentService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class StudentDAOTest {

	@Inject
	private StudentDAO dao;
	
	@Inject
	private StudentService service;
	
	@Test
	public void createTest() throws Exception{
		StudentVO obj = new StudentVO();
		obj.setSname("정주영");
		obj.setSid("jyy");
		obj.setSpw("jyy");
		obj.setSemail("sih@gmail.com");
		dao.create(obj);
	}
	
	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read("ljp"));
	}
	
	@Test
	public void updateTest() throws Exception {
		StudentVO obj = new StudentVO();
		obj.setSname("수정테스트중");
		obj.setSid("ljp");
		obj.setSpw("ljp");
		obj.setSemail("ljp@gmail.com");
		dao.update(obj);
	}
	
	@Test
	public void deleteTest() throws Exception {
		dao.delete("ljp3");
	}
	
	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
		
	}
	
	// =============== SERVICE ==================
	
	
	@Test
	public void registerTest() throws Exception {
		
		StudentVO obj = new StudentVO();
		obj.setSname("서인효2");
		obj.setSid("sih2");
		obj.setSpw("sih2");
		obj.setSemail("sih2@gmail.com");
		
//		service.register(obj);
		
	}
	
	@Test
	public void viewTest() throws Exception {
		
		System.out.println(service.view("sih2"));
	}
	
	@Test
	public void modifyTest() throws Exception {
		
		StudentVO obj = new StudentVO();
		obj.setSname("asdasd");
		obj.setSid("ljp");
		obj.setSpw("sasdasdasdasdasdih");
		obj.setSemail("123123123123@gmail.com");
		
		service.modify(obj);
		
	}
	
	@Test
	public void removeTest() throws Exception {
		service.remove("sih2");
	}
	
	@Test
	public void getStudentListTest() throws Exception {
		System.out.println(service.getStudentList());
	}
	
	
}
