package com.censusapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.censusapp.entities.Member;

class MemberTest {
    Member m=new Member();
    public String familyId;
	public String memberId;
	public String firstName; 
	public String middleName; 
	public String lastName;
	public String dob; 
	public String gender; 
	public Boolean isHead;
	@Test
	void isValidFirstName() {
		firstName="Munazza";
		try {
			m.setFirstName(firstName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(firstName,m.getFirstName());
	}
	
	@Test
	void isEmptyFirstName() {
		firstName="";
		try {
			m.setFirstName(firstName);
		} catch (Exception e) {
			assertEquals("First Name field can't be empty",e.getMessage());
		}		
	}
	
	@Test
	public void validDob() {
		dob = "15/03/1998";
		try {
			assertTrue(m.setDob(dob));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void validMiddleName(){
		middleName="Fatma";
		try {
			m.setMiddleName(middleName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(middleName,m.getMiddleName());
	}

	@Test
	public void emptyMiddleName() {
		middleName = "";
		try {
			m.setMiddleName(middleName);
		} catch (Exception e) {
			assertEquals("Middle Name field can't be empty", e.getMessage());
		}
	}
	
	@Test
	public void validLastName(){
	    lastName = "Ali";
		try {
			assertTrue(m.setLastName(lastName));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void emptyLastName() {
		 lastName = "";
		try {
			m.setLastName(lastName);
		} catch (Exception e) {
			assertEquals("Last Name field can't be empty", e.getMessage());
		}
	}

}
