package com.dz.service;

import com.dz.db.DBHelp;
import com.dz.entity.Message;

import java.util.List;

import com.dz.dao.MessageDao;


public class MessageService {
	
	private MessageDao msgDao=new MessageDao();
	
	public void saveMsg(Message msg) {
		msgDao.saveMsg(msg);		
	}

	public void updateMsg(Message msg) {
		msgDao.updateMsg(msg);
		
	}

	public void delMsg(int id) {
		msgDao.delMsg(id);
		
	}

	public List<Message> findAll() {
		return msgDao.findAll();
	}

	public Message findById(int id) {
		
		return msgDao.findById(id);
	}

}
