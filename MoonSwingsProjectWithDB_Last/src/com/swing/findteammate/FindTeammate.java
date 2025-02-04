package com.swing.findteammate;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.adminstudentlist.AdminStudentProfile;
import com.swing.findteammate.Bean;
import com.swing.findteammate.DbAction;
import com.swing.mainpage.MainPage;

public class FindTeammate extends JPanel {
	
	private String loginedId;
	private JPanel panelFindTeammate;
	private JScrollPane scrollPane_FindTeammate;
	private JTable TableFindTeammate;
	private final DefaultTableModel Outer_Table_FindTeammate = new DefaultTableModel();
	private JLabel lblFindTeammateYouPickedBy;
	private JScrollPane scrollPane_YouPickedBy;
	private JTable tableYouPickedBy;
	private JTable TeammateReviewTable;
	private final DefaultTableModel Outer_Table_YouPickedBy = new DefaultTableModel();
	private JButton btnSearch;
	private JTextField textFieldSearch;
	private JComboBox searchComboBox;
	private final DefaultTableModel Outer_Table_MyPick = new DefaultTableModel();
	private JScrollPane scrollPane_MyPick;
	private JTable tableMyPick;
	private JLabel lblFindTeammateMyPick;
	private JButton btnDelete;
	
	public DbAction2 dbAction = new DbAction2();
	
	
	
	/**
	 * Create the panel.
	 */
	public FindTeammate() {
		// TODO Auto-generated constructor stub
	}
	
	public FindTeammate(String loginedId) {
		this.loginedId = loginedId;
		// TODO Auto-generated constructor stub
	}
	
	public JPanel getFindTeammate() {
		if (panelFindTeammate == null) {
			panelFindTeammate = new JPanel();
			panelFindTeammate.setBackground(Color.WHITE);
			panelFindTeammate.setBounds(300, 35, 490, 507);
			panelFindTeammate.setLayout(null);
			panelFindTeammate.add(getScrollPane_FindTeammate());
			panelFindTeammate.add(getLblFindTeammateYouPickedBy());
			panelFindTeammate.add(getScrollPane_YouPickedBy());
			panelFindTeammate.add(getSearchComboBox());
			panelFindTeammate.add(getTextFieldSearch());
			panelFindTeammate.add(getBtnSearch());
			panelFindTeammate.add(getLblFindTeammateMyPick());
			panelFindTeammate.add(getScrollPane_MyPick());
			panelFindTeammate.add(getBtnDelete());

		}
		return panelFindTeammate;
	}


	private JScrollPane getScrollPane_FindTeammate() {
		if (scrollPane_FindTeammate == null) {
			scrollPane_FindTeammate = new JScrollPane();
			scrollPane_FindTeammate.setBounds(25, 55, 430, 200);
			scrollPane_FindTeammate.setViewportView(getTableFindTeammate());
		}
		return scrollPane_FindTeammate;
	}
	private JTable getTableFindTeammate() {
		if (TableFindTeammate == null) {
			TableFindTeammate = new JTable();
			TableFindTeammate.setForeground(new Color(0, 102, 204));
			TableFindTeammate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						
						tableClick();
						
					}
				}
			});
			
			TableFindTeammate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TableFindTeammate.setModel(Outer_Table_FindTeammate); // <--***************************************************
			TableFindTeammate.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			TableFindTeammate.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
		}
		return TableFindTeammate;
	}

	public void FindTeammateTableFindTeammate(){
		int i = Outer_Table_FindTeammate.getRowCount();
		Outer_Table_FindTeammate.addColumn("ID");
		Outer_Table_FindTeammate.addColumn("Name");
		Outer_Table_FindTeammate.addColumn("TeamStatus");
		Outer_Table_FindTeammate.addColumn("MBTI");
		Outer_Table_FindTeammate.setColumnCount(4);
		
		for(int j = 0 ; j < i ; j++){
			Outer_Table_FindTeammate.removeRow(0);
		}
		TableFindTeammate.setAutoResizeMode(TableFindTeammate.AUTO_RESIZE_OFF);
		int vColIndex = 0;
		TableColumn col = TableFindTeammate.getColumnModel().getColumn(vColIndex);
		
		int width = 100;
		col.setPreferredWidth(width);
		vColIndex = 1;
		col = TableFindTeammate.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);
		vColIndex = 2;
		col = TableFindTeammate.getColumnModel().getColumn(vColIndex);
		width = 90;
		col.setPreferredWidth(width);
		vColIndex = 3;
		col = TableFindTeammate.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
}
//	*** End Find Teammate Table
	
