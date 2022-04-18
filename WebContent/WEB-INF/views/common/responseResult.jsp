<%@page import="com.test.util.CommonConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Object result = request.getAttribute(CommonConst.RESULT_KEY);
	out.println(result);
%>