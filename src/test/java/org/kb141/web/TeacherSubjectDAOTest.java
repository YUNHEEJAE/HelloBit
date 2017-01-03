package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.JoinTeacherSubjectVO;
import org.kb141.domain.TeacherSubjectVO;
import org.kb141.persistence.TeacherSubjectDAO;
import org.kb141.service.TeacherSubjectService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//IH
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TeacherSubjectDAOTest {
	
	@Inject
	private TeacherSubjectDAO dao;
	
	@Inject
	private TeacherSubjectService teacherSubjectService;
	
	@Test
	public void createTest() throws Exception {
		TeacherSubjectVO obj = new TeacherSubjectVO();
		
		obj.setTid("TEST");
		obj.setSubno(99);
		
		dao.create(obj);
	}
	
	@Test
	public void readTest() throws Exception {
		System.out.println(dao.read(29));
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
	
	@Test
	public void getTeacherSubject() throws Exception{
		
		System.out.println(dao.getTeacherSubject(1));
		
	}
	// ============================ service =======================
	
	@Test
	public void registerTest()throws Exception{
		TeacherSubjectVO vo = new TeacherSubjectVO();
		vo.setSubno(4);
		vo.setTid("naver");
		teacherSubjectService.register(vo);
	}
	
	@Test
	public void viewTest()throws Exception{
		System.out.println(teacherSubjectService.view(29));	
	}
	
	@Test
	public void modifyTest()throws Exception{
		TeacherSubjectVO vo = new TeacherSubjectVO();
		vo.setTsno(23);
		vo.setSubno(2);
		vo.setTid("kang");
		teacherSubjectService.modify(vo);
	}
	
	@Test
	public void removeTest()throws Exception{
		teacherSubjectService.remove(23);
	}
	
	@Test
	public void getTeacherSubjectList()throws Exception{
		System.out.println(teacherSubjectService.getJoinAllList());
		}
		
	@Test
	public void getTeacherSubjectService() throws Exception{
		System.out.println(teacherSubjectService.getTeacherSubject(37));
	}
	
		
	}
	
	
	

