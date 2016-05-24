package cn.lidm.domain;

import java.util.Date;

public class Columns {
	private int columnId;
	private String columnName;
	private int orderId=-1;
	private int indexShow=-1;
	private int isDel=-1;
	private int isenable=-1;
	private Date createDate = new Date();

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(int indexShow) {
		this.indexShow = indexShow;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public int getIsenable() {
		return isenable;
	}

	public void setIsenable(int isenable) {
		this.isenable = isenable;
	}

}
