package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.SubjectVO;
import org.kb141.persistence.SubjectDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SubjectDAOTest {
	
	@Inject
	private SubjectDAO dao;
	
	
	@Test
	public void createTest()throws Exception{
		SubjectVO vo = new SubjectVO();		
			vo.setSubname("Objective-c");
			vo.setSubgrade("초급");
			dao.create(vo);
	}
	
	@Test
	public void readTest()throws Exception{
		System.out.println(dao.read(41));
	}
	
	@Test
	public void updateTest()throws Exception{
		SubjectVO vo = new SubjectVO();	
			vo.setSubno(41);
			vo.setSubgrade("중급");
			vo.setSubname("Swift44");
			dao.update(vo);
	}
	
	@Test
	public void deleteTest()throws Exception{
		dao.delete(41);
	}
	
	@Test
	public void allListTest()throws Exception{
		System.out.println(dao.allList());
	}
	


}
