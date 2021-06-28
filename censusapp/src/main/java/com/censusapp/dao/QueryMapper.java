package com.censusapp.dao;

import com.censusapp.entities.Member;

public interface QueryMapper {

	public static final String createHeadMemberTable = "CREATE TABLE if not exists APPLICATION_HEAD_INFO" + "("
			+ " APPLICATION_ID VARCHAR(20)," 
			+ " HEAD_FIRST_NAME VARCHAR(30)," 
			+ " HEAD_MIDDLE_NAME VARCHAR(30),"
			+ " HEAD_LAST_NAME VARCHAR(30)," 
			+ " SUFFIX VARCHAR(10)," 
			+ " DATE_OF_BIRTH  VARCHAR(15)," 
			+ " GENDER VARCHAR(10),"
			+ " STATUS VARCHAR(20)," 
			+ " CONSTRAINT APP_HEAD_INFO_PK PRIMARY KEY(APPLICATION_ID)" + ");";

	public static final String createMemberTable = "CREATE TABLE if not exists APPLICATION_MEMBER_INFO(" 
			+ " APPLICATION_ID VARCHAR(20),"
			+ " MEMBER_ID VARCHAR(20),"
			+ " MEMBER_FIRST_NAME VARCHAR(30)," 
	        + " MEMBER_MIDDLE_NAME VARCHAR(30)," 
			+ " MEMBER_LAST_NAME VARCHAR(30),"
			+ " SUFFIX VARCHAR(10)," 
			+ " DATE_OF_BIRTH  VARCHAR(15)," 
			+ " GENDER VARCHAR(10)," 
			+ " RELATION VARCHAR(20)," 
			+ " CONSTRAINT APP_MEM_INFO_PK PRIMARY KEY(MEMBER_ID),"
			+ " CONSTRAINT APP_HEAD_INFO_FK FOREIGN KEY(APPLICATION_ID) REFERENCES APPLICATION_HEAD_INFO(APPLICATION_ID)"
			+ ");";

	public static String insertInMemberTable(Member m) {
		// TODO Auto-generated method stub
		String str="insert into APPLICATION_MEMBER_INFO(APPLICATION_ID,MEMBER_ID,MEMBER_FIRST_NAME,MEMBER_MIDDLE_NAME,MEMBER_LAST_NAME,SUFFIX,DATE_OF_BIRTH,GENDER,RELATION) "
				+ "values ("+"'"+ m.getApplicationId() + "','" + m.getMemberId() + "','" 
				+ m.getFirstName() + "','" + m.getMiddleName() + "','" 
				+ m.getLastName() + "','" + m.getSuffix() + "','" + m.getDob().toString() + "','" 
				+ m.getGender() + "','" +  "')";
		return str;
	}

	public static String insertInHeadMemberTable(Member m) {
		// TODO Auto-generated method stub
		String str= "INSERT INTO APPLICATION_HEAD_INFO(APPLICATION_ID,HEAD_FIRST_NAME,HEAD_MIDDLE_NAME,HEAD_LAST_NAME,SUFFIX,DATE_OF_BIRTH,GENDER,STATUS) VALUES('"
				+ m.getApplicationId() + "','" 
				+ m.getFirstName() + "','" + m.getMiddleName() + "','" 
				+ m.getLastName() + "','" + m.getSuffix() + "','" + m.getDob().toString() + "','" 
				+ m.getGender() + "','" + " '"+");";
		return str;
	}

	public static String insertRelationMemberTable(String memberId, String relationship) {
		// TODO Auto-generated method stub
		String str= "UPDATE APPLICATION_MEMBER_INFO SET RELATION='" + relationship + "' where MEMBER_ID='" + memberId + "';";
		return str;
	}

	public static String getHeadMember(String applicationId) {
		// TODO Auto-generated method stub
		String str= "select * from APPLICATION_HEAD_INFO where APPLICATION_ID='" + applicationId +  "'";
		return str;
	}

	public static String getMembers(String applicationId) {
		// TODO Auto-generated method stub
		String str="select * from APPLICATION_MEMBER_INFO where APPLICATION_ID='" + applicationId +  "'";
		return str;
	}

	public static String updateHeadMember(Member m) {
		// TODO Auto-generated method stub
		String statement = "UPDATE APPLICATION_HEAD_INFO SET HEAD_FIRST_NAME='" + m.getFirstName() + "',HEAD_MIDDLE_NAME='" + m.getMiddleName() + "',HEAD_LAST_NAME='" + m.getLastName() + "',SUFFIX='" + m.getSuffix() + "',DATE_OF_BIRTH='" + m.getDob() + "',GENDER='" + m.getGender() + "' where APPLICATION_ID='" + m.getApplicationId() + "';";
		return statement;
	}

	public static String updateMember(Member m) {
		// TODO Auto-generated method stub
		String statement = "UPDATE APPLICATION_MEMBER_INFO SET MEMBER_FIRST_NAME='" + m.getFirstName() + "',MEMBER_MIDDLE_NAME='" + m.getMiddleName() + "',MEMBER_LAST_NAME='" + m.getLastName() + "',SUFFIX='" + m.getSuffix() + "',DATE_OF_BIRTH='" + m.getDob() + "',GENDER='" + m.getGender() + "',RELATION='" + m.getRelationship() + "' where MEMBER_ID='" + m.getMemberId() + "';";
		return statement;
	}

	public static String deleteHeadMember(String applicationId) {
		// TODO Auto-generated method stub
		String statement = "DELETE FROM APPLICATION_HEAD_INFO WHERE APPLICATION_ID='" + applicationId + "';";
		return statement;
	}

	public static String deleteMember(String memberId) {
		// TODO Auto-generated method stub
		String statement = "DELETE FROM APPLICATION_MEMBER_INFO WHERE MEMBER_ID='" + memberId + "';";
		return statement;
	}

	public static String deleteAllMember(String applicationId) {
		String statement = "DELETE FROM APPLICATION_MEMBER_INFO WHERE APPLICATION_ID='" + applicationId + "';";
		return statement;
	}

	/*
	 * public static final String
	 * s="insert into member_info(familyid,memberid,firstname,middlename,lastname,suffix,dateOfbirth,gender,ishead) "
	 * + "values ("+"'"+ m.getApplicationId() + "','" + m.getMemberId() + "','" +
	 * m.getFirstName() + "','" + m.getMiddleName() + "','" + m.getLastName() +
	 * "','" + m.getSuffix() + "','" + m.getDob().toString() + "','" + m.getGender()
	 * + "'," + m.getIshead()+")";
	 */
}
