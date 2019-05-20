/**
 * 
 */
package org.sagacity.tools.diversity.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.sagacity.tools.diversity.DiversityConstants;
import org.sagacity.tools.diversity.model.DataSourceModel;
import org.sagacity.tools.diversity.model.DiversityModel;
import org.sagacity.tools.diversity.utils.callback.XMLCallbackHandler;

/**
 * @author zhong
 *         <db-diversity only-differ="true" report-template="" report-file="">
 *         <reference-db url="" driver="" username="" password="" />
 *         <target-db url="" driver="" username="" password="" />
 *         </db-diversity>
 */
public class ConfigUtils {
	public static DiversityModel parse() throws Exception {
		String configXML = DiversityConstants.CONFIG_FILE;
		DiversityModel diversityModel = null;
		if (StringUtil.isBlank(configXML)) {
			return diversityModel;
		}
		String realConfig = configXML;
		if (!FileUtil.isRootPath(realConfig))
			realConfig = FileUtil.linkPath(DiversityConstants.BASE_DIR, configXML);
		diversityModel = (DiversityModel) XMLUtil.readXML(realConfig, DiversityConstants.ENCODING, false,
				new XMLCallbackHandler() {
					@Override
					public Object process(Document doc, Element root) throws Exception {
						DiversityModel diversityModel = new DiversityModel();
						String var = root.attributeValue("only-differ");
						if (StringUtil.isNotBlank(var))
							diversityModel.setOnlyDiffer(Boolean.parseBoolean(var));
						var = root.attributeValue("report-template");
						if (StringUtil.isNotBlank(var))
							diversityModel.setReportTemplate(var);
						var = root.attributeValue("report-file");
						if (StringUtil.isNotBlank(var)) {
							diversityModel.setReportFile(var);
						}
						// 忽视注释
						var = root.attributeValue("ignore-comment");
						if (StringUtil.isNotBlank(var))
							diversityModel.setIgnorComment(Boolean.parseBoolean(var));
						// 忽视主键名称
						var = root.attributeValue("ignore-pk-name");
						if (StringUtil.isNotBlank(var))
							diversityModel.setIgnorePkName(Boolean.parseBoolean(var));
						// 忽视索引名称
						var = root.attributeValue("ignore-index-name");
						if (StringUtil.isNotBlank(var))
							diversityModel.setIgnoreIndexName(Boolean.parseBoolean(var));
						// 忽视外键名称
						var = root.attributeValue("ignore-foreign-name");
						if (StringUtil.isNotBlank(var))
							diversityModel.setIgnoreForeignKeyName(Boolean.parseBoolean(var));
						// 忽视被其他表关联的名称
						var = root.attributeValue("ignore-export-name");
						if (StringUtil.isNotBlank(var))
							diversityModel.setIgnoreExportKeyName(Boolean.parseBoolean(var));
						var = root.attributeValue("include-tables");
						if (StringUtil.isNotBlank(var))
							diversityModel.setInclude(new String[] { var });
						var = root.attributeValue("exclude-tables");
						if (StringUtil.isNotBlank(var))
							diversityModel.setExclude(new String[] { var });
						String[] dbs = { "reference-db", "target-db" };
						Element elt;
						String value;
						Element child;
						for (String name : dbs) {
							elt = root.element(name);
							DataSourceModel dbModel = new DataSourceModel();
							dbModel.setName(elt.attributeValue("name"));
							if (StringUtil.isBlank(dbModel.getName()))
								dbModel.setName(name);
							child = elt.element("url");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setUrl(value == null ? child.getTextTrim() : value);
							} else
								dbModel.setUrl(elt.attributeValue("url"));
							child = elt.element("driver");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setDriverClass(value == null ? child.getTextTrim() : value);
							}else
								dbModel.setDriverClass(elt.attributeValue("driver"));
							child = elt.element("password");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setPassword(value == null ? child.getTextTrim() : value);
							}else
								dbModel.setPassword(elt.attributeValue("password"));
							child = elt.element("username");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setUsername(value == null ? child.getTextTrim() : value);
							}else
								dbModel.setUsername(elt.attributeValue("username"));
							child = elt.element("schema");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setSchema(value == null ? child.getTextTrim() : value);
							}else
								dbModel.setSchema(elt.attributeValue("schema"));
							child = elt.element("catalog");
							if (child != null) {
								value = child.attributeValue("value");
								dbModel.setCatalog(value == null ? child.getTextTrim() : value);
							}else
								dbModel.setCatalog(elt.attributeValue("catalog"));
							if (name.equals(dbs[0]))
								diversityModel.setReference(dbModel);
							else
								diversityModel.setTarget(dbModel);

						}
						return diversityModel;
					}
				});
		return diversityModel;
	}

}
