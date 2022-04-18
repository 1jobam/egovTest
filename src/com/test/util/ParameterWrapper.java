package com.test.util;

import javax.servlet.http.HttpServletRequest;

public class ParameterWrapper {
	
	public static int getInt(HttpServletRequest req, String paramName) {
		return getInt(req, paramName, 0);
	}
	
	public static int getInt(HttpServletRequest req, String paramName, int defaultValue) {
		try{
			String s = req.getParameter(paramName);
			return s == null || s.trim().length() == 0 ? defaultValue : Integer.parseInt(s);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	public static long getLong(HttpServletRequest req, String paramName) {
		return getLong(req, paramName, 0);
	}
	
	public static long getLong(HttpServletRequest req, String paramName, long defaultValue) {
		try{
			String s = req.getParameter(paramName);
			return s == null || s.trim().length() == 0 ? defaultValue : Long.parseLong(s);
		}catch(Exception e){
			return defaultValue;
		}
	}

	public static float getFloat(HttpServletRequest req, String paramName) {
		return getFloat(req, paramName, 0);
	}
	
	public static float getFloat(HttpServletRequest req, String paramName, float defaultValue) {
		try{
			String s = req.getParameter(paramName);
			return s == null || s.trim().length() == 0 ? defaultValue : Float.parseFloat(s);
		}catch(Exception e){
			return defaultValue;
		}
	}

	public static double getDouble(HttpServletRequest req, String paramName) {
		return getDouble(req, paramName, 0);
	}
	
	public static double getDouble(HttpServletRequest req, String paramName, double defaultValue) {
		try{
			String s = req.getParameter(paramName);
			return s == null || s.trim().length() == 0 ? defaultValue : Double.parseDouble(s);
		}catch(Exception e){
			return defaultValue;
		}
	}
	
	public static String getString(HttpServletRequest req, String paramName) {
		return getString(req, paramName, ""); 
	}
	
	public static String getString(HttpServletRequest req, String paramName, String defaultValue) {
		String s = req.getParameter(paramName);
		return s == null ? defaultValue : s;
	}
	
}
