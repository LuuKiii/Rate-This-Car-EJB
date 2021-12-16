package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.entities.UserRatesVehicle;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class UserRatesVehicleDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(UserRatesVehicle userrates) {
		em.persist(userrates);
	}

	public UserRatesVehicle merge(UserRatesVehicle userrates) {
		return em.merge(userrates);
	}

	public void remove(UserRatesVehicle userrates) {
		em.remove(em.merge(userrates));
	}

	public UserRatesVehicle find(Object id) {
		return em.find(UserRatesVehicle.class, id);
	}

	public List<UserRatesVehicle> getAllUsers() {
		List<UserRatesVehicle> list = null;

		Query query = em.createQuery("select u from UserRatesVehicle u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}



}
