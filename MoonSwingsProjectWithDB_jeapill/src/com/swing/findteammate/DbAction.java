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
	
	// 조건 검색
	public ArrayList<Bean> ConditionQueryAction() {
		
		ArrayList <Bean> beanFTList = new ArrayList<Bean>();

		String query1 = "SELECT s.id, s.name, ";
		String query2 = "(SELECT t.name FROM joining j, team t WHERE s.id = j.student_id and j.team_no = t.no and j.secession is null, ";
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
				int wkTeamName = rs.getInt(3);
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
	public ArrayList<ArrayList<Bean>> selectSearchTeamStatusList(){
		ArrayList<ArrayList<Bean>> beanList = new ArrayList<ArrayList<Bean>>();
		ArrayList<Bean> beanFTList = new ArrayList<Bean>();
		ArrayList<Bean> beanUnteamed = new ArrayList<Bean>();
		String query1 = "SELECT s.id, s.name, ";
		String query2 = "(SELECT t.name FROM joining j, team t WHERE s.id = j.student_id and j.team_no = t.no AND j.secession is null, ";
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
				int wkTeamName = rs.getInt(3);
				String wkMbti =rs.getString(4);
				int wkDiptargetCount =rs.getInt(5);
				
				String stTeamName = Integer.toString(wkTeamName);

				if(wkTeamName == 0) {
					Bean bean = new Bean(wkId, wkName, wkTeamName, wkMbti, wkDiptargetCount);
					beanUnteamed.add(bean);
				}else if(stTeamName.equals(selection)) {
					Bean bean = new Bean(wkId, wkName, wkTeamName, wkMbti, wkDiptargetCount);
					beanFTList.add(bean);					
				}
			}
			beanList.add(beanUnteamed);
			beanList.add(beanFTList);
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanList;
	}
	
}// end line