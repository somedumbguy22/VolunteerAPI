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
import com.hug.models.HugSchool;
import com.hug.models.HugSchoolDao;
import com.hug.models.HugVolunteer;
import com.hug.models.HugVolunteerDao;
import com.hug.models.User;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@Controller
public class HugVolunteerController {

	@RequestMapping(value = "/volunteer/", method = RequestMethod.POST, 
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
    public ResponseEntity<GenericResponseEntity> addVolunteer(@RequestBody @Valid HugVolunteer hugVolunteer) 
		{
		    GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
		  	if (hugVolunteer!=null)
		  	{
		    	try
		    	{
			    	if (hugVolunteerDao.getByVolunteerFirstNameLastNameAndEmail(hugVolunteer.getVolunteerFirstName(),hugVolunteer.getVolunteerlastName(), hugVolunteer.getVolunteerEmail()) != null) {
			    		ErrorResponseEntity error = new ErrorResponseEntity();
			    		error.setErrorCode(HttpStatus.CONFLICT.value());
			    		error.setErrorMessage("Volunteer Id already exist");
			    		response.setErrorResponse(error);
			            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.CONFLICT);
			        }
			    	
			    	long volunteerId = hugVolunteerDao.create(hugVolunteer);
			    	hugVolunteer.setVolunteerId(volunteerId);
			        response.setDataList(Arrays.asList(hugVolunteer));
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
		 		error.setErrorMessage("Volunteer details cannot be null");
		 		response.setErrorResponse(error);
		 		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		  	}
	    }

	@RequestMapping(value = "/volunteer/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listVolunteers()
    {
    	GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
    	try
    	{
	        List<HugVolunteer> hugVolunteer = hugVolunteerDao.getAll();
	        if(hugVolunteer != null)
	        {
	        	response.setDataList(hugVolunteer);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	        }
	        else{
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
	
	@RequestMapping(value = "/activevolunteer/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listActiveVolunteers()
    {
    	GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
    	try
    	{
	        List<HugVolunteer> hugVolunteer = hugVolunteerDao.getAllActiveVolunteers();
	        if(hugVolunteer != null)
	        {
	        	response.setDataList(hugVolunteer);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	        }
	        else{
	            
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
	
	@RequestMapping(value = "/volunteer/{volunteerId}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listVolunteer(@PathVariable("volunteerId") long volunteerId)
    {
    	GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
    	try
    	{
    		HugVolunteer hugVolunteer = hugVolunteerDao.GetByVolunteerId(volunteerId);
	    	if(hugVolunteer != null)
	    	{
	    		response.setDataList(Arrays.asList(hugVolunteer));
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Volunteer not found");
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
	
	@RequestMapping(value = "/volunteerfirstname/{volunteerFirstName}/volunteerlastname/{volunteerLastName}/email/{volunteerEmail}")
	@ResponseBody
	public HugVolunteer getByFirstandLastNameAndEmail(
			String volunteerFirstName, String volunteerLastName,
			String volunteerEmail) {

		HugVolunteer hugVolunteer = null;
		try {
			hugVolunteer = hugVolunteerDao
					.getByVolunteerFirstNameLastNameAndEmail(
							volunteerFirstName, volunteerLastName,
							volunteerEmail);
		} catch (Exception ex) {
			
			return hugVolunteer;
		}
		
		return hugVolunteer;
	}

	
	@RequestMapping(value = "/volunteer/{volunteerId}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseEntity> deleteVolunteer(@PathVariable("volunteerId") long volunteerId)
    {
    	GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
    	try
    	{
    		HugVolunteer hugVolunteer = hugVolunteerDao.GetByVolunteerId(volunteerId);
	    	if(hugVolunteer != null)
	    	{
	    		hugVolunteer.setVolunteerDeleteFlag(true);
	    		hugVolunteerDao.update(hugVolunteer);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Volunteer not found");
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
	

	@RequestMapping(value = "/volunteer/", method = RequestMethod.PUT,
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	 public ResponseEntity<GenericResponseEntity> updateVolunteer(@RequestBody @Valid HugVolunteer hugVolunteer) {
	    GenericResponseEntity<HugVolunteer> response = new GenericResponseEntity<HugVolunteer>();
  	try
  	{
  		HugVolunteer currentVolunteer = hugVolunteerDao.GetByVolunteerId(hugVolunteer.getVolunteerId());
	         
	        if (currentVolunteer==null) {
	        	ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Volunteer not found");
	    		response.setErrorResponse(error);
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
	        }
	        
	        hugVolunteerDao.update(hugVolunteer);
	        response.setDataList(Arrays.asList(hugVolunteer));
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
	private HugVolunteerDao hugVolunteerDao;

}
