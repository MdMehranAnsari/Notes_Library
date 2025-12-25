package com.example.uploadingfiles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uploadingfiles.NoteWeb;
import com.example.uploadingfiles.dbpojo.NoteDB;
import com.example.uploadingfiles.repositories.NoteRepo;

@Service
public class NoteService {
	
	@Autowired
	NoteRepo noterepo;
	
	public NoteDB webToDB(NoteWeb noteWeb)
	{
		return new NoteDB(0, noteWeb.getGrade(), noteWeb.getSubject(), noteWeb.getChapter(), noteWeb.getFile().getOriginalFilename());
	}
	
	public void addNote(NoteWeb noteWeb)
	{
		noterepo.save(webToDB(noteWeb));
	}
}
