package cn.lidm.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.lidm.domain.User;

public class UserFormBean extends User {
	
	private Map<String,String> errors=new HashMap<String, String>();	
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean validate()
	{
		boolean isOK=true;
		if(this.getUsername().isEmpty())
		{
			isOK=false;
			errors.put("username", "用户名不能为空");
		}
		if(this.getPassword().isEmpty())
		{
			isOK=false;
			errors.put("password", "密码不 能为空");
		}
		return isOK;
	}
}
