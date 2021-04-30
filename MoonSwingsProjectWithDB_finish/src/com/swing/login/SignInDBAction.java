package com.swing.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.swing.DB.ShareVar;

public class SignInDBAction {
	private final String url_mysql =  ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	String pw;
	
	
	public SignInDBAction(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public boolean CheckLoginAction() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

	        String A = "SELECT * FROM student";
	        String B = " WHERE id = ? AND pw = ?"  ;
	        
	        System.out.println(A+B);

	        ps = conn_mysql.prepareStatement(A+B);
	        
	        ps.setString(1, id.trim());
	        ps.setString(2, pw.trim());
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
	public boolean CheckTeacherLoginAction() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

	        String A = "SELECT * FROM teacher";
	        String B = " WHERE id = ? AND pw = ?"  ;
	        
	        System.out.println(A+B);

	        ps = conn_mysql.prepareStatement(A+B);
	        
	        ps.setString(1, id.trim());
	        ps.setString(2, pw.trim());
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
	        return result;
	    }
	}
	
}
