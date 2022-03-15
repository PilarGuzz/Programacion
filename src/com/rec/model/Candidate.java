package com.rec.model;

import java.time.LocalDate;

public abstract class Candidate implements Comparable<Candidate>{
	
	
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
	
	public abstract Double computeGrossSalary(); 
	
	public int compareTo(Candidate o) {
		return 0;
	}

}
