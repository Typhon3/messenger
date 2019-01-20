package org.simon.projects.messenger.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.simon.projects.messenger.beans.Message;

public class MessageService {
	
	

	public List<Message> getAllMessages() {
		return null;

		
	}
	
	public Message getMessage(long id) {
		return null;
		
	}
	
	public Message updateMessage(Message msg) {
		return msg;
		
	}
	
	public Message addMessage(Message msg) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Message.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(msg);
		session.getTransaction().commit();
		System.out.println("Done");
		return msg;
		
	}
	
	public Message removeMessage(long id) {
		return null;
		
	}
}
