package com.dz.db.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 将单条记录封装为一个Object[]
 * @author dz
 *
 */
public class ArrayRowMapper implements RowMapper<Object[]>{

	@Override
	public Object[] mapRow(ResultSet rs) throws SQLException {
		//获取列的数量
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		//定义返回的Object数组
		Object[] obj = new Object[columnCount];
		
		//数组赋值
		for (int i = 0; i < obj.length; i++) {
			obj[i] = rs.getObject(i+1);
		}
		
		return obj;
	}

}
