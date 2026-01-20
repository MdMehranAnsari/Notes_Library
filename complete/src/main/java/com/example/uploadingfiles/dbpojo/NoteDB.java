package com.example.uploadingfiles.dbpojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notes")
public class NoteDB
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="note_id")
	private int id;
	
	@Column(name="note_chapter")
	private String chapter;
	@Column(name="note_subject")
	private String subject;
	@Column(name="note_exam_id")
	private int examId;
	@Column(name="note_description")
	private String description;
	@Column(name="note_grade_id")
	private int gradeId;
	@Column(name="note_school_board_id")
	private int schoolBoardId;
	@Column(name="note_institute")
	private String institue;
	@Column(name="note_og_file_name")
	private String fileName;
	
	public NoteDB() {
		
	}

	public NoteDB(int id, String chapter, String subject, int examId, String description, int gradeId,
			int schoolBoardId, String institue, String fileName) {
		super();
		this.id = id;
		this.chapter = chapter;
		this.subject = subject;
		this.examId = examId;
		this.description = description;
		this.gradeId = gradeId;
		this.schoolBoardId = schoolBoardId;
		this.institue = institue;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getSchoolBoardId() {
		return schoolBoardId;
	}

	public void setSchoolBoardId(int schoolBoardId) {
		this.schoolBoardId = schoolBoardId;
	}

	public String getInstitue() {
		return institue;
	}

	public void setInstitue(String institue) {
		this.institue = institue;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
}