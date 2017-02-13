#HUG API Service Repository
This repository is for the HUG volunteer program. 


##Resources - A list of available API resources

	consumes = {"application/json", "application/xml" } 
	produces = {"application/json", "application/xml" }

###Student:
	- GET (Retrieve):
		/student/
		/activestudent/
		/student/{studentId}
		/get-by-studentFirst-LastName-and-zipCd/
			requires query parameters: studentFirstName, studentLastName, studentZipCd

	- POST (Insert):
		/student/

	- PUT (Update):
		/student/

	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
		/student/{studentId}

###Lesson:
	- GET (Retrieve):
		/lesson/
		/activelesson/
		/lesson/{lessonId}
		/get-by-lessontitle-and-theme/
			requires query parameters: lessonTitle, lessonTheme

	- POST (Insert):
		/lesson/

	- PUT (Update):
		/lesson/

	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
		/lesson/{lessonId}

###School:
	- GET (Retrieve):
		/school/
		/activeschool/
		/school/{schoolId}
		/get-by-schoolName-and-city/
			requires query parameters: schoolName, schoolCity

	- POST (Insert):
		/school/

	- PUT (Update):
		/School/

	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
		/school/{schoolId}

###Volunteer:
	- GET (Retrieve):
		/volunteer/
		/activevolunteer/
		/volunteer/{volunteerId}
		/get-by-volunteerFirstName-and-LastName-and-email/
			requires query parameters: volunteerFirstName, volunteerLastName, volunteerEmail

	- POST (Insert):
		/volunteer/

	- PUT (Update):
		/volunteer/

	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
		/volunteer/{volunteerId}

###Session Plan:
	- GET (Retrieve):
		/get-by-studentid-and-schoolid-and-lessonid/
			requires query parameters: studentId, schoolId, lessonId
	- POST (Insert):
		/sessionPlanAttempt/
	- PUT (Update):
		/updateSessionPlanAttemptData/
	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
