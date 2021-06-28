package com.censusapp.entities;

public class Relation {
	private String relation_id;
	private Member member1;
	private Member member2;
	
	public Relation(String relation_id) {
		this.relation_id=relation_id;
	}
	public String getRelation_id() {
		return relation_id;
	}
	public void setRelation_id(String relation_id) {
		this.relation_id = relation_id;
	}
	
	public Member getMember1() {
		return member1;
	}
	public Member getMember2() {
		return member2;
	}
	
}
