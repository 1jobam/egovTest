<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String userAgent = request.getHeader("User-Agent").toUpperCase();

if((userAgent != null || userAgent != "")){
	if(userAgent.indexOf("MOBILE") > -1){
		response.sendRedirect(request.getContextPath() + "/mobile/login.do?returnUrl=" + request.getAttribute("returnUrl"));
	}else{
		response.sendRedirect(request.getContextPath() + "/login.do?returnUrl=" + request.getAttribute("returnUrl"));		
	}
}
%>