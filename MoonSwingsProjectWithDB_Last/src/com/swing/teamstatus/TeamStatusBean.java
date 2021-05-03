package com.swing.teamstatus;

public class TeamStatusBean {
	
	//학생 정보
	String name;
	String id;

	//조인 정보
	int student_id;
	int team_no;
	
	//팀 정보
	int no;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TeamStatusBean(int no, String name) {
		super();
		this.name = name;
		this.no = no;
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