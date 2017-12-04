package com.kabank.web.bean;

public class MemberBean {
	private int customNum, age;
	private String name, gender, ssn;

	// 0 또는 null을 줄때는 생성자를 안 만들어도 된다.
	public void setCustomNum(int customNum) {           //setter라고 한다. 외부에서 값을 받아줘야해서 파라미터가 있다
		this.customNum = customNum;						//하지만 개발자가 판단해서, 외부에서 받을거냐 내부에서 연산할거냐를 구분해서,
	}													// 파라미터 쓸지말지 결정해라

	public int getCustomNum() {							//getter라고 한다. read 읽기 전용 메소드라서 파라미터가 없다
		return customNum;								// 원래는 customNum인데 CumstomNum이라고 바뀐이유? 네이밍 규칙때문에
	}

	public void setName(String name) {					//setter는 void!
		this.name = name;								//컨스트럭터에서 초기화한 걔한테 줌.
	}

	public String getName() {							//리턴할 녀석의 타입을 줘야됨
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
