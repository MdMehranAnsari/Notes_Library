package com.example.uploadingfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadingfiles.dbpojo.SchoolBoardDB;
import com.example.uploadingfiles.repositories.SchoolBoardRepo;

@Service
public class SchoolBoardService {
	
	@Autowired
	private SchoolBoardRepo schoolBoardRepo;
	
	public List<SchoolBoardDB> getAllSchoolBoards()
	{
		return schoolBoardRepo.findAll();
	}
	
	public SchoolBoardDB getSchoolBoardById(int schoolBoardId)
	{
		return schoolBoardRepo.getReferenceById(schoolBoardId);
	}
}