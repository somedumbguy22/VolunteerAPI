package com.hug.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hug_student")
public class HugStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Student_id")
	private long studentid;
	
	@Column(name = "Student_FirstName")
	private String studentFirstName;
	
	@Column(name = "Student_LastName")
	private String studentLastName;
	
	@Column(name = "Student_Zip_Cd")
	private String studentZipCd;
	
	@Column(name = "Student_Sex_Cd")
	private String studentSexCd;
	
	@Column(name = "Student_Goal_Clarity_Person_FirstName")
	private String studentGoalClarityPersonFirstName;
	
	@Column(name = "Student_Goal_Clarity_Person_LastName")
	private String studentGoalClarityPersonLastName;
	
	@Column(name = "Student_Goal_Clarity_Person_Email")
	private String studentGoalClarityPersonEmail;
	
	@Column(name = "Student_Goal_Clarity_Person_Mobile_Phone")
	private String studentGoalClarityPersonMobilePhone;
	
	@Column(name = "Student_Goal_Clarity_Person_Other_Phone")
	private String studentGoalClarityPersonOtherPhone;
	
	@Column(name = "Student_Teacher_FirstName")
	private String studentTeacherFirstName;
	
	@Column(name = "Student_Teacher_LastName")
	private String studentTeacherLastName;
	
	@Column(name = "Student_Teacher_Email")
	private String studentTeacherEmail;
	
	@Column(name = "Student_Teacher_Mobile_Phone")
	private String studentTeacherMobilePhone;
	
	@Column(name = "Student_Teacher_Other_Phone")
	private String studentTeacherOtherPhone;
	
	@Column(name = "Student_School_Id")
	private String studentSchoolId;
	
	@Column(name = "Student_Hug_Program_Start_Date")
	private Date studentHugProgramStartDate;
	
	@Column(name = "Student_DRAScore1")
	private int studentDRAScore1;
	
	@Column(name = "Student_DRAScore2")
	private int studentDRAScore2;
	
	@Column(name = "Student_DRAScore3")
	private int studentDRAScore3;
	
	@Column(name = "Student_Free_Text")
	private String studentFreeText;
	
	@Column(name = "Student_Delete_Flag")
	private Boolean studentDeleteFlag;
	
	@Column(name = "Last_Modified_By")
	private String lastModifiedBy;
	
	public HugStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HugStudent(String studentFirstName, String studentLastName,
			String studentZipCd, String studentSexCd,
			String studentGoalClarityPersonFirstName,
			String studentGoalClarityPersonLastName,
			String studentGoalClarityPersonEmail,
			String studentGoalClarityPersonMobilePhone,
			String studentGoalClarityPersonOtherPhone,
			String studentTeacherFirstName, String studentTeacherLastName,
			String studentTeacherEmail, String studentTeacherMobilePhone,
			String studentTeacherOtherPhone, String studentSchoolId,
			Date studentHugProgramStartDate, int studentDRAScore1,
			int studentDRAScore2, int studentDRAScore3, String studentFreeText,
			Boolean studentDeleteFlag, String lastModifiedBy) {
		super();
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentZipCd = studentZipCd;
		this.studentSexCd = studentSexCd;
		this.studentGoalClarityPersonFirstName = studentGoalClarityPersonFirstName;
		this.studentGoalClarityPersonLastName = studentGoalClarityPersonLastName;
		this.studentGoalClarityPersonEmail = studentGoalClarityPersonEmail;
		this.studentGoalClarityPersonMobilePhone = studentGoalClarityPersonMobilePhone;
		this.studentGoalClarityPersonOtherPhone = studentGoalClarityPersonOtherPhone;
		this.studentTeacherFirstName = studentTeacherFirstName;
		this.studentTeacherLastName = studentTeacherLastName;
		this.studentTeacherEmail = studentTeacherEmail;
		this.studentTeacherMobilePhone = studentTeacherMobilePhone;
		this.studentTeacherOtherPhone = studentTeacherOtherPhone;
		this.studentSchoolId = studentSchoolId;
		this.studentHugProgramStartDate = studentHugProgramStartDate;
		this.studentDRAScore1 = studentDRAScore1;
		this.studentDRAScore2 = studentDRAScore2;
		this.studentDRAScore3 = studentDRAScore3;
		this.studentFreeText = studentFreeText;
		this.studentDeleteFlag = studentDeleteFlag;
		this.lastModifiedBy = lastModifiedBy;
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentZipCd() {
		return studentZipCd;
	}

	public void setStudentZipCd(String studentZipCd) {
		this.studentZipCd = studentZipCd;
	}

	public String getStudentSexCd() {
		return studentSexCd;
	}

	public void setStudentSexCd(String studentSexCd) {
		this.studentSexCd = studentSexCd;
	}

	public String getStudentGoalClarityPersonFirstName() {
		return studentGoalClarityPersonFirstName;
	}

	public void setStudentGoalClarityPersonFirstName(
			String studentGoalClarityPersonFirstName) {
		this.studentGoalClarityPersonFirstName = studentGoalClarityPersonFirstName;
	}

	public String getStudentGoalClarityPersonLastName() {
		return studentGoalClarityPersonLastName;
	}

	public void setStudentGoalClarityPersonLastName(
			String studentGoalClarityPersonLastName) {
		this.studentGoalClarityPersonLastName = studentGoalClarityPersonLastName;
	}

	public String getStudentGoalClarityPersonEmail() {
		return studentGoalClarityPersonEmail;
	}

	public void setStudentGoalClarityPersonEmail(
			String studentGoalClarityPersonEmail) {
		this.studentGoalClarityPersonEmail = studentGoalClarityPersonEmail;
	}

	public String getStudentGoalClarityPersonMobilePhone() {
		return studentGoalClarityPersonMobilePhone;
	}

	public void setStudentGoalClarityPersonMobilePhone(
			String studentGoalClarityPersonMobilePhone) {
		this.studentGoalClarityPersonMobilePhone = studentGoalClarityPersonMobilePhone;
	}

	public String getStudentGoalClarityPersonOtherPhone() {
		return studentGoalClarityPersonOtherPhone;
	}

	public void setStudentGoalClarityPersonOtherPhone(
			String studentGoalClarityPersonOtherPhone) {
		this.studentGoalClarityPersonOtherPhone = studentGoalClarityPersonOtherPhone;
	}

	public String getStudentTeacherFirstName() {
		return studentTeacherFirstName;
	}

	public void setStudentTeacherFirstName(String studentTeacherFirstName) {
		this.studentTeacherFirstName = studentTeacherFirstName;
	}

	public String getStudentTeacherLastName() {
		return studentTeacherLastName;
	}

	public void setStudentTeacherLastName(String studentTeacherLastName) {
		this.studentTeacherLastName = studentTeacherLastName;
	}

	public String getStudentTeacherEmail() {
		return studentTeacherEmail;
	}

	public void setStudentTeacherEmail(String studentTeacherEmail) {
		this.studentTeacherEmail = studentTeacherEmail;
	}

	public String getStudentTeacherMobilePhone() {
		return studentTeacherMobilePhone;
	}

	public void setStudentTeacherMobilePhone(String studentTeacherMobilePhone) {
		this.studentTeacherMobilePhone = studentTeacherMobilePhone;
	}

	public String getStudentTeacherOtherPhone() {
		return studentTeacherOtherPhone;
	}

	public void setStudentTeacherOtherPhone(String studentTeacherOtherPhone) {
		this.studentTeacherOtherPhone = studentTeacherOtherPhone;
	}

	public String getStudentSchoolId() {
		return studentSchoolId;
	}

	public void setStudentSchoolId(String studentSchoolId) {
		this.studentSchoolId = studentSchoolId;
	}

	public Date getStudentHugProgramStartDate() {
		return studentHugProgramStartDate;
	}

	public void setStudentHugProgramStartDate(Date studentHugProgramStartDate) {
		this.studentHugProgramStartDate = studentHugProgramStartDate;
	}

	public int getStudentDRAScore1() {
		return studentDRAScore1;
	}

	public void setStudentDRAScore1(int studentDRAScore1) {
		this.studentDRAScore1 = studentDRAScore1;
	}

	public int getStudentDRAScore2() {
		return studentDRAScore2;
	}

	public void setStudentDRAScore2(int studentDRAScore2) {
		this.studentDRAScore2 = studentDRAScore2;
	}

	public int getStudentDRAScore3() {
		return studentDRAScore3;
	}

	public void setStudentDRAScore3(int studentDRAScore3) {
		this.studentDRAScore3 = studentDRAScore3;
	}

	public String getStudentFreeText() {
		return studentFreeText;
	}

	public void setStudentFreeText(String studentFreeText) {
		this.studentFreeText = studentFreeText;
	}

	public Boolean getStudentDeleteFlag() {
		return studentDeleteFlag;
	}

	public void setStudentDeleteFlag(Boolean studentDeleteFlag) {
		this.studentDeleteFlag = studentDeleteFlag;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	
}
