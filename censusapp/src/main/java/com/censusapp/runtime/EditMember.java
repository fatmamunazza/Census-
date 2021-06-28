/**
 * 
 */
package com.censusapp.runtime;

import java.util.Scanner;

import com.censusapp.entities.Member;

public class EditMember {
	  static Scanner sc=new Scanner(System.in);
	  static String s;
	 
	public static  Member edit(String appId,String memId,Member m) throws Exception {
		System.out.print("First Name: ");
			s = sc.next();
			m.setFirstName(s);
			
			System.out.print("Middle Name: ");
			s = sc.next();
			m.setMiddleName(s);
			
			System.out.print("Last Name : ");
			s = sc.next();
			m.setLastName(s);
			
			System.out.print("Suffix : ");
			s = sc.next();
			m.setSuffix(s);
			
			System.out.print("Date of birth (dd/mm/yyyy) : ");
			String dobstr = sc.next();
			m.setDob(dobstr);
			
			System.out.print("Gender (Male|Female|Other): ");
			s = sc.next();
			m.setGender(s);
			
			m.setApplicationId(appId);
			m.setMemberId(memId);
			
			return m;
			
			
	}
}
