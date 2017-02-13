package com.hug.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hug_sessionplanattempts")
public class HugSessionPlanAttempts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SPA_Id")
	private long spaId;
	
	@Column(name = "SPA_Student_id")
	private long spaStudentId;
	
	@Column(name = "SPA_School_Id")
	private long spaSchoolId;
	

	@Column(name = "SPA_Instructor_id")
	private long spaInstructorid;
	
	@Column(name = "SPA_Lession_Id")
	private long spaLessionId;
	
	@Column(name = "SPA_Original_Plan_Date")
	private String spaOriginalPlanDate;
	
	@Column(name = "SPA_Actual_Date")
	private String spaActualDate;
	
	@Column(name = "SPA_Total_Words")
	private long spaTotalWords;
	
	@Column(name = "SPA_First_Attempt_Fluency")
	private String spaFirstAttemptFluency;
	
	@Column(name = "SPA_First_Attempt_Wrong_Words")
	private long spaFirstAttemptWrongWords;
	
	@Column(name = "SPA_First_Attempt_SelfReportedMood")
	private String spaFirstAttemptSelfReportedMood;
	
	@Column(name = "SPA_Second_Attempt_Fluency")
	private String spaSecondAttemptFluency;
	
	@Column(name = "SPA_Second_Attempt_Wrong_Words")
	private long spaSecondAttemptWrongWords;
	
	@Column(name = "SPA_Second_Attempt_SelfReportedMood")
	private String spaSecondAttemptSelfReportedMood;
	
	@Column(name = "SPA_Delete_Flag")
	private Boolean spaDeleteFlag;
	
	@Column(name = "SPA_Activities_Done_Flag")
	private String spaActivitiesDoneFlag;
	
	@Column(name = "SPA_Free_Text")
	private String spaFreeText;
	
	@Column(name = "Last_Modified_By")
	private String lastModifiedBy;

	public HugSessionPlanAttempts() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public HugSessionPlanAttempts(long spaStudentId, long spaSchoolId,
			long spaInstructorid, long spaLessionId,
			String spaOriginalPlanDate, String spaActualDate,
			long spaTotalWords, String spaFirstAttemptFluency,
			long spaFirstAttemptWrongWords,
			String spaFirstAttemptSelfReportedMood,
			String spaSecondAttemptFluency, long spaSecondAttemptWrongWords,
			String spaSecondAttemptSelfReportedMood, Boolean spaDeleteFlag,
			String spaActivitiesDoneFlag, String spaFreeText,
			String lastModifiedBy) {
		super();
		this.spaStudentId = spaStudentId;
		this.spaSchoolId = spaSchoolId;
		this.spaInstructorid = spaInstructorid;
		this.spaLessionId = spaLessionId;
		this.spaOriginalPlanDate = spaOriginalPlanDate;
		this.spaActualDate = spaActualDate;
		this.spaTotalWords = spaTotalWords;
		this.spaFirstAttemptFluency = spaFirstAttemptFluency;
		this.spaFirstAttemptWrongWords = spaFirstAttemptWrongWords;
		this.spaFirstAttemptSelfReportedMood = spaFirstAttemptSelfReportedMood;
		this.spaSecondAttemptFluency = spaSecondAttemptFluency;
		this.spaSecondAttemptWrongWords = spaSecondAttemptWrongWords;
		this.spaSecondAttemptSelfReportedMood = spaSecondAttemptSelfReportedMood;
		this.spaDeleteFlag = spaDeleteFlag;
		this.spaActivitiesDoneFlag = spaActivitiesDoneFlag;
		this.spaFreeText = spaFreeText;
		this.lastModifiedBy = lastModifiedBy;
	}



	public long getSpaId() {
		return spaId;
	}



	public void setSpaId(long spaId) {
		this.spaId = spaId;
	}



	public long getSpaStudentId() {
		return spaStudentId;
	}



	public void setSpaStudentId(long spaStudentId) {
		this.spaStudentId = spaStudentId;
	}



	public long getSpaSchoolId() {
		return spaSchoolId;
	}



	public void setSpaSchoolId(long spaSchoolId) {
		this.spaSchoolId = spaSchoolId;
	}



	public long getSpaInstructorid() {
		return spaInstructorid;
	}



	public void setSpaInstructorid(long spaInstructorid) {
		this.spaInstructorid = spaInstructorid;
	}



	public long getSpaLessionId() {
		return spaLessionId;
	}



	public void setSpaLessionId(long spaLessionId) {
		this.spaLessionId = spaLessionId;
	}



	public String getSpaOriginalPlanDate() {
		return spaOriginalPlanDate;
	}



	public void setSpaOriginalPlanDate(String spaOriginalPlanDate) {
		this.spaOriginalPlanDate = spaOriginalPlanDate;
	}



	public String getSpaActualDate() {
		return spaActualDate;
	}



	public void setSpaActualDate(String spaActualDate) {
		this.spaActualDate = spaActualDate;
	}



	public long getSpaTotalWords() {
		return spaTotalWords;
	}



	public void setSpaTotalWords(long spaTotalWords) {
		this.spaTotalWords = spaTotalWords;
	}



	public String getSpaFirstAttemptFluency() {
		return spaFirstAttemptFluency;
	}



	public void setSpaFirstAttemptFluency(String spaFirstAttemptFluency) {
		this.spaFirstAttemptFluency = spaFirstAttemptFluency;
	}



	public long getSpaFirstAttemptWrongWords() {
		return spaFirstAttemptWrongWords;
	}



	public void setSpaFirstAttemptWrongWords(long spaFirstAttemptWrongWords) {
		this.spaFirstAttemptWrongWords = spaFirstAttemptWrongWords;
	}



	public String getSpaFirstAttemptSelfReportedMood() {
		return spaFirstAttemptSelfReportedMood;
	}



	public void setSpaFirstAttemptSelfReportedMood(
			String spaFirstAttemptSelfReportedMood) {
		this.spaFirstAttemptSelfReportedMood = spaFirstAttemptSelfReportedMood;
	}



	public String getSpaSecondAttemptFluency() {
		return spaSecondAttemptFluency;
	}



	public void setSpaSecondAttemptFluency(String spaSecondAttemptFluency) {
		this.spaSecondAttemptFluency = spaSecondAttemptFluency;
	}



	public long getSpaSecondAttemptWrongWords() {
		return spaSecondAttemptWrongWords;
	}



	public void setSpaSecondAttemptWrongWords(long spaSecondAttemptWrongWords) {
		this.spaSecondAttemptWrongWords = spaSecondAttemptWrongWords;
	}



	public String getSpaSecondAttemptSelfReportedMood() {
		return spaSecondAttemptSelfReportedMood;
	}



	public void setSpaSecondAttemptSelfReportedMood(
			String spaSecondAttemptSelfReportedMood) {
		this.spaSecondAttemptSelfReportedMood = spaSecondAttemptSelfReportedMood;
	}



	public Boolean getSpaDeleteFlag() {
		return spaDeleteFlag;
	}



	public void setSpaDeleteFlag(Boolean spaDeleteFlag) {
		this.spaDeleteFlag = spaDeleteFlag;
	}



	public String getSpaActivitiesDoneFlag() {
		return spaActivitiesDoneFlag;
	}



	public void setSpaActivitiesDoneFlag(String spaActivitiesDoneFlag) {
		this.spaActivitiesDoneFlag = spaActivitiesDoneFlag;
	}



	public String getSpaFreeText() {
		return spaFreeText;
	}



	public void setSpaFreeText(String spaFreeText) {
		this.spaFreeText = spaFreeText;
	}



	public String getLastModifiedBy() {
		return lastModifiedBy;
	}



	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}



	@Override
	public String toString() {
		return "HugSessionPlanAttempts [spaId=" + spaId + ", spaStudentId="
				+ spaStudentId + ", spaSchoolId=" + spaSchoolId
				+ ", spaInstructorid=" + spaInstructorid + ", spaLessionId="
				+ spaLessionId + ", spaOriginalPlanDate=" + spaOriginalPlanDate
				+ ", spaActualDate=" + spaActualDate + ", spaTotalWords="
				+ spaTotalWords + ", spaFirstAttemptFluency="
				+ spaFirstAttemptFluency + ", spaFirstAttemptWrongWords="
				+ spaFirstAttemptWrongWords
				+ ", spaFirstAttemptSelfReportedMood="
				+ spaFirstAttemptSelfReportedMood
				+ ", spaSecondAttemptFluency=" + spaSecondAttemptFluency
				+ ", spaSecondAttemptWrongWords=" + spaSecondAttemptWrongWords
				+ ", spaSecondAttemptSelfReportedMood="
				+ spaSecondAttemptSelfReportedMood + ", spaDeleteFlag="
				+ spaDeleteFlag + ", spaActivitiesDoneFlag="
				+ spaActivitiesDoneFlag + ", spaFreeText=" + spaFreeText
				+ ", lastModifiedBy=" + lastModifiedBy + "]";
	}
	
	
	
}
