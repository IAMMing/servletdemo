package cn.lidm.dao;

import java.util.List;

public interface IManageDAO<T> {
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
	
	/**
	 * 更新信息
	 * @param sql
	 * @return
	 */
	int Update(T t);
	
	/**
	 * 添加数据
	 * @param t
	 * @return
	 */
	int Insert(T t);
}
