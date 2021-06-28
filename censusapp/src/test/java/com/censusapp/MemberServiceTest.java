package com.censusapp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.censusapp.entities.Member;
import com.censusapp.service.MemberService;

public class MemberServiceTest {
	@Test
    public boolean testAddMember() {
		Member member =new Member("Munazza","Fatma","Ali","Miss","15/03/1998","Female");
		//Create the mock object of member service
		MemberService memberService = mock(MemberService.class);
		// Mock implementation of addMember method of member service
		when(memberService.addMember(member)).thenReturn(true);
		// Adding the member
		memberService.addMember(member);

		// verify the implementation
		verify(memberService).addMember(member);
    	return false;
    }
}
