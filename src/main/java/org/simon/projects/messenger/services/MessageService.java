package org.simon.projects.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.simon.projects.messenger.beans.Message;
import org.simon.projects.messenger.beans.User;

public class MessageService {
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private Session session = factory.getCurrentSession();


	public List<Message> getAllMessages() {
		session.beginTransaction();
		Query query = session.createQuery("from Message");
		List<Message> list = query.getResultList();
		session.close();
		return list;

		
	}
	
	public Message getMessage(long id) {
		session.beginTransaction();
		Query query = session.createQuery("from Message where idMessage = :id ");
		query.setParameter("id", id);
		List<Message> list = query.getResultList();
		session.close();
		return list.get(0);
		
	}
	
	public boolean updateMessage(Message msg) {
		session.beginTransaction();
		Query query = session.createQuery("update Message set content = :content, User_idUser = :userId where idMessage = :id ");
		query.setParameter("content", msg.getContent());
		query.setParameter("userId", msg.getUser().getId());
        query.setParameter("id", msg.getId());
        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
		if (i>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean addMessage(Message msg) {
		msg.setCreatedOn(new Date());
		session.beginTransaction();
		session.save(msg);
		session.getTransaction().commit();
		return true;
		
	}
	
	public boolean deleteById(long id) {
		session.beginTransaction();
		Query query = session.createQuery("delete from Message where idMessage = :id ");
        query.setParameter("id", id);
        int i = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
		if (i>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
