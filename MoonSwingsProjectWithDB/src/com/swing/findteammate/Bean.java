package com.swing.findteammate;

import java.sql.Blob;

public class Bean {

	// field
	String id ;
	Blob photo;
	String name;
	String mbti;
	String github_id;
	String subway;
	String phone;
	String strength;
	String introduce;
	String teamName;
	int diptargetCount;
	

	


	// constructor
	public Bean() {
		// TODO Auto-generated constructor stub
	}

	public Bean(String id) {
		super();
		this.id = id;
	}


	public Bean(String id, String name, Blob photo, String mbti, String github_id, String subway, String phone,
			String strength, String introduce) {
		super();
		this.id = id;
		this.photo = photo;
		this.name = name;
		this.mbti = mbti;
		this.github_id = github_id;
		this.subway = subway;
		this.phone = phone;
		this.strength = strength;
		this.introduce = introduce;
	}

	public Bean(String id, String name, String teamName, String mbti, int diptargetCount) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.mbti = mbti;
		this.diptargetCount = diptargetCount;
	}
	
	// method
	
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


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getSubway() {
		return subway;
	}


	public void setSubway(String subway) {
		this.subway = subway;
	}


	public String getStrength() {
		return strength;
	}


	public void setStrength(String strength) {
		this.strength = strength;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getDiptargetCount() {
		return diptargetCount;
	}

	public void setDiptargetCount(int diptargetCount) {
		this.diptargetCount = diptargetCount;
	}
	
}