//	You Picked By Table
	private JLabel getLblFindTeammateYouPickedBy() {
		if (lblFindTeammateYouPickedBy == null) {
			lblFindTeammateYouPickedBy = new JLabel("You Picked By");
			lblFindTeammateYouPickedBy.setForeground(Color.GRAY);
			lblFindTeammateYouPickedBy.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblFindTeammateYouPickedBy.setBounds(25, 275, 308, 36);
		}
		return lblFindTeammateYouPickedBy;
	}
	
//	 25 340 430 120 
	private JScrollPane getScrollPane_YouPickedBy() {
		if (scrollPane_YouPickedBy == null) {
			scrollPane_YouPickedBy = new JScrollPane();
			scrollPane_YouPickedBy.setBounds(25, 320, 215, 120);
			scrollPane_YouPickedBy.setViewportView(getTableYouPickedBy());
		}
		return scrollPane_YouPickedBy;
	}
	private JTable getTableYouPickedBy() {
		if (tableYouPickedBy == null) {
			tableYouPickedBy = new JTable();
			tableYouPickedBy.setForeground(new Color(0,102,204)); 
			tableYouPickedBy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableYouPickedBy.setModel(Outer_Table_YouPickedBy); // <--***************************************************
			tableYouPickedBy.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			tableYouPickedBy.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
		}
		return tableYouPickedBy;
	}
	public void FindTeammateTableYouPickedBy(){
			int i = Outer_Table_YouPickedBy.getRowCount();
			Outer_Table_YouPickedBy.addColumn("ID");
			Outer_Table_YouPickedBy.addColumn("Name");
			Outer_Table_YouPickedBy.addColumn("TeamStatus");
			
			Outer_Table_YouPickedBy.setColumnCount(3);
			for(int j = 0 ; j < i ; j++){
				Outer_Table_YouPickedBy.removeRow(0);
			}
			tableYouPickedBy.setAutoResizeMode(tableYouPickedBy.AUTO_RESIZE_OFF);
			int vColIndex = 0;
			TableColumn col = tableYouPickedBy.getColumnModel().getColumn(vColIndex);
			int width = 75;
			col.setPreferredWidth(width);
			vColIndex = 1;
			col = tableYouPickedBy.getColumnModel().getColumn(vColIndex);
			width = 75;
			col.setPreferredWidth(width);
			vColIndex = 2;
			col = tableYouPickedBy.getColumnModel().getColumn(vColIndex);
			width = 75;
			col.setPreferredWidth(width);
	}
//	 25 340 430 120 
	private JLabel getLblFindTeammateMyPick() {
		if (lblFindTeammateMyPick == null) {
			lblFindTeammateMyPick = new JLabel("My Pick");
			lblFindTeammateMyPick.setForeground(Color.GRAY);
			lblFindTeammateMyPick.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblFindTeammateMyPick.setBounds(260, 275, 308, 36);
		}
		return lblFindTeammateMyPick;
	}
	
	private JScrollPane getScrollPane_MyPick() {
		if (scrollPane_MyPick == null) {
			scrollPane_MyPick = new JScrollPane();
			scrollPane_MyPick.setBounds(260, 320, 215, 120);
			scrollPane_MyPick.setViewportView(getTableMyPick());
		}
		return scrollPane_MyPick;
	}
	private JTable getTableMyPick() {
		if (tableMyPick == null) {
			tableMyPick = new JTable();
			tableMyPick.setForeground(new Color(0,102,204));
			TableFindTeammate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						
					}
				}
			});
			tableMyPick.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableMyPick.setModel(Outer_Table_MyPick); // <--***************************************************
			tableMyPick.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			tableMyPick.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
		}
		return tableMyPick;
	}
	public void FindTeammateTableMyPick(){
		int i = Outer_Table_MyPick.getRowCount();
		Outer_Table_MyPick.addColumn("ID");
		Outer_Table_MyPick.addColumn("Name");
		Outer_Table_MyPick.addColumn("Team Status");
		
		Outer_Table_MyPick.setColumnCount(3);
		for(int j = 0 ; j < i ; j++){
			Outer_Table_MyPick.removeRow(0);
		}
		tableMyPick.setAutoResizeMode(tableMyPick.AUTO_RESIZE_OFF);
		int vColIndex = 0;
		TableColumn col = tableMyPick.getColumnModel().getColumn(vColIndex);
		int width = 75;
		col.setPreferredWidth(width);
		vColIndex = 1;
		col = tableMyPick.getColumnModel().getColumn(vColIndex);
		width = 75;
		col.setPreferredWidth(width);
		vColIndex = 2;
		col = tableMyPick.getColumnModel().getColumn(vColIndex);
		width = 75;
		col.setPreferredWidth(width);
	}
	
	private JComboBox getSearchComboBox() {
		if (searchComboBox == null) {
			searchComboBox = new JComboBox();
			searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Name", "id", "MBTI", "Team Status"}));
			searchComboBox.setForeground(Color.GRAY);
			searchComboBox.setBounds(25, 21, 107, 27);
		}
		return searchComboBox;
	}
	
	private JTextField getTextFieldSearch() {
		if (textFieldSearch == null) {
			textFieldSearch = new JTextField();
			textFieldSearch.setForeground(new Color(0, 102, 204));
			textFieldSearch.setBounds(138, 20, 238, 30);
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
			btnSearch.setBounds(378, 20, 77, 29);
		}
		return btnSearch;
	}
	
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete= new JButton("Delete");
			btnDelete.setForeground(new Color(0, 102, 204));
			btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
