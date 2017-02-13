package com.hug.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HugSessionPlanAttemptsDao {

	@PersistenceContext
	  private EntityManager entityManager;
	  
	 /**
	   * Save the Session Plan Attempts in the database.
	   */
	  public void create(HugSessionPlanAttempts hugSessionPlanAttempts) {
	    entityManager.persist(hugSessionPlanAttempts);
	    return;
	  }
	  
	  /**
	   * Delete the Session Plan Attempts from the database.
	   */
	  public void delete(HugSessionPlanAttempts hugSessionPlanAttempts) {
	    if (entityManager.contains(hugSessionPlanAttempts))
	      entityManager.remove(hugSessionPlanAttempts);
	    else
	      entityManager.remove(entityManager.merge(hugSessionPlanAttempts));
	    return;
	  }
	  
	  /**
	   * Return all the Session Plan Attempts stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugSchool> getAll() {
	    return entityManager.createQuery("from HugSessionPlanAttempts").getResultList();
	  }
	  
	  /**
	   * Return all the Session Plan Attempts stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugSchool> getAllActiveSPAs() {
	    return entityManager.createQuery("from HugSessionPlanAttempts where SPA_Delete_Flag = 0").getResultList();
	  }
	  
	  /**
	   * Return the Session Plan Attempts having the passed Student id, School Id and Lesson Id.
	   */
	  public HugSessionPlanAttempts getByStudentIdAndSchoolIdAndInstructorIdAndLessonId(long SPA_Student_id,long SPA_School_Id,long SPA_Lession_Id) {
	    HugSessionPlanAttempts hug =  (HugSessionPlanAttempts) entityManager.createQuery(
	        "from HugSessionPlanAttempts where SPA_Student_id = :SPA_Student_id and SPA_School_Id = :SPA_School_Id and SPA_Lession_Id = :SPA_Lession_Id")
	        .setParameter("SPA_Student_id", SPA_Student_id).setParameter("SPA_School_Id", SPA_School_Id).setParameter("SPA_Lession_Id", SPA_Lession_Id)
	        .getSingleResult();
	    return hug;
	  }

	  /**
	   * Update the passed Session Plan Attempts in the database.
	   */
	  public void update(HugSessionPlanAttempts hugSessionPlanAttempts) {
			// TODO Auto-generated method stub
			entityManager.merge(hugSessionPlanAttempts);
		    return;
		}
}
