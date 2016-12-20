package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.persistence.TimeDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SqlTest {
		
	
	@Inject
	TimeDAO dao;
	
	@Test
	public void daoTest()throws Exception{
		
		dao.getTime();
		System.out.println(dao.getTime());
	}
}
     