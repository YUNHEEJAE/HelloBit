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
public class ByteConverter {
	
	public byte[] ByteConvert(String url) throws Exception{	
		String imgData = url.split(",")[1];
		byte[] image = DatatypeConverter.parseBase64Binary(imgData);	
		return image;
	}

}
