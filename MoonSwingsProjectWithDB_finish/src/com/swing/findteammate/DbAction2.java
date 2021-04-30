package com.swing.findteammate;

import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.swing.DB.ShareVar;
import com.swing.checkprofile.CheckProfileBean;

public class DbAction2 {
	
	// Field
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	String loginId;
	String id;
	int teamName;

	public DbAction2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DbAction2(String loginId, String id) {
		super();
		this.loginId = loginId;
		this.id = id;
	}


	public DbAction2(String id) {
		super();
		this.id = id;
	}
	
	

	// method
	
	//---------------------------------
	// 21.04.28 hyogang studentProfile
	//---------------------------------

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
            	BufferedImage wkPhoto = ImageIO.read(rs.getBinaryStream(3));
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

	
	//--------------------
	// 21.04.29 hyogang
	// Pick Method
	//--------------------
	
	
	// You picked by list -- beanPickedList
	public ArrayList<Bean> selectYouPickedByList(){
		
		ArrayList<Bean> beanPickedList = new ArrayList<Bean>();
		String query1 = "SELECT DISTINCT d.sender, sender.name, ";
		String query2 = "(SELECT t.name FROM team t, joining j "
						+ "WHERE d.sender = j.student_id "
						+ "AND j.team_no = t.no) as team_name "
						+ "FROM dip d, ";
		String query3 = "(SELECT st.id as id, d.target, st.name "
						+ "FROM student st, dip d "
						+ "WHERE st.id = d.sender) as sender ";
		String query4 =	"WHERE d.target = '" + id + "' AND d.sender = sender.id "
						+"AND d.cancellation is null";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query1+query2+query3+query4);
	
			while(rs.next()){
				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				int wkTeamName = rs.getInt(3);
				  
				Bean bean = new Bean(wkId, wkName, wkTeamName);
				beanPickedList.add(bean);
			}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanPickedList;
		
	} // selectYouPickedByList End
	
	
	// My Pick List ------- beanMyPickList 
	public ArrayList<Bean> selectMyPickList(){
		
		ArrayList<Bean> beanMyPickList = new ArrayList<Bean>();
		String query1 = "SELECT DISTINCT d.target, target.name, ";
		String query2 = "(SELECT t.name FROM team t, joining j "
						+ "WHERE d.target = j.student_id "
						+ "AND j.team_no = t.no) as team_name "
						+ "FROM dip d, ";
		String query3 = "(SELECT st.id as id, d.target, st.name "
						+ "FROM student st, dip d "
						+ "WHERE st.id = d.target) as target ";
		String query4 =	"WHERE d.sender = '" + id + "' AND d.target = target.id "
						+"AND d.cancellation is null";

		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query1+query2+query3+query4);
	
			while(rs.next()){
				String wkId = rs.getString(1);
				String wkName = rs.getString(2);
				int wkTeamName = rs.getInt(3);
				  
				Bean bean = new Bean(wkId, wkName, wkTeamName);
				beanMyPickList.add(bean);
			}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanMyPickList;
		
	} // selectMyPickList End
	
	
	//insert into dip (application, sender, target) values (now(), 'ohoh9900', 'sajangnim');
	/*
	 * please Team with me btn Action - insert into dip
	 */
	public boolean insertDip() {
		  PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String query1 = "INSERT INTO dip (application, sender, target";
		      String query2 = ") VALUES (now(), ? , ? )";
		
		      ps = conn_mysql.prepareStatement(query1 + query2);
		      ps.setString(1, loginId);
		      ps.setString(2, id);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		      return true;
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }
	}// Please team with Me End
	
	
	// My pick table click 후 delete btn action
	// update dip cancellation date
	public void deleteMyDip() {
		  PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String query1 = "UPDATE dip SET cancellation = now() ";
		      String query2 = "WHERE sender = ? AND target = ? ";
		
		      ps = conn_mysql.prepareStatement(query1 + query2);
		      ps.setString(1, loginId);
		      ps.setString(2, id);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		      
		  } catch (Exception e){
		      e.printStackTrace();
		  }
	}// Please team with Me End

	
	/*
	 * Dip 현황 체크, 이미 pick한 학생 중복 pick 불가
	 */
	public ArrayList checkDipList() {
		ArrayList<Bean> beanDipList = new ArrayList<Bean>();
		String query1 = "select application, sender, target from dip where cancellation is null";

		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(query1);
	
			while(rs.next()){
				String wkApplication = rs.getString(1);
				String wkSender = rs.getString(2);
				String wkTarget = rs.getString(3);
				  
				Bean bean = new Bean(wkSender, wkTarget);
				beanDipList.add(bean);
			}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanDipList;
	} // checkDipList End
	
	// Table Column : ProjectName, TeamName, GitAddress
	public ArrayList<Bean> selectStudentProjectList(){
		
		ArrayList<Bean> beanList = new ArrayList<Bean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        String selectDefault = "select p.name, t.name, t.project_git_address "
	        		+ "from joining j, team t, do d, project p "
	        		+ "where j.student_id = ? and j.team_no = t.no and t.no = d.team_no "
	        		+ "and d.project_no = p.no";

	        ps = conn_mysql.prepareStatement(selectDefault);
	        ps.setString(1, id);
	        rs = ps.executeQuery();
	        
			while(rs.next()){
				String projectName = rs.getString(1);
				int teamName = rs.getInt(2);
				String teamGitAddress= rs.getString(3);
				
				Bean bean = new Bean(projectName,teamName,teamGitAddress);
				beanList.add(bean);
				
				}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanList;
		
	}
	
	// review Table column = Teammate Name, ProjectName, Review
	public ArrayList<Bean> selectStudentReviewList(){
		
		ArrayList<Bean> beanList = new ArrayList<Bean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();

	        String selectDefault =  "select (Select p.name from do d, project p "
	        		+ "where c.team_no and d.project_no = p.no limit 1) project_name, c.sender, c.content "
	        		+ "from comment c where c.target = ? ";
	        ps = conn_mysql.prepareStatement(selectDefault);
	        
	        ps.setString(1, id);
	        
	        rs = ps.executeQuery();
	        
			while(rs.next()){
				String projectName = rs.getString(1);
				String sender = rs.getString(2);
				String comment = rs.getString(3);
				
				Bean bean = new Bean(projectName, sender, comment);
				beanList.add(bean);
				}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanList;
		
	}
	
	
	
}// end line