package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.entities.Car;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class CarDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Car car) {
		em.persist(car);
	}

	public Car merge(Car car) {
		return em.merge(car);
	}

	public void remove(Car car) {
		em.remove(em.merge(car));
	}

	public Car find(Object id) {
		return em.find(Car.class, id);
	}

	public List<Car> getAllUsers() {
		List<Car> list = null;

		Query query = em.createQuery("select c from Car c");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}



}
