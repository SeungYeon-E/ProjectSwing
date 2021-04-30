package com.swing.adminteamstatus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.adminteamstatus.AdminTeamStatusBean;
import com.swing.adminteamstatus.AdminTeamStatusDBAction;
import com.swing.mainpage.MainPage;

public class AdminTeamStatus extends JPanel {
	public AdminTeamStatus() {
	}
	/**
	 * Create the panel.
	 */
//	Panel for TeamStatus 
	private JPanel panelTeamStatus;
	private JRadioButton rbTeam1;
	private JRadioButton rbTeam2;
	private JRadioButton rbTeam3;
	private JRadioButton rbTeam4;
	private JRadioButton rbTeam5;
	private JRadioButton rbTeam6;
//	Need to Change
	private JButton btnInTeamStatus;
	private JButton btnOutTeamStatus;
	private JTextField tfmate1_1;
	private JTextField tfmate1_2;
	private JTextField tfmate1_3;
	private JTextField tfmate1_4;
	private JTextField tfmate2_1;
	private JTextField tfmate2_2;
	private JTextField tfmate2_3;
	private JTextField tfmate2_4;
	private JTextField tfmate3_1;
	private JTextField tfmate3_2;
	private JTextField tfmate3_3;
	private JTextField tfmate3_4;
	private JTextField tfmate4_1;
	private JTextField tfmate4_2;
	private JTextField tfmate4_3;
	private JTextField tfmate4_4;
	private JTextField tfmate5_1;
	private JTextField tfmate5_2;
	private JTextField tfmate5_3;
	private JTextField tfmate5_4;
	private JTextField tfmate6_1;
	private JTextField tfmate6_2;
	private JTextField tfmate6_3;
	private JTextField tfmate6_4;
	private JTextField tfmate6_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel Outer_Table_StrudentList = new DefaultTableModel();
	private JScrollPane scrollPane_TSStudentList;
	private JTable tableTeamStatus;
	
	public AdminTeamStatusDBAction dbAction = new AdminTeamStatusDBAction();
	
	//팀원이름을 불러올 텍스트필드 집합
	ArrayList<JTextField[]> tfbeanList = new ArrayList<JTextField[]>();
	
	//라디오버튼 집합(처음에 이름불러오고 내가 속한 팀에 라디오버튼이 클릭되어 있도록하기위해)
	ArrayList<JRadioButton> rdbs = new ArrayList<JRadioButton>();
	
	//들어갈 팀의 번호를 저장하기 위한 객체
	int selectedrdb = 999;
	
