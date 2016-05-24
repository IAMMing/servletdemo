package cn.lidm.dao;

import java.util.List;

public interface IWebDAO<T> {
	/**
	 * 读取 一个列表的数据
	 * @param sql
	 * @return
	 */	
	List<T> GetList(String sql);
	
	/**
	 * 读取一条数据
	 * @param sql
	 * @return
	 */
	T Get(String sql);
	
}
