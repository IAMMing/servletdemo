package cn.lidm.web.formbean;

import java.util.HashMap;
import java.util.Map;

import cn.lidm.domain.Columns;

public class ColumnFormBean extends Columns {

	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean validate() {
		boolean isOK = true;
		if (this.getColumnName() == null || this.getColumnName().isEmpty()) {
			isOK = false;
			errors.put("columnName", "栏目不能为空");
		}
		return isOK;
	}
}
