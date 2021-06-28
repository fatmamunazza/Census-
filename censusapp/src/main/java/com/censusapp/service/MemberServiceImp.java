package com.censusapp.service;

import java.util.ArrayList;
import java.util.List;

import com.censusapp.dao.MemberDaoImpl;
import com.censusapp.entities.Member;


public class MemberServiceImp implements MemberService{

	@Override
	public boolean addMember(Member member) {

		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		boolean res = false;
		
		try {
			res = memberDaoImpl.addMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}


	@Override
	public boolean addHeadMember(Member member) {
		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		boolean res = false;
		
		try {
			res = memberDaoImpl.addHeadMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	
	@Override
	public List<Member> findAllMembersByApplicationId(String applicationId) {
		// TODO Auto-generated method stub
		List<Member> membersList = new ArrayList<Member>();
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		try {
			membersList = memberDaoImpl.getMembersByApplicationId(applicationId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return membersList; 
	}


	public boolean setRelationship(String memberId, String relationship) {
		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		boolean res = false;
		
		try {
			res = memberDaoImpl.setRelationship(memberId,relationship);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	

	@Override
	public boolean updateMember(Member member) {
		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		boolean res = false;
		
		try {
			res = memberDaoImpl.updateMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public boolean updateHeadMember(Member member) {
		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		boolean res = false;
		
		try {
			res = memberDaoImpl.updateHeadMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

	public void deleteHeadMember(Member member) {
		// TODO Auto-generated method stub
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		
		try {
			memberDaoImpl.deleteHeadMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
         MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		
		try {
			memberDaoImpl.deleteMember(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
