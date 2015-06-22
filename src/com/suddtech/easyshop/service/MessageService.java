package com.suddtech.easyshop.service;

import java.util.List;

import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.Offer;

public interface MessageService {
	public List<Message> getCurrent();

	public void createMessage(Message message);

	// public boolean hasMessage(String name);

	public Offer getMessage(String username);

	public void saveOrUpdate(Offer offer);

	public void delete(int id);

}