//			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					deleteMyPick();
				}
			});
			btnDelete.setBounds(378, 455 , 70, 35);
		}
		return btnDelete;
	}

	// --------------------------------
	// 21.04.28 Hyokyeong 
	// ---------------------------------
	
	//DB to Table
	public void searchAction(){
		
		FindTeammateTableFindTeammate();
		
        DbAction3 dbAction = new DbAction3(loginedId);
        ArrayList<Bean> beanFTList = dbAction.selectStudentList();
        
        int listCount = beanFTList.size();
        
        for(int i=0; i<listCount; i++) {
        	
        	String teamStatus = Integer.toString(beanFTList.get(i).getTeamName());//        	
        	if(teamStatus.equals("0")) {
        		teamStatus = "UNTEAMED";
        	}
        	
        	String[] qTxt = {beanFTList.get(i).getId(),
        			beanFTList.get(i).getName(), 
        			teamStatus, 
        			beanFTList.get(i).getMbti()};
        	
        	Outer_Table_FindTeammate.addRow(qTxt);	
        	
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
			FindTeammateTableFindTeammate();
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
			FindTeammateTableFindTeammate();
			if(selection.equals("")) {
				searchAction();
			}else {
				searchTeamStatus(selection);
			}
			return;
			
		default:
			break;
		}
		
		FindTeammateTableFindTeammate();
		ConditionQueryAction(ConditionQueryColumn, selection);
	}
	
	/*
	Student List combo_box -> team status로 search시
	 */
	private void searchTeamStatus(String selection) {
        DbAction dbAction = new DbAction(selection);
        
        ArrayList<ArrayList<Bean>> beanList = dbAction.selectSearchTeamStatusList();
        ArrayList<Bean> beanFTList = beanList.get(1);
        ArrayList<Bean> beanUnteamedList = beanList.get(0);
        
        int listCount = beanFTList.size();
        int unTeamListCount = beanUnteamedList.size();
        
        char unteam = selection.toLowerCase().charAt(0);
        
        if(unteam == 'u') {
        	for(int i=0; i<unTeamListCount; i++) {
            	
        		String teamStatus = Integer.toString(beanUnteamedList.get(i).getTeamName());//        	
            	if(teamStatus.equals("0")) {
            		teamStatus = "UNTEAMED";
            	}
	        	
	        	String[] qTxt = {beanUnteamedList.get(i).getId(),
	        			beanUnteamedList.get(i).getName(), 
	        			teamStatus, 
	        			beanUnteamedList.get(i).getMbti()};
	        		        	
	        	Outer_Table_FindTeammate.addRow(qTxt);
        	}
        	
        }else{
        	for(int i=0; i<listCount; i++) {
        	
	        	String teamStatus = Integer.toString(beanFTList.get(i).getTeamName());
	        	
	        	String[] qTxt = {beanFTList.get(i).getId(),
	        			beanFTList.get(i).getName(), 
	        			teamStatus, 
	        			beanFTList.get(i).getMbti()};
	        	
	        	Outer_Table_FindTeammate.addRow(qTxt);	
        	}
        }
	}
	
	
	// 조건검색 실행 
	private void ConditionQueryAction(String ConditionQueryColumn, String selection) {
		
		DbAction dbAction = new DbAction(ConditionQueryColumn, selection);
		ArrayList<Bean> beanFTList = dbAction.ConditionQueryAction();
		int listCount = beanFTList.size();

        for(int i=0; i<listCount; i++) {
        	
        	String teamStatus = Integer.toString(beanFTList.get(i).getTeamName());//        	
        	if(teamStatus.equals("0")) {
        		teamStatus = "UNTEAMED";
        	}
        	String[] qTxt = {beanFTList.get(i).getId(),
        			beanFTList.get(i).getName(), 
        			teamStatus, 
        			beanFTList.get(i).getMbti()};
        	Outer_Table_FindTeammate.addRow(qTxt);
		}
		
	}
	
	//	 FindTeammatetableClick
	private void tableClick() {
		
		int i = TableFindTeammate.getSelectedRow();
		String ckId = (String)TableFindTeammate.getValueAt(i, 0);
		String ckName = (String)TableFindTeammate.getValueAt(i, 1);
		
		OthersProfile studentProfile = new OthersProfile(ckId, ckName);
		studentProfile.run(ckId, ckName);
		
	}// table Click End
	
	
	//--------------------
	// 21.04.29 hyogang
	// Pick Method
	//--------------------
	// 현재 testId "ohoh9900"으로 진행중. 병합 후 testId 삭제하기!!!!!!
