package cn.lidm.service;

import java.util.List;

import cn.lidm.domain.Article;

public interface IArticleService {
	List<Article> Get();
	void Add(Article article);
	void Update(Article article);
}
