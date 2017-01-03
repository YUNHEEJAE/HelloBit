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

	@Test
	public void checkMemberTest() throws Exception{
		System.out.println(dao.checkMember(1));
	}
	
	@Test
	public void checkDateTest() throws Exception{
		
		System.out.println(dao.checkDate(1));
	}
	
	@Test
	public void checkLateTest() throws Exception{
		System.out.println(dao.checkLate(1));
	}
	
	@Test
	public void checkLaterMan() throws Exception{
		System.out.println(dao.checkLaterMan(1));
	}
	
	@Test
	public void checkLaterCnt() throws Exception{
		System.out.println(dao.checkLaterCnt(1));
	}
	
	@Test
	public void checkAttendanceCntTest() throws Exception{
		System.out.println(dao.checkAttendanceCnt(1));
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
	
	@Test
	public void getcheckMemberTest() throws Exception{
		System.out.println(service.getcheckMember(1));
	}
	
	@Test
	public void getcheckDateTest() throws Exception{
		System.out.println(service.getcheckDate(1));
	}
	
	@Test
	public void getcheckWeek() throws Exception {
		System.out.println(service.getcheckWeek(1));
	}
	
	@Test
	public void getcheckLate() throws Exception{
		System.out.println(service.getcheckLate(1));
	}
	
	@Test
	public void getcheckLaterManTest() throws Exception{
		System.out.println(service.getcheckLaterMan(1));
	}
	
	@Test
	public void getcheckLateCntTest() throws Exception{
		System.out.println(service.getcheckLaterCnt(1));
	}
	
	@Test
	public void getcheckAttendanceCntTest() throws Exception{
		System.out.println(service.getcheckAttendanceCnt(1));
	}
}
