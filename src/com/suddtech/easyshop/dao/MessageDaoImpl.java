package com.suddtech.easyshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suddtech.easyshop.model.Message;

@Repository
@Transactional
@Component("messageDao")
public class MessageDaoImpl extends GenericDaoImpl<Message> implements
		MessageDao {
	
	public MessageDaoImpl(){
		setEntityClass(Message.class);
	}
	
	
//	@SuppressWarnings("unchecked")
//	public List<Message> getMessages() {
//		Criteria crit = session().createCriteria(Message.class);
//		return crit.list();
//	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String username) {
		Criteria crit = getCurrentSession().createCriteria(Message.class);

		crit.add(Restrictions.eq("username", username));

		return crit.list();
	}

//	public void saveOrUpdate(Message message) {
//		System.out.println(message);
//		session().saveOrUpdate(message);
//	}

//	public boolean delete(int id) {
//		Query query = session().createQuery("delete from Message where id=:id");
//		query.setLong("id", id);
//		return query.executeUpdate() == 1;
//	}

//	public Message getMessage(int id) {
//		Criteria crit = session().createCriteria(Message.class);
//
//		crit.add(Restrictions.idEq(id));
//
//		return (Message)crit.uniqueResult();
//	}
//	
}
