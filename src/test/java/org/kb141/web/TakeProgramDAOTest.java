package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.TakeProgramVO;
import org.kb141.persistence.TakeProgramDAO;
import org.kb141.service.TakeProgramService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// IH
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TakeProgramDAOTest {
	
	@Inject
	private TakeProgramDAO dao;
	
	@Inject
	private TakeProgramService service;
	
	
	@Test
	public void createTest() throws Exception{
		TakeProgramVO obj = new TakeProgramVO();
		obj.setSid("sih");
		obj.setPno(1);
		dao.create(obj);
	}
	
	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read("sih"));
	}
	
	@Test
	public void updateTest() throws Exception {
		TakeProgramVO obj = new TakeProgramVO();
		obj.setSid("sih");
		obj.setPno(2);
		dao.update(obj);
	}
	
	@Test
	public void deleteTest() throws Exception {
		dao.delete("sih");
	}
	
	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
	}

	@Test
	public void listTest() throws Exception {
		System.out.println(dao.list(3));
	}
	
	
	// ================ service ================
	
	@Test
	public void registerTest() throws Exception {
		
		TakeProgramVO  vo = new TakeProgramVO();
		
		vo.setPno(1);
		vo.setSid("jyyy");
		
		service.join(vo);
		
		
	}
	
	@Test
	public void viewTest()throws Exception{
		
		System.out.println(service.view("23"));
		
	}
	
	@Test
	public void modifyTest()throws Exception{
		
		TakeProgramVO  vo = new TakeProgramVO();
		
		vo.setSid("23");
		vo.setPno(1);
		
		service.modify(vo);
		
	}
	
	@Test
	public void removeStudentTest() throws Exception {
		service.remove("jyy");
	}

	@Test
	public void removeTest() throws Exception {

		service.remove("23");

	}

	@Test
	public void programAllListTest() throws Exception {

		System.out.println(service.getAllList());

	}

	@Test
	public void programListTest() throws Exception {

		System.out.println(service.getList(1));

	}
	
	
}
