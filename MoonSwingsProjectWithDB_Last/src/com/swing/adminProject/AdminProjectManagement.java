//------- Manage Project UI --------//

package com.swing.adminProject;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminProjectManagement extends JPanel {
	private JPanel adminProjectManagement;
	private JScrollPane scrollPane_ManageProject;
	private JTable tableManageProject;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JScrollPane scrollPane_ProjectDetails;
	private JLabel lblProjectName;
	private JTextField tfTeammate1;
	private JTextField tfTeammate2;
	private JTextField tfTeammate3;
	private JTextField tfTeammate4;
	private JTextField tfTeammate5;
	private JTable tableProjectDetails;
	private final DefaultTableModel Outer_Table_ManageProject = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_ProjectDetails = new DefaultTableModel();

	ArrayList<JTextField> tfs = new ArrayList<JTextField>();
	
	public AdminProjectManagement() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,45,490,497);
		add(getScrollPane_ManageProject());
		add(getBtnCreate());
		add(getBtnDelete());
		add(getBtnUpdate());
		add(getScrollPane_ProjectDetails());
		add(getLblProjectName());
		add(getTfTeammate1());
		add(getTextField_1());
		add(getTextField_1_1());
		add(getTfTeammate4());
		add(getTfTeammate5());

	}
	
	public void initialiser() {
		tableManageProject();
		tableProjectDetails();
		projectTableSetItem();
	}
	
	private JScrollPane getScrollPane_ManageProject() {
		if (scrollPane_ManageProject == null) {
			scrollPane_ManageProject = new JScrollPane();
			scrollPane_ManageProject.setBounds(20, 16, 300, 150);
			scrollPane_ManageProject.setViewportView(getTableManageProject());
		}
		return scrollPane_ManageProject;
	}
	private JTable getTableManageProject() {
		if (tableManageProject == null) {
			tableManageProject = new JTable();
			tableManageProject.setForeground(new Color(0, 102, 204));
			tableManageProject.setBackground(Color.WHITE);
			tableManageProject.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableManageProject.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						readTeamOnProject();
					}
				}
			});
			tableManageProject.getTableHeader().setReorderingAllowed(false);
			tableManageProject.setModel(Outer_Table_ManageProject); 
		}
		return tableManageProject;
	}
	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton("Create");
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertProject();
				}
			});
			btnCreate.setBackground(Color.WHITE);
			btnCreate.setForeground(new Color(0, 102, 204));
			btnCreate.setBounds(340, 15, 130, 40);
		}
		return btnCreate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					projectDelete();
				}
			});
			btnDelete.setForeground(new Color(0, 102, 204));
			btnDelete.setBackground(Color.WHITE);
			btnDelete.setBounds(340, 126, 130, 40);
		}
		return btnDelete;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateProject();
				}
			});
			btnUpdate.setForeground(new Color(0, 102, 204));
			btnUpdate.setBackground(Color.WHITE);
			btnUpdate.setBounds(340, 70, 130, 40);
		}
		return btnUpdate;
	}
	private JScrollPane getScrollPane_ProjectDetails() {
		if (scrollPane_ProjectDetails == null) {
			scrollPane_ProjectDetails = new JScrollPane();
			scrollPane_ProjectDetails.setBounds(20, 232, 450, 160);
			scrollPane_ProjectDetails.setViewportView(getTableProjectDetails());
		}
		return scrollPane_ProjectDetails;
	}
	private JLabel getLblProjectName() {
		if (lblProjectName == null) {
			lblProjectName = new JLabel("Swing Project Details");
			lblProjectName.setForeground(Color.GRAY);
			lblProjectName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			lblProjectName.setBounds(20, 190, 444, 30);
		}
		return lblProjectName;
	}
	private JTextField getTfTeammate1() {
		if (tfTeammate1 == null) {
			tfTeammate1 = new JTextField();
			tfTeammate1.setHorizontalAlignment(SwingConstants.CENTER);
			tfTeammate1.setBackground(Color.WHITE);
			tfTeammate1.setForeground(new Color(0, 102, 204));
			tfTeammate1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfTeammate1.setBounds(19, 413, 90, 43);
			tfTeammate1.setColumns(10);
			tfs.add(tfTeammate1);
		}
		return tfTeammate1;
	}
	private JTextField getTextField_1() {
		if (tfTeammate2 == null) {
			tfTeammate2 = new JTextField();
			tfTeammate2.setHorizontalAlignment(SwingConstants.CENTER);
			tfTeammate2.setBackground(Color.WHITE);
			tfTeammate2.setForeground(new Color(0, 102, 204));
			tfTeammate2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfTeammate2.setColumns(10);
			tfTeammate2.setBounds(109, 413, 90, 43);
			tfs.add(tfTeammate2);
		}
		return tfTeammate2;
	}
	private JTextField getTextField_1_1() {
		if (tfTeammate3 == null) {
			tfTeammate3 = new JTextField();
			tfTeammate3.setHorizontalAlignment(SwingConstants.CENTER);
			tfTeammate3.setBackground(Color.WHITE);
			tfTeammate3.setForeground(new Color(0, 102, 204));
			tfTeammate3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfTeammate3.setColumns(10);
			tfTeammate3.setBounds(199, 413, 90, 43);
			tfs.add(tfTeammate3);
		}
		return tfTeammate3;
	}
	private JTextField getTfTeammate4() {
		if (tfTeammate4 == null) {
			tfTeammate4 = new JTextField();
			tfTeammate4.setHorizontalAlignment(SwingConstants.CENTER);
			tfTeammate4.setBackground(Color.WHITE);
			tfTeammate4.setForeground(new Color(0, 102, 204));
			tfTeammate4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfTeammate4.setColumns(10);
			tfTeammate4.setBounds(289, 413, 90, 43);
			tfs.add(tfTeammate4);
		}
		return tfTeammate4;
	}
	private JTextField getTfTeammate5() {
		if (tfTeammate5 == null) {
			tfTeammate5 = new JTextField();
			tfTeammate5.setHorizontalAlignment(SwingConstants.CENTER);
			tfTeammate5.setBackground(Color.WHITE);
			tfTeammate5.setForeground(new Color(0, 102, 204));
			tfTeammate5.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfTeammate5.setColumns(10);
			tfTeammate5.setBounds(379, 413, 90, 43);
			tfs.add(tfTeammate5);
		}
		return tfTeammate5;
	}
	private JTable getTableProjectDetails() {
		if (tableProjectDetails == null) {
			tableProjectDetails = new JTable();
			tableProjectDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableProjectDetails.setForeground(new Color(0, 102, 204));
			tableProjectDetails.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						readStudentInTeam();
					}
				}
			});
			tableProjectDetails.getTableHeader().setReorderingAllowed(false);
			tableProjectDetails.setModel(Outer_Table_ProjectDetails); 
		}
		return tableProjectDetails;
	}

	
	// tableManageProject Column설정 and 초기화
	public void tableManageProject(){
		
	    int i = Outer_Table_ManageProject.getRowCount();
	    Outer_Table_ManageProject.addColumn("No");
	    Outer_Table_ManageProject.addColumn("Date");
	    Outer_Table_ManageProject.addColumn("ProjectName");
	    Outer_Table_ManageProject.setColumnCount(3);
	    
	    for(int j = 0 ; j < i ; j++){
	    	Outer_Table_ManageProject.removeRow(0);
	    }
//	    Outer_Table_ManageProject.setAutoResizeMode(tableManageProject.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = tableManageProject.getColumnModel().getColumn(vColIndex);
	    int width = 50;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = tableManageProject.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = tableManageProject.getColumnModel().getColumn(vColIndex);
	    width = 130;
	    col.setPreferredWidth(width);
	}
	// tableManageProject Column설정 and 초기화
	public void tableProjectDetails(){
		
	    int i = Outer_Table_ProjectDetails.getRowCount();
	    Outer_Table_ProjectDetails.addColumn("Team No");
	    Outer_Table_ProjectDetails.addColumn("Team Name");
	    Outer_Table_ProjectDetails.addColumn("Result of Project - Git Address");
	    Outer_Table_ProjectDetails.setColumnCount(3);
	    
	    for(int j = 0 ; j < i ; j++){
	    	Outer_Table_ProjectDetails.removeRow(0);
	    }
//	    Outer_Table_ManageProject.setAutoResizeMode(tableManageProject.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = tableProjectDetails.getColumnModel().getColumn(vColIndex);
	    int width = 50;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = tableProjectDetails.getColumnModel().getColumn(vColIndex);
	    width = 80;
	    vColIndex = 2;
	    col = tableProjectDetails.getColumnModel().getColumn(vColIndex);
	    width = 300;
	}
	
	//상단 테이블 내용물 제거
	public void ManageProjectTableClean() {
	    int rowCount = Outer_Table_ManageProject.getRowCount();
	    for(int i = 0 ; i < rowCount ; i++){
	    	Outer_Table_ManageProject.removeRow(0);
	    }
	}
	//하단 테이블 내용물 제거
	public void ProjectDetailsTableClean() {
	    int rowCount = Outer_Table_ProjectDetails.getRowCount();
	    for(int i = 0 ; i < rowCount ; i++){
	    	Outer_Table_ProjectDetails.removeRow(0);
	    }
	}
	
	
	//project table data 부착
	public void projectTableSetItem() {
		ManageProjectTableClean();
	    
		DBAction dba = new DBAction();
		ArrayList<String[]> rsArr = dba.selectAllProject();
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table_ManageProject.addRow(rsArr.get(i));
		}
	}
	
	//프로젝트 테이블 클릭시 해당 프로젝트의 팀을 하단 테이블에 출력
	public void readTeamOnProject() {
		int row = tableManageProject.getSelectedRow();
		String getProjectNoToString = (String) tableManageProject.getValueAt(row, 0);
		int projectNoParsedInt = Integer.parseInt(getProjectNoToString);
		System.out.println("선택된 열 : " + row + " // 프로젝트번호 :" + getProjectNoToString);

		ProjectDetailsTableClean();
		
		DBAction dba = new DBAction();
		ArrayList<String[]> rsArr = dba.selectTeamOnProject(projectNoParsedInt);
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table_ProjectDetails.addRow(rsArr.get(i));
		}
	}
	
	public void studentsTextFieldClean(){
		for(JTextField tf : tfs) {
			tf.setText("");
		}
	}
	
	//팀 테이블 선택시 팀원을 하단 tf에 출력
	public void readStudentInTeam(){
		studentsTextFieldClean();
		
		int row = tableProjectDetails.getSelectedRow();
		String getTeamNoToString = (String) tableProjectDetails.getValueAt(row, 0);
		int TeamNoParsedInt = Integer.parseInt(getTeamNoToString);
		System.out.println("선택된 열 : " + row + " // 팀 번호 :" + getTeamNoToString);

		DBAction dba = new DBAction();
		ArrayList<String> rsArr = dba.selectStudentInTeam(TeamNoParsedInt);
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			tfs.get(i).setText(rsArr.get(i));
		}
	}
	//인서트 버튼 클릭시
	//*팝업창을 띄워서 해당 값으로 대체되게 수정해야 
	public void insertProject() {
		JOptionPane projectNameInputPane =new JOptionPane();
		String name = projectNameInputPane.showInputDialog("추가할 프로젝트 이름을 입력하세요.");
	
		DBAction dba = new DBAction();
		boolean result = dba.insertProject(name);
		if(result) {
			JOptionPane.showMessageDialog(null, "프로젝트가 생성 되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "프로젝트 생성에 실패했습니다.");
		}
		projectTableSetItem();
	}
	
	//업데이트 버튼 클릭시
	//*팝업창을 띄워서 해당 값으로 대체되게 수정해야 
	public void updateProject(){
		int row = tableManageProject.getSelectedRow();
		//테이블에 선택된 아이템이 없을 
		if ( row == -1 ) {
			return;
		}
		
		String getProjectNoToString = (String) tableManageProject.getValueAt(row, 0);
		int projectNoParsedInt = Integer.parseInt(getProjectNoToString);
		System.out.println("선택된 열 : " + row + " // 프로젝트번호 :" + getProjectNoToString);
		String getProjectNameToString = (String) tableManageProject.getValueAt(row, 1);
		
		
		JOptionPane projectNameInputPane =new JOptionPane();
		String changedName = projectNameInputPane.showInputDialog("수정할 프로젝트 이름을 입력하세요.");
		if (changedName == null) {
			return;
		}
		
		int choice = JOptionPane.showConfirmDialog(null, getProjectNameToString + " 을" + changedName + " 으로 수정하시겠습니까?" ,
				"프로젝트 삭제", JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.NO_OPTION) {
			return;
		}
		
		DBAction dba = new DBAction();
		boolean result = dba.updateProject(projectNoParsedInt, changedName);
		if(result) {
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
		}
	}
	
	//델리트 버튼 클릭시
	public void projectDelete() {
		int row = tableManageProject.getSelectedRow();
		//테이블에 선택된 아이템이 없을 
		if ( row == -1 ) {
			return;
		}
		String getProjectNoToString = (String) tableManageProject.getValueAt(row, 0);
		int projectNoParsedInt = Integer.parseInt(getProjectNoToString);
		System.out.println("선택된 열 : " + row + " // 프로젝트번호 :" + getProjectNoToString);
		String getProjectNameToString = (String) tableManageProject.getValueAt(row, 1);
		int choice = JOptionPane.showConfirmDialog(null, getProjectNameToString + " 프로젝트를 삭제하시겠습니까?", "프로젝트 삭제", JOptionPane.YES_NO_OPTION);
		
		if(choice == JOptionPane.NO_OPTION) {
			return;
		}
		
		DBAction dba = new DBAction();
		boolean result = dba.deleteProject(projectNoParsedInt );
		if(result) {
			JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "삭제에 실패했습니다.");
		}
	}
}