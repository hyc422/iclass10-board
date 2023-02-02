package org.iclass.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.dao.CommunityDao;

public class ListController implements Controller
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	// db select * from community
		CommunityDao dao = CommunityDao.getInstance();
		
		request.setAttribute("list", dao.list());
		request.setAttribute("today", LocalDate.now());
		// 현재날싸시간 저장-출력형식 2개 중 하나 고를때 비교값
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		// 요청링크가 /community/list 였고 원하는 jsp도 community 폴더
		dispatcher.forward(request, response);
	}	// method end
}	// Class end
