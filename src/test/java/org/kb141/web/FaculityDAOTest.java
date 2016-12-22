package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.FaculityVO;
import org.kb141.persistence.FaculityDAO;
import org.kb141.service.FaculityService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class FaculityDAOTest {
	
	@Inject
	private FaculityDAO dao;
	
	@Inject
	private FaculityService service;
	
	
	@Test
	public void createTest()throws Exception{
		FaculityVO vo = new FaculityVO();
		vo.setFname("윤대리");
		vo.setFid("yun123");
		vo.setFpw("yun123");
		dao.create(vo);
	}
	
	@Test
	public void readTest()throws Exception{
		System.out.println(dao.read("yun123"));
	}
	
	@Test
	public void updateTest()throws Exception{
		FaculityVO vo = new FaculityVO();
		vo.setFid("yun123");
		vo.setFname("윤과장");
		vo.setFpw("yun123");
		dao.update(vo);
	}
	
	@Test
	public void deleteTest()throws Exception{
		dao.delete("yun123");
	}
	
	@Test
	public void allListTest()throws Exception{
		System.out.println(dao.getList());
	}
	
	// ==================== service ===================
	
	@Test
	public void registerTest()throws Exception{
		FaculityVO vo = new FaculityVO();
		vo.setFid("yun123");
		vo.setFname("윤회장");
		vo.setFpw("yun123");
		service.register(vo);
		
	}
	
	@Test
	public void viewTest()throws Exception{
		System.out.println(service.view("yun123"));
	}
	
	@Test
	public void modifyTest()throws Exception{
		FaculityVO vo = new FaculityVO();
		vo.setFid("yun123");
		vo.setFname("윤사장");
		vo.setFpw("yun123");
		service.modify(vo);
	}
	
	@Test
	public void removeTest()throws Exception{
		service.remove("yun123");
	}
	
	@Test
	public void getFaculityList()throws Exception{
		System.out.println(service.getFaculityList());
	}

}
