package com.swing.adminteamstatus;

public class AdminTeamStatusBean {
	
	//학생 정보
	String id;
	String name;
	String mbti;
	String dip;
	
	//조인 정보
	int student_id;
	int team_no;
	
	//팀 정보
	int no;

	public AdminTeamStatusBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public AdminTeamStatusBean(String id, String name, String mbti, String dip) {
		super();
		this.id = id;
		this.name = name;
		this.mbti = mbti;
		this.dip = dip;
	}

	public AdminTeamStatusBean(int no, String name) {
		super();
		this.name = name;
		this.no = no;
	}
	
	public AdminTeamStatusBean(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMbti() {
		return mbti;
	}

	public void setMbti(String mbti) {
		this.mbti = mbti;
	}

	public String getDip() {
		return dip;
	}

	public void setDip(String dip) {
		this.dip = dip;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}