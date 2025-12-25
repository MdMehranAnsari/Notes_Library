package com.example.uploadingfiles.dbpojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="school_board")
public class SchoolBoardDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_board_id")
	private int id;
	@Column(name="school_board_name")
	private String name;
	
	public SchoolBoardDB() {
		
	}

	public SchoolBoardDB(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}