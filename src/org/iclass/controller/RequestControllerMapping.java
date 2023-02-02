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
		// 회원가입
		mapping.put(new RequestKeyValue("/member/join","GET"), null);	
		mapping.put(new RequestKeyValue("/member/join","POST"), null);	
		// 회원정보수정
		mapping.put(new RequestKeyValue("/member/modify","GET"), null);	
		mapping.put(new RequestKeyValue("/member/modify","POST"), null);	
		// login
		mapping.put(new RequestKeyValue("/login","GET"), null);	
		mapping.put(new RequestKeyValue("/login","POST"), null);	
		mapping.put(new RequestKeyValue("/logout","GET"), null);	
	}
	
	public static Controller getController(RequestKeyValue key)
	{return mapping.get(key);}
	// url,method field를 저장하는 key를 전달, HashMap에서 value(controller) return
}	// Class end
