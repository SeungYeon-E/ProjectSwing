package com.swing.DB;

public class Bean {
	
	//학생 정보
	String id;
	String name;
	String mbti;
	String github_id;
	String subway;
	String phone;
	String strength;
	String introduce;
	
	//조인 정보
	int student_id;
	int team_no;
	
	//팀 정보
	int no;
	
	
	
	public Bean(int no) {
		super();
		this.no = no;
	}

	public Bean(int no, String name) {
		super();
		this.name = name;
		this.no = no;
	}

	public Bean(String id, String name, String mbti, String github_id, String subway, String phone,
			String strength, String introduce) {
		super();
		this.id = id;
		this.name = name;
		this.mbti = mbti;
		this.github_id = github_id;
		this.subway = subway;
		this.phone = phone;
		this.strength = strength;
		this.introduce = introduce;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getGithub_id() {
		return github_id;
	}
	public void setGithub_id(String github_id) {
		this.github_id = github_id;
	}
	public String getSubway() {
		return subway;
	}
	public void setSubway(String subway) {
		this.subway = subway;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getTeam_no() {
		return team_no;
	}

	public void setTeam_no(int team_no) {
		this.team_no = team_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	

}
