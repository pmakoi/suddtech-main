package com.suddtech.easyshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Message;
import com.suddtech.easyshop.model.Offer;
import com.suddtech.easyshop.model.User;

@Repository
@Transactional
public class MessageDaoImpl extends GenericDaoImpl<Message> implements
		MessageDao {
	public MessageDaoImpl() {
		setEntityClass(Message.class);
	}

	@Override
	public List<Message> getMessages(String username) {
		Criteria crit = getCurrentSession().createCriteria(clazz);
		//crit.createAlias("user", "u");
		//crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("username", username));
		return crit.list();
	}

}
