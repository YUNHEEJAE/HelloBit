package org.kb141.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * TBL_IMAGE
 * @author KB141
 *
 */
@RestController
@Controller
@RequestMapping("/image/")
public class ImageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	
	@PostMapping("/registerImage")
	public String registerImage(String sid , MultipartFile filename)throws Exception{
		
		logger.info("image controller called......................................................................");
		
		
		
		logger.info("sid :" + sid);
		
		logger.info("filename :"  + filename);
		
		return "success";
		
	
	}
	
	
	
	
	
	
	
	
	
}
