package com.test.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.test.util.AbstractResultFormat.ResultFormat;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@SuppressWarnings({"rawtypes","unchecked"})
public class AbstractBaseController {
	
	public static final String KEY_SESSION_ID = "sessionId";
	public static final String[] KEY_PARAMS = {
		KEY_SESSION_ID
	};

	public static final String PAGE_PARAM_LIMIT    = "limit";
	public static final String PAGE_PARAM_OFFSET   = "offset";
	public static final String PAGE_PARAM_ORDER_BY = "order";
	
	public static final String PAGE_VIEW_COUNT     = "viewCount";
	public static final String PAGE_START_INDEX    = "startIndex";
	public static final String PAGE_ORDER_BY       = "order";
	
	public static final String PAGE_RESULT_TOTAL   = "total";
	public static final String PAGE_RESULT_ROWS    = "rows";
	
	protected AbstractResultFormat createResultFormat(ResultFormat format){
		AbstractResultFormat obj = null;
		
		if(format == ResultFormat.JSON){
			obj = new JsonResultFormat(); 
		}
		
		return obj;
	}
	
	public String responseJson(ModelMap model, Object result){
		Object o = null;
		
		if(result instanceof List){
			o = toResultFormat(ResultFormat.JSON, (List)result);
		}
		else if(result instanceof Map){
			o = toResultFormat(ResultFormat.JSON, (Map)result);
		}
		else if(result instanceof EgovMap){
			o = toResultFormat(ResultFormat.JSON, (EgovMap)result);
		} else if (result instanceof Object) {
			o = result;
		}
		else{
			throw new IllegalArgumentException("Invalid result class type : " + result.getClass() + ". Only List, Map is available");
		}
		
		model.addAttribute(CommonConst.RESULT_KEY, o);
		
		return CommonConst.RESPONSE_PAGE;
	}
	
	public Object toResultFormat(ResultFormat format, Object result){
		AbstractResultFormat obj = createResultFormat(format);
		
		Object o = null;
		if(result instanceof List){
			o = obj.toResultFormat((List)result);
		}
		else if(result instanceof Map){
			o = obj.toResultFormat((Map)result);
		}
		else if(result instanceof EgovMap){
			o = obj.toResultFormat((EgovMap)result);
		}
		else{
			throw new IllegalArgumentException("Invalid result class type : " + result.getClass() + ". Only List, Map is available");
		}
		
		return o;
	}
	
	public static Map<String, Object> createPageResult(int totalCount, List dataList){
    	Map<String, Object> m = new HashMap<String, Object>();
    	m.put(PAGE_RESULT_TOTAL, totalCount);
    	m.put(PAGE_RESULT_ROWS, dataList);

    	return m;
	}
	
	public static Map<String, Object> createPageParameter(HttpServletRequest req) throws Exception{
		return createPageParameter(req, new HashMap<String, Object>());
	}
	
	public static Map<String, Object> createPageParameter(HttpServletRequest req, Map<String, Object> paramMap) throws Exception{
		Map<String, Object> newParamMap = new HashMap<String, Object>();
		
		int limit = ParameterWrapper.getInt(req, PAGE_PARAM_LIMIT);
		int offset = ParameterWrapper.getInt(req, PAGE_PARAM_OFFSET);
		if(limit == 0){
			limit = 10;
		}
		
		int viewCount = limit;
		int startIndex = offset;
		String order = req.getParameter(PAGE_PARAM_ORDER_BY);
		if(order == null){
			order = "asc";
		}
		
		String[] keys = paramMap.keySet().toArray(new String[paramMap.size()]);
		for(int i = 0; i < keys.length; i++){
			String key = keys[i];
			if(key == null || isSkipParameter(key)){
				continue;
			}
			
			Object o = paramMap.get(key);
			if(o != null){
				newParamMap.put(key, o);
			}
		}
		
		newParamMap.put(PAGE_VIEW_COUNT, viewCount);
		newParamMap.put(PAGE_START_INDEX, startIndex);
		newParamMap.put(PAGE_ORDER_BY, order);
		
		return newParamMap;
	}
	
	private static boolean isSkipParameter(String name){
		return PAGE_PARAM_LIMIT.equals(name) || PAGE_PARAM_OFFSET.equals(name) || PAGE_PARAM_ORDER_BY.equals(name);
	}
	
	protected void putUserParameters(Map<String, Object> param){
		putUserParameters(param, false);
	}
	
	protected void putUserParameters(Map<String, Object> param, boolean overWriteExist){
		if(param == null){
			return;
		}
		/*
		PSecurityVO user = getUser();

		Class cls = PSecurityVO.class;
		for(String key : KEY_PARAMS){
			Object pv = param.get(key);
			if(pv != null && !overWriteExist){
				continue;
			}
			try{
				String methodKey = key.substring("session".length());

				String getter = "get" + Character.toUpperCase(methodKey.charAt(0)) + methodKey.substring(1);
				Method m = cls.getMethod(getter);
				if(m == null){
					continue;
				}
				Object v = m.invoke(user);
				if(v == null){
					continue;
				}
				param.put(key, v);
			}catch(Exception e){
				// ignore exception
			}
		}
		*/	
	}
    
    protected List<HashMap<String, Object>> getListparam(HttpServletRequest req){
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			Object obj = e.nextElement();
			if(obj instanceof String){
				String paramKey = (String) obj;
				
				int i=0;
				for(String item : req.getParameterValues(paramKey)){
					if(list.size()-1 < i ){
						HashMap<String, Object> map = new HashMap<String, Object>();
						list.add(map);
					}
					HashMap<String, Object> map = list.get(i);
					if(map == null){
						map = new HashMap<String, Object>();
						list.add(map);
					}
					map.put(paramKey, item);
					
					i++;
				}
			}
		}
		
		return list;
    }
    
	protected String getColumnToVar(String column){
		String resultStr = "";
		
		column = column.toLowerCase();
		String[] columnArr = column.split("_");
		for(int i=0; i<columnArr.length; i++){
			if(i == 0){
				resultStr += columnArr[i];
			}else{
				resultStr += columnArr[i].substring(0, 1).toUpperCase() + columnArr[i].substring(1);
			}
		}
		return resultStr;
	}
	
}