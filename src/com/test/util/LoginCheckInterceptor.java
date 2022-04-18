package com.test.util;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egov.exception.AjaxSessionDisconnectException;
import egov.exception.SessionDisconnectException;

@SuppressWarnings("unchecked")
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
	static Logger logger = Logger.getLogger(LoginCheckInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

		logger.info("LoginCheckInterceptor " + handler.getClass().toString());
		
		String strUri = request.getRequestURI();
		int iMbi = strUri.indexOf("mbi");
		
		String urlPrefix = "http://" + request.getServerName();
		if (request.getServerPort() != 80) {
			urlPrefix = urlPrefix + ":" + request.getServerPort();
		}
		urlPrefix = urlPrefix + request.getContextPath();
		request.setAttribute("gUrlPrefix", urlPrefix);

		String sMbrId = (String)EgovSessionCookieUtil.getSessionAttribute(request, "mbrId");
		if(sMbrId == null) {
			String returnUrl = request.getRequestURI();
			request.setAttribute("returnUrl", URLEncoder.encode(returnUrl, "UTF-8"));
			
			String headerAccept = request.getHeader("Accept"); 
			if (headerAccept!=null && headerAccept.startsWith("application/json")) {
				throw new AjaxSessionDisconnectException("-1001");
			} else {
				throw new SessionDisconnectException("-1001");
			}
		}
		return true;
	}
}