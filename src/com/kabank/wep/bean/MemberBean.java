package com.kabank.wep.bean;

public class MemberBean {
	private int customNum, age;
	private String name, gender, ssn;

	// 0 또는 null을 줄때는 생성자를 안 만들어도 된다.
	public void setCustomNum(int customNum) {
		this.customNum = customNum;
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

	public void setAge(int age) {
		
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public String getGender() {
		return gender;

	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}
	
	
}
