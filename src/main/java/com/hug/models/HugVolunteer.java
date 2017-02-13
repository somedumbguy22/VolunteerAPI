package com.hug.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hug_volunteer")
public class HugVolunteer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Volunteer_id")
	private long volunteerId;

	@Column(name = "Volunteer_FirstName")
	private String volunteerFirstName;

	@Column(name = "Volunteer_LastName")
	private String volunteerlastName;

	@Column(name = "Volunteer_Email")
	private String volunteerEmail;

	@Column(name = "Volunteer_Mobile_Phone")
	private String volunteerMobilePhone;

	@Column(name = "Volunteer_Other_Phone")
	private String volunteerOtherPhone;

	@Column(name = "Do_Not_Share_Phone")
	private String doNotSharePhone;

	@Column(name = "Volunteer_Free_Text")
	private String volunteerFreeText;

	@Column(name = "Volunteer_Commitment_Level")
	private String volunteerCommitmentLevel;

	@Column(name = "Volunteer_Specialist_Flag")
	private String volunteerSpecialistFlag;

	@Column(name = "Volunteer_Back_Ground_Check")
	private String volunteerBackGroundCheck;

	@Column(name = "Volunteer_Code_of_Ethics")
	private String volunteerCodeofEthics;

	@Column(name = "Volunteer_Delete_Flag")
	private Boolean volunteerDeleteFlag;

	@Column(name = "Last_Modified_By")
	private String lastModifiedBy;
	
	

	public HugVolunteer() {
		
	}
	
	

	public HugVolunteer(long volunteerId, String volunteerFirstName,
			String volunteerlastName, String volunteerEmail,
			String volunteerMobilePhone, String volunteerOtherPhone,
			String doNotSharePhone, String volunteerFreeText,
			String volunteerCommitmentLevel, String volunteerSpecialistFlag,
			String volunteerBackGroundCheck, String volunteerCodeofEthics,
			Boolean volunteerDeleteFlag, String lastModifiedBy) {
		
		this.volunteerId = volunteerId;
		this.volunteerFirstName = volunteerFirstName;
		this.volunteerlastName = volunteerlastName;
		this.volunteerEmail = volunteerEmail;
		this.volunteerMobilePhone = volunteerMobilePhone;
		this.volunteerOtherPhone = volunteerOtherPhone;
		this.doNotSharePhone = doNotSharePhone;
		this.volunteerFreeText = volunteerFreeText;
		this.volunteerCommitmentLevel = volunteerCommitmentLevel;
		this.volunteerSpecialistFlag = volunteerSpecialistFlag;
		this.volunteerBackGroundCheck = volunteerBackGroundCheck;
		this.volunteerCodeofEthics = volunteerCodeofEthics;
		this.volunteerDeleteFlag = volunteerDeleteFlag;
		this.lastModifiedBy = lastModifiedBy;
	}



	public long getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(long volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getVolunteerFirstName() {
		return volunteerFirstName;
	}

	public void setVolunteerFirstName(String volunteerFirstName) {
		this.volunteerFirstName = volunteerFirstName;
	}

	public String getVolunteerlastName() {
		return volunteerlastName;
	}

	public void setVolunteerlastName(String volunteerlastName) {
		this.volunteerlastName = volunteerlastName;
	}

	public String getVolunteerEmail() {
		return volunteerEmail;
	}

	public void setVolunteerEmail(String volunteerEmail) {
		this.volunteerEmail = volunteerEmail;
	}

	public String getVolunteerMobilePhone() {
		return volunteerMobilePhone;
	}

	public void setVolunteerMobilePhone(String volunteerMobilePhone) {
		this.volunteerMobilePhone = volunteerMobilePhone;
	}

	public String getVolunteerOtherPhone() {
		return volunteerOtherPhone;
	}

	public void setVolunteerOtherPhone(String volunteerOtherPhone) {
		this.volunteerOtherPhone = volunteerOtherPhone;
	}

	public String getDoNotSharePhone() {
		return doNotSharePhone;
	}

	public void setDoNotSharePhone(String doNotSharePhone) {
		this.doNotSharePhone = doNotSharePhone;
	}

	public String getVolunteerFreeText() {
		return volunteerFreeText;
	}

	public void setVolunteerFreeText(String volunteerFreeText) {
		this.volunteerFreeText = volunteerFreeText;
	}

	public String getVolunteerCommitmentLevel() {
		return volunteerCommitmentLevel;
	}

	public void setVolunteerCommitmentLevel(String volunteerCommitmentLevel) {
		this.volunteerCommitmentLevel = volunteerCommitmentLevel;
	}

	public String getVolunteerSpecialistFlag() {
		return volunteerSpecialistFlag;
	}

	public void setVolunteerSpecialistFlag(String volunteerSpecialistFlag) {
		this.volunteerSpecialistFlag = volunteerSpecialistFlag;
	}

	public String getVolunteerBackGroundCheck() {
		return volunteerBackGroundCheck;
	}

	public void setVolunteerBackGroundCheck(String volunteerBackGroundCheck) {
		this.volunteerBackGroundCheck = volunteerBackGroundCheck;
	}

	public String getVolunteerCodeofEthics() {
		return volunteerCodeofEthics;
	}

	public void setVolunteerCodeofEthics(String volunteerCodeofEthics) {
		this.volunteerCodeofEthics = volunteerCodeofEthics;
	}

	public Boolean getVolunteerDeleteFlag() {
		return volunteerDeleteFlag;
	}

	public void setVolunteerDeleteFlag(Boolean volunteerDeleteFlag) {
		this.volunteerDeleteFlag = volunteerDeleteFlag;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "HugVolunteer [volunteerId=" + volunteerId
				+ ", volunteerFirstName=" + volunteerFirstName
				+ ", volunteerlastName=" + volunteerlastName
				+ ", volunteerEmail=" + volunteerEmail
				+ ", volunteerMobilePhone=" + volunteerMobilePhone
				+ ", volunteerOtherPhone=" + volunteerOtherPhone
				+ ", doNotSharePhone=" + doNotSharePhone
				+ ", volunteerFreeText=" + volunteerFreeText
				+ ", volunteerCommitmentLevel=" + volunteerCommitmentLevel
				+ ", volunteerSpecialistFlag=" + volunteerSpecialistFlag
				+ ", volunteerBackGroundCheck=" + volunteerBackGroundCheck
				+ ", volunteerCodeofEthics=" + volunteerCodeofEthics
				+ ", volunteerDeleteFlag=" + volunteerDeleteFlag
				+ ", lastModifiedBy=" + lastModifiedBy + "]";
	}
	
	

}
