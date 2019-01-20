package org.simon.projects.messenger.services;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.simon.projects.messenger.beans.User;

public class UserService {
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	private Session session = factory.getCurrentSession();

	public List<User> getAllUsers() {
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.getResultList();
		session.close();
		return list;

		
	}
	
	public User getUser(long id) {
		session.beginTransaction();
		Query query = session.createQuery("from User where idUser = :id ");
		query.setParameter("id", id);
		List<User> list = query.getResultList();
		session.close();
		return list.get(0);
		
	}
	
	public boolean updateUser(User user) {
		session.beginTransaction();
		Query query = session.createQuery("update User set firstName = :firstName, lastName = :lastName where idUser = :id ");
		query.setParameter("firstName", user.getFirstName());
		query.setParameter("lastName", user.getLastName());
        query.setParameter("id", user.getId());
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
	
	public boolean addUser(User user) {
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		return true;
		
	}

	public boolean deleteById(int id) {

		session.beginTransaction();
		Query query = session.createQuery("delete from User where idUser = :id ");
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
