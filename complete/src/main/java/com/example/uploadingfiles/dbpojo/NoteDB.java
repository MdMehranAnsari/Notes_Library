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
	@Column(name="note_grade")
	private String grade;
	@Column(name="note_subject")
	private String subject;
	@Column(name="note_chapter")
	private String chapter;
	@Column(name="og_file_name")
	private String fileName;
	
	public NoteDB() {
		
	}

	public NoteDB(int id, String grade, String subject, String chapter, String fileName) {
		super();
		this.id = id;
		this.grade = grade;
		this.subject = subject;
		this.chapter = chapter;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "NoteDB [id=" + id + ", grade=" + grade + ", subject=" + subject + ", chapter=" + chapter + ", fileName="
				+ fileName + "]";
	}
	
}