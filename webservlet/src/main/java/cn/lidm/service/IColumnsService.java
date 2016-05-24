package cn.lidm.service;

import java.util.List;

import cn.lidm.domain.Columns;

public interface IColumnsService {

	List<Columns> Get();

	Columns GetById(int columnId);

	void Add(Columns column);

	void Edit(Columns column);
}
