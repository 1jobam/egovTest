package com.test.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public class EgovSessionCookieUtil {

	public static void mapToSession(HttpServletRequest request, HashMap<String, String> pMap) throws Exception {
		HttpSession session = request.getSession();
		
		Iterator<String> insIterator = pMap.keySet().iterator();
		
		while(insIterator.hasNext()){
			String key = (String)insIterator.next();
			session.setAttribute(key, pMap.get(key));
		}
	}
	
	public static void mapToSession(HttpServletRequest request, EgovMap pMap) throws Exception {
		HttpSession session = request.getSession(true);
		
		Iterator<String> insIterator = pMap.keySet().iterator();
		
		while(insIterator.hasNext()){
			String key = (String)insIterator.next();
			session.setAttribute(key, pMap.get(key));
		}
	}
	
	public static HashMap<String, Object> userInfoToMap(HttpServletRequest request, HashMap<String, Object> commandMap) throws Exception {
		commandMap.put("mbrId", getSessionAttribute(request, "mbrId"));
		commandMap.put("orgnId", getSessionAttribute(request, "orgnId"));
		commandMap.put("mbsOrgnId", getSessionAttribute(request, "orgnId"));
		return commandMap;
	}

    public static void setSessionAttribute(HttpServletRequest request, String keyStr, String valStr) throws Exception {
    	HttpSession session = request.getSession();
    	session.setAttribute(keyStr, valStr);
    }

    public static void setSessionAttribute(HttpServletRequest request, String keyStr, Object obj) throws Exception {
    	HttpSession session = request.getSession();
    	session.setAttribute(keyStr, obj);
    }

    public static Object getSessionAttribute(HttpServletRequest request, String keyStr) throws Exception {
    	HttpSession session = request.getSession();
    	return session.getAttribute(keyStr);
    }

    public static String getSessionValuesString(HttpServletRequest request) throws Exception {
    	HttpSession session = request.getSession();
    	String returnVal = "";
    	
    	Enumeration e = session.getAttributeNames();
    	
    	while (e.hasMoreElements()) {
    		String sessionKey = (String)e.nextElement();
    		returnVal = returnVal + "[" + sessionKey + " : " + session.getAttribute(sessionKey) + "]";
    	}
    	
    	return returnVal;
    }

    public static void removeSessionAttribute(HttpServletRequest request, String keyStr) throws Exception {
    	HttpSession session = request.getSession();
    	session.removeAttribute(keyStr);
    }

    public static void setCookie(HttpServletResponse response, String cookieNm, String cookieVal, int minute) throws UnsupportedEncodingException {
    	
    	String cookieValue = URLEncoder.encode(cookieVal, "utf-8");
    	
    	Cookie cookie = new Cookie(cookieNm, cookieValue);
    	
    	cookie.setMaxAge(60 * minute);
    	
    	response.addCookie(cookie);
    }

    public static void setCookie(HttpServletResponse response, String cookieNm, String cookieVal) throws UnsupportedEncodingException {
    	String cookieValue = URLEncoder.encode(cookieVal, "utf-8");
    	
    	Cookie cookie = new Cookie(cookieNm, cookieValue);
    	
    	response.addCookie(cookie);
    }
    
    public static String getCookie(HttpServletRequest request, String cookieNm) throws Exception {

		Cookie[] cookies = request.getCookies();
	
		if (cookies == null)
		    return "";
	
		String cookieValue = null;
	
		for (int i = 0; i < cookies.length; i++) {
	
		    if (cookieNm.equals(cookies[i].getName())) {
	
			cookieValue = URLDecoder.decode(cookies[i].getValue(), "utf-8");
	
			break;
	
		    }
		}
	
		return cookieValue;
    }

    public static void setCookie(HttpServletResponse response, String cookieNm) throws UnsupportedEncodingException {

		Cookie cookie = new Cookie(cookieNm, null);
	
		cookie.setMaxAge(0);
	
		response.addCookie(cookie);
    }
}
