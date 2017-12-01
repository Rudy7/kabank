package com.kabank.web.serviceImpl;

import java.util.Calendar;

import com.kabank.web.service.MemberService;
import com.kabank.wep.bean.MemberBean;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] members;    
	private int count;    // 빈 클래스가 아니라 impl클래스라서  getcount 대신 count를 쓴다. 
	
	public MemberServiceImpl(int count) {  //생성자를 만드는 것
		members = new MemberBean[count];
		this.count = 0;
	}
	
	public void setCount(int count) {
		this.count= count;
	}
	public int getCount() {
		return count;
	}
	
	@Override
	public int count() {
		return this.count;
	}			
	@Override
	public int createCustomNum() {
		int foo = 0;
		
		return foo;
		
	}
	@Override
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		if (ch == '1' || ch == '3') {
			foo = "남";
		} else if (ch == '2' || ch == '4') {
			foo = "여";
		} else if (ch == '5' || ch == '6') {
			foo = "외국인";
		} else {
			foo = "다시 입력해주세요";
		}
		return foo;
	}
	@Override
	public int findAge(String ssn) {
		int foo = 0, ch = 0;
			String res = "", c2 = "";
			int c1 = 0, age = 0;
			Calendar cl = Calendar.getInstance();
			c1 = cl.get(cl.YEAR);
			res = ssn.charAt(0) + "" + ssn.charAt(1);
			ch = Integer.parseInt(res);
			
			if(res.charAt(0) == '0') {
				ch= 20 + res;
			}else {
				ch = 19 + res;
			}
			System.out.println(res);
//			c2 = Integer.parseInt(res);
//			age = (int) ((c1 - c2) + 1) ;
//			
			return age;
	}	
		
		@Override
		public void addMember (MemberBean member) {
			members[count] = member;
			count++;
		}
		
		@Override
		public MemberBean[] list() {
			return members;
		}
	
	
	} 



















// public String[] join(String ssn) {
// Calendar cl = Calendar.getInstance();
// String res[] = new String[2];
// String ssnTemp = "";
// char temp1 = 0, temp2 = 0;
// int c1 = 0, c2 = 0, result = 0;
// temp1 = ssn.charAt(7);
// if(temp1 == '1' || temp1 == '3') { // 성별 체크
// res[0] = "남";
// } else if(temp1 == '2' || temp1 == '4') {
// res[0] = "여";
// } else {
// res[0] = "누구냐넌";
// }
// c1 = cl.get(cl.YEAR);
// temp2 = ssn.charAt(0); // 주민번호 첫째자리를 temp2에 assignment
// ssnTemp += temp2; // ssnTemp에 첫째자리를 붙혀넣는다
// temp2 = ssn.charAt(1); // 주민번호 둘째자리를 temp2에 assignment
// ssnTemp += temp2; // ssnTemp에 둘째자리를 붙혀넣는다
//
// // 2000년도와 1900년도는 7번째 주민번호가 다르다
// // 조건을 줘서 구분한다.
// if(temp1 == '3' || temp1 == '4') { // 2000 ~
// ssnTemp = "20" + ssnTemp; // ex) 2000, 2001, 2005, etc.
// } else { // 1900 ~ 1999
// ssnTemp = "19" + ssnTemp; // ex) 1984, 1986, 1988, 1990, etc.
// System.out.println(ssnTemp);// ex) 2000, 2001, 2005, etc.
// }
// c2 = Integer.parseInt(ssnTemp); // String Type의 res[1]을 int type으로 변환해서 c2에
// assignment
// result = (c1 - c2) + 1; // 우리나라의 나이는 1살으로 시작하기 때문에 +1
// res[1] = String.valueOf(result); // result 값을 String type으로 변환
// return res;
// }
// }

// package com.kabank.web.service;
//
// import java.util.Calendar;
// public class MemberService {
// String id;
// String name;
// String ssn;
// String gender;
// int age;
// public MemberService(){
// id = "101";
// name = "";
// ssn = "";
// gender = "";
// age = 0;
// }
// public void join(String ssn) {
// Calendar cl = Calendar.getInstance();
// String res = "";
// char temp = 0;
// int c1 = 0, c2 = 0;
// temp = ssn.charAt(7);
// if(temp == '1' || temp == '3') {
// gender = "남";
// } else if(temp == '2' || temp == '4') {
// gender = "여";
// } else {
// gender = "누구냐넌";
// }
// c1 = cl.get(cl.YEAR);
// temp = ssn.charAt(0);
// res += temp;
// temp = ssn.charAt(1);
// res += temp;
// if(res.charAt(0) == '0') {
// res = "20" + res;
// } else {
// res = "19" + res;
// }
// c2 = Integer.parseInt(res);
// age = (c1 - c2) + 1;
// }
// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }
// public String getSsn() {
// return ssn;
// }
// public void setSsn(String ssn) {
// this.ssn = ssn;
// }
// public String getId() {
// return id;
// }
// public void setId(String id) {
// this.id = id;
// }
// public String getGender() {
// return gender;
// }
// public void setGender(String gender) {
// this.gender = gender;
// }
// public int getAge() {
// return age;
// }
// public void setAge(int age) {
// this.age = age;
// }
// }

// package com.kabank.web.service;
//
// import java.util.Calender;
//
// public MemberService() {
//
// String id;
// String name;
// String ssn;
// String gender;
// int age;
//
// public MemberService() {
// id = "101";
// name = "";
// ssn = "";
// gender = "";
// age = 0;
//
// public String join(String ssn)
// String res = "", gender = "",result = "";
// res += "[고객번호]101";
// char ch = ssn.charAt(7);
// if(ch=='1'||ch=='3') {
// result = "남자";
// }else if(ch=='2'||ch=='4') {
// result = "여자";
// }else if(ch=='5'||ch=='6'){
// result = "외국인";
// }else {
// result = "다시 입력하세요.";
// }
// return res + gender;
// }
// }
//
