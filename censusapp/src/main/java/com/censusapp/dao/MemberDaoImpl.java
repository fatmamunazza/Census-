package com.censusapp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.censusapp.constant.Constants;
import com.censusapp.entities.Member;
import com.censusapp.exceptions.AddEntryException;
import com.censusapp.exceptions.AddHeadMemberException;
import com.censusapp.exceptions.CreateTableException;
import com.censusapp.exceptions.DbConnectionException;
import com.censusapp.exceptions.UpdateEntryException;
import com.censusapp.exceptions.UpdateRelationshipException;


public class MemberDaoImpl implements MemberDAO {
	
	
	static Connection dbConnection = null;
	static Statement sqlStatement = null;
	static Statement sqlStatement2 = null;
	static String statement = null;
	private static final String url="jdbc:mysql://localhost:3306/census_app_db";
	private static final String user="Admin";
	private static final String password="Sapient123";
	
	
	public void startDatabaseConnection() throws Exception {
		try {
			dbConnection = DriverManager.getConnection(url, user, password);
			sqlStatement = dbConnection.createStatement();
		} catch (Exception e) {
			throw new DbConnectionException();
		}
	}

	@Override
	public Boolean addHeadMember(Member m) throws Exception {
		// TODO Auto-generated method stub
		Boolean addedEntry = false;
		sqlStatement = dbConnection.createStatement();
		
		statement =QueryMapper.createHeadMemberTable;
		
		try {
			sqlStatement.executeUpdate(statement);
		} catch (SQLException e) {
			throw new CreateTableException(e);
		}
		statement = QueryMapper.insertInHeadMemberTable(m);
		
		try {
			sqlStatement.executeUpdate(statement);
			addedEntry = true;
		} catch (SQLException e) {
			throw new AddHeadMemberException(e);
		}
		
		return addedEntry;
	}
	
	public Boolean addMember(Member m) throws Exception {
		Boolean addedEntry = false;
		sqlStatement = dbConnection.createStatement();
		
		statement =QueryMapper.createMemberTable;
		
		try {
			sqlStatement.executeUpdate(statement);
		} catch (SQLException e) {
			throw new CreateTableException(e);
		}
		statement = QueryMapper.insertInMemberTable(m);
		
		try {
			sqlStatement.executeUpdate(statement);
			addedEntry = true;
		} catch (SQLException e) {
			throw new AddEntryException(e);
		}
		
		return addedEntry;
	}
	

	public boolean setRelationship(String memberId, String relationship) throws Exception {
		// TODO Auto-generated method stub
		
		Boolean updateEntry = false;
		sqlStatement = dbConnection.createStatement();
		statement = QueryMapper.insertRelationMemberTable(memberId,relationship);
		
		try {
			sqlStatement.executeUpdate(statement);
			updateEntry = true;
		} catch (SQLException e) {
			throw new UpdateRelationshipException(e);
		}
		
		return updateEntry;
	}



	public List<Member> getMembersByApplicationId(String applicationId) {
		List<Member> membersList = new ArrayList<Member>();
		ResultSet rs1,rs2;
		
		try {
			sqlStatement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);
			sqlStatement2 = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				    ResultSet.CONCUR_READ_ONLY);
			String statement1  = QueryMapper.getHeadMember(applicationId);
			String statement2  = QueryMapper.getMembers(applicationId);
		   
			rs1 = sqlStatement.executeQuery(statement1);	
			rs2 = sqlStatement2.executeQuery(statement2);	
			while(rs1.next()) {
				Member m = new Member();
				try {
					m.setApplicationId(rs1.getString("APPLICATION_ID"));
					m.setFirstName(rs1.getString("HEAD_FIRST_NAME"));
					m.setMiddleName(rs1.getString("HEAD_MIDDLE_NAME"));
					m.setLastName(rs1.getString("HEAD_LAST_NAME"));
					m.setSuffix(rs1.getString("SUFFIX"));
					m.setDob(rs1.getString("DATE_OF_BIRTH"));
					m.setGender(rs1.getString("GENDER"));
					membersList.add(m);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}	
			}
			
			while(rs2.next()) {
				Member m1 = new Member();
				try {
					m1.setApplicationId(rs2.getString("APPLICATION_ID"));
					m1.setMemberId(rs2.getString("MEMBER_ID"));
					m1.setFirstName(rs2.getString("MEMBER_FIRST_NAME"));
					m1.setMiddleName(rs2.getString("MEMBER_MIDDLE_NAME"));
					m1.setLastName(rs2.getString("MEMBER_LAST_NAME"));
				    m1.setSuffix(rs2.getString("SUFFIX"));
					m1.setDob(rs2.getString("DATE_OF_BIRTH"));
					m1.setGender(rs2.getString("GENDER"));
					m1.setRelationship(rs2.getString("RELATION"));
					membersList.add(m1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			
			rs1.close();
			rs2.close();
			sqlStatement.close();
			sqlStatement2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	}

	public boolean updateHeadMember(Member m) throws Exception {
		// TODO Auto-generated method stub
		boolean updateEntry = false;
		sqlStatement = dbConnection.createStatement();
		statement=QueryMapper.updateHeadMember(m);
		
		try {
			sqlStatement.executeUpdate(statement);
			updateEntry = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return updateEntry;
	}

	public boolean updateMember(Member m) throws Exception {
		// TODO Auto-generated method stub
		boolean updateEntry = false;
		sqlStatement = dbConnection.createStatement();
		statement=QueryMapper.updateMember(m);
		
		try {
			sqlStatement.executeUpdate(statement);
			updateEntry = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return updateEntry;
	}

	@Override
	public void deleteHeadMember(Member m) throws Exception {
		// TODO Auto-generated method stub
		sqlStatement = dbConnection.createStatement();
		sqlStatement2 = dbConnection.createStatement();
		String statement1=QueryMapper.deleteHeadMember(m.getApplicationId());
		String statement2=QueryMapper.deleteAllMember(m.getApplicationId());
		try {
			sqlStatement2.executeUpdate(statement2);
			sqlStatement.executeUpdate(statement1);
			System.out.println(Constants.deletedSuccessfully);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteMember(Member m) throws Exception {
		// TODO Auto-generated method stub
		sqlStatement = dbConnection.createStatement();
		statement=QueryMapper.deleteMember(m.getMemberId());
		try {
			sqlStatement.executeUpdate(statement);
			System.out.println(Constants.deletedSuccessfully);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
}
