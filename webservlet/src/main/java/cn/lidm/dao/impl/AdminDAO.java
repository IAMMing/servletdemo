package cn.lidm.dao.impl;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.lidm.dao.IManageDAO;
import cn.lidm.dbhelper.DataBase;
import cn.lidm.domain.User;

public class AdminDAO implements IManageDAO<User> {

	DataBase db = new DataBase();

	public List<User> GetList(String sql) {

		try {
			return db.ReadData(User.class, sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User Get(String sql) {
		List<User> lst = GetList(sql);
		if (lst != null) {
			return lst.get(0);
		}

		return null;
	}

	public int Update(User user) {
		if (user.getUserId() > -1) {
			String updateColumn = "";
			if (!user.getUsername().isEmpty()) {
				updateColumn += ",username=" + user.getUsername();
			}
			if (!user.getPassword().isEmpty()) {
				updateColumn += ",password=" + user.getPassword();
			}
			if (user.getLevel() > -1) {
				updateColumn += ",level=" + user.getLevel();
			}
			if (user.getIsDel() > -1) {
				updateColumn += ",isdel=" + user.getIsDel();
			}
			if (user.getIsEnable() > -1) {
				updateColumn += ",isenable=" + user.getIsEnable();
			}
			String sql = MessageFormat.format(
					"UPATE Admin SET {0} WHERE userid={1}",
					updateColumn.substring(1), user.getUserId());
			try {
				return db.executeSQL(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		} else {
			return 0;
		}
	}

	public int Insert(User user) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = MessageFormat
				.format("INSERT INTO admin(username,password,level,isenable,isdel,createdate) VALUES({0},{1},{2},{3},{4},{5})",
						"'"+user.getUsername()+"'","'"+ user.getPassword()+"'",
						user.getLevel(), user.getIsEnable(), user.getIsDel(),
						"'"+sdf.format(user.getCreateDate())+"'");
		
		System.out.println(sql);
		try {
			return db.executeSQL(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
