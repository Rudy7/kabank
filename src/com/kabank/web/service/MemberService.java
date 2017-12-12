package com.kabank.web.service;

import java.util.Vector;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	
	public void addMember(MemberBean member);		//파라미터에 MemberBean member은 왜 적어주는 걸까? 
	public int createCustomNum();					// 메뉴판에 짜장면 이라는 '글씨'만 있는 상태. 내용은 오픈 안할거야.
	public String findGender(String ssn);			// 이렇게 블락(바디)가 없는 메소드 : 추상메소드
	public int findAge(String ssn);					// 메뉴판에 없는걸 서비스임플로 가서 오버라이드로 묶으면 에러난다.
	public Vector<MemberBean> list();
	public int count();
	public void deleteAll(String inputOk);
	public void delete(String inputOk, String id);
	public void updatePass(String id);
	public MemberBean findById(String id);
	public MemberBean findByName(String name);
	
	
}
