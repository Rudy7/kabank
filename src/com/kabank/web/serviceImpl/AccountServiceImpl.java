package com.kabank.web.serviceImpl;

import java.util.Random;

/*
 * 님 앞으로 1234-통장개설이 되었습니다.
 */

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
		// Q. 100000~999999 6자리가 만들어지면 빠져나와라
		while (flag) {
			int temp = r.nextInt(1000000);   				//한번쓰고 말 변수들은 이렇게 바로 이닛을 해라
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

