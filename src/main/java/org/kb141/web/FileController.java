package org.kb141.web;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import org.kb141.util.FaceAPIUtils;
import org.kb141.util.ByteConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@Controller
@RequestMapping("/file")
@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Inject
	private FaceAPIUtils faceAPI;
	
	@Inject
	private ByteConverter bc;
	
	@PostMapping(value = "/getFile" , produces="application/text;charset=utf8")
	public String getFile(String file)throws Exception{
		logger.info("file called.....");
		logger.info("file : " + file );	
		
		byte[] imgData = bc.ByteConvert(file);
		List<String> result = faceAPI.detectAndIdentifyFace(imgData, "java_beginner_34");
		logger.info("result  = " + result);  
		
		return "2016-12-29 15:00 정주영 출근"; 

	}
	
	@PostMapping(value = "/registerImage" , produces ="text/html")
	public String getImage(String data)throws Exception{
		logger.info("regimg called........");
		byte[] imgData = bc.ByteConvert(data);	
		logger.info("imgData" + imgData);
		return null;
	}
	
}
