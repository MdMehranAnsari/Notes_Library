package com.example.uploadingfiles;

import org.springframework.web.multipart.MultipartFile;


public class NoteWeb {
	private MultipartFile file;
	private String subject;
	private String chapter;
	private int examId;
	private String description;
	private int gradeId;
	private int schoolBoardId;
	private String institute;
	
	public NoteWeb() {
		
	}

	public NoteWeb(MultipartFile file, String subject, String chapter, int examId, String description, int gradeId,
			int schoolBoardId, String institute) {
		super();
		this.file = file;
		this.subject = subject;
		this.chapter = chapter;
		this.examId = examId;
		this.description = description;
		this.gradeId = gradeId;
		this.schoolBoardId = schoolBoardId;
		this.institute = institute;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	@Override
	public String toString() {
		return "NoteWeb [file=" + file + ", subject=" + subject + ", chapter=" + chapter + ", examId=" + examId
				+ ", description=" + description + ", gradeId=" + gradeId + ", schoolBoardId=" + schoolBoardId
				+ ", institute=" + institute + "]";
	}
	
	
}
