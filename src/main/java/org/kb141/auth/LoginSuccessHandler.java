package org.kb141.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mysql.cj.api.Session;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		GrantedAuthority curole = auth.getAuthorities().iterator().next();
		
		String rolePath = curole.toString().substring(5).toLowerCase();
		String roleID = auth.getName();
		
		System.out.println("CURR ROLE : " + rolePath);
		System.out.println(roleID);
		
//		response.sendRedirect(request.getContextPath() + "/kihahahahahahahah");
		
		Cookie cookie = new Cookie("LOGIN_ID", roleID);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		response.sendRedirect("/web/" + rolePath + "/main");
	}
}
