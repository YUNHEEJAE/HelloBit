package org.kb141.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.http.HttpStatus;
import org.kb141.domain.ProgramVO;
import org.kb141.service.ProgramService;
import org.kb141.service.TakeProgramService;
import org.kb141.util.ByteConverter;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private TakeProgramService takeprogramService;
	
	@Inject
	private ProgramService programService;

	
	@GetMapping("/frontend")
	public ResponseEntity<List<ProgramVO>> gotofrontend() throws Exception{
		logger.info("frontend  start .....................");
//		
//		ResponseEntity<String> entity = null;
//		try {
//				entity = new ResponseEntity<List<ProgramVO>>(programService., HttpStatus.OK);
//			} catch (Exception e) {
//				e.printStackTrace();
//				entity = new ResponseEntity<List<ProgramVO>>(e.getMessage(), HttpStatus.BAD_REQUEST);
//			}
//			return entity;
//		
//		
		
		
		
		
		return null;
	}
	
	
	
	
	
	@ResponseBody
	@PostMapping(value = "/frontAuth" , produces="text/html")
	public String frontAuth(String blob)throws Exception{
		//ResponseEntity<String>
		ByteConverter bc = new ByteConverter();
		logger.info("blob : " + blob);
		
		byte[] image = bc.ByteConvert(blob);

//		List<String> faceIds = faceAPI.detectAndIdentifyFace(image, "java_beginner_34");
		
		String sname = null;
//		
//		ResponseEntity<String> entity = null;
//		try {
//			if(faceIds.size() != 0){
//					for (int i = 0 ; i < faceIds.size() ; i ++){
//						sname = takeprogramService.viewSname(faceIds.get(i));
//					}
//						logger.info("faceID :" + sname);
//						entity = new ResponseEntity<String>(sname, HttpStatus.OK);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//			}
//			return entity;
		
		sname = takeprogramService.viewSname("47579260-7ff0-4329-afbb-4c594223cb12");
		
		return sname;
		
	}
	
}
