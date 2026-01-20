package com.example.uploadingfiles;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public class NoteWebView {
	private String fileId; 
	private String fileDownloadResource;
	private String fileEmbedResource;
	private String fileName;
	private String subject;
	private String chapter;
	private String exam;
	private String description;
	private String grade;
	private String schoolBoard;
	private String institute;
	
	public NoteWebView() {
		
	}
	
	public NoteWebView(String fileId, String fileDownloadResource, String fileEmbedResource, String fileName, String subject, String chapter, String exam, String description,
			String grade, String schoolBoard, String institute) {
		super();
		this.fileId = fileId;
		this.fileDownloadResource = fileDownloadResource;
		this.fileEmbedResource = fileEmbedResource;
		this.fileName = fileName;
		this.subject = subject;
		this.chapter = chapter;
		this.exam = exam;
		this.description = description;
		this.grade = grade;
		this.schoolBoard = schoolBoard;
		this.institute = institute;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileDownloadResource() {
		return fileDownloadResource;
	}

	public void setFileDownloadResource(String fileDownloadResource) {
		this.fileDownloadResource = fileDownloadResource;
	}

	public String getFileEmbedResource() {
		return fileEmbedResource;
	}

	public void setFileEmbedResource(String fileEmbedResource) {
		this.fileEmbedResource = fileEmbedResource;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSchoolBoard() {
		return schoolBoard;
	}

	public void setSchoolBoard(String schoolBoard) {
		this.schoolBoard = schoolBoard;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
}