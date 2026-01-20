package com.example.uploadingfiles.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.uploadingfiles.FileUploadController;
import com.example.uploadingfiles.NoteWeb;
import com.example.uploadingfiles.NoteWebView;
import com.example.uploadingfiles.dbpojo.NoteDB;
import com.example.uploadingfiles.repositories.NoteRepo;
import com.example.uploadingfiles.storage.StorageService;

@Service
public class NoteService {
	
	@Autowired
	NoteRepo noteRepo;
	@Autowired
	ExamService examService;
	@Autowired
	GradeService gradeService;
	@Autowired
	SchoolBoardService schoolBoardSevice;
	@Autowired
	StorageService storageService;
	
	public NoteDB webToDB(NoteWeb noteWeb)
	{
		//get the filename without the file path, platform independent 
		String fileName = noteWeb.getFile().getOriginalFilename();
		int startIndex = fileName.replaceAll("\\\\", "/").lastIndexOf('/');
		fileName = fileName.substring(startIndex + 1);
		
		return new NoteDB(0, noteWeb.getChapter(), noteWeb.getSubject(), noteWeb.getExamId(), noteWeb.getDescription(), noteWeb.getGradeId(), noteWeb.getSchoolBoardId(), noteWeb.getInstitute(), fileName);
	}
	
	public NoteWebView dbToWebView(NoteDB noteDB)
	{
		return new NoteWebView(
			Integer.toString(noteDB.getId()),
			MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", noteDB.getFileName()).build().toUri().toString(),
			MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile1", noteDB.getFileName()).build().toUri().toString(),
			noteDB.getFileName(),
			noteDB.getSubject(),
			noteDB.getChapter(),
			examService.getExamById(noteDB.getExamId()).toString(),
			noteDB.getDescription(),
			gradeService.getGradeById(noteDB.getGradeId()).toString(),
			schoolBoardSevice.getSchoolBoardById(noteDB.getSchoolBoardId()).toString(),
			noteDB.getInstitue()
		);
	}
	
	public void addNote(NoteWeb noteWeb)
	{
		noteRepo.save(webToDB(noteWeb));
	}
	
	public List<NoteDB> getAllNotes()
	{
		return noteRepo.findAll();
	}
	
	public NoteDB getNoteById(int noteId)
	{
		return noteRepo.getReferenceById(noteId);
	}
	
	public List<NoteDB> getNotesBySearch(String query)
	{
		List<NoteDB> allNotesList = noteRepo.findAll();
		List<NoteDB> responseList = new ArrayList<>();
		
		String words[] = query.trim().split("[^a-zA-Z0-9]+"); //splits the query expression into separate words with length more than 0 based on non alphabetic characters as separators
		int wordsCount = words.length;
		int matchIndex[] = new int[wordsCount];
		
		int i;
		for(i=0; i<wordsCount; i++)
		{
			matchIndex[i] = -1;
		}
		
		int matchCount = 0;
		for(NoteDB noteDB : allNotesList)
		{
			matchCount = 0;
			for(String word: words)
			{
				if(noteDB.getChapter().toLowerCase().contains(word.toLowerCase()) ||
					noteDB.getSubject().toLowerCase().contains(word.toLowerCase()) ||
					noteDB.getDescription().toLowerCase().contains(word.toLowerCase()))
				{
					matchCount++;
				}
			}
			
			if(matchCount > 0)
			{
				responseList.add(++matchIndex[matchCount-1], noteDB);
				for(i = matchCount-2; i >= 0; i--)
				{
					matchIndex[i]++;
				}
			}
		}
		return responseList;
	}
}
