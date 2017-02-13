package com.hug.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query; 
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HugSchoolDao {
	
	 @PersistenceContext
	  private EntityManager entityManager;
	  
	 /**
	   * Save the user in the database.
	   */
	  public long create(HugSchool hugSchool) {
	    entityManager.persist(hugSchool);
	    return hugSchool.getSchoolId();
	  }
	  
	  /**
	   * Return the Lesson Info having the passed Lesson Id
	   */
	  public HugSchool getBySchoolId(long School_Id) {
		  HugSchool hug = null;
		  Query query =  entityManager.createQuery(
	        "from HugSchool where School_Id = :School_Id")
	        .setParameter("School_Id", School_Id);
		  
		  if (query.getResultList().size()>0){
              hug = (HugSchool) query.getSingleResult();
          }
	    return hug;
	  }
	  
	  /**
	   * Delete the user from the database.
	   */
	  public void delete(HugSchool hugSchool) {
	    if (entityManager.contains(hugSchool))
	      entityManager.remove(hugSchool);
	    else
	      entityManager.remove(entityManager.merge(hugSchool));
	    return;
	  }
	  
	  /**
	   * Return all the users stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugSchool> getAll() {
	    return entityManager.createQuery("from HugSchool").getResultList();
	  }
	  
	  /**
	   * Return all the active schools stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugSchool> getAllActiveSchools() {
	    return entityManager.createQuery("from HugSchool where School_Delete_Flag = 0").getResultList();
	  }
	  
	  /**
	   * Return the schools having the passed school name.
	   */
	  public HugSchool getBySchoolNameAndCity(String School_Name,String School_City) {
		  HugSchool hug = null;
		  Query query =  entityManager.createQuery(
	        "from HugSchool where School_Name = :School_Name and School_City = :School_City")
	        .setParameter("School_Name", School_Name).setParameter("School_City", School_City);
	        if (query.getResultList().size()>0){
	              hug = (HugSchool) query.getSingleResult();
	          }
	    return hug;
	  }
	  
	  /**
	   * Update the passed School Info in the database.
	   */
	  public void update(HugSchool hugSchool) {
			// TODO Auto-generated method stub
			entityManager.merge(hugSchool);
		    return;
		}

}
