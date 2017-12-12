package com.kabank.web.controller;

import java.security.Provider.Service;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		MemberServiceImpl memberService = new MemberServiceImpl(); // 이제 1~4케이스가 다 쓰니까 맨 위로 올려줌.
		MemberBean member = null; // MemberBean memberbean = null; 으로 하지 않고 member를 쓰는걸까?
		while (true) {
			switch (JOptionPane.showInputDialog("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수\n" 
											  + " 4.회원목록 5.로그인 6.ID검색 7. 이름검색\n"
											  + " 8.비번수정 9. 회원탈퇴 10.회원전체삭제" // 하나만 탈퇴할때는 remove
			)) {
			case "0":   //종료
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":  //회원가입
				String spec = JOptionPane.showInputDialog("이름/주민번호/id/pass"); // 순서 중요. 슬러시가 토큰이다. 0,1,2,3 순서다
				// String[] arr = spec.split("/"); //@@@@@@@@@중요하다. 외워라 핫산
				String[] dummy = { "홍길동/800101-1234567/hong/1", 
								  "김유신/900203-1345678/kim/1",
								  "이이/900304-1894567/lee/1",
								  "유관순/850123-2234123/you/1",
								  "유관순/850123-2234223/you2/2",
							      "신사임당/950123-2712345/shin/1" };
				for (int i = 0; i < dummy.length; i++) {
					member = new MemberBean(); // 위치가 포문 안에 있어야 한다. 다른데 있으면 오버로딩이 된다.. 다 신사임당 나온다. 여기에 있는 카피가딥카피가 된다. 위로
												// 올리면 얇은 쉘로우카피가된다.
					String[] arr = dummy[i].split("/"); // 쉘로우카페가 필요할때-로그인했을때.페이지이동시.페이지마다 나를 카피해서 보내는 것이다. 네이버에서 여러창
														// 열어두면 다 로그인되어 있다.
					member.setName(arr[0]);
					member.setSsn(arr[1]);
					member.setId(arr[2]);
					member.setPass(arr[3]);
					member.setCustomNum(memberService.createCustomNum());
					member.setGender(memberService.findGender(member.getSsn()));
					member.setAge(memberService.findAge(member.getSsn()));
					memberService.addMember(member); // 회원수를 무한이 늘려야해서 몇명인지 물어보고 그 수만큼 회원수의 제한을 잡기위해 쓴다2.
				}
				break;
			case "2":  //계좌개설
				AccountServiceImpl accountService = new AccountServiceImpl(); // 디폴드 생성자가 어카운트 서비스클래스에 있었는데. 우리 눈에 안 보이는
																				// 것이다. 그래서 여기서 이렇게 사용한다.
				accountService.setName(JOptionPane.showInputDialog("이름 입력 : "));
				accountService.setAccountNum();
				JOptionPane.showMessageDialog(null,
						"[이름]" + accountService.getName() + "\n" + "[계좌번호]" + accountService.getAccountNum());
				break;
			case "3":   //총회원수
				JOptionPane.showMessageDialog(null, "총 회원수 : " + memberService.count());
				break;
			case "4":   //회원목록
				JOptionPane.showMessageDialog(null, memberService.list()); // @@@@@ members.get(i)는 곧 members[i] 이다

				break;
			case "5":   //로그인
				String[] arr = JOptionPane.showInputDialog("ENTER ID / PASS").split("/"); // 이 한줄은 객체이다. 끝에.찍으면 메소드를
																							// 붙일수있다. 객체다음에만 메소드를 붙일수있다.
																							// new없이도객체를 만든다 어떻게 카피를
																							// 쓴거다.이해를 해야한다.
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPass(arr[1]);
				String loginOk = memberService.login(member);
				JOptionPane.showMessageDialog(null, loginOk);
				break;
			case "6":   //ID검색
				// member = new memberService 이게 생략된 것이다. 그래서 아랫줄이 객체가 되었다. 카피 이용
				JOptionPane.showMessageDialog(null,
						memberService.findById(JOptionPane.showInputDialog("ENTER SEARCH ID")).toString());  //.toString()
				break;
			case "7":	//이름검색
				JOptionPane.showMessageDialog(null,
						memberService.findByName(JOptionPane.showInputDialog("ENTER SEARCH NAME")).toString());  //.toString()
				break;
			case "8":  //비번수정
				memberService.updatePass(JOptionPane.showInputDialog("아이디를 입력해 주세요."));
				break;
//			case "9":	//회원탈퇴
//				memberService.delete(JOptionPane.showInputDialog("아이디를 입력해주세요."));
				
//				break;
			case "10":	//회원전체탈퇴
				 memberService.deleteAll(JOptionPane.showInputDialog("정말 회원 전체를 탈퇴하시겠습니까? "));
				break;
			}
		}
	}

}
// 여기 있는 임폴트한 스케너를 어카운터서비스로 같이 쓸때 (scanner) 써준다.
// 가장 주의할 사항은 컨트롤 + F11을 하고 이름이나 주민번호 같은 값을 쓸때. 무작정 쓰지말고, 방향키 아래나 오른쪽을 눌러주고 써야
// java.lang.numberformatexception 에러가 안난다.
