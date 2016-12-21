package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.CheckVO;
import org.kb141.persistence.CheckDAO;
import org.kb141.service.CheckService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class CheckDAOTest {

	@Inject
	private CheckDAO dao;

	@Inject
	private CheckService service;

	@Test
	public void createTest() throws Exception {
		CheckVO obj = new CheckVO();
		obj.setSid("ljp");
		obj.setPno(1);

		String emotion = "\"scores\"" + ": {" + "\"anger\"" + ": 0," + "\"contempt\"" + ": 0, " + "\"disgust\"" + ":0,"
				+ "\"fear\"" + ": 0," + "\"happiness\"" + ": 0," + "\"neutral\"" + ":1," + "\"sadness\"" + ":0,"
				+ "\"surprise\"" + ": 0}";
		obj.setEmotion(emotion);
		dao.create(obj);
	}

	@Test
	public void checkListTest() throws Exception {
		System.out.println(dao.checkList());
	}

	// =======================SERVICE=========================

	@Test
	public void serviceCreateTest() throws Exception {
		CheckVO obj = new CheckVO();
		obj.setSid("lsy");
		obj.setPno(1);

		String emotion = "\"scores\"" + ": {" + "\"anger\"" + ": 0.5," + "\"contempt\"" + ": 0.5, " + "\"disgust\""
				+ ":0," + "\"fear\"" + ": 0," + "\"happiness\"" + ": 0," + "\"neutral\"" + ":0," + "\"sadness\"" + ":0,"
				+ "\"surprise\"" + ": 0}";
		obj.setEmotion(emotion);
		service.create(obj);
	}

	@Test
	public void serviceCheckListTest() throws Exception {
		System.out.println(service.checkList());
	}

}
