package cn.lidm.dbhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cn.lidm.util.BeanUtil;

import com.mysql.jdbc.Connection;

public class DataBase {

	
	protected static Connection connection = null;
	static {
		ClassLoader classLoader = DataBase.class.getClassLoader();
		InputStream inputStream = classLoader
				.getResourceAsStream("db.properties");
		Properties dbConfig = new Properties();
		try {
			dbConfig.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName(dbConfig.getProperty("driver"));
			connection = (Connection) DriverManager.getConnection(
					dbConfig.getProperty("url"), dbConfig.getProperty("user"),
					dbConfig.getProperty("password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void ConnectToDB() throws SQLException {
		if (connection != null) {
			if (!connection.isClosed()) {
				System.out.println("连接数据库成功...");
			}
		}
	}

	/**
	 * 执行select 操作
	 * @param clazz
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public <T> List<T> ReadData(Class<T> clazz, String sql) throws SQLException {
		if (connection != null) {
			Statement stt = connection.createStatement();

			ResultSet rs = stt.executeQuery(sql);

			List<T> lstResult = new ArrayList<T>();

			while (rs.next()) {
				lstResult.add(BeanUtil.row2Bean(rs, clazz));
			}
			rs.close();
			return lstResult;
		}
		return null;
	}

	/**
	 * 执行 insert update delete 操作
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public int executeSQL(String sql) throws SQLException {
		System.out.println(sql);
		if (connection != null) {
			Statement stt = connection.createStatement();
			
			return stt.executeUpdate(sql);
		}
		return 0;
	}

	public void insertData(String name, int gender) throws SQLException {
		if (connection != null) {
			Statement stt = connection.createStatement();
			String sql = "insert into test(name,sex) values('" + name + "',"
					+ gender + ")";
			stt.executeUpdate(sql);

		}
	}

	protected void distory() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

}
