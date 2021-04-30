// 21.04.29 hyokyeong ------------
package com.swing.findteammate;

import java.awt.image.BufferedImage;

public class Bean {

	// field
	String id ;
	BufferedImage photo;
//	Blob photo;
	String name;
	String mbti;
	String github_id;
	String subway;
	String phone;
	String strength;
	String introduce;
	int teamName;
//	String teamName;
	int diptargetCount;
	String sender;
	String target;
	String projectName;
	String comment;
	String teamGitAddress;
	

	


	// constructor
	public Bean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Bean(String projectName, String sender, String comment) {
		super();
		this.sender = sender;
		this.projectName = projectName;
		this.comment = comment;
	}



	public Bean(String id) {
		super();
		this.id = id;
	}
	
	public Bean(String sender, String target) {
		super();
		this.sender = sender;
		this.target = target;
	}
	
	
	

	public Bean(String projectName, int teamName, String teamGitAddress) {
		super();
		this.teamName = teamName;
		this.projectName = projectName;
		this.teamGitAddress = teamGitAddress;
	}

	// FindTeammate - My Pick and You Picked by tabel column --------
	public Bean(String id, String name, int teamName) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
	}// -------- FindTeammate - My Pick and You Picked by tabel column 

	
	// FindTeammate and Student List의 Profile ----------------------
	public Bean(String id, String name, BufferedImage photo, String mbti, String github_id, String subway, String phone,
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
	}// ---------------------- FindTeammate and Student List의 Profile 
	
	
	// FindTeammate and Admin Student List Table ----------------------
	public Bean(String id, String name, int teamName, String mbti, int diptargetCount) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.mbti = mbti;
		this.diptargetCount = diptargetCount;
	}// ---------------------- FindTeammate and Admin Student List Table
	
	
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


	public BufferedImage getPhoto() {
		return photo;
	}

	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getTeamName() {
		return teamName;
	}

	public void setTeamName(int teamName) {
		this.teamName = teamName;
	}

	public int getDiptargetCount() {
		return diptargetCount;
	}

	public void setDiptargetCount(int diptargetCount) {
		this.diptargetCount = diptargetCount;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTeamGitAddress() {
		return teamGitAddress;
	}

	public void setTeamGitAddress(String teamGitAddress) {
		this.teamGitAddress = teamGitAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}