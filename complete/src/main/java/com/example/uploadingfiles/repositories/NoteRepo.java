package com.example.uploadingfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadingfiles.dbpojo.NoteDB;

@Repository
public interface NoteRepo extends JpaRepository<NoteDB, Integer>{
	
}