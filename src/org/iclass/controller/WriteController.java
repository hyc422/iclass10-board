package org.iclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class WriteController implements Controller
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		Community vo = Community.builder()
								.title(title)
								.writer(writer)
								.content(content)
								.ip(ip)
								.build();
		
		CommunityDao dao = CommunityDao.getInstance();
		
		long result = dao.insert(vo);
		
		if(result!=0)
		{response.sendRedirect("list");}
		else	// 메인 화면으로 이동
		{response.sendRedirect(request.getContextPath());}
	}	// method end
}	// Class end
