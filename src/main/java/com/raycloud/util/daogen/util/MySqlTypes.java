/*
 * 文 件 名:  MySqlTypes.java
 * 版    权:  KAINAODONG
 * 描    述:  <描述>
 * 创建人:  chenzhixiang
 * 创建时间:  2017年1月23日
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
package com.raycloud.util.daogen.util;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>类描述:
 * <br>功能详细描述:
 * 
 * @author  chenzhixiang
 * @date  [2017年1月23日]
 */
public class MySqlTypes {
	
	public static Map<Integer, String> sqlTypeMap = new HashMap<Integer, String>();
	
	static {
		Class typesClass = Types.class;
		for(Field sqlTypeField:typesClass.getFields()) {
			try {
				sqlTypeMap.put(sqlTypeField.getInt(null), sqlTypeField.getName());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getSqlTypeName(int type) {
		return sqlTypeMap.get(type);
	}
	
}
