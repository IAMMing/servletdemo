package cn.lidm.web.ui.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lidm.domain.Columns;
import cn.lidm.service.IColumnsService;
import cn.lidm.service.impl.ColumnService;

public class ListColumn extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IColumnsService columnService = new ColumnService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Columns> lst = columnService.Get();
		req.setAttribute("lst", lst);
		req.getRequestDispatcher("/WEB-INF/pages/manage/listcolumn.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
