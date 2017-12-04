package com.kabank.web.serviceImpl;

import java.util.Calendar;
import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;
//import com.school.web.bean.StudentBean;
//import com.school.web.service.StudentService;

public class MemberServiceImpl implements MemberService {   //
	private MemberBean[] members;    	//보안을 위해서,몇명인지 하려고 배열을 이용, 집합체는 입장이 좀 다르다. setget 할필요 X
	private int count;   	//하나씩 호출하려고 	// 빈 클래스가 아니라 impl클래스라서  getcount 대신 count를 쓴다. 
	
	public MemberServiceImpl(int count) { 			   	    //생성자를 만드는 것
		members = new MemberBean[count];
		this.count = 0;
	}
	
//public class StudentServiceImpl implements StudentService {
//		
//	private StudentBean[] students;
//	private int count;
//		
//	public StudentServiceImpl(int count) {
//		students = new StudentBean[count];
//		this.count = 0;
//	}}
	
	
//	public class StudentServiceImpl implements StudentService{
//     // String[] arr = new String[4];
//	private StudentBean[] students = new StudentBean[3];  
//
//	이건 문법이 잘못된 구조이다. 
//	생성자 --> 생성자라는 것은 메모리 내에 인스턴스(객체)가 생성될때 자동적으로 단 한번 호출되어 클래스(객체)의 구조를 인식하게 하고 생성되는 클래스(객체)의 멤버변수들을 초기화하는 데 목적을 둔 것을 말한다. 
//
//	이유 -  생성자가 없어서. 
//	데이터가 0 이거나 null이면 생성자는 자동으로 생성된다.  하지만 그 데이터값이 있을때는 직접 생성자를 만들어야만 한다. 
//	여기에서는 배열에 3개의 데이터값이 있기 때문에 디폴트생성자(자동으로 생기는)는 의미가 없어졌고, 
//	없는 것과 같다.  그래서 생성자를 직접 만들어 줘야 한다.  
//
//	public StudentServiceImpl() {
//	            // TODO Auto-generated constructor stub
//	      }
	
	@Override
	public int count() {
		return this.count;
	}	
	
	@Override
	public void addMember (MemberBean member) {
		members[count] = member;          				 // 회원수를 무한이 늘려야해서 몇명인지 물어보고 그 수만큼 회원수의 제한을 잡기위해 쓴다1. 
		count++;
	}
	
	@Override
	public int createCustomNum() {
		int foo = 101;
		return foo;
	}
	
	@Override			//오버라이드로 묶어준것(알고리즘 하나당 오버라이드 하나). 이러면 알고리즘은 숨겨짐(겉에서 안보임) 이게 있어야 메뉴판과 연동.
	public String findGender(String ssn) {
		String foo = "";									// temp를 줘야한다! 왜냐면 지역변수의 쓰임을 구분하려고.
															// this.gender = this.ssn; //읽어 들이는 것과 쓰는 것을 구분한 이유? 보안때문에
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
		return foo;										// foo는 답을 담기위해 만든것!
	}
	
	@Override
	public int findAge(String ssn) {					// ssn저장장소가 bean이기 떄문에 서비스에서는 각각 다받아야된다
		int age = 0, bir = 0, gap = 0;					// ssn = ""; //사실 this.ssn 을 그냥 ssn으로 생략해도 된다
		String res = "";
		Calendar cal = Calendar.getInstance();
		int now = cal.get(cal.YEAR);  
		char ch0 = ssn.charAt(0);
		res += ch0;
		char ch1 = ssn.charAt(1);
		res += ch1;

		int result = Integer.parseInt(res);				// if(!"".equals(res)){                    //만약 받아온 데이터가 공백이 아니면 데이터를 형변환 하여 적재 
														//		result = Integer.parseInt(res);
		gap = now - result;								//		}
		if (gap>=2000) {
			bir = 2000 + result; 
		}else {
			bir = 1900 + result;
		}
		age = now - bir;
		return age;
	}	
	
	
	/*
	@Override
	public void setCount(int count) {				//setCount는 의미가 없다. 안만들어도 되고, 만들지 말아야할때도 있는데 일단은 배우는중이니 만들자.
		this.count = count;							//그리고 관례적으로 getset은 Bean에서만 만드는것. 
	}												//그러니까 Bean외에선 그냥 겟카운트 역할을 이름다르게 만들자
	@Override
	public int getCount() {
		return this.count;
	}
	*/
	
	@Override
	public MemberBean[] list() {
		return members;
	}
	
}
/*
 * public String join(String ssn) { 위에 ssn을 setter getter로 설정했기 때문에 이제 join메소드는
 * 필요없다 // TODO Auto-generated method stub String res = ""; res += "[고객번호]101";
 * 
 * res += "[이름]홍길동";
 * 
 * res += "[성별]남";
 * 
 * res += "[나이]30"; return res; }
 */







