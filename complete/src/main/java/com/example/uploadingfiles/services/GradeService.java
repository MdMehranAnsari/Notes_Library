package com.example.uploadingfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadingfiles.dbpojo.GradeDB;
import com.example.uploadingfiles.repositories.GradeRepo;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepo gradeRepo;
	
	public List<GradeDB> getAllGrades()
	{
		return gradeRepo.findAll();
	}
	
	public GradeDB getGradeById(int gradeId)
	{
		return gradeRepo.getReferenceById(gradeId);
	}
}
