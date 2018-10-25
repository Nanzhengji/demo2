package com.dz.dao;

import com.dz.db.DBHelp;
import java.util.List;
import com.dz.db.rowmapper.BeanPropertyRowMapper;
import com.dz.entity.Message;

public class MessageDao {
	DBHelp dbHelp=new DBHelp();
	
	//������ݿ�
	public void saveMsg(Message msg) {
		String sql="insert into t_message (username,title,content)values(?,?,?)";
		dbHelp.executeUpdate(sql, msg.getUsername(),msg.getTitle(),msg.getContent());
		
	}
	
	public List<Message> findAll(){
		String sql = "select id,username,title,content,createtime from t_message order by createtime desc";
		return dbHelp.queryForList(sql, new BeanPropertyRowMapper<Message>(Message.class));
	}
	
	/**
	 * ͨ��idɾ����Ϣ
	 * @param id
	 */
	public void delMsg(int id){
		String sql = "delete from t_message where id = ?";
		dbHelp.executeUpdate(sql, id);
		
	}
	
	public Message findById(int id){
		
		String sql = "select id,username,title,content,createtime from t_message where id = ?";
		return dbHelp.queryForObject(sql, new BeanPropertyRowMapper<Message>(Message.class), id);
		
	}
	
	public void updateMsg(Message msg){
		String sql = "update t_message set username = ?,title = ?,content = ? where id = ?";
		dbHelp.executeUpdate(sql, msg.getUsername(),msg.getTitle(),msg.getContent(),msg.getId());
	}

	
	
	
	
}
