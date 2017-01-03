package org.kb141.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import org.kb141.domain.CheckVO;
import org.kb141.domain.TakeProgramVO;
import org.kb141.domain.WeekDataVO;
import org.kb141.service.CheckService;
import org.kb141.service.TakeProgramService;
import org.kb141.util.ByteConverter;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/check")
public class CheckController {
	private static final Logger logger = LoggerFactory.getLogger(CheckController.class);

	@Inject
	private CheckService service;
	
	@Inject
	private FaceAPIUtils faceAPI;
	
	@Inject
	private TakeProgramService takeprogramService;

	// 내가 만들건 Create야
//	@PostMapping("/register")
//	public void checkRegister(CheckVO vo, Model model) throws Exception {
//		logger.info("REGISTER.........");
//		logger.info("DEBUG: " + vo);
//		
//		service.create(vo);
//	}
	

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody CheckVO vo) {
		logger.info("REGISTER.........");
		logger.info("DEBUG: " + vo);
		ResponseEntity<String> entity = null;
		try {
			service.create(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
	@ResponseBody
	@GetMapping("/checklist")
	public List<CheckVO> checkList() throws Exception{
		logger.info("checklist Start .......");
		
		logger.info("CheckList : " + service.checkList());
		
		return service.checkList();
		
	}
	
	@ResponseBody
	@GetMapping("/checkWeek/{pno}")
	public WeekDataVO checkWeek(@PathVariable("pno") Integer pno) throws Exception {
		logger.info("Weeklist Start...");
		
		return service.getcheckWeek(pno);
	}
	
	

}
