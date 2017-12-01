package com.kabank.web.serviceImpl;

import java.util.Random;

public class AccountServiceImpl {
	private String name;
	private int accountNum;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAccountNum() {
		Random r = new Random();
		boolean flag = true;
		while (flag) {
			int temp = r.nextInt(1000000);
			if (temp > 100000) {
				accountNum = temp;
				flag = false;
			} else {
				flag = true;
			}
		}
	}

	public int getAccountNum() {
		return this.accountNum;
	}

}

// package com.kabank.web.service;
//
// import java.util.Random;
// import java.util.Scanner;
// public class AccountService {
// Random gen = new Random();
// private String name = "";
// String accNum = "";
// public String createAccount(Scanner scanner) {
// for(int i = 0; i < 16; i++) {
// if(i != 0 && i % 4 == 0) {
// accNum += "-";
// }
// accNum += gen.nextInt(10);
// }
// return accNum;
// }
// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }
// }

// package com.kabank.web.service;
// import java.util.Random;
// import java.util.Scanner;
//// 홍길동 1234 계좌번호 발급
// public class AccountService {
// public int createAccount() {
//// (Scanner scanner) 이게 파라미터라고한다 매개변수
// String name = "";
// System.out.print("이름");
// // 100000 ~ 999999
// Random r = new Random();
// int accountNo = 0;
// boolean flag = true;
// while(flag) {
// int temp = r.nextInt(1000000);
// if(temp >= 100000) {
// accountNo = temp;
// flag = false;
// }else {
// flag = true;
// }
// }
// return accountNo;
// }
// }
