/**
 * 
 */
package com.censusapp.runtime;

import java.util.Scanner;

import com.censusapp.constant.Constants;
import com.censusapp.entities.Member;
import com.censusapp.service.MemberServiceImp;

public class AddMember {
      String s,appId,memberId;
      Scanner sc=new Scanner(System.in);
      MemberServiceImp memberServiceImp=new MemberServiceImp();
      public boolean addMember(MemberFactory memfact, Integer i) {
    	  try {
    		 GetMember getMember=new GetMember();
  			memfact.addMember(getMember.getMember(memfact,i),i);
  				
  		} catch (Exception e) {
  			System.out.println(e.getMessage() + "\n");
  			return false;
  		}
    	return true;
      }   
}
