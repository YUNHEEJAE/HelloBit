package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.util.FaceAPIUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class FaceAPIUtilsTest {
	
	@Inject
	private FaceAPIUtils utils;
	
	@Test
	public void cpTest() {
		try {
			System.out.println(utils.createPersonId("hy2345", "java_beginner_34"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void deletePersonIdTest() throws Exception{
		utils.deletePersonId("8a5c46a3-f9cc-48fc-a050-db512be2be31", "windows_20");
		
	}
	
}
