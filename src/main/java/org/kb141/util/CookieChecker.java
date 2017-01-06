package org.kb141.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

@Repository
public class CookieChecker {

	public void cookieChecker(Cookie[] cookies, Integer pno) throws UnsupportedEncodingException {
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("MY_PROGRAM")){
				String myProgramsComma = URLDecoder.decode(cookie.getValue(),"UTF-8");
				String[] myPrograms = myProgramsComma.split(",");
				boolean flag = true;
				for (String string : myPrograms) {
					if(pno == Integer.parseInt(string)){
						flag = false;
					}
				}
				if(flag){
					throw new AccessDeniedException("HAS NO Program");
				}
					
			}
		}
		
		
	}
	
}
