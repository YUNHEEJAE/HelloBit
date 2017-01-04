package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.kb141.domain.CheckVO;
import org.kb141.domain.ProgramVO;
import org.kb141.domain.StudentVO;
import org.kb141.service.CheckService;
import org.kb141.service.ProgramService;
import org.kb141.service.StudentService;
import org.kb141.util.ByteConverter;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/front")
public class FrontController {

	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	@Inject
	private FaceAPIUtils faceAPI;
	
	@Inject
	private ProgramService programService;
	
	@Inject
	private CheckService checkService;
	
	@Inject
	private StudentService studentService;

	
	@GetMapping("/authpage/programlist")
	public ResponseEntity<List<ProgramVO>> gotofrontend(){
		logger.info("frontend  start .....................");

		ResponseEntity<List<ProgramVO>> entity = null;
		try {
				entity = new ResponseEntity<List<ProgramVO>>(programService.getProgramList(), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<List<ProgramVO>>(HttpStatus.BAD_REQUEST);
			}
			return entity;

	}
	
	@ResponseBody
	@GetMapping("/authpage/checklist")
	public ResponseEntity<List<CheckVO>>checkList(){
		
		ResponseEntity<List<CheckVO>> entity = null;
		try {
			entity = new ResponseEntity<List<CheckVO>>(checkService.checkList(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<CheckVO>>(HttpStatus.BAD_REQUEST);
		}	
		return entity;

	}

	@ResponseBody
	@PostMapping(value = "/frontAuth" , produces="application/json")
	public StudentVO frontAuth(String blob , String groupId)throws Exception{
		ByteConverter bc = new ByteConverter();
		logger.info("groupId :" + groupId);
		byte[] image = bc.ByteConvert(blob);
		StudentVO vo = new StudentVO();

		List<String> faceIds = faceAPI.detectAndIdentifyFace(image, groupId);
		logger.info("----------------");
		
		logger.info("faceId : " + faceIds);
			if(faceIds.size() != 0){
				vo = (studentService.viewSname(faceIds.get(0)));				
			}	
		return vo;
	}

	@ResponseBody
	@PostMapping(value ="/emotion")
	public void getEmotion(CheckVO vo)throws Exception{		
		logger.info("emotion called..................");	
		logger.info("emotion :" + vo);	
		checkService.create(vo);
	}  

	
	
}
