package com.hug.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query; 
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HugStudentDao {
	
	 @PersistenceContext
	  private EntityManager entityManager;
	  
	 /**
	   * Save the Student Info in the database.
	   */
	  public long create(HugStudent hugStudent) {
	    entityManager.persist(hugStudent);
	    return hugStudent.getStudentid();
	  }
	  
	  /**
	   * Delete the Student Info from the database.
	   */
	  public void delete(HugStudent hugStudent) {
	    if (entityManager.contains(hugStudent))
	      entityManager.remove(hugStudent);
	    else
	      entityManager.remove(entityManager.merge(hugStudent));
	    return;
	  }
	  
	  /**
	   * Return all the Student Info stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugStudent> getAll() {
	    return entityManager.createQuery("from HugStudent").getResultList();
	  }
	  
	  /**
	   * Return the Student Info having the passed Student Id
	   */
	  public HugStudent getByStudentId(long Student_Id) {
		  
		  HugStudent hug =  null; 		  
	      
		  Query query =  entityManager.createQuery(
	        "from HugStudent where Student_id = :Student_id")
	        .setParameter("Student_id", Student_Id);
		  
	        if (query.getResultList().size()>0){
	              hug = (HugStudent) query.getSingleResult();
	          }
	    return hug;
	  }
	  
	  /**
	   * Returns all the Active Students stored in the database.
	   * Active Students are currently marked with a VARCHAR(1) of Y or N (N = not deleted)
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugStudent> getAllActiveStudents() {
		  
		  return entityManager.createQuery("from HugStudent where Student_Delete_Flag = 0").getResultList();
		  
	  }
	  
	  /**
	   * Return the Student Info having the passed Student First Name, Student Last Name and Student Zip code.
	   */
	  public HugStudent getByStudentFirstAndLastNameAndZipCd(String Student_FirstName,String Student_LastName,String Student_Zip_Cd) {
		  HugStudent hug =  null; 		  
	      
		  Query query =  entityManager.createQuery(
	        "from HugStudent where Student_FirstName = :Student_FirstName and Student_LastName = :Student_LastName and Student_Zip_Cd = :Student_Zip_Cd")
	        .setParameter("Student_FirstName", Student_FirstName).setParameter("Student_LastName", Student_LastName).setParameter("Student_Zip_Cd",Student_Zip_Cd);
		  
	        if (query.getResultList().size()>0){
	              hug = (HugStudent) query.getSingleResult();
	          }
	    return hug;
	  }

	  /**
	   * Update the passed Student Info in the database.
	   */
	  public void update(HugStudent hugStudent) {
			// TODO Auto-generated method stub
			entityManager.merge(hugStudent);
		    return;
		}
}
