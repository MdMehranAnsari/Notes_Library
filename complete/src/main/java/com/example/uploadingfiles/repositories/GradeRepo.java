package com.example.uploadingfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadingfiles.dbpojo.GradeDB;

@Repository
public interface GradeRepo extends JpaRepository<GradeDB, Integer>{
	
}