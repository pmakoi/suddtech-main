package com.suddtech.easyshop.dao;

import java.util.List;

import com.suddtech.easyshop.model.Message;


public interface MessageDao extends GenericDao<Message> {

	List<Message> getMessages(String username);
//	public List<Message> getMessages() ;
//
//	public List<Message> getMessages(String username) ;
//
//	public void saveOrUpdate(Message message) ;
//
//	public boolean delete(int id) ;
//
//	public Message getMessage(int id) ;
	

}
