package org.sagacity.tools.diversity;

import java.io.Serializable;

/**
 * 常量定义
 * 
 * @author zhong
 *
 */
public class DiversityConstants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4450759166278747553L;

	/**
	 * 根路径
	 */
	public static String BASE_DIR;

	/**
	 * 数据库驱动类
	 */
	public static String DRIVER_PATH = "drivers";

	/**
	 * 默认配置文件
	 */
	public static String CONFIG_FILE = "db-diversity.xml";

	/**
	 * 日志文件
	 */
	public static String LOG_CONFIG = "org/sagacity/tools/diversity/log4j2.xml";

	/**
	 * 编码格式
	 */
	public static String ENCODING = "UTF-8";
}
