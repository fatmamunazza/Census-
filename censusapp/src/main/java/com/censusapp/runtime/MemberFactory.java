/**
 * 
 */
package com.censusapp.runtime;

import java.util.ArrayList;
import java.util.List;

import com.censusapp.entities.Member;
import com.censusapp.exceptions.DetailsNotFoundException;


public class MemberFactory {
	public List<Member>familyList;
	public boolean entryFound=false;
	Member editedMem;
	Member deleteMem;
	List<Member> list = new ArrayList<Member>();
	
	public MemberFactory() {		
		familyList=new ArrayList<Member>();
	}
	
	public Boolean addMember(Member m, Integer i) throws Exception {
		this.familyList.add(m);
		return true;
	}
	
	public List<Member> getFamilyList(String applicationId) throws Exception{
		
		this.familyList.forEach((m) -> {
			if(m.getApplicationId().equals(applicationId)) {
				list.add(m);
			}
		});
		
		if(list.size() == 0) throw new DetailsNotFoundException();
		return list;
	}
   public List<Member> getFamilyList() throws Exception{
		return familyList;
	}
	
	
	public Member editMember(String appId,String memId) throws Exception {
		this.familyList.forEach((m)->{
			if(m.getApplicationId().equals(appId) && m.getMemberId().equals(memId)) {
				this.entryFound=true;
					try {
						editedMem=EditMember.edit(appId,memId,m);
						//m.setFirstName(editedMem.getFirstName());
						//m.setMiddleName(editedMem.getMiddleName());
						//m.setLastName(editedMem.getLastName());
						//m.setDob(editedMem.getDob());
						//m.setSuffix(editedMem.getSuffix());
						//m.setGender(editedMem.getGender());
					} catch (Exception e) {
						e.printStackTrace();
					}
				
			}
		});
		
		if(!this.entryFound) throw new  DetailsNotFoundException();
		return editedMem;
		
	}
	
	public Member deleteMember(String appId,String memId) throws Exception{
		this.familyList.forEach((m)->{
			if(m.getApplicationId().equals(appId) && m.getMemberId().equals(memId)) {
				this.entryFound=true;
				this.deleteMem=m;
				familyList.remove(m);
			}
		});
		if(!this.entryFound) throw new  DetailsNotFoundException();
		return deleteMem;
		
	}
}

