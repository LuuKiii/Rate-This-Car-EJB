package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.entities.User;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class UserDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object id) {
		return em.find(User.class, id);
	}

	public List<User> getAllUsers() {
		List<User> list = null;

		Query query = em.createQuery("select u from User u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<User> usernameExists(String name){
		List <User> user = null;
		
		Query query = em.createQuery("select u from User u where u.userName like :name");
		query.setParameter("name", name);
		
		try {
			user = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<User> mailExists(String mail){
		List <User> user = null;
		
		Query query = em.createQuery("select u from User u where u.email like :mail");
		query.setParameter("mail", mail);
		
		try {
			user = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<User> canLogin(String mail, String pass){
		List<User> user = null;
		
		String select = "select u ";
		String from = "from User u ";
		String where = "where u.email like :mail and u.password like :pass ";
		String orederby = "";
		
		Query query = em.createQuery(select + from + where);
		
		query.setParameter("mail", mail);
		query.setParameter("pass", pass);
		
		try {
			user = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}



}
