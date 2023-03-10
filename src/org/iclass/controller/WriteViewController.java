package org.iclass.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteViewController implements Controller
{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("write.jsp");
		
		dispatcher.forward(request, response);
	}	// method end
}	// Class end
