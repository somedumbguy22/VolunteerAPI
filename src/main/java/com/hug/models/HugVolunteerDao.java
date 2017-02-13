package com.hug.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Transactional
public class HugVolunteerDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the user in the database.
	 */
	public long create(HugVolunteer hugVolunteer) {
		entityManager.persist(hugVolunteer);
		return hugVolunteer.getVolunteerId();
	}
	
	 public HugVolunteer GetByVolunteerId(long Volunteer_id) {
		  HugVolunteer hug =  null; 		  
	      
		  Query query = entityManager.createQuery(
	        "from HugVolunteer where Volunteer_id = :Volunteer_id")
	        .setParameter("Volunteer_id", Volunteer_id)
	        ;
		  
	        if (query.getResultList().size()>0){
	              hug = (HugVolunteer) query.getSingleResult();
	          }
	    return hug;
	  }

	/**
	 * Return the schools having the passed school name.
	 */
	public HugVolunteer getByVolunteerFirstNameLastNameAndEmail(
			String Volunteer_FirstName, String Volunteer_LastName,
			String Volunteer_Email) {
		 HugVolunteer hug =  null; 		  
	      
		  Query query = entityManager
				.createQuery(
						"from HugVolunteer where Volunteer_FirstName = :Volunteer_FirstName and Volunteer_LastName = :Volunteer_LastName and Volunteer_Email = :Volunteer_Email")
				.setParameter("Volunteer_FirstName", Volunteer_FirstName)
				.setParameter("Volunteer_LastName", Volunteer_LastName)
				.setParameter("Volunteer_Email", Volunteer_Email);
		  
	        if (query.getResultList().size()>0){
	              hug = (HugVolunteer) query.getSingleResult();
	          }
		return hug;
	}

	/**
	 * Return all the Volunteer Info stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<HugVolunteer> getAll() {
		return entityManager.createQuery("from HugVolunteer").getResultList();
	}
	
	/**
	 * Return all the Active Volunteer Info stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<HugVolunteer> getAllActiveVolunteers() {
		return entityManager.createQuery("from HugVolunteer where Volunteer_Delete_Flag = 0").getResultList();
	}

	/**
	 * Update the passed Volunteer Info in the database.
	 */
	public void update(HugVolunteer hugVolunteer) {
		// TODO Auto-generated method stub
		entityManager.merge(hugVolunteer);
		return;
	}

}
