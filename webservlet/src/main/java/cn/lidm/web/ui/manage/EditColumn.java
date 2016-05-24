package cn.lidm.web.ui.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lidm.domain.Columns;
import cn.lidm.service.IColumnsService;
import cn.lidm.service.impl.ColumnService;
import cn.lidm.util.path.PathUtil;

public class EditColumn extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IColumnsService columnService = new ColumnService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int columnid = 0;
		Object param = req.getParameter("columnId");
		if (param != null) {
			columnid = Integer.parseInt(param.toString());
		}
		System.out.println(columnid);
		Columns column = columnService.GetById(columnid);

		req.setAttribute("column", column);
		req.getRequestDispatcher(PathUtil.MANAGE_PATH + "editcolumn.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
