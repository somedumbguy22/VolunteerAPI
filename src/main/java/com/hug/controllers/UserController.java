package com.hug.controllers;


import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.hug.models.User;
import com.hug.models.UserDao;

/**
 * Class UserController
 */
@JsonAutoDetect(getterVisibility=Visibility.NONE)
@Controller
public class UserController {

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Create a new user with an auto-generated id and email and name as passed 
   * values.
   */
  @RequestMapping(value="/create")
  @ResponseBody
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      userDao.create(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created!";
  }
  
	@RequestMapping(value = "/data", method = RequestMethod.POST,
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	public String getUserDetails(@RequestBody User user){
	  if (user!=null){
		  userDao.create(user);
	  }else {
		  return "user details cannot be null";
	  }
	  return "Successfully created";
  }
  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value="/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
  
  @RequestMapping(value="/get-by-email1")
  @ResponseBody
  public User getByEmail1(String email) {
    String userId;
    User user = null;
    try {
      user = userDao.getByEmail(email);
     }
    catch (Exception ex) {
    	return  user;
    }
    return user;
  }
  
  @RequestMapping(value="/get-by-email-and-name")
  @ResponseBody
  public User getByEmailAndName(String email,String name) {
    String userId;
    User user = null;
    try {
      user = userDao.getByEmailAndName(email,name);
      //userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return user;
    }
    return user;
  }
  
  
  
  /**
   * Update the email and the name for the user indentified by the passed id.
   */
  @RequestMapping(value="/update")
  @ResponseBody
  public String updateName(long id, String email, String name) {
    try {
      User user = userDao.getById(id);
      user.setEmail(email);
      user.setName(name);
      userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  } 

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UserDao used inside this controller.
  @Autowired
  private UserDao userDao;
  
} // class UserController
