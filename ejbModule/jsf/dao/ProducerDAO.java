package jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import jsf.entities.Producer;
import jsf.entities.User;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class ProducerDAO {
	private final static String UNIT_NAME = "ratethiscarPU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Producer producer) {
		em.persist(producer);
	}

	public Producer merge(Producer producer) {
		return em.merge(producer);
	}

	public void remove(Producer producer) {
		em.remove(em.merge(producer));
	}

	public Producer find(Object id) {
		return em.find(Producer.class, id);
	}

	public List<Producer> getAllProducers() {
		List<Producer> list = null;

		Query query = em.createQuery("select p from Producer p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Producer> producerExists(String producer){
		List <Producer> producerE = null;
		
		Query query = em.createQuery("select p from Producer p where p.producerName like :name");
		query.setParameter("name", producer);
		
		try {
			producerE = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return producerE;
	}


}
