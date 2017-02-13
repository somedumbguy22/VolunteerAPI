package com.hug.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hug_lessons")
public class HugLessons {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Lesson_id")
	private long lessonId;
	
	@Column(name = "Lesson_Title")
	private String lessonTitle;
	
	@Column(name = "Lesson_Theme")
	private String lessonTheme;
	
	@Column(name = "Lesson_Level")
	private String lessonLevel;
	
	@Column(name = "Lesson_Grade")
	private String lessonGrade;
	
	@Column(name = "Lesson_Total_Words")
	private int lessonTotalWords;
	
	@Column(name = "Lesson_Workbook_Name")
	private String lessonWorkbookName;
	
	@Column(name = "Lesson_Free_Text")
	private String lessonFreeText;
	
	@Column(name = "Lesson_TipsnTricks")
	private String lessonTipsnTricks;
	
	@Column(name = "Lesson_Challenging_Words")
	private String lessonChallengingWords;
	
	@Column(name = "Lesson_Activities_Notes")
	private String lessonActivitiesNotes;
	
	@Column(name = "Lesson_Delete_Flag")
	private Boolean lessonDeleteFlag;
	
	@Column(name = "Last_Modified_By")
	private String lastModifiedBy;

	public HugLessons(String lessonTitle, String lessonTheme,
			String lessonLevel, String lessonGrade, int lessonTotalWords,
			String lessonWorkbookName, String lessonFreeText,
			String lessonTipsnTricks, String lessonChallengingWords,
			String lessonActivitiesNotes, Boolean lessonDeleteFlag,
			String lastModifiedBy) {
		this.lessonTitle = lessonTitle;
		this.lessonTheme = lessonTheme;
		this.lessonLevel = lessonLevel;
		this.lessonGrade = lessonGrade;
		this.lessonTotalWords = lessonTotalWords;
		this.lessonWorkbookName = lessonWorkbookName;
		this.lessonFreeText = lessonFreeText;
		this.lessonTipsnTricks = lessonTipsnTricks;
		this.lessonChallengingWords = lessonChallengingWords;
		this.lessonActivitiesNotes = lessonActivitiesNotes;
		this.lessonDeleteFlag = lessonDeleteFlag;
		this.lastModifiedBy = lastModifiedBy;
	}

	public HugLessons() {
		
	}

	public long getLessonId() {
		return lessonId;
	}

	public void setLessonId(long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonTitle() {
		return lessonTitle;
	}

	public void setLessonTitle(String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}

	public String getLessonTheme() {
		return lessonTheme;
	}

	public void setLessonTheme(String lessonTheme) {
		this.lessonTheme = lessonTheme;
	}

	public String getLessonLevel() {
		return lessonLevel;
	}

	public void setLessonLevel(String lessonLevel) {
		this.lessonLevel = lessonLevel;
	}

	public String getLessonGrade() {
		return lessonGrade;
	}

	public void setLessonGrade(String lessonGrade) {
		this.lessonGrade = lessonGrade;
	}

	public int getLessonTotalWords() {
		return lessonTotalWords;
	}

	public void setLessonTotalWords(int lessonTotalWords) {
		this.lessonTotalWords = lessonTotalWords;
	}

	public String getLessonWorkbookName() {
		return lessonWorkbookName;
	}

	public void setLessonWorkbookName(String lessonWorkbookName) {
		this.lessonWorkbookName = lessonWorkbookName;
	}

	public String getLessonFreeText() {
		return lessonFreeText;
	}

	public void setLessonFreeText(String lessonFreeText) {
		this.lessonFreeText = lessonFreeText;
	}

	public String getLessonTipsnTricks() {
		return lessonTipsnTricks;
	}

	public void setLessonTipsnTricks(String lessonTipsnTricks) {
		this.lessonTipsnTricks = lessonTipsnTricks;
	}

	public String getLessonChallengingWords() {
		return lessonChallengingWords;
	}

	public void setLessonChallengingWords(String lessonChallengingWords) {
		this.lessonChallengingWords = lessonChallengingWords;
	}

	public String getLessonActivitiesNotes() {
		return lessonActivitiesNotes;
	}

	public void setLessonActivitiesNotes(String lessonActivitiesNotes) {
		this.lessonActivitiesNotes = lessonActivitiesNotes;
	}

	public Boolean getLessonDeleteFlag() {
		return lessonDeleteFlag;
	}

	public void setLessonDeleteFlag(Boolean lessonDeleteFlag) {
		this.lessonDeleteFlag = lessonDeleteFlag;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "HugLessons [lessonId=" + lessonId + ", lessonTitle="
				+ lessonTitle + ", lessonTheme=" + lessonTheme
				+ ", lessonLevel=" + lessonLevel + ", lessonGrade="
				+ lessonGrade + ", lessonTotalWords=" + lessonTotalWords
				+ ", lessonWorkbookName=" + lessonWorkbookName
				+ ", lessonFreeText=" + lessonFreeText + ", lessonTipsnTricks="
				+ lessonTipsnTricks + ", lessonChallengingWords="
				+ lessonChallengingWords + ", lessonActivitiesNotes="
				+ lessonActivitiesNotes + ", lessonDeleteFlag="
				+ lessonDeleteFlag + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

	
}
