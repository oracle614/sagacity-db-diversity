/**
 * 
 */
package org.sagacity.tools.diversity.model;

import java.io.Serializable;

/**
 * @author zhong
 *
 */
public class ProduceColumn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1933425309820543522L;

	/**
	 * 存储过程名称
	 */
	private String produceName;

	private String columnName;

	private String columnType;

	/**
	 * @return the produceName
	 */
	public String getProduceName() {
		return produceName;
	}

	/**
	 * @param produceName the produceName to set
	 */
	public void setProduceName(String produceName) {
		this.produceName = produceName;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}

	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	
}
