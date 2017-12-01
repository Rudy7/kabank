package com.kabank.web.service;

import com.kabank.wep.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void addMember(MemberBean member);
	public int count();
	public MemberBean[] list();
	
}
