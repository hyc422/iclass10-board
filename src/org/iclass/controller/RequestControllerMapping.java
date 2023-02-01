package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestControllerMapping 
{
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	
	public static void init()
	{	// 설계된 URL, method에 따라 처리할 controller 구현체를 key, Value로 HashMap에 저장
		mapping.put(new RequestKeyValue("/community/list","GET"), new ListController());
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController());
		mapping.put(new RequestKeyValue("/community/write","POST"), new WriteController());	
	}
	
	public static Controller getController(RequestKeyValue key)
	{return mapping.get(key);}
	// url,method field를 저장하는 key를 전달, HashMap에서 value(controller) return
}	// Class end
