package com.dz.db.rowmapper;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanPropertyRowMapper<T> implements RowMapper<T>{

	private Class<T> clazz;
	public BeanPropertyRowMapper(Class<T> clazz) {
		this.clazz = clazz;
	}
	@Override
	public T mapRow(ResultSet rs) throws SQLException {
		try {
			//创建T对象
			T t = clazz.newInstance();
			//给对象的属性赋值
			//2.1获取列的名字
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取列的数量
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				//获取第i列的名字
				String columnName = rsmd.getColumnLabel(i);
				//获取第i列的值
				Object columnValue = rs.getObject(columnName);
				setPropertyValue(t,columnName,columnValue);
			}
			//返回T对象
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据找到的列名去类中执行对应的set方法
	 * @param t
	 * @param columnName
	 * @param columnValue
	 */
	private void setPropertyValue(T t, String columnName, Object columnValue) {
		//根据columnName值构建出setColumnName()方法     setUsername
		String methodName = "set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
		
		//根据clazz获取该类中的所有方法
		Method[] methods = clazz.getMethods();
		//根据每个方法的方法名和methodName比较，如果相等则执行该方法
		for(Method m : methods) {
			if(m.getName().equals(methodName)) {
				//执行方法
				try {
					m.invoke(t, columnValue);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
