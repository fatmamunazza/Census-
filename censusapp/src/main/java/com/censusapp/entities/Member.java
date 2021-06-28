/**
 * 
 */
package com.censusapp.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.censusapp.exceptions.EmptyFieldException;
import com.censusapp.exceptions.InvalidDateException;

public class Member {
	
	private String applicationId;
	private String memberId;
	private String suffix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private String relationship;
	//private HashMap<String,Relation> relation;
	public Member(String firstName,String middleName,String lastName,String suffix,String dob,String gender) {
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.suffix=suffix;
		this.middleName=middleName;
		this.dob=dob;
		this.gender=gender;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public Member() {
		
	}
	public String getApplicationId() {
		return applicationId;
	}
	public Boolean setApplicationId(String applicationId) throws Exception {
		if(applicationId==null || applicationId.isEmpty())
			throw new EmptyFieldException("Application ID is a mandatory field");
		this.applicationId = applicationId;
		return true;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public Boolean setMemberId(String memberId) throws Exception {
		if(memberId==null || memberId.isEmpty())
			throw new EmptyFieldException("Member ID is a mandatory field");
		this.memberId = memberId;
		return true;
	}
	public String getSuffix() {
		return suffix;
	}
	public Boolean setSuffix(String suffix) {
		this.suffix = suffix;
		return true;
	}
	public String getFirstName() {
		return firstName;
	}
	public Boolean setFirstName(String firstName) throws Exception{
		if(firstName==null || firstName.isEmpty()) 
			throw new EmptyFieldException("First name is a mandatory field");
		
		this.firstName = firstName;
		return true;
	}
	public String getMiddleName() {
		return middleName;
	}
	public Boolean setMiddleName(String middleName) {
		this.middleName = middleName;
		return true;
	}
	public String getLastName() {
		return lastName;
	}
	public Boolean setLastName(String lastName) throws Exception {
		if(lastName==null || lastName.isEmpty()) 
			throw new EmptyFieldException("Last name is a mandatory field");
		
		this.lastName = lastName;
		return true;
	}
	public String getDob() {
		return dob;
	}
	public Boolean setDob(String dob) throws Exception {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=null;
		try {
			date=LocalDate.parse(dob,dtf);
		}catch(Exception ex){
			throw new InvalidDateException();
		}
		this.dob =dob;
		return true;
	}
	public String getGender() {
		return gender;
	}
	public Boolean setGender(String gender) {
		this.gender = gender;
		return true;
	}	
}
