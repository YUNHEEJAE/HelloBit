package org.kb141.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Repository;

@Repository
public class ImageToUrlConverter {
	
	public String ImageConverter(String url) throws Exception{
		
		String imgData = url.split(",")[1];
		byte[] image = DatatypeConverter.parseBase64Binary(imgData);
		
		BufferedImage bimg = ImageIO.read(new ByteArrayInputStream(image));
		
		File outputFile = new File("test123.png");
		
		ImageIO.write(bimg, "png", new FileOutputStream("/Users/juyoungjung/"+outputFile));

		URL fileUrl = new File("/Users/juyoungjung/"+outputFile).toURI().toURL();
		
		return fileUrl.toString();
		
		
	}

}
