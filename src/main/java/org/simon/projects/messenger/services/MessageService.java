package org.simon.projects.messenger.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.simon.projects.messenger.beans.Message;
import org.simon.projects.messenger.beans.User;



/**
 * A service created to make changes to messages in the database
 * @author Simon Leu
 * @version 1.5
 */
@ManagedBean(name = "msgService")
@SessionScoped
public class MessageService {
	
	private SessionFactory factory;
	private Session session;


	/**
	 * Gets all messages from the database
	 * @return Returns a list of messages
	 */
	public List<Message> getAllMessages() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message");
		List<Message> list = query.getResultList();
		session.close();
		return list;

		
	}
	
	
	/**
	 * Gets a single message from the database
	 * @param id The id of the message to be returned
	 * @return Returns a message
	 */
	public Message getMessage(long id) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message where idMessage = :id ");
		query.setParameter("id", id);
		List<Message> list = query.getResultList();
		session.close();
		return list.get(0);
		
	}
	
	
	/**
	 * Updates a single message
	 * @param msg The message with the updated information
	 * @return A boolean is returned to indicate the updates success
	 */
	public boolean updateMessage(Message msg) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
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
	
	/**
	 * Adds a message to the database
	 * @param msg The message with the updated information
	 * @return A boolean is returned to indicate the updates success
	 */
	public long addMessage(Message msg) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		msg.setCreatedOn(new Date());
		session.beginTransaction();
		long id = (long) session.save(msg);
		session.getTransaction().commit();
		session.close();
		return id;
		
	}
	
	/**
	 * Deletes a single message
	 * @param id The id of the message that is to be deleted
	 * @return A boolean is returned to indicate the deletions success
	 */
	public boolean deleteById(long id) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
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
