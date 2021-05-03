package com.swing.adminannouncement;
import com.swing.DB.ShareVar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAction {

	// Field
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pw_mysql = ShareVar.pw_mysql;
	
	int no;
	String writing;
	String title;
	String content;
	int views;
	
	// Construction
	public DbAction() {
		// TODO Auto-generated constructor stub
	}

	
	public DbAction(int no) {
		this.no = no;
	}

	public DbAction(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public DbAction(int no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
	
	public DbAction(int no, int views) {
		super();
		this.no = no;
		this.views = views;
	}

	// Method
/*
 * select list => selectAnnouncementList should be changed 
 * HyoGang Jo done with selectAnnouncement list which is shown in Announcement Panel
 * */
	// Announcement table의 db값 전부 불러오기~
	public ArrayList<Bean> selectAnnouncementList(){
		ArrayList<Bean> beanList = new ArrayList<Bean>();
		String WhereDefault = "select no, writing, title, views from Announcement where delete_date is null order by no desc ";
		
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        
	        ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
	
			while(rs.next()){
				int wkNo = rs.getInt(1);
				String wkWriting = rs.getString(2);
				String wkTitle = rs.getString(3);
				int wkviews =rs.getInt(4);
				  
				Bean bean = new Bean(wkNo, wkWriting, wkTitle, wkviews);
				beanList.add(bean);
				}
			
			conn_mysql.close();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	    return beanList;
		
	}
	//	selectAnnouncementList end
	
	/*
	 * when tableClicked the count in DB would be increased Action
	 * HyoGang Jo 
	 * TODO  Query Check!!! 
	 * */
	// table click count ++
	public void clickCount() {
		
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

            String A = "update Announcement set views = ? + 1  where no = ? ";

            ps = conn_mysql.prepareStatement(A);
            ps.setInt(1, views);
            ps.setInt(2, no);
            ps.executeUpdate();

            conn_mysql.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
	}
	// Click Count end 
	
	/*
	 * Table Click 시 해당 DB값을 Selcet, 화면 하단에 클릭한 공지의 No, title, writing date, content 보여주기.
	 * HyoGang Jo 
	 * */
	public Bean TableClick() {
		
		Bean bean = null;
        String WhereDefault = "select no, title, writing, content from Announcement "; 
        String WhereDefault2 = "where no = " ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            Statement stmt_mysql = conn_mysql.createStatement();
            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2 + no);

            if(rs.next()){
            	int wkNo = rs.getInt(1);
            	String wkTitle = rs.getString(2);
            	String wkWriting = rs.getString(3);
            	String wkContent = rs.getString(4);
            	
            	bean = new Bean(wkNo, wkTitle, wkWriting, wkContent);
            }
            conn_mysql.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bean;
	}// Table Click End
	
	
	// Create Announcement 
	public boolean insertAction() {
		  PreparedStatement ps = null;
		  try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		      @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();
		
		      String A = "insert into Announcement (writing, title, content";
		      String B = ") values (now(), ? , ? )";
		
		      ps = conn_mysql.prepareStatement(A+B);
		      ps.setString(1, title);
		      ps.setString(2, content);
		      ps.executeUpdate();
		
		      conn_mysql.close();
		      return true;
		  } catch (Exception e){
		      e.printStackTrace();
		      return false;
		  }             
	}// * insert Action End *
	
	
	// Delete Announcement
	public void deleteAction() {
		PreparedStatement ps = null;
		
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

            String A = "update announcement set delete_date = now() where no = ?";

            ps = conn_mysql.prepareStatement(A);
            
            ps.setInt(1, no);
            ps.executeUpdate();

            conn_mysql.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
	}	//*delete Action end*
	
	// update Announcement
	public void updateAction() {
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
            @SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

            String A = "update Announcement set writing = now(), title = ?, content = ? ";
            String B = " where no = ? ";

            ps = conn_mysql.prepareStatement(A+B);
            
//            ps.setString(1, writing);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, no);
            ps.executeUpdate();

            conn_mysql.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
	}// *update Action end*
	
} // *end line*