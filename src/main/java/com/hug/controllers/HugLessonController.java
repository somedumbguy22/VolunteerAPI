package com.hug.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.hug.models.ErrorResponseEntity;
import com.hug.models.GenericResponseEntity;
import com.hug.models.HugLessons;
import com.hug.models.HugLessonsDao;
import com.hug.models.HugSchool;
import com.hug.models.HugStudent;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@Controller
public class HugLessonController {

		@RequestMapping(value = "/lesson/", method = RequestMethod.POST, consumes = {
				"application/json", "application/xml" }, produces = {
				"application/json", "application/xml" })
		@ResponseBody
	  public ResponseEntity<GenericResponseEntity> addLessson(@RequestBody @Valid HugLessons hugLessons) 
		{
	    GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
	  	if (hugLessons!=null)
	  	{
	    	try
	    	{
		    	if (hugLessonsDao.getByLessonTitleAndTheme(hugLessons.getLessonTitle(), hugLessons.getLessonTheme()) != null) {
		    		ErrorResponseEntity error = new ErrorResponseEntity();
		    		error.setErrorCode(HttpStatus.CONFLICT.value());
		    		error.setErrorMessage("Lesson Id already exist");
		    		response.setErrorResponse(error);
		            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.CONFLICT);
		        }
		    	
		    	long lessonId = hugLessonsDao.create(hugLessons);
		    	hugLessons.setLessonId(lessonId);
		        response.setDataList(Arrays.asList(hugLessons));
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.CREATED);
	    	}
	    	catch(Exception e)
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    		error.setErrorMessage("Internal Server Error");
	    		response.setErrorResponse(error);
	    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	  	}
	  	else {
		  		 
	  		ErrorResponseEntity error = new ErrorResponseEntity();
    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		error.setErrorMessage("Lesson details cannot be null");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	  		}
	    }
	
	@RequestMapping(value = "/lesson/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listLessons()
    {
    	GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
    	try
    	{
	        List<HugLessons> hugLessons = hugLessonsDao.getAll();
	        if(hugLessons != null)
	        {
	        	response.setDataList(hugLessons);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	        }
	        else {
	            
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NO_CONTENT);
	        }
    	}
    	catch(Exception e)
    	{
    		ErrorResponseEntity error = new ErrorResponseEntity();
    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		error.setErrorMessage("Internal Server Error");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@RequestMapping(value = "/activelesson/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listActiveLessons()
    {
    	GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
    	try
    	{
	        List<HugLessons> hugLessons = hugLessonsDao.getAllActiveLessons();
	        if(hugLessons != null)
	        {
	        	response.setDataList(hugLessons);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	        }
	        else { 
	            
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NO_CONTENT);
	        }
    	}
    	catch(Exception e)
    	{
    		ErrorResponseEntity error = new ErrorResponseEntity();
    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		error.setErrorMessage("Internal Server Error");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	
	@RequestMapping(value = "/lesson/{lessonId}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listLesson(@PathVariable("lessonId") long lessonId)
    {
    	GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
    	try
    	{
    		HugLessons hugLessons = hugLessonsDao.getByLessonId(lessonId);
	    	if(hugLessons != null)
	    	{
	    		response.setDataList(Arrays.asList(hugLessons));
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Lesson not found");
	    		response.setErrorResponse(error);
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
	        }
    	}
		catch(Exception e)
		{
			ErrorResponseEntity error = new ErrorResponseEntity();
    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		error.setErrorMessage("Internal Server Error");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@RequestMapping(value = "/lesson/{lessonTitle}/theme/{lessonTheme}")
	@ResponseBody
	public HugLessons getByLessonTitleAndTheme(String lessonTitle,
			String lessonTheme) {

		HugLessons hugLessons = null;
		
		try {
			hugLessons = hugLessonsDao.getByLessonTitleAndTheme(lessonTitle,
					lessonTheme);
		} catch (Exception ex) {
			
			return hugLessons;
		}
		
		return hugLessons;
	}

	@RequestMapping(value = "/lesson/{lessonId}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseEntity> deleteLesson(@PathVariable("lessonId") long lessonId)
    {
    	GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
    	try
    	{
    		HugLessons hugLessons = hugLessonsDao.getByLessonId(lessonId);
	    	if(hugLessons != null)
	    	{
	    		hugLessons.setLessonDeleteFlag(true);
	    		hugLessonsDao.update(hugLessons);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Lesson not found");
	    		response.setErrorResponse(error);
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
	        }
    	}
		catch(Exception e)
		{
			ErrorResponseEntity error = new ErrorResponseEntity();
    		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    		error.setErrorMessage("Internal Server Error");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@RequestMapping(value = "/lesson/", method = RequestMethod.PUT,
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	 public ResponseEntity<GenericResponseEntity> updateLesson(@RequestBody @Valid HugLessons hugLesson) {
	    GenericResponseEntity<HugLessons> response = new GenericResponseEntity<HugLessons>();
  	try
  	{
  		HugLessons currentLesson = hugLessonsDao.getByLessonId(hugLesson.getLessonId());
	         
	        if (currentLesson==null) {
	        	ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Lesson not found");
	    		response.setErrorResponse(error);
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
	        }
      
	        hugLessonsDao.update(hugLesson);
	        response.setDataList(Arrays.asList(hugLesson));
	        return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
  		}
	  	catch(Exception e)
	  	{
	  		ErrorResponseEntity error = new ErrorResponseEntity();
	  		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	  		error.setErrorMessage("Internal Server Error");
	  		response.setErrorResponse(error);
	  		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	  	}
	} 
	
	@Autowired
	private HugLessonsDao hugLessonsDao;
}
