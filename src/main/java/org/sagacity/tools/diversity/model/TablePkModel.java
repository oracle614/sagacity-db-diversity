package org.sagacity.tools.diversity.model;

import java.io.Serializable;

public class TablePkModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6006356541366377136L;

	/**
	 * 主键名称
	 */
	private String pkName;

	/**
	 * 主键列
	 */
	private String[] pkColumns;

	/**
	 * @return the pkName
	 */
	public String getPkName() {
		return pkName;
	}

	/**
	 * @param pkName
	 *            the pkName to set
	 */
	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	/**
	 * @return the pkColumns
	 */
	public String[] getPkColumns() {
		return pkColumns;
	}

	/**
	 * @param pkColumns
	 *            the pkColumns to set
	 */
	public void setPkColumns(String[] pkColumns) {
		this.pkColumns = pkColumns;
	}

}
