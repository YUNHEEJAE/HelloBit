package org.kb141.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import org.imgscalr.Scalr;
import org.kb141.util.FaceAPIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * TBL_IMAGE
 * @author KB141
 *
 */
@CrossOrigin
@RestController
@Controller
@RequestMapping("/image/")
public class ImageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@Inject
	private FaceAPIUtils faceAPI;
	
	@PostMapping("/registerImage")
	public String registerImage(String sid , MultipartFile file)throws Exception{
		
		logger.info("image controller called......................................................................");
		
		logger.info("filename :"  + file);

		BufferedImage origin = ImageIO.read(file.getInputStream());
		
		String uploadName =  sid + "_0.jpg";
		logger.info(uploadName);
//		ImageIO.write(origin, "jpg", 
//				new FileOutputStream("/Users/juyoungjung/upload/"+uploadName));
			// 윈도우 저장 버전 
		ImageIO.write(origin, "jpg", 
				new FileOutputStream("C://zzz//upload//"+file.getOriginalFilename())); 

		
		return uploadName;

	}
	
	@PostMapping(value = "/getFile" , produces="application/text;charset=utf8")
	public String getFile(String file)throws Exception{
		logger.info("file called.....");
		logger.info("file : " + file );	
		
		String imgData = file.split(",")[1];
		byte[] image = DatatypeConverter.parseBase64Binary(imgData);
		
		BufferedImage bimg = ImageIO.read(new ByteArrayInputStream(image));
		
		File outputFile = new File("test123.png");
		
		ImageIO.write(bimg, "png", new FileOutputStream("/Users/juyoungjung/"+outputFile));
		
		BufferedImage onimg = ImageIO.read(new FileInputStream("/Users/juyoungjung/"+outputFile));
		
		return "2016-12-29 15:00 정주영 출근";

	}
	
	
	

	
}
