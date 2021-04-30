package com.swing.findteammate;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.swing.DB.ShareVar;

public class DbAction2 {
	
	// Field
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;

	public DbAction2() {
		// TODO Auto-generated constructor stub
	}
	
	public DbAction2(String id) {
		super();
		this.id = id;
	}

	// method

	// Table Click 시 해당 Student id의 정보 가져오기.
	/*
	 * Table Click 시 해당 DB값을 AdminStudentProfile(새창)에 보여주기.
	 * id, name, photo, mbti, github_id, subway, phone, strength, introduce
	 * HyoGang Jo 
	 * */
	public Bean TableClick() {
		
		Bean bean = null;
        String query1 = "select id, name, photo, mbti, github_id, subway, phone, strength, introduce from student "; 
        String query2 = "where id = '" ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();
            ResultSet rs = stmt_mysql.executeQuery(query1 + query2 + id + "'");

            if(rs.next()){
            	String wkId = rs.getString(1);
            	String wkName = rs.getString(2);
            	Blob wkPhoto = rs.getBlob(3);
            	String wkMbti = rs.getString(4);
            	String wkGithub_id = rs.getString(5);
            	String wkSubway = rs.getString(6);
            	String wkPhone = rs.getString(7);
            	String wkStrength = rs.getString(8);
            	String wkIntroduce = rs.getString(8);
            	
            	bean = new Bean(wkId, wkName, wkPhoto, wkMbti, wkGithub_id, wkSubway, wkPhone, wkStrength, wkIntroduce);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bean;
	}// Table Click End
	
}// end line