//	String testId = "ohoh9900"; // 병합 후 삭제할 변수 !!!!!!!!!!
	
	
	// You picked by list -- beanPickedList
	//DB to Table
	public void showYouPickedby(){
		FindTeammateTableYouPickedBy();
        DbAction2 dbAction = new DbAction2(loginedId); // login id로 보내기************
        ArrayList<Bean> beanPickedList = dbAction.selectYouPickedByList();
        
        int listCount = beanPickedList.size();
        
        for(int i=0; i<listCount; i++) {
        	
        	String teamStatus = Integer.toString(beanPickedList.get(i).getTeamName());//        	
        	if(teamStatus.equals("0")) {
        		teamStatus = "UNTEAMED";
        	}
        	
        	String[] qTxt = {beanPickedList.get(i).getId() , 
        			beanPickedList.get(i).getName(), 
        			teamStatus};
        	Outer_Table_YouPickedBy.addRow(qTxt);	
        	
        }
	}
	
	// You picked by list -- beanPickedList
	//DB to Table
	public void showMyPick(){
		
		FindTeammateTableMyPick();
		
        DbAction2 dbAction = new DbAction2(loginedId); // login id로 보내기************
        ArrayList<Bean> beanMyPickList = dbAction.selectMyPickList();
        
        int listCount = beanMyPickList.size();
        
        for(int i=0; i<listCount; i++) {
        	
        	String teamStatus = Integer.toString(beanMyPickList.get(i).getTeamName());//        	
        	if(teamStatus.equals("0")) {
        		teamStatus = "UNTEAMED";
        	}
        	
        	String[] qTxt = {beanMyPickList.get(i).getId(), 
        			beanMyPickList.get(i).getName(), 
        			teamStatus};
        	Outer_Table_MyPick.addRow(qTxt);	
        	
        }
	}// showMyPick End
	
	
	// delete button Action
	/*
	 * update dip cancellation date
	 */
	private void deleteMyPick() {
		
		String clickId = "";
		int i = tableMyPick.getSelectedRow();
		if(i == -1) {
			clickId = "";
		}else {
			clickId = (String)tableMyPick.getValueAt(i, 0);
		}
		
		if(!clickId.equals("")) {
			DbAction2 dbAction = new DbAction2(loginedId, clickId);
			dbAction.deleteMyDip();
			showMyPick();
			return;
		}else {
			JOptionPane.showMessageDialog(null, "MY PICK에서 Delete 할 사람을 선택해 주세요.");
			return;
		}
	}
	
	
	
} // End Line
