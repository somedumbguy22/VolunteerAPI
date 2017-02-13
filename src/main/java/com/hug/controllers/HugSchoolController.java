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
import com.hug.models.HugStudent;
import com.hug.models.User;
import com.hug.models.UserDao;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@Controller
public class HugSchoolController {

	@RequestMapping(value = "/school/", method = RequestMethod.POST, 
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<GenericResponseEntity> create(@RequestBody @Valid HugSchool hugSchool) {

		GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
	  	if (hugSchool!=null)
	  	{
	    	try
	    	{
		    	if (hugSchoolDao.getBySchoolNameAndCity(hugSchool.getSchoolName(),hugSchool.getSchoolCity()) != null) {
		    		ErrorResponseEntity error = new ErrorResponseEntity();
		    		error.setErrorCode(HttpStatus.CONFLICT.value());
		    		error.setErrorMessage("school Id already exist");
		    		response.setErrorResponse(error);
		            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.CONFLICT);
		        }
		    	
		    	long schoolId = hugSchoolDao.create(hugSchool);
		    	hugSchool.setSchoolId(schoolId);
		        response.setDataList(Arrays.asList(hugSchool));
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
    		error.setErrorMessage("school details cannot be null");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	  		}
	}

	@RequestMapping(value = "/school/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listSchools()
    {
    	GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
    	try
    	{
	        List<HugSchool> hugSchools = hugSchoolDao.getAll();
	        if(hugSchools != null)
	        {
	        	response.setDataList(hugSchools);
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
	
	@RequestMapping(value = "/activeschool/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listActiveSchools()
    {
    	GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
    	try
    	{
	        List<HugSchool> hugSchools = hugSchoolDao.getAllActiveSchools();
	        if(hugSchools != null)
	        {
	        	response.setDataList(hugSchools);
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
	
	@RequestMapping(value = "/school/{schoolId}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listSchool(@PathVariable("schoolId") long schoolId)
    {
    	GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
    	try
    	{
    		HugSchool hugSchools = hugSchoolDao.getBySchoolId(schoolId);
	    	if(hugSchools != null)
	    	{
	    		response.setDataList(Arrays.asList(hugSchools));
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("School not found");
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
	
	@RequestMapping(value = "/school/{schoolName}/city/{schoolCity}")
	@ResponseBody
	public HugSchool getBySchoolNameAndCity(String schoolName, String schoolCity) {
	
		HugSchool hugSchool = null;
		try {
			
			hugSchool = hugSchoolDao.getBySchoolNameAndCity(schoolName, schoolCity);

		} catch (Exception ex) {
			
			return hugSchool;
		}
		return hugSchool;
	}
	
	@RequestMapping(value = "/school/{schoolId}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseEntity> deleteSchool(@PathVariable("schoolId") long schoolId)
    {
    	GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
    	try
    	{
    		HugSchool hugSchool = hugSchoolDao.getBySchoolId(schoolId);
	    	if(hugSchool != null)
	    	{
	    		hugSchool.setSchoolDeleteFlag(true);
	    		hugSchoolDao.update(hugSchool);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("School not found");
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

	@RequestMapping(value = "/school/", method = RequestMethod.PUT, 
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<GenericResponseEntity> updateSchoolData(@RequestBody @Valid HugSchool hugSchool) {
		 GenericResponseEntity<HugSchool> response = new GenericResponseEntity<HugSchool>();
		  	try
		  	{
		  		HugSchool currentSchool = hugSchoolDao.getBySchoolId(hugSchool.getSchoolId());
			         
			        if (currentSchool==null) {
			        	ErrorResponseEntity error = new ErrorResponseEntity();
			    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
			    		error.setErrorMessage("School not found");
			    		response.setErrorResponse(error);
			            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
			        }
		      
			        hugSchoolDao.update(hugSchool);
			        response.setDataList(Arrays.asList(hugSchool));
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
	private HugSchoolDao hugSchoolDao;

}
