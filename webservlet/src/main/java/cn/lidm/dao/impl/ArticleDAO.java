package cn.lidm.dao.impl;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.lidm.dao.IManageDAO;
import cn.lidm.dbhelper.DataBase;
import cn.lidm.domain.Article;

public class ArticleDAO implements IManageDAO<Article> {

	DataBase db = new DataBase();

	public List<Article> GetList(String sql) {
		try {
			return db.ReadData(Article.class, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Article Get(String sql) {
		List<Article> lst = GetList(sql);
		if (lst != null && lst.size() > 0) {
			return lst.get(0);
		}
		return null;
	}

	public int Update(Article article) {
		if (article.getArticleId() > -1) {
			String updateString = "";
			if (article.getColumnId() > -1)

			{
				updateString += ",columnid=" + article.getColumnId();
			}
			if (!article.getContent().isEmpty()) {
				updateString += ",content=" + article.getContent();
			}
			if (article.getIsDel() > -1) {
				updateString += ",isdel=" + article.getIsDel();
			}
			if (!article.getTitle().isEmpty()) {
				updateString += ",title=" + article.getTitle();
			}
			if (article.getUserId() > -1) {
				updateString += ",userid=" + article.getUserId();
			}

			if (updateString.isEmpty()) {
				return 0;
			} else {
				String sql = MessageFormat.format(
						"UPDATE article SET {0} WHERE articleid={1}",
						updateString.substring(1), article.getArticleId());
				try {
					return db.executeSQL(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return 0;
	}

	public int Insert(Article article) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String sql = MessageFormat
				.format("INSERT INTO article(columnid,content,createdate,isdel,title,userid) VALUES({0},{1},{2},{3},{4},{5})",
						article.getColumnId(), "'"+article.getContent()+"'",
					 "'"+sdf.format(article.getCreateDate())+"'", article.getIsDel(),
						"'"+article.getTitle()+"'", article.getUserId());
		try {
			return db.executeSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
