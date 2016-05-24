package cn.lidm.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.lidm.domain.Article;
import cn.lidm.service.IArticleService;
import cn.lidm.service.impl.ArticleService;
import cn.lidm.util.WebUtils;
import cn.lidm.web.formbean.ArticleFormBean;

public class SubmitArticle extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IArticleService articleService=new ArticleService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ArticleFormBean formbean=WebUtils.request2Bean(req, ArticleFormBean.class);
		if(formbean.validate()==false)
		{
			req.setAttribute("formbean", formbean);
			req.getRequestDispatcher("/WEB-INF/pages/manage/addarticle.jsp").forward(req, resp);
		}
		
		Article article=new Article();
		
		try {
			BeanUtils.copyProperties(article, formbean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		articleService.Add(article);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
