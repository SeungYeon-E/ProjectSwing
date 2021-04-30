package com.swing.findteammate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.swing.DB.ShareVar;
import com.swing.findteammate.Bean;

public class DbAction {
	
	// Field
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String id;
	String name;
	String github_id;
	String teamName;
	String ConditionQueryColumn;
	String selection;
	
	
	// constructor
	public DbAction() {
		// TODO Auto-generated constructor stub
	}

	public DbAction(String selection) {
		super();
		this.selection = selection;
	}

	public DbAction(String conditionQueryColumn, String selection) {
			super();
			ConditionQueryColumn = conditionQueryColumn;
			this.selection = selection;
		}

	
	// method
	
	// Admin : Student List Table에 전부 띄우기
	// FindTeamMate Table에 DB값 가져와서 띄우기
//	public ArrayList<Bean> selectFindTeammateList(){
//		ArrayList<Bean> beanFTList = new ArrayList<Bean>();
//		String query1 = "select s.name, s.github_id, t.name, s.mbti from student s, joining j, team t ";
//		String query2 = "where s.id = j.student_id and j.team_no = t.no ";
//		
//	    try{
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
//	        Statement stmt_mysql = conn_mysql.createStatement();
//	        
//	        ResultSet rs = stmt_mysql.executeQuery(query1+query2);
//	
//			while(rs.next()){
//				String wkName = rs.getString(1);
//				String wkGithub_id = rs.getString(2);
//				String wkTeamName = rs.getString(3);
//				String wkMbti =rs.getString(4);
//				  
////				Bean bean = new Bean(wkName, wkGithub_id, wkTeamName, wkMbti);
////				beanFTList.add(bean);
//				}
//			
//			conn_mysql.close();
//	    }
//	    catch (Exception e){
//	        e.printStackTrace();
//	    }
//	    return beanFTList;
//		
//	}
	
	// Admin : Student List Table에 ID, Name, TeamStatus, MBTI, Dip count 띄우기
	public ArrayList<Bean> selectStudentList(){
		ArrayList<Bean> beanFTList = new ArrayList<Bean>();
		String query1 = "SELECT s.id, s.name, ";
		String query2 = "(SELECT t.name FROM joining j, team t WHERE s.id = j.student_id and j.team_no = t.no), ";
		String query3 = "s.mbti, count(d.target) FROM student s ";
		String query4 =	"LEFT JOIN dip d on s.id = d.target GROUP BY s.id";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query1+query2+query3+query4);
	
			while(rs.next()){
				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				String wkTeamName = rs.getString(3);
				String wkMbti =rs.getString(4);
				int wkDiptargetCount =rs.getInt(5);
				  
				Bean bean = new Bean(wkId, wkName, wkTeamName, wkMbti, wkDiptargetCount);
				beanFTList.add(bean);
				}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanFTList;
		
	}
	
	// 조건 검색
	public ArrayList<Bean> ConditionQueryAction() {
		
		ArrayList <Bean> beanFTList = new ArrayList<Bean>();

		String query1 = "SELECT s.id, s.name, ";
		String query2 = "(SELECT t.name FROM joining j, team t WHERE s.id = j.student_id and j.team_no = t.no), ";
		String query3 = "s.mbti, count(d.target) FROM student s LEFT JOIN dip d on s.id = d.target ";
		String query4 =	"WHERE " + ConditionQueryColumn + " like '%"+ selection +"%' GROUP BY s.id";
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();

            ResultSet rs = stmt_mysql.executeQuery(query1 + query2 + query3 + query4);

			while(rs.next()){
				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				String wkTeamName = rs.getString(3);
				String wkMbti =rs.getString(4);
				int wkDiptargetCount =rs.getInt(5);
				  
				Bean bean = new Bean(wkId, wkName, wkTeamName, wkMbti, wkDiptargetCount);
				beanFTList.add(bean);
            }
            conn_mysql.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
		
        return beanFTList;
	}
	/*
		Student List combo_bax -> team status로 search시
		data 전부 가져와서, selection 값 == (TextField값) 만 beanFTList에 저장.
	 */
	public ArrayList<Bean> selectSearchTeamStatusList(){
		ArrayList<Bean> beanFTList = new ArrayList<Bean>();
		String query1 = "SELECT s.id, s.name, ";
		String query2 = "(SELECT t.name FROM joining j, team t WHERE s.id = j.student_id and j.team_no = t.no), ";
		String query3 = "s.mbti, count(d.target) FROM student s ";
		String query4 =	"LEFT JOIN dip d on s.id = d.target GROUP BY s.id";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query1+query2+query3+query4);
	
			while(rs.next()){
				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				String wkTeamName = rs.getString(3);
				String wkMbti =rs.getString(4);
				int wkDiptargetCount =rs.getInt(5);
				
				if(wkTeamName == null) {
					continue;
				}else if(wkTeamName.equals(selection)) {
					Bean bean = new Bean(wkId, wkName, wkTeamName, wkMbti, wkDiptargetCount);
					beanFTList.add(bean);					
				}
			}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanFTList;
	}
	
}// end line