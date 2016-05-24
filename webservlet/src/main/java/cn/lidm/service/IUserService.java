package cn.lidm.service;

import java.util.List;

import cn.lidm.domain.User;

public interface IUserService {
	User Login(String username,String password);
	
	void AddUser(User user);
	
	void EditUser(User user);
	
	List<User> GetUser();
}
