/* //DBAction.java//
 * 본인의 팀 출력 쿼리 teamReviewProjectTableDataSelect() 작성
 * [1.0] 2021-04-27 윤재필
 * 
 * comment panel에 사용할 메서드 추가
 * 1. getCommentPanelData() - 패널에 필요한 데이터 출력
 * 2. commentInsert() - 코멘트 최초 추가
 * 3. commentUpdate() - 코멘트 수정
 * 
 * getCommentPanelData(String loginedId)으로 로그인한 아이디 받도록 수정
 */

package com.swing.teammatereview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;

import com.swing.DB.ShareVar;

public class DBAction {
	//database connection info
	ShareVar sv = new ShareVar();
	
	//연결에 성공/실패한 Connection 객체를 반환
	public Connection mysqlConnect() {
		Connection conn_mysql = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn_mysql = DriverManager.getConnection(sv.url_mysql, sv.id_mysql, sv.pw_mysql);
			System.out.println("[mysqlConnect] mysql 연결 성공");
		}catch (Exception e) {
			System.out.println("[mysqlConnect] mysql 연결 실패");
			e.printStackTrace();
		}
		return conn_mysql;
	}
	
	//team review - project table item select 
	public ArrayList<String[]> teamReviewProjectTableDataSelect(String loginedId) {
		Connection conn_mysql = null;
        Statement stmt_mysql = null;
        //최초 1회에만 사용하므로 bean 미사용
		ArrayList<String[]> rsSet = new ArrayList<String[]>();
		
		String select = "SELECT t.no, p.name, t.name, t.project_git_address ";
		String from = "FROM joining j, team t, do d, project p ";
		//id는 나중에 수정을 해야 합니다.
		String where = "WHERE j.student_id = '" + loginedId + "' AND j.team_no = t.no AND t.no = d.team_no AND d.project_no = p.no ";
		String orderBy = "ORDER BY t.no ASC";
		
		try {
			conn_mysql = mysqlConnect();
			stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(select + from + where);
			
			while(rs.next()) {
				String teamNo = Integer.toString(rs.getInt(1));
				String projectName = rs.getString(2);
				String teamName = rs.getString(3);
				String projectGitAddress = rs.getString(4);
				
				String[] result = {teamNo, projectName, teamName, projectGitAddress};
				rsSet.add(result);
			}
			System.out.println("[searchAll] 불러오기 성공");
			conn_mysql.close();
			System.out.println("[searchAll] mysql연결 종료");
		}catch (Exception e) {
			System.out.println("[searchAll] 불러오기 실패");
			e.printStackTrace();
		}

		return rsSet;
	}
	
	//패널에 사용할 같은 조원의 아이디, 이름, 사진, 코멘트를 가져온다.
	//** team.no도 받아오도록 수정해야 
	public ArrayList<CommentBean> getCommentPanelData(String loginedId) {
		System.out.println("[getStudentImage] 실행");
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CommentBean> beans = new ArrayList<CommentBean>();
		
		Connection conn_mysql = mysqlConnect();
		
		try{
	        String select = "SELECT s.id, s.name, s.photo, t.content ";
	        String from = "FROM student s ";
	        String leftJoin = "LEFT JOIN (SELECT * FROM comment WHERE comment.sender = '" + loginedId + "') t ON s.id = t.target ";
	    	//** team.no도 받아오도록 수정해야
	        String where = "WHERE s.id IN (SELECT s.id FROM joining j, student s WHERE j.team_no = 1 AND j.student_id = s.id)";
	       
	        ps = conn_mysql.prepareStatement(select + from + leftJoin + where);
	        
	        rs = ps.executeQuery();
			while(rs.next()) {
				CommentBean bean = new CommentBean();
				bean.id = rs.getString(1);
				bean.name = rs.getString(2);
				bean.photo = ImageIO.read(rs.getBinaryStream(3));
				bean.content = rs.getString(4);
				
				beans.add(bean);
			}
	        
	        conn_mysql.close();
	        System.out.println("[getCommentPanelData] comment bean생성 및 반환 성공");
	        return beans;
	        
	    } catch (Exception e){                    
	        e.printStackTrace();
	        return null;
	    }
	}
	
	//코멘트 최초 추가
    //*팀넘버 받아오도록 수정해야
	public boolean commentInsert(String target, String sender, String content){
		
        PreparedStatement ps = null;
        Statement stmt_mysql = null;
		Connection conn_mysql = mysqlConnect();
        
        try{
			stmt_mysql = conn_mysql.createStatement();
			
            String insert = "INSERT INTO comment (target, sender, content, writing, team_no) ";
            String values = "VALUES (?, ?, ?, ?, ?)";
            System.out.println("[commentInsert] qeury = " + insert + values);
        
            ps = conn_mysql.prepareStatement(insert + values);
            
            ps.setString(1, target);
            ps.setString(2, sender);
            ps.setString(3, content);
            ps.setString(4, getDate());
            //*팀넘버 받아오도록 수정해야
            ps.setInt(5, 1);
            
            ps.executeUpdate();
            System.out.println("[commentInsert] 수행완료");
            conn_mysql.close();
            System.out.println("[commentInsert] mysql연결 종료");
            return true;
        } catch (Exception e){                  
            e.printStackTrace();
            return false;
        }
	}
	
	//코멘트 수정
    //*팀넘버 받아오도록 수정해야
	public boolean commentUpdate(String target, String sender, String content) {
		Connection conn_mysql = mysqlConnect();
		Statement stmt_myslq = null; 
		
		try {
		    //*팀넘버 받아오도록 수정해야
			String update = "UPDATE comment SET content = '" + content + "', modify = '" + getDate() + "', team_no = '1' " ;
			String where = "WHERE target = '"+ target + "' AND sender = '" + sender + "'";
			System.out.println("[commentUpdate]query = " + update + where);

			stmt_myslq = conn_mysql.createStatement();
			stmt_myslq.executeUpdate(update + where);
			System.out.println("[commentUpdate] 업데이트 성공");
			conn_mysql.close();
			System.out.println("[commentUpdate] mysql연결 종료");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// return yyyy-mm-dd
	public String getDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		return year + "-" + month + "-" + date ;
	}
	
}