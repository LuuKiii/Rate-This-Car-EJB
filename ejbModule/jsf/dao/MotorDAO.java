package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.entities.Motor;
import jsf.entities.Vehicle;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class MotorDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Motor motor) {
		em.persist(motor);
	}

	public Motor merge(Motor motor) {
		return em.merge(motor);
	}

	public void remove(Motor motor) {
		em.remove(em.merge(motor));
	}

	public Motor find(Object id) {
		return em.find(Motor.class, id);
	}

	public List<Motor> getAllUsers() {
		List<Motor> list = null;

		Query query = em.createQuery("select m from Motor m");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Motor getOriginVeh(Vehicle vehicle) {
		Motor OriginVeh = null;
		
		Query query = em.createQuery("Select m from Motor m where m.vehicle like :vehicle ");
		query.setParameter("vehicle", vehicle);
		try {
			OriginVeh =  (Motor) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  OriginVeh;
	}




}
