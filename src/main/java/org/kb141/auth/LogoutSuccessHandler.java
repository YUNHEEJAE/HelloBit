package org.kb141.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{

	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		if (authentication != null) {
			
			Cookie jCookie = new Cookie("JSESSIONID", "");
			jCookie.setPath("/");
			jCookie.setMaxAge(0);
			
			Cookie lCookie = new Cookie("LOGIN_ID", "");
			lCookie.setPath("/");
			lCookie.setMaxAge(0);
			
			Cookie mCookie = new Cookie("MY_PROGRAM", "");
			mCookie.setPath("/");
			mCookie.setMaxAge(0);
			
			response.addCookie(jCookie);
			response.addCookie(lCookie);
			response.addCookie(mCookie);
		}

		setDefaultTargetUrl("/login?logout");
		super.onLogoutSuccess(request, response, authentication);
	}

}
