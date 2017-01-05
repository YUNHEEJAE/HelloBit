package org.kb141.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.CheckTimeVO;
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
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		obj.setSid("ljp");
		obj.setPno(1);
		String emotion = "\"scores\"" + ": {" + "\"anger\"" + ": 0," + "\"contempt\"" + ": 0, " + "\"disgust\"" + ":0,"
				+ "\"fear\"" + ": 0," + "\"happiness\"" + ": 0," + "\"neutral\"" + ":1," + "\"sadness\"" + ":0,"
				+ "\"surprise\"" + ": 0}";
		obj.setEmotion(emotion);
		obj.setChecktime(dateFormat.parse("2017-01-04 18:34:23"));
		System.out.println(obj);
		dao.create(obj);
	}

	@Test
	public void checkListTest() throws Exception {
		System.out.println(dao.checkList());
	}

	@Test
	public void checkMemberTest() throws Exception {
		System.out.println(dao.checkMember(1));
	}

	@Test
	public void checkDateTest() throws Exception {

		System.out.println(dao.checkDate(1));
	}

	@Test
	public void checkLateTest() throws Exception {
		System.out.println(dao.checkLate(1));
	}

	@Test
	public void checkLaterMan() throws Exception {
		System.out.println(dao.checkLateMan(1));
	}

	@Test
	public void checkLaterCnt() throws Exception {
		System.out.println(dao.checkLaterCnt(1));
	}

	@Test
	public void checkStudentTest() throws Exception {
		System.out.println(dao.checkStudent("lsy"));
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
	public void getcheckMemberTest() throws Exception {
		System.out.println(service.getcheckMember(1));
	}
	

	@Test
	public void getTime() throws Exception{
		Date date = new Date();
		String s = date.toString();
		System.out.println(s);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
	}
	
	
	

	@Test
	public void getcheckDateTest() throws Exception {
		System.out.println(service.getcheckDate(1));
	}

	@Test
	public void getCheckWeekTest() throws Exception {
		System.out.println(service.getCheckWeek(37));
	}

	@Test
	public void getcheckLate() throws Exception {
		System.out.println(service.getcheckLate(1));
	}

	@Test
	public void getcheckLateManTest() throws Exception {
		System.out.println(service.getcheckLateMan(37));
	}

	@Test
	public void getcheckLateCntTest() throws Exception {
		System.out.println(service.getcheckLaterCnt(1));
	}

	@Test
	public void checkStudentServiceTest() throws Exception {
		System.out.println(service.checkStudent("lsy"));
	}

	
	@Test
	public void getcheckAttendanceCntTest() throws Exception{
		System.out.println(service.getAttendanceCnt(1));
	}
	
	@Test
	public void getTodayCheck() throws Exception {
		List<CheckTimeVO> result = service.getTodayCheck(37);
		List<CheckTimeVO> chulseok = new ArrayList<CheckTimeVO>();
		List<CheckTimeVO> jigak = new ArrayList<CheckTimeVO>();
		
		System.out.println(result);
		
		for (CheckTimeVO checkTimeVO : result) {
			if(checkTimeVO.getStates().equals("blue") ){
				chulseok.add(checkTimeVO);
			} else {
				jigak.add(checkTimeVO);
			}
		}
		
		System.out.println("CHULSEOK : " + chulseok);
		System.out.println("CHULSEOK size : " + chulseok.size());
		System.out.println("JIGAK : " + jigak);
		System.out.println("JIGAK : size " + jigak.size());
		
	}
	
	@Test
	public void emotionParseTest() throws Exception {
		List<CheckTimeVO> result = service.getTodayCheck(37);
		Map<String, Integer> emotionMap = new HashMap<String, Integer>();
//		String[] keys = {"contempt", "surprise", "happiness", "neutral", "sadness", "disgust", "anger", "fear"};
		String[] keys = { "happiness", "neutral", "sadness", "anger", "fear","surprise"};
		JSONParser parser = new JSONParser();

		for (String key : keys) {
			emotionMap.put(key, 0);
		}
		
		for (CheckTimeVO checkTimeVO : result) {
			JSONObject obj = (JSONObject) parser.parse("{" + checkTimeVO.getEmotion() + "}");
			long highScore = -1;
			long currScore;
			String state = null;
			for (String key : keys) {
				currScore = (Long) obj.get(key);
				if(highScore < currScore) {
					highScore = currScore;
					state = key;
				}
			}
			emotionMap.put(state, emotionMap.get(state) + 1);		
		}
		
		System.out.println(emotionMap);
		
		// 감정 = 제일 큰 값의 key 값 따야지.
		// 
		
		
		
		
	}
	
	
}
