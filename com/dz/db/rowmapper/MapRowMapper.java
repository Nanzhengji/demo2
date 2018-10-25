package com.dz.db.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class MapRowMapper implements RowMapper<Map<String, Object>>{

	@Override
	public Map<String, Object> mapRow(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		for (int i = 1; i <= columnCount; i++) {
			String columnName = rsmd.getColumnLabel(i);
			Object columnValue = rs.getObject(columnName);
			map.put(columnName, columnValue);
		}
		return map;
	}

}
