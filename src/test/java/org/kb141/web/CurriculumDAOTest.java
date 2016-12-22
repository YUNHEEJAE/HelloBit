package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.CurriculumVO;
import org.kb141.persistence.CurriculumDAO;
import org.kb141.service.CurriculumService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// IH
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CurriculumDAOTest {
	
	@Inject
	private CurriculumDAO dao;
	
	@Inject
	private CurriculumService service;
	
	@Test
	public void createTest() throws Exception{
		CurriculumVO obj = new CurriculumVO();
		obj.setPno(3);
		obj.setTsno(10);
		dao.create(obj);
	}
	
	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read(17));
		
	}
	
	@Test
	public void updateTest() throws Exception {
		CurriculumVO obj = new CurriculumVO();
		obj.setPno(3);
		obj.setTsno(99);
		obj.setUno(17);
		dao.update(obj);
	}
	
	@Test
	public void deleteTest() throws Exception {
		dao.delete(17);
	}
	
	@Test
	public void allListTest() throws Exception {
		System.out.println(dao.allList());
	}
	
	@Test
	public void listTest() throws Exception {
		System.out.println(dao.list(2));
	}
	
	// ================== SERVICE =================
	
	@Test
	public void registerTest() throws Exception {
		CurriculumVO obj = new CurriculumVO();
		obj.setPno(8);
		obj.setTsno(88);
		service.register(obj);
	}
	
	@Test
	public void viewTest() throws Exception {
		System.out.println(service.view(2));
	}
	
	@Test
	public void modifyTest() throws Exception {
		CurriculumVO obj = new CurriculumVO();
		obj.setPno(99);
		obj.setTsno(99);
		obj.setUno(18);
		service.modify(obj);
	}
	
	@Test
	public void removeTest() throws Exception {
		service.remove(18);
		
	}
	
	@Test
	public void getAllCurriculumListTest() throws Exception {
		System.out.println(service.getAllCurriculumList());
	}
	
}
