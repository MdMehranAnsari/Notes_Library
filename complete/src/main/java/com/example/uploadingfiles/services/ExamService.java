package com.example.uploadingfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadingfiles.dbpojo.ExamDB;
import com.example.uploadingfiles.repositories.ExamRepo;

@Service
public class ExamService {
	
	@Autowired
	private ExamRepo examRepo;
	
	public List<ExamDB> getAllExams()
	{
		return examRepo.findAll();
	}
	
	public ExamDB getExamById(int examId)
	{
		return examRepo.getReferenceById(examId);
	}
}
