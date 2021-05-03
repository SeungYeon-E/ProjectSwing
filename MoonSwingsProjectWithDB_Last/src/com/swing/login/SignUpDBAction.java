package com.swing.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.swing.DB.ShareVar;

public class SignUpDBAction {
	

	private final String url_mysql =  ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	String pw;
	String name;
	String mbti;
	String kakao_id;
	String github_id;
	String introduce;
	String subway;
	String strength;
	String phone;
	String status;
	String photo;

	// Construction
	
	public SignUpDBAction(String id){
		this.id = id;
	}
	
	public SignUpDBAction(String id, String pw, String name, String mbti, String phone, String github_id,
			String introduce, String subway, String strength,String photo) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mbti = mbti;
		this.phone = phone;
		this.github_id = github_id;
		this.introduce = introduce;
		this.subway = subway;
		this.strength = strength;
		this.photo = photo;
//		this.status = status;
//		this.phone = phone;
	}
	
	
	
	
	// Method
public boolean insertAction(){
		
        PreparedStatement ps = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

            String A = "INSERT INTO student (id, pw, name, mbti, phone, github_id, introduce, subway, strength, photo";
            String B = ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            InputStream inputStream = new FileInputStream(new File(photo));
            
            ps = conn_mysql.prepareStatement(A+B);
            
            ps.setString(1, id.trim());
            ps.setString(2, pw.trim());
            ps.setString(3, name.trim());
            ps.setString(4, mbti.trim());
            ps.setString(5, phone.trim());
            ps.setString(6, github_id.trim());
            ps.setString(7, introduce.trim());
            ps.setString(8, subway.trim());
            ps.setString(9, strength.trim());
            ps.setBlob(10, inputStream);
            
            ps.executeUpdate();

            conn_mysql.close();
            
            return true;
        } catch (Exception e){                    
            e.printStackTrace();
            return false;
        }
    
		
	}
public boolean idCheckInDB() {
	PreparedStatement ps = null;
	ResultSet rs = null;
	boolean result = false;
	
	try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        @SuppressWarnings("unused")
		Statement stmt_mysql = conn_mysql.createStatement();

        String A = "select id";
        String B = " from makeavengers.student where id = ?"  ;
        
        System.out.println(A+B);

        ps = conn_mysql.prepareStatement(A+B);
        
        ps.setString(1, id.trim());        
        rs = ps.executeQuery();
        
        
        
        if(rs.next()) {
        	result = true;
        }else {
        	result = false;
        }
        
        conn_mysql.close();
        return result;
    } catch (Exception e){                    
        e.printStackTrace();
        return false;
    }
	
}
	
	
	
}

