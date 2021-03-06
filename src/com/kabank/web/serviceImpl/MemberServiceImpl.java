package com.kabank.web.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService { //
	// private MemberBean[] members; //보안을 위해서,몇명인지 하려고 배열을 이용, 집합체는 입장이 좀 다르다.
	// setget 할필요 X\
	private Vector<MemberBean> members;

	// 하나씩 호출하려고 // 빈 클래스가 아니라 impl클래스라서 getcount 대신 count를 쓴다.

	public MemberServiceImpl() { // 생성자를 만드는 것
		// members = new MemberBean[count];

		members = new Vector<MemberBean>(10, 10);
	}

	@Override
	public void addMember(MemberBean member) {
		// members[count] = member; // 회원수를 무한이 늘려야해서 몇명인지 물어보고 그 수만큼 회원수의 제한을 잡기위해 쓴다1.
		members.add(member);
	}

	@Override
	public int createCustomNum() {
		int foo = 101;
		return foo;
	}

	@Override // 오버라이드로 묶어준것(알고리즘 하나당 오버라이드 하나). 이러면 알고리즘은 숨겨짐(겉에서 안보임) 이게 있어야 메뉴판과 연동.
	public String findGender(String ssn) {
		String foo = ""; // temp를 줘야한다! 왜냐면 지역변수의 쓰임을 구분하려고.
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
		return foo; // foo는 답을 담기위해 만든것!
	}

	@Override
	public int findAge(String ssn) { // ssn저장장소가 bean이기 떄문에 서비스에서는 각각 다받아야된다
		int age = 0, bir = 0, gap = 0; // ssn = ""; //사실 this.ssn 을 그냥 ssn으로 생략해도 된다
		String res = "";
		Calendar cal = Calendar.getInstance();
		int now = cal.get(cal.YEAR);
		char ch0 = ssn.charAt(0);
		res += ch0;
		char ch1 = ssn.charAt(1);
		res += ch1;

		int result = Integer.parseInt(res); // if(!"".equals(res)){ //만약 받아온 데이터가 공백이 아니면 데이터를 형변환 하여 적재
											// result = Integer.parseInt(res);
		gap = now - result; // }
		if (gap >= 2000) {
			bir = 2000 + result;
		} else {
			bir = 1900 + result;
		}
		age = now - bir + 1;
		return age;
	}

	@Override
	public Vector<MemberBean> list() {

		return members;
	}

	@Override
	public int count() {

		return members.size();
	}

	@Override
	public void deleteAll(String inputOk) { // clear();
			if(inputOk.equals("Y")) {
				members.clear();
			}else {
				JOptionPane.showMessageDialog(null, "모든 회원 삭제를 취소합니다.");
			}
			return res;
}	

	@Override
	public void delete(String inputOk, String id) { // remove
//			String inputOk = JOptionPane.showInputDialog("정말 회원을 탈퇴를 하시겠습니까?  Y , N ");
			if(inputOk.equals("Y")) {
				for (int i = 0; i < members.size(); i++) {
					if (id.equals(members.get(i).getId())) {
						members.remove(i);
					}	
				}
			}else {
				JOptionPane.showMessageDialog(null, "회원 삭제를 취소합니다.");
			}
		}

	public String login(MemberBean member) { // 3가지 프린트 나오게. 아이디가 존재안합니다. / 비번이 다릅니다./ 로그인되었습니다.
		String res = "아이디 없음";
		for (int i = 0; i < members.size(); i++) {
			if (member.getId().equals(members.get(i).getId())) { // members.get(i).getId())는 쉘로우다.
				res = (member.getPass().equals(members.get(i).getPass())) ? "로그인 되었습니다." : "비번이 다릅니다.";

				return res;
			}
		}
		return res; // 두 번 쓰는게 더 좋다고 한다
	}
	// for (int i = 0; i < members.size(); i++) {
	// if (member.getId().equals(members.get(i).getId())) { //
	// members.get(i).getId())는 쉘로우다.
	// if (member.getPass().equals(members.get(i).getPass())) {
	// res = "로그인 되었습니다.";
	// break;
	// } else {
	// res = "비번이 다릅니다.";
	// break;
	// }
	// } else {
	// res = "존재하지 않는 아이디입니다.";
	// break;
	// }
	// }
	// return res;
	// }

	@Override
	public void updatePass(String id) {
		for (int i = 0; i < members.size(); i++) {
			if (id.equals(members.get(i).getId())) {
				members.get(i).setPass(JOptionPane.showInputDialog("변경하실 비밀번호를 입력해주세요."));
				JOptionPane.showInternalMessageDialog(null, "비밀번호가 변경되었습니다.");	
			}
		}
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean res = new MemberBean();
		for (int i = 0; i < members.size(); i++) {
			if (id.equals(members.get(i).getId())) {
				String m8 = "", m9 = "";
				int i1 = members.get(i).getCustomNum();
				int i2 = members.get(i).getAge();
				String i3 = members.get(i).getName();
				String i4 = members.get(i).getGender();
				String i5 = members.get(i).getSsn();
				String i6 = members.get(i).getId();
				String i7 = members.get(i).getPass();
				m8 = String.valueOf(i1 + i2);
				m9 = m8.concat(i3 + i4 + i5 + i6 + i7);
				JOptionPane.showMessageDialog(null, m9);
			}

		}
		return res;
	}

	@Override
	public MemberBean findByName(String name) {
		MemberBean[] memberc = null;
		MemberBean res = new MemberBean();
		for (int i = 0; i < members.size(); i++) {
			if (name.equals(members.get(i).getName())) {
				memberc = new MemberBean[res];
				res = members.get(i);
				res++;
			}
		}
		return res;
	}
}

/*
 * @Override public void setCount(int count) { //setCount는 의미가 없다. 안만들어도 되고, 만들지
 * 말아야할때도 있는데 일단은 배우는중이니 만들자. this.count = count; //그리고 관례적으로 getset은 Bean에서만
 * 만드는것. } //그러니까 Bean외에선 그냥 겟카운트 역할을 이름다르게 만들자
 * 
 * @Override public int getCount() { return this.count; }
 */

// @Override
// public MemberBean[] list() {
// return members;
// }

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

// public class StudentServiceImpl implements StudentService {
//
// private StudentBean[] students;
// private int count;
//
// public StudentServiceImpl(int count) {
// students = new StudentBean[count];
// this.count = 0;
// }}

// public class StudentServiceImpl implements StudentService{
// // String[] arr = new String[4];
// private StudentBean[] students = new StudentBean[3];
//
// 이건 문법이 잘못된 구조이다.
// 생성자 --> 생성자라는 것은 메모리 내에 인스턴스(객체)가 생성될때 자동적으로 단 한번 호출되어 클래스(객체)의 구조를 인식하게 하고
// 생성되는 클래스(객체)의 멤버변수들을 초기화하는 데 목적을 둔 것을 말한다.
//
// 이유 - 생성자가 없어서.
// 데이터가 0 이거나 null이면 생성자는 자동으로 생성된다. 하지만 그 데이터값이 있을때는 직접 생성자를 만들어야만 한다.
// 여기에서는 배열에 3개의 데이터값이 있기 때문에 디폴트생성자(자동으로 생기는)는 의미가 없어졌고,
// 없는 것과 같다. 그래서 생성자를 직접 만들어 줘야 한다.
//
// public StudentServiceImpl() {
// // TODO Auto-generated constructor stub
// }