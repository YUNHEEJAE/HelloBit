package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.StudentVO;
import org.kb141.persistence.StudentDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class StudentDAOTest {

	@Inject
	private StudentDAO dao;
	
	@Test
	public void createTest() throws Exception{
		StudentVO obj = new StudentVO();
		obj.setSname("서인효");
		obj.setSid("sih");
		obj.setSpw("sih");
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
		obj.setSname("이종필");
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
	
	
}
