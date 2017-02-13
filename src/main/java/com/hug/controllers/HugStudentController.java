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
import com.hug.models.HugStudent;
import com.hug.models.HugStudentDao;

@SuppressWarnings("rawtypes")
@JsonAutoDetect(getterVisibility=Visibility.NONE)
@Controller
public class HugStudentController {


	@RequestMapping(value = "/student/", method = RequestMethod.POST,
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	  public ResponseEntity<GenericResponseEntity> addStudent(@RequestBody @Valid HugStudent hugStudent) 
		{
	    GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
	  	if (hugStudent!=null)
	  	{
	    	try
	    	{
		    	if (hugStudentDao.getByStudentFirstAndLastNameAndZipCd(hugStudent.getStudentFirstName(),hugStudent.getStudentLastName(),hugStudent.getStudentZipCd()) != null) {
		    		ErrorResponseEntity error = new ErrorResponseEntity();
		    		error.setErrorCode(HttpStatus.CONFLICT.value());
		    		error.setErrorMessage("Student Id already exist");
		    		response.setErrorResponse(error);
		            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.CONFLICT);
		        }
		    	
		    	long studentId = hugStudentDao.create(hugStudent);
		    	hugStudent.setStudentid(studentId);
		        response.setDataList(Arrays.asList(hugStudent));
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
    		error.setErrorMessage("Student details cannot be null");
    		response.setErrorResponse(error);
    		return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	  		}
	    }
	
	
	@RequestMapping(value = "/student/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listStudents()
    {
    	GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
    	try
    	{
	        List<HugStudent> students = hugStudentDao.getAll();
	        if(students != null)
	        {
	        	response.setDataList(students);
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
	
	///----------------------------------------------------------------------------
	@RequestMapping(value = "/activestudent/", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listActiveStudents()
    {
    	GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
    	try
    	{
	        List<HugStudent> students = hugStudentDao.getAllActiveStudents();
	        if(students != null)
	        {
	        	response.setDataList(students);
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
	
	///----------------------------------------------------------------------------
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseEntity> listStudent(@PathVariable("studentId") long studentId)
    {
    	GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
    	try
    	{
    		HugStudent student = hugStudentDao.getByStudentId(studentId);
	    	if(student != null)
	    	{
	    		response.setDataList(Arrays.asList(student));
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Student not found");
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
	
	@RequestMapping(value="/get-by-studentFirst-LastName-and-zipCd")
	  @ResponseBody
	  public HugStudent getBySchoolNameAndCity(String studentFirstName,String studentLastName, String studentZipCd) {
	    //String userId;
	    HugStudent hugStudent = null;
	    try {
	    	hugStudent = hugStudentDao.getByStudentFirstAndLastNameAndZipCd(studentFirstName, studentLastName, studentZipCd);
	      //userId = String.valueOf(user.getId());
	    }
	    catch (Exception ex) {
	      return hugStudent;
	    }
	    return hugStudent;
	  }
	
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseEntity> deleteStudent(@PathVariable("studentId") long studentId)
    {
    	GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
    	try
    	{
    		HugStudent student = hugStudentDao.getByStudentId(studentId);
	    	if(student != null)
	    	{
	    		student.setStudentDeleteFlag(true);
	    		hugStudentDao.update(student);
	        	return new ResponseEntity<GenericResponseEntity>(response, HttpStatus.OK);
	    	}
	    	else
	    	{
	    		ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Student not found");
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
	
	/**
	   * Update the student identified by the passed id.
	   */
	@RequestMapping(value = "/student/", method = RequestMethod.PUT,
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	 public ResponseEntity<GenericResponseEntity> updateStudent(@RequestBody @Valid HugStudent hugStudent) {
	    GenericResponseEntity<HugStudent> response = new GenericResponseEntity<HugStudent>();
    	try
    	{
    		HugStudent currentStudent = hugStudentDao.getByStudentId(hugStudent.getStudentid());
	         
	        if (currentStudent==null) {
	        	ErrorResponseEntity error = new ErrorResponseEntity();
	    		error.setErrorCode(HttpStatus.NOT_FOUND.value());
	    		error.setErrorMessage("Student not found");
	    		response.setErrorResponse(error);
	            return new ResponseEntity<GenericResponseEntity>(response,HttpStatus.NOT_FOUND);
	        }
        
	        hugStudentDao.update(hugStudent);
	        response.setDataList(Arrays.asList(hugStudent));
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
	    private HugStudentDao hugStudentDao;
}
