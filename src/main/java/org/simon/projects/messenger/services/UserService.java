package org.simon.projects.messenger.services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.simon.projects.messenger.beans.User;



/**
 * A service created to make changes to users in the database
 * @author Simon Leu
 * @version 1.4
 */
@ManagedBean(name = "userService")
@SessionScoped
public class UserService {
	
	private SessionFactory factory;
	private Session session;

	/**
	 * Gets all users from the database
	 * @return Returns a list of users
	 */
	public List<User> getAllUsers() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		List<User> list = query.getResultList();
		session.close();
		return list;

		
	}
	
	
	/**
	 * Gets a single user from the database
	 * @param id The id of the user to be returned
	 * @return Returns a user
	 */
	public User getUser(long id) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where idUser = :id ");
		query.setParameter("id", id);
		List<User> list = query.getResultList();
		session.close();
		return list.get(0);
		
	}
	
	
	/**
	 * Updates a single user
	 * @param user The user with the updated information
	 * @return A boolean is returned to indicate the updates success
	 */
	public boolean updateUser(User user) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
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
	
	
	/**
	 * Adds a user to the database
	 * @param user The user with the updated information
	 * @return A boolean is returned to indicate the updates success
	 */
	public long addUser(User user) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		long id = (long) session.save(user);
		session.getTransaction().commit();
		session.close();
		
		return id;
		
	}

	/**
	 * Deletes a single user
	 * @param id The id of the user that is to be deleted
	 * @return A boolean is returned to indicate the deletions success
	 */
	public boolean deleteById(int id) {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.getCurrentSession();
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
