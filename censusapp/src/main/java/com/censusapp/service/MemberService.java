package com.censusapp.service;

import java.util.List;

import com.censusapp.entities.Member;

public interface MemberService {
	public boolean addMember(Member member);
	public boolean addHeadMember(Member member);
	
	public boolean updateMember(Member member);
	public boolean updateHeadMember(Member member);
	
	public List<Member> findAllMembersByApplicationId(String applicationId);
	public boolean setRelationship(String memberId,String relationship);
	
	public void deleteHeadMember(Member member);
	public void deleteMember(Member member);
}
