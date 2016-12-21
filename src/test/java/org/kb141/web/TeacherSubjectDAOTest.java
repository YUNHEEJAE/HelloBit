package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.TeacherSubjectVO;
import org.kb141.persistence.TeacherSubjectDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//IH
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TeacherSubjectDAOTest {
	
	@Inject
	private TeacherSubjectDAO dao;
	
	@Test
	public void createTest() throws Exception {
		TeacherSubjectVO obj = new TeacherSubjectVO();
		
		obj.setTid("TEST");
		obj.setSubno(99);
		
		dao.create(obj);
	}
	
	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read(22));
	}
	
	@Test
	public void updateTest() throws Exception {
		TeacherSubjectVO obj = new TeacherSubjectVO();
		obj.setTid("TEST2");
		obj.setSubno(88);
		obj.setTsno(22);
		dao.update(obj);
	}

	@Test
	public void deleteTest() throws Exception {
		dao.delete(22);
	}
	
	@Test
	public void allListTest() throws Exception{
		System.out.println(dao.allList());
	}
	
}
