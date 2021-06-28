package com.censusapp.runtime;

import java.util.Scanner;

import com.censusapp.constant.Constants;
import com.censusapp.entities.Member;
import com.censusapp.service.MemberServiceImp;

public class GetMember {
	 static String appId;
	 String s,memberId;
     Scanner sc=new Scanner(System.in);
     MemberServiceImp memberServiceImp=new MemberServiceImp();
     public Member getMember(MemberFactory memfact, Integer i) throws Exception {
   	 
    	 Member m=new Member();
			
			setDetails(m);
			if(i == 0) {
				String str=m.getFirstName();
				if(str.length()>3) {
					str=str.substring(0, 3);
				}
				String str2=m.getLastName();
				if(str2.length()>3) {
					str2=str2.substring(0, 3);
				}
				appId = m.getGender().substring(0,1) + "-" + str + (m.getDob().replaceAll("/","") + str2);	
				m.setApplicationId(appId);
				
				boolean ret=memberServiceImp.addHeadMember(m);
				if(ret) {
					System.out.println("\n" +Constants.detailsAddedSuccessfully);
					System.out.println(Constants.applicationIdMessage + "->" + appId + "\n");
				}else {
					System.out.println(Constants.failedToAddHeadMember + "\n");
				}
			} else {
				Member headMember=memfact.getFamilyList().get(0);
				String str=m.getFirstName();
				appId=headMember.getApplicationId();
				if(str.length()>3) {
					str=str.substring(0, 3);
				}
				memberId=appId+str;
				m.setMemberId(memberId);
				m.setApplicationId(appId);
				if(memberServiceImp.addMember(m)) {
					System.out.println("\n" + Constants.detailsAddedSuccessfully);
					System.out.println(Constants.memberIdMessage + "->" + memberId + "\n");
				}else {
					System.out.println(Constants.failedToAddMember + "\n");
				}
				
			}
		return m;
     }
	public void setDetails(Member m) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("First Name: ");
		s = sc.nextLine();
		m.setFirstName(s);
		
		System.out.print("Middle Name: ");
		s = sc.nextLine();
		m.setMiddleName(s);
		
		System.out.print("Last Name : ");
		s = sc.nextLine();
		m.setLastName(s);
		
		System.out.print("Suffix : ");
		s = sc.nextLine();
		m.setSuffix(s);
		
		System.out.print("Date of birth (dd/MM/yyyy) : ");
		String dobstr = sc.nextLine();
		m.setDob(dobstr);
		
		System.out.print("Gender (Male|Female|Other): ");
		s = sc.nextLine();
		m.setGender(s);		
	}   
}
