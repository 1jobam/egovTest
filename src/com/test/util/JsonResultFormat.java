package com.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@SuppressWarnings({"rawtypes", "unchecked"})
public class JsonResultFormat extends AbstractResultFormat {
	
	@Override
	public Object toResultFormat(List<Map> list) {
		
		JSONObject jo = new JSONObject();

		JSONArray ja = convListToJson(list);
		
		jo.put(CommonConst.RESULT_KEY, ja);
		
		return jo;
		
	}

	@Override
	public Object toResultFormat(Map result) {
		
		return convMapToJson(result);
		
	}
	
	protected JSONArray convListToJson(List<Map> list) {
		
		JSONArray ja = new JSONArray();
		
		for(Map map : list){
			Object[] keys = map.keySet().toArray(new String[map.size()]);
			
			JSONObject jo = new JSONObject();
			
			for(Object key : keys) {
				jo.put(key, map.get(key));
			}
			
			ja.add(jo);
		}
		
		return ja;
		
	}
	
	protected JSONObject convMapToJson(Map map) {
		
		JSONObject jo = new JSONObject();
		
		Object[] keys = map.keySet().toArray(new String[map.size()]);
		
		for(Object key : keys) {
			Object elem = map.get(key);
			Object value = null;
			if(elem instanceof Map){
				value = convMapToJson((Map)elem);
			}
			else if(elem instanceof List){
				value = convListToJson((List)elem);
			}
			else{
				value = elem;
			}
			jo.put(key, value);
		}
		return jo;
		
	}

	@Override
	public Object toResultFormat(EgovMap result) {
		return convEgovMapToJson(result);
	}
	
	
	protected JSONObject convEgovMapToJson(EgovMap map) {
		
		JSONObject jo = new JSONObject();
		
		Object[] keys = map.keySet().toArray(new String[map.size()]);
		
		for(Object key : keys) {
			Object elem = map.get(key);
			Object value = null;
			if(elem instanceof EgovMap){
				value = convEgovMapToJson((EgovMap)elem);
			}
			else if(elem instanceof List){
				value = convListToJson((List)elem);
			}
			else{
				value = elem;
			}
			jo.put(key, value);
		}
		return jo;
		
	}
	
	public HashMap<String, Object> convJsonToHashMap(JSONObject jo) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		Object[] keys = jo.keySet().toArray(new String[jo.size()]);
		
		for(Object key : keys) {
			Object elem = jo.get(key);
			hashMap.put((String)key, elem);
		}		
		return hashMap;
	}
	
	public List<HashMap<String, Object>> convJsonToListHashMap(JSONArray ja) {
		List<HashMap<String, Object>> list = new ArrayList();
		
		for(int i = 0; i < ja.size(); i++) {
			list.add(convJsonToHashMap(ja.getJSONObject(i)));
		}		
		return list;
	}
}
