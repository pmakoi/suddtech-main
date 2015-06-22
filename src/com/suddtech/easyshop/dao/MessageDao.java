package com.suddtech.easyshop.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Message;

@Repository
@Transactional
@Component("messageDao")
public interface MessageDao extends GenericDao<Message> {

	List<Message> getMessages(String username);

}
