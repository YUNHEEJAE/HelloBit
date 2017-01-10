package org.kb141.auth;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kb141.domain.ProgramVO;
import org.kb141.persistence.ProgramDAO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Inject
	private ProgramDAO programDAO;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		
		
		GrantedAuthority curole = auth.getAuthorities().iterator().next();
		
		String rolePath = curole.toString().substring(5).toLowerCase();
		String roleID = auth.getName();
		
		
		Cookie cookie = new Cookie("LOGIN_ID", roleID);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		if (rolePath.equals("teacher")) {
			
			try {
				List<ProgramVO> myProgram = programDAO.teacherList(roleID);
				String myProgramCookieList = "";
				
				for(int i = 0 ; i < myProgram.size() ; i++){
					myProgramCookieList += myProgram.get(i).getPno() + ",";
				}
				
				System.out.println(myProgramCookieList);
				
				Cookie programCookie = new Cookie("MY_PROGRAM", URLEncoder.encode(myProgramCookieList, "UTF-8"));
				programCookie.setPath("/");
				response.addCookie(programCookie);
				
				response.sendRedirect("/web/teacher/main?pno=" + myProgram.get(0).getPno());
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("CANNOT MAKE COOKIES at Teacher");
			}
			
		} else if (rolePath.equals("faculity")){
			try {
				List<ProgramVO> myProgram = programDAO.allList();
				String myProgramCookieList = "";
				
				for(int i = 0 ; i < myProgram.size() ; i++){
					myProgramCookieList += myProgram.get(i).getPno() + ",";
				}
				
				System.out.println(myProgramCookieList);
				
				Cookie programCookie = new Cookie("MY_PROGRAM", URLEncoder.encode(myProgramCookieList, "UTF-8"));
				programCookie.setPath("/");
				response.addCookie(programCookie);
				
				response.sendRedirect("/web/faculity/main?pno=" + myProgram.get(0).getPno());
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("CANNOT MAKE COOKIES at faculity");
			}
			
		} else {
			response.sendRedirect("/web/" + rolePath + "/main");
		}
//		System.out.println("CURR ROLE : " + rolePath);
//		System.out.println(roleID);
	}
}
