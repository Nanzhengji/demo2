package com.dz.db.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	/**
	 * 将数据库中的一条记录封装为Java中的一个对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public T mapRow(ResultSet rs) throws SQLException;
}
