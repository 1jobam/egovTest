package com.test.util;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@SuppressWarnings("rawtypes")
public abstract class AbstractResultFormat {
	
	public enum ResultFormat {
		JSON
	}
	
	public abstract Object toResultFormat(List<Map> result);
	
	public abstract Object toResultFormat(Map result);
	
	public abstract Object toResultFormat(EgovMap result);
	
}
