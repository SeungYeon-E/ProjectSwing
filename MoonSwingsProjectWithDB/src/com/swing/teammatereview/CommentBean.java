/* //CommentBean.java//
 * 쿼리작업시 받아올 데이터의 타입이 다르므로 bean 사용
 * 토이프로젝트의 아이템 그대로 복붛 및 주석처리
 * [1.0] 2021-04-29 윤재필
 * 
 */

package com.swing.teammatereview;

import java.awt.image.BufferedImage;

public class CommentBean {
	
	BufferedImage photo;
	String id;
	String name;
	String content;
	
	public CommentBean() {
		
	}
	
	public CommentBean(BufferedImage photo, String id, String name, String comment) {
		super();
		this.photo = photo;
		this.id = id;
		this.name = name;
		this.content = comment;
	}

	public BufferedImage getPhoto() {
		return photo;
	}

	public void setPhoto(BufferedImage photo) {
		this.photo = photo;
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

	public String getComment() {
		return content;
	}

	public void setComment(String comment) {
		this.content = comment;
	}
	
	

}