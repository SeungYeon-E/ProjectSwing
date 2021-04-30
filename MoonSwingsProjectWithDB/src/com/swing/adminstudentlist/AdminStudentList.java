package com.swing.adminstudentlist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.findteammate.Bean;
import com.swing.findteammate.DbAction;


//Need To Change 

public class AdminStudentList extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
//	Panel for StrudentList
	private JPanel panelStudentList;
	private JButton btnSearch;
	private JTextField textFieldSearch;
	private JComboBox searchComboBox;
	private JScrollPane scrollPane_StudentList;
	private JTable tableStudentList;
	private final DefaultTableModel Outer_Table_StudentList = new DefaultTableModel();
	
	public JPanel getStudentList() {
		if (panelStudentList == null) {
			panelStudentList = new JPanel();
			panelStudentList.setBackground(Color.white);
			panelStudentList.setBounds(300, 45, 490, 497);
			panelStudentList.setLayout(null);
			panelStudentList.add(getSearchComboBox());
			panelStudentList.add(getTextFieldSearch());
			panelStudentList.add(getBtnSearch());
			panelStudentList.add(getScrollPane_StudentList());

		}
		return panelStudentList;
	}
	
	private JComboBox getSearchComboBox() {
		if (searchComboBox == null) {
			searchComboBox = new JComboBox();
			searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Name", "ID", "MBTI", "TeamStatus"}));
			searchComboBox.setForeground(Color.GRAY);
			searchComboBox.setBounds(25, 11, 107, 27);
		}
		return searchComboBox;
	}
	
	private JTextField getTextFieldSearch() {
		if (textFieldSearch == null) {
			textFieldSearch = new JTextField();
			textFieldSearch.setForeground(new Color(0, 102, 204));
			textFieldSearch.setBounds(138, 10, 238, 30);
			textFieldSearch.setColumns(10);
		}
		return textFieldSearch;
	}
	
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch= new JButton("Search");
			btnSearch.setForeground(new Color(0, 102, 204));
			btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ConditionQuery();
				}
			});
			btnSearch.setBounds(378, 10, 77, 29);
		}
		return btnSearch;
	}
	
	private JScrollPane getScrollPane_StudentList() {
		if (scrollPane_StudentList == null) {
			scrollPane_StudentList = new JScrollPane();
			scrollPane_StudentList.setBounds(25, 50, 440, 420);
			scrollPane_StudentList.setViewportView(getTableStudentList());
		}
		return scrollPane_StudentList;
	}
	private JTable getTableStudentList() {
		if (tableStudentList == null) {
			tableStudentList = new JTable();
			tableStudentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableStudentList.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tableStudentList.setForeground(new Color(0, 102, 204));
			tableStudentList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						
						tableClick();
//						AdminStudentProfile studentProfile = new AdminStudentProfile();
//						studentProfile.run();
						
					}
				}
			});
			
			tableStudentList.setModel(Outer_Table_StudentList); // <--***************************************************
			tableStudentList.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			tableStudentList.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
		}
		return tableStudentList;
	}
	
	@SuppressWarnings("static-access")
	public void SLStudentListTable(){
		int i = Outer_Table_StudentList.getRowCount();
		Outer_Table_StudentList.addColumn("Id");
		Outer_Table_StudentList.addColumn("Name");
		Outer_Table_StudentList.addColumn("TeamStatus");
		Outer_Table_StudentList.addColumn("MBTI");
		Outer_Table_StudentList.addColumn("Signal");
		Outer_Table_StudentList.setColumnCount(5);
		
		
		for(int j = 0 ; j < i ; j++){
			Outer_Table_StudentList.removeRow(0);
		}
		tableStudentList.setAutoResizeMode(tableStudentList.AUTO_RESIZE_OFF);
		int vColIndex = 0;
		TableColumn col = tableStudentList.getColumnModel().getColumn(vColIndex);
		int width = 120;
		col.setPreferredWidth(width);
		vColIndex = 1;
		col = tableStudentList.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		vColIndex = 2;
		col = tableStudentList.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		vColIndex = 3;
		col = tableStudentList.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		vColIndex = 4;
		col = tableStudentList.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	}
	
	// --------------------------------
	// 21.04.28 Hyokyeong 
	// ---------------------------------
	
	
	//DB to Table
	public void searchAction(){
        DbAction dbAction = new DbAction();
        ArrayList<Bean> beanFTList = dbAction.selectStudentList();
        
        int listCount = beanFTList.size();
        
        for(int i=0; i<listCount; i++) {
        	
        	String stDipCount = Integer.toString(beanFTList.get(i).getDiptargetCount());
        	String teamStatus = beanFTList.get(i).getTeamName();
//        	
//        	if(teamStatus == null) {
//        		teamStatus = "NONE";
//        	}
        	
        	String[] qTxt = {beanFTList.get(i).getId(),
        			beanFTList.get(i).getName(), 
        			teamStatus, 
        			beanFTList.get(i).getMbti(), stDipCount};
        	
        	Outer_Table_StudentList.addRow(qTxt);	
        	
        }
	}
	
	// Condition Query
	private void ConditionQuery() {
		int i = searchComboBox.getSelectedIndex();
		String ConditionQueryColumn = "";
		String selection = textFieldSearch.getText().trim();
		switch (i) {
		case 0:
			textFieldSearch.setText("");
			SLStudentListTable();
			searchAction();
			return;
		case 1:
			ConditionQueryColumn = "s.name";
			break;
		case 2:
			ConditionQueryColumn = "s.id";
			break;
		case 3:
			ConditionQueryColumn = "s.mbti";
			break;
		case 4:
			SLStudentListTable();
			searchTeamStatus(selection);
			return;
			
		default:
			break;
		}
		
		SLStudentListTable();
		ConditionQueryAction(ConditionQueryColumn, selection);
	}
	
	/*
	Student List combo_bax -> team status로 search시
	 */
	private void searchTeamStatus(String selection) {
		
        DbAction dbAction = new DbAction(selection);
        ArrayList<Bean> beanFTList = dbAction.selectSearchTeamStatusList();
        
        int listCount = beanFTList.size();
        
        for(int i=0; i<listCount; i++) {
        	
        	String stDipCount = Integer.toString(beanFTList.get(i).getDiptargetCount());
        	String teamStatus = beanFTList.get(i).getTeamName();

        	
        	String[] qTxt = {beanFTList.get(i).getId(),
        			beanFTList.get(i).getName(), 
        			teamStatus, 
        			beanFTList.get(i).getMbti(), stDipCount};
        	
        	Outer_Table_StudentList.addRow(qTxt);	
        	
        }
	}
	
	
	// 조건검색 실행 
	private void ConditionQueryAction(String ConditionQueryColumn, String selection) {
		
		DbAction dbAction = new DbAction(ConditionQueryColumn, selection);
		ArrayList<Bean> beanFTList = dbAction.ConditionQueryAction();
		int listCount = beanFTList.size();

        for(int i=0; i<listCount; i++) {
        	
        	String stDipCount = Integer.toString(beanFTList.get(i).getDiptargetCount());
        	String teamStatus = beanFTList.get(i).getTeamName();
//        	
//        	if(teamStatus == null) {
//        		teamStatus = "NONE";
//        	}
        	
        	String[] qTxt = {beanFTList.get(i).getId(),
        			beanFTList.get(i).getName(), 
        			teamStatus, 
        			beanFTList.get(i).getMbti(), stDipCount};
			Outer_Table_StudentList.addRow(qTxt);
		}
		
	}
	
	// tableClick
	private void tableClick() {
		
		int i = tableStudentList.getSelectedRow();
		String ckId = (String)tableStudentList.getValueAt(i, 0);
		String ckName = (String)tableStudentList.getValueAt(i, 1);
		String dipCount = (String)tableStudentList.getValueAt(i, 4);
		
		AdminStudentProfile studentProfile = new AdminStudentProfile(ckId, ckName, dipCount);
		studentProfile.run(ckId, ckName, dipCount);
		
	}// table Click End


}// end line