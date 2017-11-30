package com.kabank.web.service;

import java.util.Calendar;

public class MemberService {
	private int customNum;
	private String name;
	private int age;
	private String gender;
	private String ssn;

	public MemberService() {
		this.customNum = 0;
		this.name = "";
		this.age = 0;
		this.gender = "";
		this.ssn = "";
	}	
	public void join(String ssn) {
	char temp = 0;
	temp = ssn.charAt(7);
	if(temp == '1'|| temp == '3') {
		gender = "남";
	}else if(temp == '2'|| temp == '4') {
		gender = "여";
	}else if(temp == '5'|| temp == '6') {
		gender = "외국인";
	}else {
		gender = "다시 입력해주세요";
	}
}
	
	public void setCustomNum() {
		this.customNum = 101;
	}
	public int getCustomNum() {
		return customNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge() {
		this.ssn = "";
	    this.age = 34;
	}
	public int getAge() {
		return age;
	}
	public void setGender() {
		//
		//
		//
		this.gender = this.ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return this.ssn;
	}
}	
	
		

	
	
	

//	public String[] join(String ssn) {
//		Calendar cl = Calendar.getInstance();
//		String res[] = new String[2];
//		String ssnTemp = "";
//		char temp1 = 0, temp2 = 0;
//		int c1 = 0, c2 = 0, result = 0;
//		temp1 = ssn.charAt(7);
//		if(temp1 == '1' || temp1 == '3') { // 성별 체크
//			res[0] = "남";
//		} else if(temp1 == '2' || temp1 == '4') {
//			res[0] = "여";
//		} else {
//			res[0] = "누구냐넌";
//		}
//		c1 = cl.get(cl.YEAR);
//		temp2 = ssn.charAt(0);  // 주민번호 첫째자리를 temp2에 assignment
//		ssnTemp += temp2; // ssnTemp에 첫째자리를 붙혀넣는다
//		temp2 = ssn.charAt(1); // 주민번호 둘째자리를 temp2에 assignment
//		ssnTemp += temp2; // ssnTemp에 둘째자리를 붙혀넣는다
//		
//		// 2000년도와 1900년도는 7번째 주민번호가 다르다
//		// 조건을 줘서 구분한다.
//		if(temp1 == '3' || temp1 == '4') {  // 2000 ~  
//			ssnTemp = "20" + ssnTemp; // ex) 2000, 2001, 2005, etc.
//		} else { //  1900 ~ 1999
//			ssnTemp = "19" + ssnTemp; // ex) 1984, 1986, 1988, 1990, etc.
//			System.out.println(ssnTemp);// ex) 2000, 2001, 2005, etc.
//		}
//		c2 = Integer.parseInt(ssnTemp); // String Type의 res[1]을 int type으로 변환해서 c2에 assignment
//		result = (c1 - c2) + 1; // 우리나라의 나이는 1살으로 시작하기 때문에 +1
//		res[1] = String.valueOf(result);    // result 값을 String type으로 변환
//		return res;
//	}
//}




















//package com.kabank.web.service;
//
//import java.util.Calendar;
//public class MemberService {
//String id;
//String name;
//String ssn;
//String gender;
//int age;
//public MemberService(){
//id = "101";
//name = "";
//ssn = "";
//gender = "";
//age = 0;
//}
//public void join(String ssn) {
//Calendar cl = Calendar.getInstance();
//String res = "";
//char temp = 0;
//int c1 = 0, c2 = 0;
//temp = ssn.charAt(7);
//if(temp == '1' || temp == '3') {
//gender = "남";
//} else if(temp == '2' || temp == '4') {
//gender = "여";
//} else {
//gender = "누구냐넌";
//}
//c1 = cl.get(cl.YEAR);
//temp = ssn.charAt(0);
//res += temp;
//temp = ssn.charAt(1);
//res += temp;
//if(res.charAt(0) == '0') {
//res = "20" + res;
//} else {
//res = "19" + res;
//}
//c2 = Integer.parseInt(res);
//age = (c1 - c2) + 1;
//}
//public String getName() {
//return name;
//}
//public void setName(String name) {
//this.name = name;
//}
//public String getSsn() {
//return ssn;
//}
//public void setSsn(String ssn) {
//this.ssn = ssn;
//}
//public String getId() {
//return id;
//}
//public void setId(String id) {
//this.id = id;
//}
//public String getGender() {
//return gender;
//}
//public void setGender(String gender) {
//this.gender = gender;
//}
//public int getAge() {
//return age;
//}
//public void setAge(int age) {
//this.age = age;
//}
//}



























//package com.kabank.web.service;
//
//import java.util.Calender;
//
//public MemberService() {
//
//	    String id;
//		String name;
//		String ssn;
//		String gender;
//		int age;
//		
//		public MemberService() {
//			id = "101";
//			name = "";
//			ssn = "";
//			gender = "";
//			age = 0;
//			
//	public String join(String ssn) 
//		String res = "", gender = "",result = "";
//		res += "[고객번호]101";
//		char ch = ssn.charAt(7);
//		if(ch=='1'||ch=='3') {
//				result = "남자";
//		}else if(ch=='2'||ch=='4') {
//				result = "여자";
//		}else if(ch=='5'||ch=='6'){
//				result = "외국인";
//		}else {
//				result = "다시 입력하세요.";
//		}
//		return res + gender;
//	}
//}
//
