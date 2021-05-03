package com.swing.teammatereview;

public class StudentBean {
	String id;
	String pw;
	String photo;
	String name;
	String mbti;
	String github_id;
	String introduce;
	String subway;
	String strength;
	String phone;
	
	
	public StudentBean() {
		
	}
	
	public StudentBean(String id, String pw, String photo, String name, String mbti, String github_id, String introduce,
			String subway, String strength, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.photo = photo;
		this.name = name;
		this.mbti = mbti;
		this.github_id = github_id;
		this.introduce = introduce;
		this.subway = subway;
		this.strength = strength;
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	
	
}