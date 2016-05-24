package cn.lidm.web.ui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.getWriter().println("23ds");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		doPost(request,response);
	}
}
