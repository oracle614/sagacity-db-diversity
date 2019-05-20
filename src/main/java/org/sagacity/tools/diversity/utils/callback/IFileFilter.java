/**
 * 
 */
package org.sagacity.tools.diversity.utils.callback;

import java.io.File;

/**
 *@project sagacity-core 
 *@description 文件过滤器
 *@author Hunny $<a href="mailto:Hunny@hotmail.com">联系作者</a>$
 *@version $id:IFileFilter.java,Revision:v1.0,Date:2012-1-7 下午2:07:38 $
 */
public interface IFileFilter {
	public boolean matcher(File file);
}
