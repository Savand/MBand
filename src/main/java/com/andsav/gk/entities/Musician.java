package com.andsav.gk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Musician{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String alias;
	
	@Column //TODO change to Enum
	private String gender;
	
	@Column //TODO change to Enum
	private String instrument;
	
	@Column
	private String company;
	
	@Column //TODO change to Enum
	private String role;
	

}
