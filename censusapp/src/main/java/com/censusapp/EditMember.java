package com.censusapp;

import java.util.Scanner;

import com.censusapp.constant.Constants;
import com.censusapp.entities.Member;
import com.censusapp.runtime.GetMember;
import com.censusapp.service.MemberServiceImp;

public class EditMember {
    MemberServiceImp memServ=new MemberServiceImp();
    String s;
    Scanner sc=new Scanner(System.in);
	public void editMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		setDetails(member);
		System.out.print(Constants.relationshipToHead + member.getFirstName() + " with Head Member:");
		s = sc.nextLine();
		if(!s.equals("")) {
			member.setRelationship(s);
		}
		
		if(memServ.updateMember(member)) {
			System.out.println(Constants.updateMember);
		}else {
			System.out.println(Constants.FailedToUpdateMember);
		}
	}

	public void editHeadMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		setDetails(member);
		if(memServ.updateHeadMember(member)) {
			System.out.println(Constants.updateMember);
		}else {
			System.out.println(Constants.FailedToUpdateMember);
		}
	}
	public void setDetails(Member m) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("First Name: ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setFirstName(s);
		}
		System.out.print("Middle Name: ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setMiddleName(s);
		}
		
		System.out.print("Last Name : ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setLastName(s);
		}
	
		System.out.print("Suffix : ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setSuffix(s);
		}
		
		
		System.out.print("Date of birth (dd/MM/yyyy) : ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setDob(s);
		}
	
		
		System.out.print("Gender (Male|Female|Other): ");
		s = sc.nextLine();
		if(!s.equals("")) {
			m.setGender(s);		
		}
		
	}   

}
