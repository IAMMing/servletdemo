package cn.lidm.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.lidm.domain.Article;

public class ArticleFormBean extends Article{

	private Map<String,String> errors=new HashMap<String,String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public boolean validate()
	{
		boolean isOK=true;
		if(this.getColumnId()<1)
		{
			errors.put("columnId", "必须选择文章所属于的栏目");
			isOK=false;
		}
		if(this.getContent().isEmpty())
		{
			errors.put("content", "文章内容不允许为空");
			isOK=false;
		}
		if(this.getTitle().isEmpty())
		{
			errors.put("title", "标题不能为空");
			isOK=false;
		}
		return isOK;
	}
}
