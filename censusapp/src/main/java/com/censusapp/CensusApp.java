package com.censusapp;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.censusapp.constant.Constants;
import com.censusapp.dao.MemberDAO;
import com.censusapp.dao.MemberDaoImpl;
import com.censusapp.entities.Member;
import com.censusapp.exceptions.InvalidDateException;
import com.censusapp.runtime.AddMember;
import com.censusapp.runtime.DisplayDetails;
import com.censusapp.runtime.MemberFactory;
import com.censusapp.service.MemberServiceImp;

public class CensusApp {

	static Scanner sc=new Scanner(System.in);
	static int index=0;
	public static Statement myStat=null;
	public static ResultSet myRes=null;
	public static void main(String[] args) throws Exception {
		
		System.out.println("*******************WELCOME TO CENSUS APPLICATION*******************");
		
		MemberDaoImpl m=new MemberDaoImpl();
		m.startDatabaseConnection();
		
		firstScreenMethod();
		
	}

	private static void firstScreenMethod() throws Exception {
		// TODO Auto-generated method stub
		printMethod("Create Application: Enter 1");
		printMethod("Search Application: Enter 2");
		printMethod("Exit Application: Enter 3");
		int select=sc.nextInt();
		
		if(select==1) {
			printMethod("1." + Constants.addDetails);
			printMethod("2." + Constants.backToHomeScreen);
			printMethodWithoutBreak(Constants.enterChoice);
			int choice=sc.nextInt();
			if(choice==1) {
				addDetailsOfHeadMember();
			}else if(choice==2) {
				firstScreenMethod();
			}else {
				printMethod(Constants.incorrectOption);
			}
		}else if(select==2) {
			searchApplication();
		}else if(select==3){
			System.out.println(Constants.exitApplicationMessage);
			System.exit(0);
		}else {
			printMethod(Constants.incorrectOption);
		}
	}
	

	private static void addDetailsOfHeadMember() throws Exception {
		// TODO Auto-generated method stub
		printMethod("Enter the details of Head of the family");
		MemberFactory family=new MemberFactory();
		AddMember addMember = new AddMember();
		boolean check=addMember.addMember(family, index);
		if(check) {
			while(true) {
				printMethod("1." + Constants.addMember);
				printMethod("2." + Constants.next);
				printMethod("3." + Constants.backToHomeScreen);
				printMethod("4." + Constants.saveAndExit);	
				printMethodWithoutBreak(Constants.enterChoice);	
				int select=sc.nextInt();
				switch(select) {
				case 1:
					addMember.addMember(family, ++index);
					break;
				case 2:
					if(index==0) {
						printMethod(Constants.applicationsubmitted + "\n");
						firstScreenMethod();
					}else {
						setRelationship(family.familyList);	
					}
					break;
				case 3:
					firstScreenMethod();
					break;
				case 4:
					System.out.println(Constants.exitApplicationMessage);
					System.exit(0);
					break;
				default:
					printMethod(Constants.incorrectOption);
					break;
				}
			}
		}else {
			firstScreenMethod();
		}
		
		

	}

	private static void setRelationship(List<Member> familyList) throws Exception {
		// TODO Auto-generated method stub
	   int size=familyList.size();
	   printMethod("");
	   for(int i=1;i<size;i++) {
		   printMethod(Constants.relationshipToHead + familyList.get(0).getFirstName() + " with " + familyList.get(i).getFirstName() + ":");
		   String relationship=sc.next();
		   familyList.get(i).setRelationship(relationship);
		   MemberServiceImp memberServiceImp=new MemberServiceImp();
		   if(memberServiceImp.setRelationship(familyList.get(i).getMemberId(),relationship)) {
			   printMethod(Constants.relationshipSetSuccessfully);
		   }else {
			   printMethod(Constants.failedToSetRelationship + "\n");
		   }
		   
	   }
	    printMethod(Constants.applicationsubmitted + "\n");
	    printMethod("1." + Constants.backToHomeScreen);
		printMethod("2." + Constants.saveAndExit);	
		printMethodWithoutBreak(Constants.enterChoice);	
		int select=sc.nextInt();
		switch(select) {
		case 1:
			printMethod("");
			firstScreenMethod();
			break;
		case 2:
			System.exit(0);
			System.out.println("\n" + Constants.exitApplicationMessage);
			break;
		default:
			printMethod(Constants.incorrectOption);
			break;
		}
	}

