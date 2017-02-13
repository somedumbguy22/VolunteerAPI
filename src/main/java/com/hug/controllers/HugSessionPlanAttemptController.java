package com.hug.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.hug.models.HugSessionPlanAttempts;
import com.hug.models.HugSessionPlanAttemptsDao;
import com.hug.models.HugStudent;
import com.hug.models.HugVolunteer;
import com.hug.models.HugVolunteerDao;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@Controller
public class HugSessionPlanAttemptController {

	@RequestMapping(value = "/sessionPlanAttempt", method = RequestMethod.POST, 
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	public String create(
			@RequestBody @Valid HugSessionPlanAttempts hugSessionPlanAttempts) {

		if (hugSessionPlanAttempts != null) {
			System.out.println("Plan Attempts is :" + hugSessionPlanAttempts);
			hugSessionPlanAttemptsDao.create(hugSessionPlanAttempts);
		} else {
			return "user details cannot be null";
		}
		return "Successfully created";

	}

	@RequestMapping(value = "/get-by-studentid-and-schoolid-and-lessonid")
	@ResponseBody
	public HugSessionPlanAttempts getByStudentIdAndSchoolIdAndLessonId(
			int studentId, int schoolId, int lessonId) {

		HugSessionPlanAttempts hugSessionPlanAttempts = null;
		try {
			hugSessionPlanAttempts = hugSessionPlanAttemptsDao
					.getByStudentIdAndSchoolIdAndInstructorIdAndLessonId(
							studentId, schoolId, lessonId);

		} catch (Exception ex) {
			return hugSessionPlanAttempts;
		}
		return hugSessionPlanAttempts;
	}

	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */

	@RequestMapping(value = "/updateSessionPlanAttemptData", method = RequestMethod.PUT, 
			consumes = {"application/json", "application/xml" }, 
			produces = {"application/json", "application/xml" })
	@ResponseBody
	public String updateVolunteer(
			@RequestBody @Valid HugSessionPlanAttempts hugSessionPlanAttempts) {
		try {
			HugSessionPlanAttempts hugSessionPlanAttemptsFromDB = hugSessionPlanAttemptsDao
					.getByStudentIdAndSchoolIdAndInstructorIdAndLessonId(
							hugSessionPlanAttempts.getSpaStudentId(),
							hugSessionPlanAttempts.getSpaSchoolId(),
							hugSessionPlanAttempts.getSpaLessionId());
			hugSessionPlanAttemptsFromDB
					.setLastModifiedBy(hugSessionPlanAttempts
							.getLastModifiedBy());

			hugSessionPlanAttemptsDao.update(hugSessionPlanAttemptsFromDB);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	@Autowired
	private HugSessionPlanAttemptsDao hugSessionPlanAttemptsDao;
}
