package org.kb141.web;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

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
	
	
	@PostMapping("/getFile")
	public void getFile(String file)throws Exception{
		logger.info("file called.....");
		logger.info("file : " + file );	
		
		FileOutputStream fos = new FileOutputStream("/Users/juyoungjung/test11.png");
		
		byte[] image = file.getBytes();
		
		logger.info("img : " + image);
		
		fos.write(image);
		

		
	}
}