	public static void printMethod(String str) {
		System.out.println(str);
	}
	public static void printMethodWithoutBreak(String str) {
		System.out.print(str);
	}
	private static void searchApplication() throws Exception {
		// TODO Auto-generated method stub
		printMethod(Constants.search);
		printMethod("1." + Constants.searchByApplicationId);
		printMethod("2." + Constants.searchbyfields);
		printMethod("3." + Constants.backToHomeScreen);
		printMethod(Constants.enterChoice);
		int select=sc.nextInt();
		switch(select) {
		case 1:
			searchByApplicationId();
			break;
		case 2:
			searchByAnyField();
			break;
		case 3:
			firstScreenMethod();
			break;
		default:
			printMethod(Constants.incorrectOption);
			break;
		}
		
	}

	private static void searchByAnyField() throws Exception {
		// TODO Auto-generated method stub
		sc.nextLine();
		printMethodWithoutBreak("First Name:");
		String firstName=sc.nextLine();
		printMethodWithoutBreak("Last Name:");
		String lastName=sc.nextLine();
		printMethodWithoutBreak("DOB(dd/MM/yyyy):");
		String dob=sc.nextLine();
		if(!dob.equals("")) {
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date=null;
			try {
				date=LocalDate.parse(dob,dtf);
			}catch(Exception ex){
				throw new InvalidDateException();
			}
		}
		
		//String firstName=sc.nextLine();
	    if(firstName.equals("") && lastName.equals("") && dob.equals("")) {
	    	printMethod(Constants.noSearchField + "\n");
	    }else {
	    	printMethod(Constants.notImplemented);
	    }
	    searchApplication();
	}

	private static void searchByApplicationId() throws Exception {
		// TODO Auto-generated method stub
		sc.nextLine();
		printMethodWithoutBreak("Application ID:");
		String applicationId=sc.nextLine();
	    if(applicationId.equals("")) {
	    	printMethod(Constants.searchFieldEmpty + "\n");
	    	searchApplication();
	    }else {
	    	MemberServiceImp meberServiceImp=new MemberServiceImp();
	    	List<Member> list=meberServiceImp.findAllMembersByApplicationId(applicationId);
	    	int size=list.size();
	    	if(size>=1) {
	    		DisplayDetails displayDetails=new DisplayDetails();
		    	displayDetails.printFamily(list);
		        printMethod(Constants.enterChoice);
		        int select=sc.nextInt();
		        if(select>=1 && select<=size) {
		        	EditMember editMember=new EditMember();
		        	if(select==1) {
		        		editMember.editHeadMember(list.get(select-1));
		        	}else {
		        		editMember.editMember(list.get(select-1));	
		        	}
		        	//printMethod(Constants.notImplemented);
		        }else if(select>size && select<=2*size){
		        	if(select==(size+1)) {
		        		printMethod(Constants.deleteWarning);
		        		printMethod(Constants.confirmDelete);
		        		int confirm=sc.nextInt();
		        		if(confirm==1) {
		        			meberServiceImp.deleteHeadMember(list.get(select-size-1));
		        		}else {
		        		   searchApplication();
		        		}
		        	}else {
		        		meberServiceImp.deleteMember(list.get(select-size-1));
		        	}
		        }else {
		        	printMethod(Constants.incorrectOption);
		        }
			}else {
				printMethod(Constants.noDetailsFound);
			}
	    	searchApplication();
	    }
	}
}
