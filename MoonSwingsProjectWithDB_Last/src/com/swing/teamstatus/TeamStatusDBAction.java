package com.swing.teamstatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.swing.teamstatus.TeamStatusBean;
import com.swing.DB.ShareVar;

public class TeamStatusDBAction {
	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	//학생 정보
	String name;
	String id;

	//조인 정보
	int student_id;
	int team_no;
	
	//팀 정보
	int no;
	
	
	
	public TeamStatusDBAction(String id) {
		super();
		this.id = id;
	}

	public TeamStatusDBAction() {
		// TODO Auto-generated constructor stub
	}
	
	//TeamStatus In Action
	public boolean teamStatusInAction(int selectedrdb) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		String now = year + "-" + month + "-" + date ;
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			//여기만 변경될거야
			String query = "INSERT INTO joining (creation, student_id, team_no) VALUES (?, ?, ?)"; //? 쓰기위해 프리페어 선언 ?에 입력창에 들어갈것
			ps = conn_mysql.prepareStatement(query); //컴파일전에 자바로 바꿔줘
			
			ps.setString(1, now);
			ps.setString(2, id);
			ps.setInt(3, selectedrdb);
			ps.executeUpdate();//입력되면 업데이트된다
			
			conn_mysql.close();// 사용후 데이터베이스 연결 끊음
			
			JOptionPane.showMessageDialog(null, selectedrdb + "팀에 정보가 입력되었습니다.");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//TeamStatus Out Action
	public boolean teamStatusOutAction() {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		String now = year + "-" + month + "-" + date ;
		
		PreparedStatement ps = null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			//수정하기
			String A = "UPDATE joining SET secession = ? WHERE student_id = ?";
			ps = conn_mysql.prepareStatement(A);
			//수정하기
			ps.setString(1, now);
	        ps.setString(2, id.trim());
			ps.executeUpdate();
			
			conn_mysql.close();
			
			JOptionPane.showMessageDialog(null, "팀에서 정보가 삭제되었습니다.");
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//teammate status 불러오기
	public ArrayList<TeamStatusBean> ShowTeammateStatus(){
		
		ArrayList<TeamStatusBean> beanList = new ArrayList<TeamStatusBean>();
		String WhereDefault = "SELECT t.name, s.name "
								+ "FROM student s, joining j, team t "
								+ "WHERE s.id = j.student_id AND j.team_no = t.no AND j.secession IS NULL;";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);//레코드 단위로 가져온다
		
			while(rs.next()){
				int wkteamname = rs.getInt(1);
				String wkname = rs.getString(2);
				
				TeamStatusBean bean = new TeamStatusBean(wkteamname, wkname);
				beanList.add(bean);
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
			
		return beanList;
	}
	
	public String getIdInTeamStatus() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

	        String A = "select name";
	        String B = " from makeavengers.student where id = ?"  ;
	        
	        System.out.println(A+B);

	        ps = conn_mysql.prepareStatement(A+B);
	        
	        ps.setString(1, id.trim());        
	        rs = ps.executeQuery();
	        
	        rs.next();
	        
	        String name = rs.getString(1);
	        
	        conn_mysql.close();
	        
	        return name;
	    } catch (Exception e){                    
	        e.printStackTrace();
	        return name;
	    }
		
	}
	

}