package com.hug.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hug_school")
public class HugSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "School_Id")
	private long schoolId;
	
	@Column(name = "School_Name")
	private String schoolName;
	
	@Column(name = "School_Address1")
	private String schoolAddress1;

	@Column(name = "School_Address2")
	private String schoolAddress2;

	@Column(name = "School_City")
	private String schoolCity;

	@Column(name = "Scholl_Satet_Cd")
	private String schollSatetCd;

	@Column(name = "School_Zip_Cd")
	private String schoolZipCd;

	@Column(name = "School_Zip_Plus_Cd")
	private String schoolZipPlusCd;

	@Column(name = "School_Phone")
	private String schoolPhone;

	@Column(name = "Student_Goal_Clarity_Person_FirstName")
	private String studentGoalClarityPersonFirstName;

	@Column(name = "Student_Goal_Clarity_Person_LastName")
	private String studentGoalClarityPersonlastName;

	@Column(name = "Student_Goal_Clarity_Person_Email")
	private String studentGoalClarityPersonEmail;

	@Column(name = "Student_Goal_Clarity_Person_Mobile_Phone")
	private String studentGoalClarityPersonMobilePhone;

	@Column(name = "Student_Goal_Clarity_Person_Other_Phone")
	private String studentGoalClarityPersonOtherPhone;

	@Column(name = "School_County")
	private String schoolCounty;

	@Column(name = "School_District")
	private String schoolDistrict;

	@Column(name = "School_Pricipal_FirstName")
	private String schoolPricipalFirstName;

	@Column(name = "School_Pricipal_LastName")
	private String schoolPricipallastName;

	@Column(name = "School_Free_Text")
	private String schoolFreeText;

	@Column(name = "School_Delete_Flag")
	private Boolean schoolDeleteFlag;

	@Column(name = "Last_Modified_By")
	private String lastModifiedBy;
	
	public HugSchool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HugSchool(String schoolName, String schoolAddress1,
			String schoolAddress2, String schoolCity, String schollSatetCd,
			String schoolZipCd, String schoolZipPlusCd, String schoolPhone,
			String studentGoalClarityPersonFirstName,
			String studentGoalClarityPersonlastName,
			String studentGoalClarityPersonEmail,
			String studentGoalClarityPersonMobilePhone,
			String studentGoalClarityPersonOtherPhone, String schoolCounty,
			String schoolDistrict, String schoolPricipalFirstName,
			String schoolPricipallastName, String schoolFreeText,
			Boolean schoolDeleteFlag, String lastModifiedBy
			) {
		super();
		this.schoolName = schoolName;
		this.schoolAddress1 = schoolAddress1;
		this.schoolAddress2 = schoolAddress2;
		this.schoolCity = schoolCity;
		this.schollSatetCd = schollSatetCd;
		this.schoolZipCd = schoolZipCd;
		this.schoolZipPlusCd = schoolZipPlusCd;
		this.schoolPhone = schoolPhone;
		this.studentGoalClarityPersonFirstName = studentGoalClarityPersonFirstName;
		this.studentGoalClarityPersonlastName = studentGoalClarityPersonlastName;
		this.studentGoalClarityPersonEmail = studentGoalClarityPersonEmail;
		this.studentGoalClarityPersonMobilePhone = studentGoalClarityPersonMobilePhone;
		this.studentGoalClarityPersonOtherPhone = studentGoalClarityPersonOtherPhone;
		this.schoolCounty = schoolCounty;
		this.schoolDistrict = schoolDistrict;
		this.schoolPricipalFirstName = schoolPricipalFirstName;
		this.schoolPricipallastName = schoolPricipallastName;
		this.schoolFreeText = schoolFreeText;
		this.schoolDeleteFlag = schoolDeleteFlag;
		this.lastModifiedBy = lastModifiedBy;
		
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress1() {
		return schoolAddress1;
	}

	public void setSchoolAddress1(String schoolAddress1) {
		this.schoolAddress1 = schoolAddress1;
	}

	public String getSchoolAddress2() {
		return schoolAddress2;
	}

	public void setSchoolAddress2(String schoolAddress2) {
		this.schoolAddress2 = schoolAddress2;
	}

	public String getSchoolCity() {
		return schoolCity;
	}

	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}

	public String getSchollSatetCd() {
		return schollSatetCd;
	}

	public void setSchollSatetCd(String schollSatetCd) {
		this.schollSatetCd = schollSatetCd;
	}

	public String getSchoolZipCd() {
		return schoolZipCd;
	}

	public void setSchoolZipCd(String schoolZipCd) {
		this.schoolZipCd = schoolZipCd;
	}

	public String getSchoolZipPlusCd() {
		return schoolZipPlusCd;
	}

	public void setSchoolZipPlusCd(String schoolZipPlusCd) {
		this.schoolZipPlusCd = schoolZipPlusCd;
	}

	public String getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public String getStudentGoalClarityPersonFirstName() {
		return studentGoalClarityPersonFirstName;
	}

	public void setStudentGoalClarityPersonFirstName(
			String studentGoalClarityPersonFirstName) {
		this.studentGoalClarityPersonFirstName = studentGoalClarityPersonFirstName;
	}

	public String getStudentGoalClarityPersonlastName() {
		return studentGoalClarityPersonlastName;
	}

	public void setStudentGoalClarityPersonlastName(
			String studentGoalClarityPersonlastName) {
		this.studentGoalClarityPersonlastName = studentGoalClarityPersonlastName;
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

	public String getSchoolCounty() {
		return schoolCounty;
	}

	public void setSchoolCounty(String schoolCounty) {
		this.schoolCounty = schoolCounty;
	}

	public String getSchoolDistrict() {
		return schoolDistrict;
	}

	public void setSchoolDistrict(String schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}

	public String getSchoolPricipalFirstName() {
		return schoolPricipalFirstName;
	}

	public void setSchoolPricipalFirstName(String schoolPricipalFirstName) {
		this.schoolPricipalFirstName = schoolPricipalFirstName;
	}

	public String getSchoolPricipallastName() {
		return schoolPricipallastName;
	}

	public void setSchoolPricipallastName(String schoolPricipallastName) {
		this.schoolPricipallastName = schoolPricipallastName;
	}

	public String getSchoolFreeText() {
		return schoolFreeText;
	}

	public void setSchoolFreeText(String schoolFreeText) {
		this.schoolFreeText = schoolFreeText;
	}

	public Boolean getSchoolDeleteFlag() {
		return schoolDeleteFlag;
	}

	public void setSchoolDeleteFlag(Boolean schoolDeleteFlag) {
		this.schoolDeleteFlag = schoolDeleteFlag;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "HugSchool [schoolId=" + schoolId + ", schoolName=" + schoolName
				+ ", schoolAddress1=" + schoolAddress1 + ", schoolAddress2="
				+ schoolAddress2 + ", schoolCity=" + schoolCity
				+ ", schollSatetCd=" + schollSatetCd + ", schoolZipCd="
				+ schoolZipCd + ", schoolZipPlusCd=" + schoolZipPlusCd
				+ ", schoolPhone=" + schoolPhone
				+ ", studentGoalClarityPersonFirstName="
				+ studentGoalClarityPersonFirstName
				+ ", studentGoalClarityPersonlastName="
				+ studentGoalClarityPersonlastName
				+ ", studentGoalClarityPersonEmail="
				+ studentGoalClarityPersonEmail
				+ ", studentGoalClarityPersonMobilePhone="
				+ studentGoalClarityPersonMobilePhone
				+ ", studentGoalClarityPersonOtherPhone="
				+ studentGoalClarityPersonOtherPhone + ", schoolCounty="
				+ schoolCounty + ", schoolDistrict=" + schoolDistrict
				+ ", schoolPricipalFirstName=" + schoolPricipalFirstName
				+ ", schoolPricipallastName=" + schoolPricipallastName
				+ ", schoolFreeText=" + schoolFreeText + ", schoolDeleteFlag="
				+ schoolDeleteFlag + ", lastModifiedBy=" + lastModifiedBy
				+ "]";
	}
	
}
