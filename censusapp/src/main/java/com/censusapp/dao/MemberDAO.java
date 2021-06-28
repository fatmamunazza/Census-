package com.censusapp.dao;

import java.util.List;

import com.censusapp.entities.Member;


public interface MemberDAO {
	
	public void startDatabaseConnection() throws Exception;
	
	public Boolean addHeadMember(Member m) throws Exception;
	public Boolean addMember(Member m) throws Exception;
	
	public boolean setRelationship(String memberId,String relationship) throws Exception;

	public List<Member> getMembersByApplicationId(String familyId);
	
	public boolean updateHeadMember(Member m) throws Exception;
	public boolean updateMember(Member m) throws Exception;
	
	public void deleteHeadMember(Member member) throws Exception;
	public void deleteMember(Member member) throws Exception;
	
	
}

