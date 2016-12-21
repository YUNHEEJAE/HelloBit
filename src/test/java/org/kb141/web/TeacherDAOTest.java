package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.TeacherVO;
import org.kb141.persistence.TeacherDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TeacherDAOTest { // HJ

	@Inject
	private TeacherDAO dao;

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

}
