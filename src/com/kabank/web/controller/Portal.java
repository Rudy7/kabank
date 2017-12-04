package com.kabank.web.controller;

import java.util.Scanner;
import com.kabank.web.bean.MemberBean;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원수 입력");												    
		MemberServiceImpl memberService = new MemberServiceImpl(scanner.nextInt());    // 이제 1~4케이스가 다 쓰니까 맨 위로 올려줌.
		MemberBean member = null;													   // MemberBean memberbean = null; 으로 하지 않고  member를 쓰는걸까?
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
						
						memberService.addMember(member);						      //회원수를 무한이 늘려야해서 몇명인지 물어보고 그 수만큼 회원수의 제한을 잡기위해 쓴다2. 
						
						System.out.printf(""
								+ "\n[고객번호]" + member.getCustomNum()
								+ "\n[주민번호]" + member.getSsn()
								+ "\n[이름]" + member.getName()
								+ "\n[성별]" + member.getGender()
								+ "\n[나이]" + member.getAge() + "\n");
				
						break;
					case 2:
						AccountServiceImpl accountService = new AccountServiceImpl();  //디폴드 생성자가 어카운트 서비스클래스에 있었는데.  우리 눈에 안 보이는 것이다.  그래서 여기서 이렇게 사용한다.
				
						System.out.print("이름 입력 : ");
						accountService.setName(scanner.next());
						accountService.setAccountNum();
						// String name2 = scanner.next();
						System.out.println("[이름]" + accountService.getName() + "\n"
								  +"[계좌번호]" + accountService.getAccountNum());
						break;
					case 3:
						System.out.println("총 회원수 : " + memberService.count());
						break;
					case 4:
						MemberBean[] members = memberService.list();      //멤버서비스는 주방. 멤버스에게 리스트를 다오.
						for(int i=0; i<members.length; i++) {
							System.out.println(members[i].getName());
						}
						break;
				}
		}
	}
}
// 여기 있는 임폴트한 스케너를 어카운터서비스로 같이 쓸때 (scanner) 써준다.
// 가장 주의할 사항은 컨트롤 + F11을 하고 이름이나 주민번호 같은 값을 쓸때. 무작정 쓰지말고, 방향키 아래나 오른쪽을 눌러주고 써야 java.lang.numberformatexception 에러가 안난다.
