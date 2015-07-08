package com.suddtech.easyshop.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Message;


public interface MessageDao {
	public List<Message> getMessages() ;

	public List<Message> getMessages(String username) ;
	

	public void saveOrUpdate(Message message) ;

	public boolean delete(int id) ;

	public Message getMessage(int id) ;
	

}
