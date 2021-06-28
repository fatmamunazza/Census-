package com.censusapp.runtime;

import java.util.List;

import com.censusapp.constant.Constants;
import com.censusapp.entities.Member;

public class DisplayDetails {
	
	public void printFamily(List<Member> list) {
		// TODO Auto-generated method stub
		printHeadMember(list.get(0),list.size());
		for(int i=1;i<list.size();i++) {
			if(i==1) {
				printWithBreak("\nFamily Members");
			}
			printFamilyMembers(list.get(0).getFirstName(),list.get(i),i,list.size());
			printWithBreak("");
		}
		
	}

	private void printFamilyMembers(String headName, Member member, int i, int size) {
		// TODO Auto-generated method stub
		printWithBreak("Enter " + (i+1) + " to edit " + member.getFirstName() + " details");
		printWithBreak("Enter " + (size+i+1) + " to remove " + member.getFirstName() + " details\n");
		printWithBreak("First Name : " +member.getFirstName());
		printWithBreak("Middle Name : " +member.getMiddleName());
		printWithBreak("Last Name : " +member.getLastName());
		printWithBreak("Suffix : " +member.getSuffix());
		printWithBreak("Date of Birth : " +member.getDob());
		printWithBreak("Gender : " +member.getGender());
		printWithBreak("Relation of " + headName + " with " + member.getFirstName() + " is " +member.getRelationship());
	}

	private void printHeadMember(Member member, int i) {
		// TODO Auto-generated method stub
		printWithBreak("Head Family Member");
		printWithBreak("Enter 1 to edit\nEnter " + (i+1) + " to delete\n");
		printWithBreak("First Name : " +member.getFirstName());
		printWithBreak("Middle Name : " +member.getMiddleName());
		printWithBreak("Last Name : " +member.getLastName());
		printWithBreak("Suffix : " +member.getSuffix());
		printWithBreak("Date of Birth : " +member.getDob());
		printWithBreak("Gender : " +member.getGender());
	}

	private void printWithBreak(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
		
	}

	private void printWithoutBreak(String str) {
		// TODO Auto-generated method stub
		System.out.print(str);
	}
}
