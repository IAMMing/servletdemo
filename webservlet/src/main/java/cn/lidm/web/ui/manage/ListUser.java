package cn.lidm.web.ui.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lidm.domain.User;
import cn.lidm.service.IUserService;
import cn.lidm.service.impl.UserService;

public class ListUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService userService=new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<User> lst=userService.GetUser();
		req.setAttribute("lst", lst);
		req.getRequestDispatcher("/WEB-INF/pages/manage/listuser.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
