package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jsf.entities.Producer;
import jsf.entities.Vehicle;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class VehicleDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Vehicle vehicle) {
		em.persist(vehicle);
	}

	public Vehicle merge(Vehicle vehicle) {
		return em.merge(vehicle);
	}

	public void remove(Vehicle vehicle) {
		em.remove(em.merge(vehicle));
	}

	public Vehicle find(Object id) {
		return em.find(Vehicle.class, id);
	}

	public List<Vehicle> getAllVehicles() {
		List<Vehicle> list = null;

		Query query = em.createQuery("select v from Vehicle v");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Vehicle> getProducersVeh(Producer producer){
		List<Vehicle> list = null;
		
		Query query = em.createQuery("select v from Vehicle v where v.producer like :producer");
		query.setParameter("producer", producer);
		
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}


}
