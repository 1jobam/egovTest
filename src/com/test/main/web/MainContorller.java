package com.test.main.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.util.AbstractBaseController;

@Controller
public class MainContorller extends AbstractBaseController{
	
	@RequestMapping(value="/home.do")
	private String home(HashMap<String, Object> commandMap, ModelMap model, HttpServletRequest request) throws Exception{
		
		String url = "main/main";
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		
		if(userAgent != null){
			System.out.println(userAgent);
		}
		
		return url;
	}

}
