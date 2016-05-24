package cn.lidm.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.lidm.domain.Columns;
import cn.lidm.service.IColumnsService;
import cn.lidm.service.impl.ColumnService;
import cn.lidm.util.WebUtils;
import cn.lidm.util.path.PathUtil;
import cn.lidm.web.formbean.ColumnFormBean;

public class SubmitColumn extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IColumnsService columnService = new ColumnService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ColumnFormBean formbean = WebUtils.request2Bean(req,
				ColumnFormBean.class);

		if (formbean.validate() == false) {
			req.setAttribute("formbean", formbean);
			if (formbean.getColumnId() > 0) {
				req.getRequestDispatcher(PathUtil.MANAGE_PATH+ "editcolumn.jsp?columnid="+formbean.getColumnId())
				.forward(req, resp);
			} else {
				req.getRequestDispatcher("/WEB-INF/pages/manage/addcolumn.jsp")
						.forward(req, resp);
			}
		}

		Columns column = new Columns();
		try {
			BeanUtils.copyProperties(column, formbean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (column.getColumnId() > 0) {
			columnService.Edit(column);
		} else {
			columnService.Add(column);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
