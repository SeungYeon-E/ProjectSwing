package com.swing.checkprofile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.swing.checkprofile.CheckProfileBean;
import com.swing.DB.ShareVar;

public class CheckProfileDBAction {
	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	String name;
	String mbti;
	String github_id;
	String subway;
	String phone;
	String strength;
	String introduce;
	
	public CheckProfileDBAction() {
		// TODO Auto-generated constructor stub
	}
	
	public CheckProfileDBAction(String id, String name, String mbti, String github_id, String subway, String phone,
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
	
	
	//checkkProfile 내 정보 불러오기
	public CheckProfileBean checkProfileAction(){
		
		CheckProfileBean bean = null;
		//수정해야함
		String WhereDefault = "SELECT id, name, mbti, github_id, subway, phone, strength, introduce FROM student WHERE id = 'crybaby'";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);//레코드 단위로 가져온다
		
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String mbti = rs.getString(3);
				String github_id = rs.getString(4);
				String subway = rs.getString(5);
				String phone = rs.getString(6);
				String strength = rs.getString(7);
				String introduce = rs.getString(8);
				
				bean = new CheckProfileBean(id, name, mbti, github_id, subway, phone, strength, introduce);
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
			
		return bean;
	}
	
	//checkProfile 수정하기
	public boolean checkProfileUpdateAction() {
		
		PreparedStatement ps = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String A = "UPDATE student SET mbti = ?, github_id = ?, subway = ?, phone = ?, strength = ?, introduce = ? WHERE id = ?";

			ps = conn_mysql.prepareStatement(A);
	        ps.setString(1, mbti.trim());
	        ps.setString(2, github_id.trim());
	        ps.setString(3, subway.trim());
	        ps.setString(4, phone.trim());
	        ps.setString(5, strength.trim());
	        ps.setString(6, introduce.trim());
	        ps.setString(7, id);
			ps.executeUpdate();
			
			conn_mysql.close();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
      
		}
	}

}
