package com.swing.checkprofile;

public class CheckProfileBean {
	
	
	String projectName;
	int teamName;
	String teamGitAddress;
	
	String comment;
	String SenderName;

	
	public CheckProfileBean(String projectName, String senderName,String comment) {
		super();
		this.projectName = projectName;
		this.comment = comment;
		this.SenderName = senderName;
	}

	public CheckProfileBean(String projectName, int teamName, String teamGitAddress) {
		super();
		this.projectName = projectName;
		this.teamName = teamName;
		this.teamGitAddress = teamGitAddress;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public int getTeamName() {
		return teamName;
	}
	
	public void setTeamName(int teamName) {
		this.teamName = teamName;
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

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		this.SenderName = senderName;
	}
	
	
	
	

}
