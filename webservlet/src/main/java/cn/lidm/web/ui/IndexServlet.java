package cn.lidm.web.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lidm.domain.Article;
import cn.lidm.domain.Columns;
import cn.lidm.service.IColumnsService;
import cn.lidm.service.impl.ColumnService;

public class IndexServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IColumnsService columnService= new  ColumnService();
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{

		List<Columns> columns;
		List<Article> articles;
		
		columns=columnService.Get();
		
		request.setAttribute("columns", columns);
		request.setAttribute("ldm", "lidaming");
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		
		doPost(request, response);
	}
}
