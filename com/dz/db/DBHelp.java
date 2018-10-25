package com.dz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dz.db.rowmapper.RowMapper;

public class DBHelp {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///test?useUnicode=true&characterEncoding=utf-8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	
	/**
	 * 鍔犺浇椹卞姩
	 * @return Connection锟斤拷锟斤拷
	 */
	public Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 执锟斤拷inster update delete锟斤拷锟�
	 * executeUpdate("delete from t_user where id = ?",12);
	 * @param sql inster update delete锟斤拷锟�
	 * @param params 占位锟斤拷值锟斤拷锟斤拷要锟酵ｏ拷锟斤拷顺锟斤拷锟斤拷同
	 */
	public void executeUpdate(String sql,Object...params) {
		Connection conn = getConnection();
		PreparedStatement stat = null;
		
		try {
			stat = conn.prepareStatement(sql);
			//锟斤拷占位锟斤拷锟斤拷值
			for (int i = 0; i < params.length; i++) {
				stat.setObject(i+1, params[i]);
			}
			//执锟斤拷SQL锟斤拷锟�
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stat,conn);
		}
		
	}

	/**
	 * 执锟斤拷select锟斤拷锟斤拷取唯一锟侥讹拷锟斤拷
	 * @param sql selete锟斤拷锟�
	 * @param rowMapper RowMapper锟接口碉拷实锟斤拷锟斤拷锟斤拷锟�
	 * @param params 占位锟斤拷值
	 * @return
	 */
	public <T> T queryForObject(String sql,RowMapper<T> rowMapper,Object...params) {
		Connection conn = getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		T obj = null;
		
		try {
			stat = conn.prepareStatement(sql);
			//锟斤拷占位锟斤拷锟斤拷值
			for (int i = 0; i < params.length; i++) {
				stat.setObject(i+1, params[i]);
			}
			//执锟斤拷SQL锟斤拷锟�
			rs = stat.executeQuery();
			
			//锟斤拷取锟斤拷询锟侥斤拷锟�
			if(rs.next()) {
				obj = rowMapper.mapRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,stat,conn);
		}
		
		return obj;
	}
	
	public <T> List<T> queryForList(String sql,RowMapper<T> rowMapper,Object... params) {
		Connection conn = getConnection();
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		
		try {
			stat = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				stat.setObject(i+1, params[i]);
			}
			rs = stat.executeQuery();
			while(rs.next()) {
				T obj = rowMapper.mapRow(rs);
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs,stat,conn);
		}
		
		return list;
	}
	
	
	
	
	
	
	

	private void close(ResultSet rs, PreparedStatement stat, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	private void close(PreparedStatement stat, Connection conn) {
		close(null,stat,conn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
