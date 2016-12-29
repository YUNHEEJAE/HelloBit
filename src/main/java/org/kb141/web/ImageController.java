package org.kb141.web;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
//		

		return uploadName;

	}
	
	
	
	
	
	
	
	
	
}
