package com.example.uploadingfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uploadingfiles.dbpojo.SchoolBoardDB;

@Repository
public interface SchoolBoardRepo extends JpaRepository<SchoolBoardDB,Integer>{

}
