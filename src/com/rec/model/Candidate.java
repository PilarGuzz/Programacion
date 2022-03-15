package com.rec.model;

import java.time.LocalDate;

public class Candidate{
	
	
	private LocalDate dateOfBirth;
	private LocalDate startDate;
	private String dni;
	private String name;
	private String surname;
	private ContractType ct;
	private boolean inProject;
	
	
	//constructor
	public Candidate(String dni, String name) { //Crea candidatos
		this.dni = dni;
		this.name = name;
	}

}
