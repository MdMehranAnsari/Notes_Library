package com.example.uploadingfiles;

import org.springframework.web.multipart.MultipartFile;


public class NoteWeb {
	private String grade;
	private String subject;
	private String chapter;
	private MultipartFile file;
	
	public NoteWeb() {
		
	}
	
	public NoteWeb(String grade, String subject, String chapter, MultipartFile file) {
		super();
		this.grade = grade;
		this.subject = subject;
		this.chapter = chapter;
		this.file = file;
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