	public JPanel getTeamStatus() {
		if (panelTeamStatus == null) {
			panelTeamStatus = new JPanel();
			panelTeamStatus.setBounds(300, 35, 490, 507);
			panelTeamStatus.setBackground(new Color(255, 255, 255));
			panelTeamStatus.setLayout(null);
			panelTeamStatus.add(getRbTeam1());
			panelTeamStatus.add(getRbTeam2());
			panelTeamStatus.add(getRbTeam3());
			panelTeamStatus.add(getRbTeam4());
			panelTeamStatus.add(getRbTeam5());
			panelTeamStatus.add(getRbTeam6());
			panelTeamStatus.add(gettfmate1_1());
			panelTeamStatus.add(gettfmate1_2());
			panelTeamStatus.add(gettfmate1_3());
			panelTeamStatus.add(gettfmate1_4());
			panelTeamStatus.add(gettfmate2_1());
			panelTeamStatus.add(getTfmate2_2());
			panelTeamStatus.add(getTfmate2_3());
			panelTeamStatus.add(getTfmate2_4());
			panelTeamStatus.add(gettfmate3_1());
			panelTeamStatus.add(gettfmate3_2());
			panelTeamStatus.add(gettfmate3_3());
			panelTeamStatus.add(gettfmate3_4());
			panelTeamStatus.add(gettfmate4_1());
			panelTeamStatus.add(gettfmate4_2());
			panelTeamStatus.add(gettfmate4_3());
			panelTeamStatus.add(gettfmate4_4());
			panelTeamStatus.add(gettfmate5_1());
			panelTeamStatus.add(gettfmate5_2());
			panelTeamStatus.add(gettfmate5_3());
			panelTeamStatus.add(gettfmate5_4());
			panelTeamStatus.add(getTfmate6_1());
			panelTeamStatus.add(getTfmate6_2());
			panelTeamStatus.add(getTfmate6_3());
			panelTeamStatus.add(getTfmate6_4());
			panelTeamStatus.add(gettfmate6_5());
			panelTeamStatus.add(getBtnInTeamStatus());
			panelTeamStatus.add(getBtnOutTeamStatus());
			panelTeamStatus.add(getScrollPane_TSStudentList());
		}
		return panelTeamStatus;
	}
	private JRadioButton getRbTeam1() {
		if (rbTeam1 == null) {
			rbTeam1 = new JRadioButton("T1");
			buttonGroup.add(rbTeam1);
			rbTeam1.setForeground(new Color(0, 51, 102));
			rbTeam1.setBounds(10, 27, 50, 23);
			rbTeam1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 1;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam1);
		return rbTeam1;
	}
	private JRadioButton getRbTeam2() {
		if (rbTeam2 == null) {
			rbTeam2 = new JRadioButton("T2");
			buttonGroup.add(rbTeam2);
			rbTeam2.setForeground(new Color(0, 51, 102));
			rbTeam2.setBounds(10, 67, 50, 23);
			
			rbTeam2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 2;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam2);
		return rbTeam2;
	}
	private JRadioButton getRbTeam3() {
		if (rbTeam3 == null) {
			rbTeam3 = new JRadioButton("T3");
			buttonGroup.add(rbTeam3);
			rbTeam3.setForeground(new Color(0, 51, 102));
			rbTeam3.setBounds(10, 107, 50, 23);
			rbTeam3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 3;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam3);
		return rbTeam3;
	}
	private JRadioButton getRbTeam4() {
		if (rbTeam4 == null) {
			rbTeam4 = new JRadioButton("T4");
			buttonGroup.add(rbTeam4);
			rbTeam4.setForeground(new Color(0, 51, 102));
			rbTeam4.setBounds(10, 147, 50, 23);
			rbTeam4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 4;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam4);
		return rbTeam4;
	}
	private JRadioButton getRbTeam5() {
		if (rbTeam5 == null) {
			rbTeam5 = new JRadioButton("T5");
			buttonGroup.add(rbTeam5);
			rbTeam5.setForeground(new Color(0, 51, 102));
			rbTeam5.setBounds(10, 187, 50, 23);
			rbTeam5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 5;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam5);
		return rbTeam5;
	}
	private JRadioButton getRbTeam6() {
		if (rbTeam6 == null) {
			rbTeam6 = new JRadioButton("T6");
			buttonGroup.add(rbTeam6);
			rbTeam6.setForeground(new Color(0, 51, 102));
			rbTeam6.setBounds(10, 227, 50, 23);
			rbTeam6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 6;
					checkFull(selectedrdb);
					checkLow(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam6);
		return rbTeam6;
	}
	private JTextField gettfmate1_1() {
		if (tfmate1_1 == null) {
			tfmate1_1 = new JTextField();
			tfmate1_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_1.setForeground(new Color(0, 51, 102));
			tfmate1_1.setColumns(10);
			tfmate1_1.setBounds(65, 25, 80, 30);
			tfmate1_1.setEditable(false);
			
		}
		return tfmate1_1;
	}
	private JTextField gettfmate1_2() {
		if (tfmate1_2 == null) {
			tfmate1_2 = new JTextField();
			tfmate1_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_2.setForeground(new Color(0, 51, 102));
			tfmate1_2.setColumns(10);
			tfmate1_2.setBounds(145, 25, 80, 30);
			tfmate1_2.setEditable(false);
		}
		return tfmate1_2;
	}
	private JTextField gettfmate1_3() {
		if (tfmate1_3 == null) {
			tfmate1_3 = new JTextField();
			tfmate1_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_3.setForeground(new Color(0, 51, 102));
			tfmate1_3.setColumns(10);
			tfmate1_3.setBounds(225, 25, 80, 30);
			tfmate1_3.setEditable(false);
		}
		return tfmate1_3;
	}
	private JTextField gettfmate1_4() {
		if (tfmate1_4 == null) {
			tfmate1_4 = new JTextField();
			tfmate1_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_4.setForeground(new Color(0, 51, 102));
			tfmate1_4.setColumns(10);
			tfmate1_4.setBounds(305, 25, 80, 30);
			tfmate1_4.setEditable(false);
		}
		return tfmate1_4;
	}
	private JTextField gettfmate2_1() {
		if (tfmate2_1 == null) {
			tfmate2_1 = new JTextField();
			tfmate2_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_1.setForeground(new Color(0, 51, 102));
			tfmate2_1.setColumns(10);
			tfmate2_1.setBounds(65, 63, 80, 30);
			tfmate2_1.setEditable(false);
		}
		return tfmate2_1;
	}
	private JTextField getTfmate2_2() {
		if (tfmate2_2 == null) {
			tfmate2_2 = new JTextField();
			tfmate2_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_2.setForeground(new Color(0, 51, 102));
			tfmate2_2.setColumns(10);
			tfmate2_2.setBounds(145, 63, 80, 30);
			tfmate2_2.setEditable(false);
		}
		return tfmate2_2;
	}
	private JTextField getTfmate2_3() {
		if (tfmate2_3 == null) {
			tfmate2_3 = new JTextField();
			tfmate2_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_3.setForeground(new Color(0, 51, 102));
			tfmate2_3.setColumns(10);
			tfmate2_3.setBounds(225, 63, 80, 30);
			tfmate2_3.setEditable(false);
		}
		return tfmate2_3;
	}
	private JTextField getTfmate2_4() {
		if (tfmate2_4 == null) {
			tfmate2_4 = new JTextField();
			tfmate2_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_4.setForeground(new Color(0, 51, 102));
			tfmate2_4.setColumns(10);
			tfmate2_4.setBounds(305, 63, 80, 30);
			tfmate2_4.setEditable(false);
		}
		return tfmate2_4;
	}

	
	private JTextField gettfmate3_1() {
		if (tfmate3_1 == null) {
			tfmate3_1 = new JTextField();
			tfmate3_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_1.setForeground(new Color(0, 51, 102));
			tfmate3_1.setColumns(10);
			tfmate3_1.setBounds(65, 103, 80, 30);
			tfmate3_1.setEditable(false);
		}
		return tfmate3_1;
	}
	private JTextField gettfmate3_2() {
		if (tfmate3_2 == null) {
			tfmate3_2 = new JTextField();
			tfmate3_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_2.setForeground(new Color(0, 51, 102));
			tfmate3_2.setColumns(10);
			tfmate3_2.setBounds(145, 103, 80, 30);
			tfmate3_2.setEditable(false);
		}
		return tfmate3_2;
	}
	private JTextField gettfmate3_3() {
		if (tfmate3_3 == null) {
			tfmate3_3 = new JTextField();
			tfmate3_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_3.setForeground(new Color(0, 51, 102));
			tfmate3_3.setColumns(10);
			tfmate3_3.setBounds(225, 103, 80, 30);
			tfmate3_3.setEditable(false);
		}
		return tfmate3_3;
	}
	private JTextField gettfmate3_4() {
		if (tfmate3_4 == null) {
			tfmate3_4 = new JTextField();
			tfmate3_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_4.setForeground(new Color(0, 51, 102));
			tfmate3_4.setColumns(10);
			tfmate3_4.setBounds(305, 103, 80, 30);
			tfmate3_4.setEditable(false);
		}
		return tfmate3_4;
	}
	private JTextField gettfmate4_1() {
		if (tfmate4_1 == null) {
			tfmate4_1 = new JTextField();
			tfmate4_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_1.setForeground(new Color(0, 51, 102));
			tfmate4_1.setColumns(10);
			tfmate4_1.setBounds(65, 143, 80, 30);
			tfmate4_1.setEditable(false);
		}
		return tfmate4_1;
	}
	private JTextField gettfmate4_2() {
		if (tfmate4_2 == null) {
			tfmate4_2 = new JTextField();
			tfmate4_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_2.setForeground(new Color(0, 51, 102));
			tfmate4_2.setColumns(10);
			tfmate4_2.setBounds(145, 143, 80, 30);
			tfmate4_2.setEditable(false);
		}
		return tfmate4_2;
	}
	private JTextField gettfmate4_3() {
		if (tfmate4_3 == null) {
			tfmate4_3 = new JTextField();
			tfmate4_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_3.setForeground(new Color(0, 51, 102));
			tfmate4_3.setColumns(10);
			tfmate4_3.setBounds(225, 143, 80, 30);
			tfmate4_3.setEditable(false);
		}
		return tfmate4_3;
	}
	private JTextField gettfmate4_4() {
		if (tfmate4_4 == null) {
			tfmate4_4 = new JTextField();
			tfmate4_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_4.setForeground(new Color(0, 51, 102));
			tfmate4_4.setColumns(10);
			tfmate4_4.setBounds(305, 143, 80, 30);
			tfmate4_4.setEditable(false);
		}
		return tfmate4_4;
	}
	private JTextField gettfmate5_1() {
		if (tfmate5_1 == null) {
			tfmate5_1 = new JTextField();
			tfmate5_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_1.setForeground(new Color(0, 51, 102));
			tfmate5_1.setColumns(10);
			tfmate5_1.setBounds(65, 184, 80, 30);
			tfmate5_1.setEditable(false);
		}
		return tfmate5_1;
	}
	private JTextField gettfmate5_2() {
		if (tfmate5_2 == null) {
			tfmate5_2 = new JTextField();
			tfmate5_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_2.setForeground(new Color(0, 51, 102));
			tfmate5_2.setColumns(10);
			tfmate5_2.setBounds(145, 184, 80, 30);
			tfmate5_2.setEditable(false);
		}
		return tfmate5_2;
	}
	private JTextField gettfmate5_3() {
		if (tfmate5_3 == null) {
			tfmate5_3 = new JTextField();
			tfmate5_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_3.setForeground(new Color(0, 51, 102));
			tfmate5_3.setColumns(10);
			tfmate5_3.setBounds(225, 184, 80, 30);
			tfmate5_3.setEditable(false);
		}
		return tfmate5_3;
	}
	private JTextField gettfmate5_4() {
		if (tfmate5_4 == null) {
			tfmate5_4 = new JTextField();
			tfmate5_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_4.setForeground(new Color(0, 51, 102));
			tfmate5_4.setColumns(10);
			tfmate5_4.setBounds(305, 184, 80, 30);
			tfmate5_4.setEditable(false);
		}
		return tfmate5_4;
	}
	
	private JTextField getTfmate6_1() {
		if (tfmate6_1 == null) {
			tfmate6_1 = new JTextField();
			tfmate6_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_1.setForeground(new Color(0, 51, 102));
			tfmate6_1.setColumns(10);
			tfmate6_1.setBounds(65, 224, 80, 30);
			tfmate6_1.setEditable(false);
		}
		return tfmate6_1;
	}
	private JTextField getTfmate6_2() {
		if (tfmate6_2 == null) {
			tfmate6_2 = new JTextField();
			tfmate6_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_2.setForeground(new Color(0, 51, 102));
			tfmate6_2.setColumns(10);
			tfmate6_2.setBounds(145, 224, 80, 30);
			tfmate6_2.setEditable(false);
		}
		return tfmate6_2;
	}
	private JTextField getTfmate6_3() {
		if (tfmate6_3 == null) {
			tfmate6_3 = new JTextField();
			tfmate6_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_3.setForeground(new Color(0, 51, 102));
			tfmate6_3.setColumns(10);
			tfmate6_3.setBounds(225, 224, 80, 30);
			tfmate6_3.setEditable(false);
		}
		return tfmate6_3;
	}
	private JTextField getTfmate6_4() {
		if (tfmate6_4 == null) {
			tfmate6_4 = new JTextField();
			tfmate6_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_4.setForeground(new Color(0, 51, 102));
			tfmate6_4.setColumns(10);
			tfmate6_4.setBounds(305, 224, 80, 30);
			tfmate6_4.setEditable(false);
		}
		return tfmate6_4;
	}
	private JTextField gettfmate6_5() {
		if (tfmate6_5 == null) {
			tfmate6_5 = new JTextField();
			tfmate6_5.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_5.setForeground(new Color(0, 51, 102));
			tfmate6_5.setColumns(10);
			tfmate6_5.setBounds(385, 224, 80, 30);
			tfmate6_5.setEditable(false);
		}
		return tfmate6_5;
	}
	private JButton getBtnInTeamStatus() {
		if (btnInTeamStatus == null) {
			btnInTeamStatus = new JButton("IN");
			btnInTeamStatus.setForeground(new Color(51, 102, 153));
			btnInTeamStatus.setBounds(20, 455, 220, 40);
			btnInTeamStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clickInAction();
				}
			});
		}
		return btnInTeamStatus;
	}
	private JButton getBtnOutTeamStatus() {
		if (btnOutTeamStatus == null) {
			btnOutTeamStatus = new JButton("OUT");
			btnOutTeamStatus.setBackground(new Color(255, 255, 255));
			btnOutTeamStatus.setForeground(new Color(51, 102, 153));
			btnOutTeamStatus.setBounds(240, 455, 220, 40);
			btnOutTeamStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clickOutAction();
				}
			});
		}
		return btnOutTeamStatus;
	}
	
	private JScrollPane getScrollPane_TSStudentList() {
		if (scrollPane_TSStudentList == null) {
			scrollPane_TSStudentList = new JScrollPane();
			scrollPane_TSStudentList.setBounds(20, 260, 437, 180);
			scrollPane_TSStudentList.setViewportView(getTableTeamStatus());
		}
		return scrollPane_TSStudentList;
	}
	private JTable getTableTeamStatus() {
		if (tableTeamStatus == null) {
			tableTeamStatus = new JTable();
			tableTeamStatus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableTeamStatus.setModel(Outer_Table_StrudentList); // <--***************************************************
			tableTeamStatus.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			tableTeamStatus.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			tableTeamStatus.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			tableTeamStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return tableTeamStatus;
	}
	//테이블 꾸미기
	public void TSStudentListTable(){
		
		int i = Outer_Table_StrudentList.getRowCount();
		Outer_Table_StrudentList.addColumn("ID");
		Outer_Table_StrudentList.addColumn("Name");
		Outer_Table_StrudentList.addColumn("MBTI");
		Outer_Table_StrudentList.addColumn("Signal");
		Outer_Table_StrudentList.setColumnCount(4);
		
		for(int j = 0 ; j < i ; j++){
			Outer_Table_StrudentList.removeRow(0);
		}
		
		tableTeamStatus.setAutoResizeMode(tableTeamStatus.AUTO_RESIZE_OFF);
		int vColIndex = 0;
		TableColumn col = tableTeamStatus.getColumnModel().getColumn(vColIndex);
		int width = 120;
		col.setPreferredWidth(width);
		vColIndex = 1;
		col = tableTeamStatus.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);
		vColIndex = 2;
		col = tableTeamStatus.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);
		vColIndex = 3;
		col = tableTeamStatus.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);
	}
	
	//전체 검색결과를 Table로 
	public void SearchAction(){
		
		ArrayList<AdminTeamStatusBean> beanList = dbAction.AdminTeamStatusList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			
			String temp = beanList.get(index).getId();
			String[] qTxt = {temp, beanList.get(index).getName(), beanList.get(index).getMbti(), beanList.get(index).getDip()};
			Outer_Table_StrudentList.addRow(qTxt);
		}

	}
	
	// Table에서 Row를 Click
	private void TableClick() {
		
        int i = tableTeamStatus.getSelectedRow();
        String tkID = (String)tableTeamStatus.getValueAt(i, 0);
        String tkName = (String)tableTeamStatus.getValueAt(i, 1);
        
        dbAction = new AdminTeamStatusDBAction(tkID, tkName);
        
        
	}
	
	//in 버튼 클릭시 insert쿼리 호출
	public void clickInAction() {
		
		JTextField[] tfs = tfbeanList.get(selectedrdb-1);
		for(int i=0;i<tfs.length;i++) {
			//수정하기
			if(tfs[i].getText().equals("")) {
				boolean aaa = dbAction.teamStatusInAction(selectedrdb);
				
				if(aaa == true){
					TSStudentListTable();
					SearchAction();
					showTeammateStatusAction();
			        JOptionPane.showMessageDialog(null, selectedrdb + " 팀에 추가 되었습니다.!"); 
				}else{
					JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 학생을 클릭해주세요!!! \n 그래도 안되면 시스템관리자에 문의하세요!");
				}
				buttonGroup.clearSelection();
				dbAction = new AdminTeamStatusDBAction();
				return;
			}
		}
	}
	
	//out버튼 클릭 delete 쿼리 호출
	public void clickOutAction() {
		
		boolean aaa = dbAction.teamStatusOutAction(selectedrdb);
		
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, selectedrdb + " 팀의 정보가 삭제 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
		
		JTextField[] tfs = tfbeanList.get(selectedrdb-1);
		for(int i=0;i<tfs.length;i++) {
			dbAction.teamStatusOutAction(selectedrdb);
		}
		buttonGroup.clearSelection();
		TSStudentListTable();
		showTeammateStatusAction();
		SearchAction();
		dbAction = new AdminTeamStatusDBAction();
	}
	
	// 텍스트 필드 집합에 저장하고 쿼리로 빈을 채움
	public void showTeammateStatusAction(){
		
		buttonGroup.clearSelection();
		btnInTeamStatus.setEnabled(false);
		btnOutTeamStatus.setEnabled(false);
		
		for(JTextField[] tfarrays : tfbeanList) {
			clearTeamColumn(tfarrays);
		}
		
		ArrayList<AdminTeamStatusBean> beanList =  dbAction.ShowTeammateStatus();
		
		JTextField[] tf1 = {tfmate1_1, tfmate1_2, tfmate1_3, tfmate1_4};
		JTextField[] tf2 = {tfmate2_1, tfmate2_2, tfmate2_3, tfmate2_4};
		JTextField[] tf3 = {tfmate3_1, tfmate3_2, tfmate3_3, tfmate3_4};
		JTextField[] tf4 = {tfmate4_1, tfmate4_2, tfmate4_3, tfmate4_4};
		JTextField[] tf5 = {tfmate5_1, tfmate5_2, tfmate5_3, tfmate5_4};
		JTextField[] tf6 = {tfmate6_1, tfmate6_2, tfmate6_3, tfmate6_4, tfmate6_5};
		
		tfbeanList.add(tf1);
		tfbeanList.add(tf2);
		tfbeanList.add(tf3);
		tfbeanList.add(tf4);
		tfbeanList.add(tf5);
		tfbeanList.add(tf6);
		
		for(int i=0; i<beanList.size(); i++) {
			
			int tempno = beanList.get(i).getNo()-1;
			String tempname = beanList.get(i).getName();
			
			insertstudentname(tfbeanList.get(tempno), tempname, tempno);
			
		}
		
	}
	
	//빈칸이면 출력
	public void insertstudentname(JTextField[] tfs, String name, int rdbcount) {
		
		for(int i=0;i<tfs.length;i++) {
			if(tfs[i].getText().equals("")) {
				tfs[i].setText(name);
				return;
			}
		}
	}
	
	//텍스트필드 확인하고 버튼 비활성화
	public void checkFull(int num) {
		
		JTextField[] tfs =  tfbeanList.get(num-1);

		for(int i=0;i<tfs.length;i++) {
			
			if(tfs[i].getText().equals("")) {
				btnInTeamStatus.setEnabled(true);
				return;
			}
		}
		btnInTeamStatus.setEnabled(false);
	}
		
	//필드에 값있는지 확인하고 out버튼 활성화
	public void checkLow(int num) {
		
		int count = 0;
		JTextField[] tfs =  tfbeanList.get(num-1);
		
		for(int i=0;i<tfs.length;i++) {
			if(tfs[i].getText().equals("")) {
				count++;
			}
		}
		
		if(count==tfs.length) {
			btnOutTeamStatus.setEnabled(false);
		}else {
			btnOutTeamStatus.setEnabled(true);
		}
			
	}
	
	//텍스트필드 지워주기 위한 친구
	private void clearTeamColumn(JTextField[] tfs) {
		for(JTextField tf : tfs) {
			tf.setText("");
		}
	}
	
}