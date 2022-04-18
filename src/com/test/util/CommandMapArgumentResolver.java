/**
 * @Class Name  : CommandMapArgumentResolver.java
 * @Description : CommandMapArgumentResolver.class
 * @Modification Information
 * @
 * @  ?àò?†ï?ùº         ?àò?†ï?ûê          ?àò?†ï?Ç¥?ö©
 * @ -------    --------    ---------------------------
 * @ 2010.02.12    lee.m.j          ÏµúÏ¥à ?Éù?Ñ±
 *
 *  @author lee.m.j
 *  @since 2010.02.12
 *  @version 1.0
 *  @see
 */

package com.test.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class CommandMapArgumentResolver implements WebArgumentResolver {
	
	public Object resolveArgument(MethodParameter methodParameter,
			NativeWebRequest webRequest) throws Exception {
		
		Class<?> clazz = methodParameter.getParameterType();
		String paramName = methodParameter.getParameterName();
		
		if((clazz.equals(HashMap.class) || clazz.equals(Map.class)) && "commandMap".equals(paramName)){
			
			HashMap<String, Object> commandMap = new HashMap<String, Object>();
			HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();			
			Enumeration<?> enumeration = request.getParameterNames();
			
			while(enumeration.hasMoreElements()){
				String key = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				if(values!=null){
				    if("atchDocId".equals(key)) {
				        commandMap.put(key, values[0]);
				    } else {
				        commandMap.put(key, (values.length > 1) ? values:values[0] );
				    }
				}
			}
			return commandMap;
		}
		return UNRESOLVED;
	}
}