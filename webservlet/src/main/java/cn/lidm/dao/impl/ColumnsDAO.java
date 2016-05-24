package cn.lidm.dao.impl;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.lidm.dao.IManageDAO;
import cn.lidm.dbhelper.DataBase;
import cn.lidm.domain.Columns;

public class ColumnsDAO implements IManageDAO<Columns> {

	DataBase db = new DataBase();

	public List<Columns> GetList(String sql) {
		try {
			return db.ReadData(Columns.class, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Columns Get(String sql) {
		List<Columns> lst = GetList(sql);
		if (lst != null) {
			return lst.get(0);
		}
		return null;
	}

	public int Update(Columns column) {

		if (column.getColumnId() > 0) {
			String updateString = "";
			if (!column.getColumnName().isEmpty()) {
				updateString += ",columnname='" + column.getColumnName()+"'";
			}
			if (column.getIndexShow() > -1) {
				updateString += ",indexshow=" + column.getIndexShow();
			}
			if (column.getIsDel() > -1) {
				updateString += ",isdel=" + column.getIsDel();
			}
			if (column.getIsenable() > -1) {
				updateString += ",isenable=" + column.getIsenable();
			}

			if (updateString.isEmpty()) {
				return 0;
			} else {
				String sql = MessageFormat.format(
						"UPDATE columns set {0} WHERE columnid={1}",
						updateString.substring(1), column.getColumnId());
				try {
					System.out.println(sql);
					return db.executeSQL(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

	public int Insert(Columns column) {

		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = MessageFormat
				.format("INSERT columns(columnname,createdate,indexshow,isdel,isenable,orderid) VALUES({0},{1},{2},{3},{4},{5})",
						"'"+column.getColumnName()+"'","'"+sdf.format( column.getCreateDate())+"'",
						column.getIndexShow(), column.getIsDel(),
						column.getIsenable(), column.getOrderId());
		try {
			return db.executeSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
