package cn.lidm.service.impl;

import java.util.List;

import cn.lidm.dao.IManageDAO;
import cn.lidm.dao.impl.ColumnsDAO;
import cn.lidm.domain.Columns;
import cn.lidm.service.IColumnsService;

public class ColumnService implements IColumnsService {

	IManageDAO<Columns> columnDAO = new ColumnsDAO();

	public List<Columns> Get() {
		return columnDAO
				.GetList("SELECT columnId,columnName,orderId,indexShow,isEnable,isDel FROM columns");
	}

	public void Add(Columns column) {
		columnDAO.Insert(column);
	}

	public void Edit(Columns column) {
		columnDAO.Update(column);
	}

	public Columns GetById(int columnId) {

		List<Columns> lst = columnDAO
				.GetList("SELECT columnId,columnName,orderId,indexShow,isEnable,isDel FROM columns where columnid="+columnId);
		if (lst != null && lst.size() > 0) {
			return lst.get(0);
		} else {
			return null;
		}
	}

}
