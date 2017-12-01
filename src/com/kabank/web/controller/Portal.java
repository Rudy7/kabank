package com.kabank.web.controller;

import java.awt.Menu;
import java.util.Scanner;

import org.omg.CORBA.SystemException;

import com.kabank.web.service.MemberService;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;
import com.kabank.wep.bean.MemberBean;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원수 입력");
		MemberServiceImpl memberService = new MemberServiceImpl(scanner.nextInt());
		MemberBean member = null;
			while(true) {
			System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수 4.회원목록");
			switch(scanner.nextInt()) {
			case 0:
				System.out.println("종료");
				return;
			case 1 :
				member = new MemberBean();
				System.out.print("이름 입력 : ");
				member.setName(scanner.next());
				System.out.println("주민번호");
				member.setSsn(scanner.next());
				member.setCustomNum(memberService.createCustomNum());
				member.setGender(memberService.findGender(member.getSsn()));
				member.setAge(memberService.findAge(member.getSsn()));
				memberService.addMember(member);
				System.out.printf("\n[고객번호]" + member.getCustomNum()
								+ "\n[주민번호]" + member.getSsn()
								+ "\n[이름]" + member.getName()
								+ "\n[성별]" + member.getGender()
								+ "\n[나이]" + member.getAge()
								);
				break;
			case 2:
				AccountServiceImpl accountService = new AccountServiceImpl();  //디폴드 생성자가 어카운트 서비스클래스에 있었는데.  우리 눈에 안 보이는 것이다.  그래서 여기서 이렇게 사용한다.
				accountService.setAccountNum();
				System.out.print("이름 입력 : ");
				accountService.setName(scanner.next());
				accountService.setAccountNum();
				System.out.println("[이름]" + accountService.getName()
								  +"[계좌번호]" + accountService.getAccountNum());
				break;
			case 3:
				System.out.println("총 회원수 : " + memberService.count());
				break;
			case 4:
				MemberBean[] members = memberService.list();
				for(int i=0; i<members.length; i++) {
				System.out.println(members[i].getName());
				}
				break;
			}
		}
	}
}



















//package com.kabank.webcontroller;
//
//import java.util.Scanner;
//import com.kabank.web.service.AccountService;
//import com.kabank.web.service.MemberService;
//public class Portal {
//public static void main(String[] args) {
//Scanner scanner = new Scanner(System.in);
//while(true) {
//System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설");
//switch(scanner.nextInt()) {
//case 0:
//System.out.println("종료");
//return;
//case 1 :
//MemberService mem = new MemberService();
//System.out.print("이름 입력 : ");
//mem.setName(scanner.next());
//System.out.print("주민번호 입력('-'포함) : ");
//mem.setSsn(scanner.next());
//mem.join(mem.getSsn());
//System.out.printf("[고객번호] %s\n"
//+ "[이름] %s\n"
//+ "[성별] %s\n"
//+ "[나이] %d\n",
//mem.getId(), mem.getName(),
//mem.getGender(), mem.getAge() );
//break;
//case 2:
//AccountService account = new AccountService();
//System.out.print("이름 입력 : ");
//account.setName(scanner.next());
//System.out.println(account.getName() + "님의 계좌가 "
//+ account.createAccount(scanner) + "로 개설 되었습니다");
//break;
//}
//}
//}
//}
//
//













//package com.kabank.webcontroller;
//
//import java.util.Scanner;
//
//import javax.print.attribute.standard.MediaPrintableArea;
//
//import com.kabank.web.service.AccountService;
//import com.kabank.web.service.MemberService;
//
//public class Portal {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);		
//		while(true) {
//				System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설");
//				switch(scanner.nextInt()) {
//				case 0: System.out.println("종료");return;
//				case 1: 
//					MemberService memberService = new MemberService();
//					
//					System.out.println("이름");
//					String name1 = scanner.next();
//					System.out.println("주민번호");
//					String ssn = scanner.next();
//					memberService.join(ssn);
//					System.out.println(
//							"%s [%s] %s [%s] %s [%s]",
//							res, "[이름]"+name1+"[성별]"+result+"[나이]");
//					
////							res += "고객번호 101\n" 
////							res += "[성별] 남\n"
////							res += "[나이] 30세\n"
////							res += "[이름] [홍길동]"
//							return res;
//							
//					int birthYear = Integer.parseInt("80");
//					break;
//				case 2: 
//					AccountService service = new AccountService();
//					System.out.print("이름");
//					String name2 = scanner.next();
//				    System.out.println(
//						    name2 + "[계좌번호]" 
//						    +service.createAccount());
//					break;
//				}
//			}
//	}
//}
//여기 있는 임폴트한 스케너를 어카운터서비스로 같이 쓸때 (scanner) 써준다.
