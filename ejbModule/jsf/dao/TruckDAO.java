package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jsf.entities.Truck;
import jsf.entities.Vehicle;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class TruckDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Truck truck) {
		em.persist(truck);
	}

	public Truck merge(Truck truck) {
		return em.merge(truck);
	}

	public void remove(Truck truck) {
		em.remove(em.merge(truck));
	}

	public Truck find(Object id) {
		return em.find(Truck.class, id);
	}

	public List<Truck> getAllUsers() {
		List<Truck> list = null;

		Query query = em.createQuery("select t from Truck t");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Truck getOriginVeh(Vehicle vehicle) {
		Truck OriginVeh = null;
		
		Query query = em.createQuery("Select t from Truck t where t.vehicle like :vehicle ");
		query.setParameter("vehicle", vehicle);
		try {
			OriginVeh =  (Truck) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  OriginVeh;
	}

}
