package cn.lidm.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.lidm.domain.User;
import cn.lidm.service.IUserService;
import cn.lidm.service.impl.UserService;
import cn.lidm.util.WebUtils;
import cn.lidm.web.formbean.UserFormBean;

public class AddUser extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IUserService userService=new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserFormBean formbean=WebUtils.request2Bean(req, UserFormBean.class);
		if(formbean.validate()==false)
		{
			req.setAttribute("formbean", formbean);
			req.getRequestDispatcher("/WEB-INF/pages/manage/adduser.jsp").forward(req, resp);
			
			return;
		}
		User user=new User();
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.AddUser(user);
	}

}
