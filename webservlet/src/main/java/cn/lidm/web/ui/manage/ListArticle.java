package cn.lidm.web.ui.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lidm.domain.Article;
import cn.lidm.service.IArticleService;
import cn.lidm.service.impl.ArticleService;

public class ListArticle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IArticleService articleService=new ArticleService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Article> lst=articleService.Get();
		req.setAttribute("lst", lst);
		req.getRequestDispatcher("/WEB-INF/pages/manage/listarticle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	

}
