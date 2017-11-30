package com.kabank.web.controller;

import java.lang.reflect.Member;
import java.util.Scanner;

import com.kabank.web.service.AccountService;
import com.kabank.web.service.MemberService;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		
		while(true) {
			System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설");
			switch(scanner.nextInt()) {
			case 0:
				System.out.println("종료");
				return;
			case 1 :
				MemberService memberService = new MemberService();
				
				System.out.print("이름 입력 : ");
				memberService.setName(scanner.next());
				System.out.println("주민번호");
				memberService.setSsn(scanner.next());
				memberService.setCustomNum();
				memberService.setGender();
				memberService.setAge();
				System.out.printf("[고객번호] \n" + memberService.getCustomNum()
								+ "[주민번호]" + memberService.getSsn()
								+ "[이름]  \n" + memberService.getName()
								+ "[성별] \n" + memberService.getGender()
								+ "[나이] \n" + memberService.getAge()
								);
				break;
			case 2:
				AccountService account = new AccountService();  //디폴드 생성자가 어카운트 서비스클래스에 있었는데.  우리 눈에 안 보이는 것이다.  그래서 여기서 이렇게 사용한다.
				account.setAccountNum();
				System.out.print("이름 입력 : ");
				name = scanner.next();
				System.out.println(name + "님의 계좌가 " 
				+ account.getAccountNum() + "로 개설 되었습니다");
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
