package com.swing.adminannouncement;

public class Bean {

	// field
	int no;
	String title;
	String content;
	String writing;
	int views;
	
	// constructor
	public Bean() {
		// TODO Auto-generated constructor stub
	}
	
	public Bean(int no, String writing, String title, int views) {
		super();
		this.no = no;
		this.title = title;
		this.writing = writing;
		this.views = views;
	}
	
	public Bean(int no, String title, String writing, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writing = writing;

	}
	
	
	//---------------------------
	// method
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	

	
	
}
