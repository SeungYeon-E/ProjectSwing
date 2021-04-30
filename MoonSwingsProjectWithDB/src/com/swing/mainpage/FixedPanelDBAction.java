package com.swing.mainpage;

import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;

import com.swing.DB.ShareVar;

public class FixedPanelDBAction {
	
	private final String url_mysql =  ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	
	
	public FixedPanelDBAction(String id) {
		super();
		this.id = id;
	}
	
	public String[] getFixedPanelInfo() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String searchId,name,mbti,github_id = "";
		String[] briefInfo = new String[4];
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

	        String A = "select id, name, mbti, github_id from student where id = ?";
	        

	        ps = conn_mysql.prepareStatement(A);
	        
	        ps.setString(1, id.trim());
	        
	      
	        rs = ps.executeQuery();

	        rs.next();
	        
	        searchId = rs.getString(1);
	        name = rs.getString(2);
	        mbti = rs.getString(3);
	        github_id = rs.getString(4);
	        
	    
	        System.out.println(searchId + name + mbti + github_id);
	        conn_mysql.close();
	        briefInfo[0] = searchId;
	        briefInfo[1] = name;
	        briefInfo[2] = mbti;
	        briefInfo[3] = github_id;
	        
	        return briefInfo;
	        
	    } catch (Exception e){                    
	        e.printStackTrace();
	        return briefInfo;
	        
	    }
	}
	
	public BufferedImage getStudentImage() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BufferedImage im = null;
		
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

	        String A = "select photo from student where id = ?";
	        

	        ps = conn_mysql.prepareStatement(A);
	        
	        ps.setString(1, id.trim());
	        
	      
	        rs = ps.executeQuery();

	        rs.next();
	        
	        im = ImageIO.read(rs.getBinaryStream(1));
	        
            
	        
	        return im;
	        
	    } catch (Exception e){                    
	        e.printStackTrace();
	        return im;
	        
	    }
		
		
		
	}
}
