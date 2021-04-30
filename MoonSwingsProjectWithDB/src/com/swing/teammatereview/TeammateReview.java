
/* //TeammateReview//
 * 
 * projectTableSetItem()으로 테이블 데이터 불러오기 부착
 * [1.0] 2021-04-29 윤재필
 * 
 */

package com.swing.teammatereview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;

public class TeammateReview extends JPanel {
	
	private String loginedId;
	private JPanel panelTeamReview;
	private JScrollPane scrollPane_Project_1;
	private JLabel lblTeamReviewProject;
	private JLabel lblTeamReviewTeammateReview;
	private JScrollPane scrollPane_TeammateReview_1;
	private JTable TRProjectTable;
	private final DefaultTableModel Outer_Table_ProjectTable = new DefaultTableModel();
	private JButton btnInsert;
	/**
	 * Create the panel.
	 */
	
	public void initialiser() {
		teammateReviewTableProject();
		projectTableSetItem();
	}
	

	public TeammateReview(String loginedId) {
		this.loginedId = loginedId;
		
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(300, 45, 490, 497);

		add(getLblTeamReviewProject());
		add(getLblTeamReviewTeammateReview());
		
		add(getScrollPane_Project_1());
		add(getScrollPane_TeammateReview_1());
		add(getBtnInsert());
		
	}
	
	public JPanel getTeamReview() {
		if (panelTeamReview == null) {
			panelTeamReview = new JPanel();
			panelTeamReview.setBackground(Color.WHITE);
			panelTeamReview.setBounds(300, 45, 490, 497);
			panelTeamReview.setLayout(null);
			
			panelTeamReview.add(getScrollPane_Project_1());
			panelTeamReview.add(getScrollPane_TeammateReview_1());
			
			panelTeamReview.add(getLblTeamReviewProject());
			panelTeamReview.add(getLblTeamReviewTeammateReview());
			
			panelTeamReview.add(getBtnInsert());
			

		}
		return panelTeamReview;
	}
	private JScrollPane getScrollPane_Project_1() {
		if (scrollPane_Project_1 == null) {
			scrollPane_Project_1 = new JScrollPane();
			scrollPane_Project_1.setBounds(33, 53, 415, 150);
			scrollPane_Project_1.setViewportView(getTRProjectTable());
		}
		return scrollPane_Project_1;
	}
	private JLabel getLblTeamReviewProject() {
		if (lblTeamReviewProject == null) {
			lblTeamReviewProject = new JLabel("Project");
			lblTeamReviewProject.setForeground(Color.GRAY);
			lblTeamReviewProject.setFont(new Font("굴림", Font.BOLD, 18));
			lblTeamReviewProject.setBounds(33, 20, 67, 21);
		}
		return lblTeamReviewProject;
	}
	private JLabel getLblTeamReviewTeammateReview() {
		if (lblTeamReviewTeammateReview == null) {
			lblTeamReviewTeammateReview = new JLabel("Teammate Review");
			lblTeamReviewTeammateReview.setForeground(Color.GRAY);
			lblTeamReviewTeammateReview.setFont(new Font("굴림", Font.BOLD, 18));
			lblTeamReviewTeammateReview.setBounds(33, 232, 170, 21);
		}
		return lblTeamReviewTeammateReview;
	}
	private JScrollPane getScrollPane_TeammateReview_1() {
		if (scrollPane_TeammateReview_1 == null) {
			scrollPane_TeammateReview_1 = new JScrollPane();
			scrollPane_TeammateReview_1.setBounds(33, 265, 415, 180);
			
			CommentPanel cp = new CommentPanel(loginedId);
			// Dimensio없으면 스크롤바 생성이 불가능하므로, 필히 부착
			Dimension size = new Dimension();
			size.setSize(300, 80 * cp.panelItemCount);
			cp.setPreferredSize(size);
			
			scrollPane_TeammateReview_1.setViewportView(cp);
		}
		return scrollPane_TeammateReview_1;
	}
	private JTable getTRProjectTable() {
		if (TRProjectTable == null) {
			TRProjectTable = new JTable();
			TRProjectTable.setForeground(new Color(0, 102, 204));
			TRProjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TRProjectTable.setModel(Outer_Table_ProjectTable); // <--***************************************************
			TRProjectTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TRProjectTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TRProjectTable;
	}
	
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("Update");
			btnInsert.setBounds(369, 19, 79, 29);
		}
		return btnInsert;
	}
	
	public void teammateReviewTableProject(){
	    int i = Outer_Table_ProjectTable.getRowCount();
	    Outer_Table_ProjectTable.addColumn("Team no");
	    Outer_Table_ProjectTable.addColumn("Project name");
	    Outer_Table_ProjectTable.addColumn("Team name");
	    Outer_Table_ProjectTable.addColumn("project git Address");
	    Outer_Table_ProjectTable.setColumnCount(4);
	    for(int j = 0 ; j < i ; j++){
	    	
	    	Outer_Table_ProjectTable.removeRow(0);
	    	
	    }
	    TRProjectTable.setAutoResizeMode(TRProjectTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    int width = 70;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    vColIndex = 3;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 300;
	    col.setPreferredWidth(width);
	}
	
	
	//project table data 부착
	public void projectTableSetItem() {
		DBAction dba = new DBAction();
		ArrayList<String[]> rsArr = dba.teamReviewProjectTableDataSelect(loginedId);
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table_ProjectTable.addRow(rsArr.get(i));
		}

	}

}