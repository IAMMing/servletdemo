package cn.lidm.service.impl;

import java.util.List;

import cn.lidm.dao.IManageDAO;
import cn.lidm.dao.impl.ArticleDAO;
import cn.lidm.domain.Article;
import cn.lidm.service.IArticleService;

public class ArticleService implements IArticleService {

	IManageDAO<Article> articleDAO=new ArticleDAO();
	public List<Article> Get() {
		return articleDAO.GetList("SELECT * FROM article");
	}

	public void Add(Article article) {
		articleDAO.Insert(article);
	}

	public void Update(Article article) {
		articleDAO.Update(article);
	}

}
