package com.hug.models;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query; 
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HugLessonsDao {
	
	@PersistenceContext
	  private EntityManager entityManager;
	 
	
	/**
	   * Save the Lessons in the database.
	   */
	  public long create(HugLessons hugLessons) {
	    entityManager.persist(hugLessons);
	    return hugLessons.getLessonId();
	  }
	  
	  /**
	   * Return all the Student Info stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugLessons> getAll() {
	    return entityManager.createQuery("from HugLessons").getResultList();
	  }
	  
	  /**
	   * Returns all the Active Lessons stored in the database.
	   */
	  @SuppressWarnings("unchecked")
	  public List<HugLessons> getAllActiveLessons() {
	    return entityManager.createQuery("from HugLessons where Lesson_Delete_Flag = 0").getResultList();
	  }
	  
	  /**
	   * Return the Lesson Info having the passed Lesson Id
	   */
	  public HugLessons getByLessonId(long Lesson_id) {
		  HugLessons hug =  null; 		  
	      
		  Query query =  entityManager.createQuery(
	        "from HugLessons where Lesson_id = :Lesson_id")
	        .setParameter("Lesson_id", Lesson_id);
		  
          if (query.getResultList().size()>0){
              hug = (HugLessons) query.getSingleResult();
          }
         return hug;
	  }
	  
	  
	  /**
	   * Return the Lessons having the passed Lesson Title and Lesson Theme.
	   */
	  public HugLessons getByLessonTitleAndTheme(String Lesson_Title,String Lesson_Theme) {
		  	HugLessons hug =  null; 		  
	      
		  Query query = entityManager.createQuery(
	        "from HugLessons where Lesson_Title = :Lesson_Title and Lesson_Theme = :Lesson_Theme")
	        .setParameter("Lesson_Title", Lesson_Title).setParameter("Lesson_Theme", Lesson_Theme);
		  
	        if (query.getResultList().size()>0){
	              hug = (HugLessons) query.getSingleResult();
	        }
	    return hug;
	  }
	  
	  /**
	   * Update the passed Lessons in the database.
	   */
	  public void update(HugLessons hugLessons) {
			// TODO Auto-generated method stub
			entityManager.merge(hugLessons);
		    return;
		}

}
