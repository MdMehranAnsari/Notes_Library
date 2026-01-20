package com.example.uploadingfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadingfiles.dbpojo.ExamDB;

@Repository
public interface ExamRepo extends JpaRepository<ExamDB, Integer>{
	
}