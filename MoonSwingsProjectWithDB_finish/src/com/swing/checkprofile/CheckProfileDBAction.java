package com.swing.checkprofile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.swing.DB.ShareVar;
import com.swing.login.Login;


public class CheckProfileDBAction {
	
	private final String url_mysql =  ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	
	String mbti;
	String github_id;
	String address;
	String phone;
	String strength;
	String introduce;
	String photo;
	
	public CheckProfileDBAction(String id) {
		super();
		this.id = id;
	}
	
	

	public CheckProfileDBAction(String id, String mbti, String github_id, String address, String phone, String strength,
			String introduce) {
		super();
		this.id = id;
		this.mbti = mbti;
		this.github_id = github_id;
		this.address = address;
		this.phone = phone;
		this.strength = strength;
		this.introduce = introduce;
		
	}



	public CheckProfileDBAction(String id, String photo) {
		super();
		this.id = id;
		this.photo = photo;
	}



	String[] checkProfileInfo = new String[8];
	
public String[] insertAction(){
		
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();


            String A = "select id, name, mbti, github_id, subway, phone, strength, introduce from student where id = ?";
            
            ps = conn_mysql.prepareStatement(A);
            
            ps.setString(1, id.trim());

            rs = ps.executeQuery();
            
            rs.next();
            checkProfileInfo[0] = rs.getString(1);
            checkProfileInfo[1] = rs.getString(2);
            checkProfileInfo[2] = rs.getString(3);
            checkProfileInfo[3] = rs.getString(4);
            checkProfileInfo[4] = rs.getString(5);
            checkProfileInfo[5] = rs.getString(6);
            checkProfileInfo[6] = rs.getString(7);
            checkProfileInfo[7] = rs.getString(8);

            System.out.println(checkProfileInfo[7]);
            
            conn_mysql.close();
            
            
            
            return checkProfileInfo;
        } catch (Exception e){                    
            e.printStackTrace();
            return checkProfileInfo;
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
public boolean updateUserProfile() {
	PreparedStatement ps = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        @SuppressWarnings("unused")
		  Statement stmt_mysql = conn_mysql.createStatement();

        String A = "update student set mbti = ?, github_id = ?, subway = ?, phone = ?, strength = ?, introduce = ? where id = ? ";
        

        ps = conn_mysql.prepareStatement(A);
        
        ps.setString(1, mbti);
        ps.setString(2, github_id);
        ps.setString(3, address);
        ps.setString(4, phone);
        ps.setString(5, strength);
        ps.setString(6, introduce);
        ps.setString(7, id);
        ps.executeUpdate();
        
        System.out.println("updated User Profile");
        
        conn_mysql.close();
        
        return true;
    } catch (Exception e){
        e.printStackTrace();
        return false;
    }

}

public boolean makeNullUserPhoto() {
	PreparedStatement ps = null;
	
	try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        @SuppressWarnings("unused")
		Statement stmt_mysql = conn_mysql.createStatement();

        String A = "update student set photo = null where id = ? ";
        
        InputStream inputStream = new FileInputStream(new File(photo));
        
        ps = conn_mysql.prepareStatement(A);
        
        
        ps.setString(1, id.trim());
        ps.executeUpdate();
        
        System.out.println("Now Your Photo is null");
        
        conn_mysql.close();
        
        return true;
        
    } catch (Exception e){
        e.printStackTrace();
        
        return false;
    }
	
	
}

public boolean updateUserPhoto() {
	
	PreparedStatement ps = null;

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        @SuppressWarnings("unused")
		Statement stmt_mysql = conn_mysql.createStatement();

        String A = "update student set photo = ? where id = ? ";
        
        InputStream inputStream = new FileInputStream(new File(photo));
        
        ps = conn_mysql.prepareStatement(A);
        
        ps.setBlob(1, inputStream);
        ps.setString(2, id);
        ps.executeUpdate();
        
        System.out.println("updated User Photo");
        
        conn_mysql.close();
        
        return true;
        
    } catch (Exception e){
        e.printStackTrace();
        
        return false;
    }

}

public ArrayList<CheckProfileBean> selectCheckProfileMyProjectList(){
	
	ArrayList<CheckProfileBean> beanList = new ArrayList<CheckProfileBean>();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();
//        do.project_no = project.no
//         team.no = do.team_no
        String selectDefault = "select p.name, t.name, t.project_git_address from joining j, team t, do d, project p where j.student_id = ? and j.team_no = t.no and t.no = d.team_no and d.project_no = p.no";
        
        
        
        
        ps = conn_mysql.prepareStatement(selectDefault);
        
        ps.setString(1, id);
        
        rs = ps.executeQuery();
        
		while(rs.next()){
			String projectName = rs.getString(1);
			int teamName = rs.getInt(2);
			String teamGitAddress= rs.getString(3);
			
			System.out.println("this is DB thing in project");
			CheckProfileBean bean = new CheckProfileBean(projectName,teamName,teamGitAddress);
			beanList.add(bean);
			}
		
		conn_mysql.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return beanList;
	
}

public ArrayList<CheckProfileBean> selectCheckProfileReviewList(){
	
	ArrayList<CheckProfileBean> beanList = new ArrayList<CheckProfileBean>();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();
//        do.project_no = project.no
//         team.no = do.team_no
        String selectDefault = "select c.sender, c.content, (Select p.name from do d, project p where c.team_no and d.project_no = p.no limit 1) project_name from comment c where c.target = ?";
        
        System.out.println(selectDefault);
        
        
        ps = conn_mysql.prepareStatement(selectDefault);
        
        ps.setString(1, id);
        
        rs = ps.executeQuery();
        
		while(rs.next()){
			String senderName = rs.getString(1);
			String comment = rs.getString(2);
			String projectName = rs.getString(3);
			
			System.out.println("this is CheckTeam REVIEW DB thing in project");
			CheckProfileBean bean = new CheckProfileBean(senderName,projectName,comment);
			beanList.add(bean);
			}
		
		conn_mysql.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return beanList;
	
}



}
