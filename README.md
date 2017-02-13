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
		/studentfirstname/{studentFirstName}/studentLastName/{studentLastName}/zip/{studentZipCd}

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
		/lesson/{lessonTitle}/theme/{lessonTheme}

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
		/school/{schoolName}/city/{schoolCity}

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
		/volunteerfirstname/{volunteerFirstName}/volunteerlastname/{volunteerLastName}/email/{volunteerEmail}

	- POST (Insert):
		/volunteer/

	- PUT (Update):
		/volunteer/

	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
		/volunteer/{volunteerId}

###Session Plan:
	- GET (Retrieve):
		/school/{schoolId}/student/{studentId}/lesson/{lessonId}
	- POST (Insert):
		/sessionPlanAttempt/
	- PUT (Update):
		/SessionPlanAttemptData/
	- DELETE (Remove): 
		- Note: This operation is always a soft delete, as indicated by the delete flag in the database
