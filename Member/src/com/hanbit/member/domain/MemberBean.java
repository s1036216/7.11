package com.hanbit.member.domain;

public class MemberBean {
	private String id,name,password,ssn,regdate;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setSsn(String ssn){
		this.ssn=ssn;
	}
	public String getSsn(){
		return ssn;
	}
	public void setRegdate(String regdate){
		this.regdate=regdate;
	}
	public String getRegdate(){
		return regdate;
	}
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", name=" + name + ", password=" + password + ", ssn=" + ssn + ", regdate="
				+ regdate + "] \n";
	}
}
