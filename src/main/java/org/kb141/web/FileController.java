package org.kb141.web;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@Controller
@RequestMapping("/file")
@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	
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
