package cn.lidm.service.impl;

import java.text.MessageFormat;
import java.util.List;

import cn.lidm.dao.impl.AdminDAO;
import cn.lidm.domain.User;
import cn.lidm.service.IUserService;

public class UserService implements IUserService {

	AdminDAO admin=new AdminDAO();
	public User Login(String username, String password) {

		String sql = MessageFormat.format(
				"SELECT * FROM Admin WHERE username={0} AND password={1}",
				username, password);
		User user=admin.Get(sql);
		return user;
	}

	public void AddUser(User user) {
		admin.Insert(user);
	}

	public void EditUser(User user) {
		admin.Update(user);
	}

	public List<User> GetUser() {
		
		return admin.GetList("SELECT * FROM admin");
	}

}
