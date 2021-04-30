package com.test.layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;


public class Announcement {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblMake;
	private JLabel lblTeam3;
	private JLabel lblBun;
	private JPanel ImagePanel;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblMbti;
	private JLabel lblGithub;
	private JLabel lblShowGithub;
	private JLabel lblShowName;
	private JLabel lblShowMbti;
	private JLabel lblShowId;
	private JButton btnAnnounce;
	private JButton btnCheckProfile;
	private JButton btnFindTeammate;
	private JButton btnTeamReview;
	private JButton btnTeammateStatus;
	private JLabel lblNewLabel;
	private JLabel lblTitle;
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final DefaultTableModel Outer_Table1 = new DefaultTableModel();
	private JPanel panelCheckProfile;
	private JPanel ImagePanel_1;
	private JLabel lblId_1;
	private JLabel lblName_1;
	private JLabel lblMbti_1;
	private JLabel lblGithub_1;
	private JLabel lblGithub_1_1;
	private JTextField tfId;
	private JTextField tfName;
	private JTextField tfAdress;
	private JTextField tfMbti;
	private JTextField tfGithub;
	private JLabel lblStrangth_1;
	private JTextField tfStrangth;
	private JLabel lblIntroduce_1;
	private JTextField tfIntroduce;
	private JScrollPane scrollPane_Project;
	private JTable ProjectTable;
	private JLabel lbl_1;
	private JLabel lbl_2;
	private JScrollPane scrollPane_TeammateReview;
	private JButton btnNewButton;
	private JTable TeammateReviewTable;
	private JLabel lblGithub_1_1_1;
	private JTextField tfPhoneNo;
	private JPanel panelTeamReview;
	private JScrollPane scrollPane_Project_1;
	private JLabel lbl_1_1;
	private JLabel lbl_2_1;
	private JScrollPane scrollPane_TeammateReview_1;
	private JButton btnOK;
	private JTable TRProjectTable;
	private JTable TRTeammateReviewTable;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Announcement window = new Announcement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Announcement() {
		initialize();
		CheckProfileTableProject();
		CheckProfileTableReview();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				panelTeamReview.setVisible(false);
				panelCheckProfile.setVisible(false);
				
			}
			
		});
		
		frame.setBounds(100, 100, 786, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanelCheckProfile());
		frame.getContentPane().add(getPanelTeamReview());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(51, 102, 153));
			panel.setBounds(0, 0, 300, 525);
			panel.setLayout(null);
			panel.add(getLblMake());
			panel.add(getLblTeam3());
			panel.add(getLblBun());
			panel.add(getImagePanel());
			panel.add(getLblId());
			panel.add(getLblName());
			panel.add(getLblMbti());
			panel.add(getLblGithub());
			panel.add(getLblShowId());
			panel.add(getLblShowName());
			panel.add(getLblShowGithub());
			panel.add(getLblShowMbti());
			panel.add(getBtnAnnounce());
			panel.add(getBtnCheckProfile());
			panel.add(getBtnFindTeammate());
			panel.add(getBtnTeamReview());
			panel.add(getBtnTeammateStatus());
		}
		return panel;
	}
	private JLabel getLblMake() {
		if (lblMake == null) {
			lblMake = new JLabel("作");
			lblMake.setBounds(6, 6, 16, 16);
		}
		return lblMake;
	}
	private JLabel getLblTeam3() {
		if (lblTeam3 == null) {
			lblTeam3 = new JLabel("Team3");
			lblTeam3.setBounds(23, 6, 47, 16);
		}
		return lblTeam3;
	}
	private JLabel getLblBun() {
		if (lblBun == null) {
			lblBun = new JLabel("BUN");
			lblBun.setBounds(68, 6, 26, 16);
		}
		return lblBun;
	}
	private JPanel getImagePanel() {
		if (ImagePanel == null) {
			ImagePanel = new JPanel();
			ImagePanel.setBounds(23, 54, 87, 108);
			ImagePanel.setLayout(null);
			ImagePanel.add(getLblNewLabel());
		}
		return ImagePanel;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(133, 54, 61, 16);
		}
		return lblId;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setBounds(133, 82, 61, 16);
		}
		return lblName;
	}
	private JLabel getLblMbti() {
		if (lblMbti == null) {
			lblMbti = new JLabel("MBTI");
			lblMbti.setBounds(133, 110, 37, 16);
		}
		return lblMbti;
	}
	private JLabel getLblGithub() {
		if (lblGithub == null) {
			lblGithub = new JLabel("Github");
			lblGithub.setBounds(133, 138, 47, 16);
		}
		return lblGithub;
	}
	private JLabel getLblShowGithub() {
		if (lblShowGithub == null) {
			lblShowGithub = new JLabel("jasper-oh");
			lblShowGithub.setBounds(193, 138, 101, 16);
		}
		return lblShowGithub;
	}
	private JLabel getLblShowName() {
		if (lblShowName == null) {
			lblShowName = new JLabel("오영준");
			lblShowName.setBounds(193, 82, 61, 16);
		}
		return lblShowName;
	}
	private JLabel getLblShowMbti() {
		if (lblShowMbti == null) {
			lblShowMbti = new JLabel("ENFJ");
			lblShowMbti.setBounds(193, 110, 61, 16);
		}
		return lblShowMbti;
	}
	private JLabel getLblShowId() {
		if (lblShowId == null) {
			lblShowId = new JLabel("Jasper");
			lblShowId.setBounds(193, 54, 61, 16);
		}
		return lblShowId;
	}
	private JButton getBtnAnnounce() {
		if (btnAnnounce == null) {
			btnAnnounce = new JButton("Announcement");
			btnAnnounce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CheckAnnouncementUIAction();
				}
			});
			btnAnnounce.setBounds(23, 234, 246, 43);
		}
		return btnAnnounce;
	}
	private JButton getBtnCheckProfile() {
		if (btnCheckProfile == null) {
			btnCheckProfile = new JButton("Check Profile");
			btnCheckProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CheckProfileUIAction();
				}
			});
			btnCheckProfile.setBounds(23, 289, 246, 43);
		}
		return btnCheckProfile;
	}
	private JButton getBtnFindTeammate() {
		if (btnFindTeammate == null) {
			btnFindTeammate = new JButton("Find Teammate");
			btnFindTeammate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkFindTeammateUIAction();
				}
			});
			btnFindTeammate.setBounds(23, 342, 246, 43);
		}
		return btnFindTeammate;
	}
	private JButton getBtnTeamReview() {
		if (btnTeamReview == null) {
			btnTeamReview = new JButton("Team Review");
			btnTeamReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTeamReviewAction();
				}
			});
			btnTeamReview.setBounds(23, 397, 246, 43);
		}
		return btnTeamReview;
	}
	private JButton getBtnTeammateStatus() {
		if (btnTeammateStatus == null) {
			btnTeammateStatus = new JButton("Teammate Status");
			btnTeammateStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTeammateStatusAction();
				}
			});
			btnTeammateStatus.setBounds(23, 452, 246, 43);
		}
		return btnTeammateStatus;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Image");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 44, 75, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Announcement");
			lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblTitle.setBounds(309, 0, 327, 36);
		}
		return lblTitle;
	}
	
	private void CheckAnnouncementUIAction(){
		lblTitle.setText("Announcement");
		
	}
	
	private void CheckProfileUIAction() {
		lblTitle.setText("Check Profile");
		panelCheckProfile.setVisible(true);
		panelTeamReview.setVisible(false);
		
		
	}
	
	private void checkFindTeammateUIAction() {
		lblTitle.setText("Find Teammate");
		
		
	}
	private void checkTeamReviewAction(){
		lblTitle.setText("Team Review");
		panelCheckProfile.setVisible(false);
		panelTeamReview.setVisible(true);
		
		
	}
	private void checkTeammateStatusAction(){
		lblTitle.setText("Teammate Status");
		
	}
	
	
	private JPanel getPanelCheckProfile() {
		if (panelCheckProfile == null) {
			panelCheckProfile = new JPanel();
			panelCheckProfile.setBackground(new Color(255, 255, 255));
			panelCheckProfile.setForeground(Color.BLACK);
			panelCheckProfile.setBounds(300, 35, 470, 479);
			panelCheckProfile.setLayout(null);
			panelCheckProfile.add(getImagePanel_1());
			panelCheckProfile.add(getLblId_1());
			panelCheckProfile.add(getLblName_1());
			panelCheckProfile.add(getLblMbti_1());
			panelCheckProfile.add(getLblGithub_1());
			panelCheckProfile.add(getLblGithub_1_1());
			panelCheckProfile.add(getTfId());
			panelCheckProfile.add(getTfName());
			panelCheckProfile.add(getTfAdress());
			panelCheckProfile.add(getTfMbti());
			panelCheckProfile.add(getTfGithub());
			panelCheckProfile.add(getLblStrangth_1());
			panelCheckProfile.add(getTextField_4());
			panelCheckProfile.add(getLblIntroduce_1());
			panelCheckProfile.add(getTextField_5());
			panelCheckProfile.add(getScrollPane_Project());
			panelCheckProfile.add(getLbl_1());
			panelCheckProfile.add(getLbl_2());
			panelCheckProfile.add(getScrollPane_TeammateReview());
			panelCheckProfile.add(getBtnNewButton());
			panelCheckProfile.add(getLblGithub_1_1_1());
			panelCheckProfile.add(getTfPhoneNo());
		}
		return panelCheckProfile;
	}
	private JPanel getImagePanel_1() {
		if (ImagePanel_1 == null) {
			ImagePanel_1 = new JPanel();
			ImagePanel_1.setLayout(null);
			ImagePanel_1.setBounds(36, 25, 132, 158);
		}
		return ImagePanel_1;
	}
	private JLabel getLblId_1() {
		if (lblId_1 == null) {
			lblId_1 = new JLabel("ID :");
			lblId_1.setBounds(180, 30, 61, 16);
		}
		return lblId_1;
	}
	private JLabel getLblName_1() {
		if (lblName_1 == null) {
			lblName_1 = new JLabel("Name :");
			lblName_1.setBounds(180, 55, 61, 16);
		}
		return lblName_1;
	}
	private JLabel getLblMbti_1() {
		if (lblMbti_1 == null) {
			lblMbti_1 = new JLabel("MBTI :");
			lblMbti_1.setBounds(180, 80, 47, 16);
		}
		return lblMbti_1;
	}
	private JLabel getLblGithub_1() {
		if (lblGithub_1 == null) {
			lblGithub_1 = new JLabel("Github :");
			lblGithub_1.setBounds(180, 105, 61, 16);
		}
		return lblGithub_1;
	}
	
	private JLabel getLblGithub_1_1() {
		if (lblGithub_1_1 == null) {
			lblGithub_1_1 = new JLabel("Adress :");
			lblGithub_1_1.setBounds(180, 130, 61, 16);
		}
		return lblGithub_1_1;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(253, 25, 116, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(253, 50, 116, 21);
		}
		return tfName;
	}
	private JTextField getTfAdress() {
		if (tfAdress == null) {
			tfAdress = new JTextField();
			tfAdress.setColumns(10);
			tfAdress.setBounds(253, 125, 184, 21);
		}
		return tfAdress;
	}
	private JTextField getTfMbti() {
		if (tfMbti == null) {
			tfMbti = new JTextField();
			tfMbti.setColumns(10);
			tfMbti.setBounds(253, 75, 116, 21);
		}
		return tfMbti;
	}
	private JTextField getTfGithub() {
		if (tfGithub == null) {
			tfGithub = new JTextField();
			tfGithub.setColumns(10);
			tfGithub.setBounds(253, 100, 184, 21);
		}
		return tfGithub;
	}
	private JLabel getLblStrangth_1() {
		if (lblStrangth_1 == null) {
			lblStrangth_1 = new JLabel("Strangth(사용가능언어) :");
			lblStrangth_1.setBounds(36, 193, 143, 15);
		}
		return lblStrangth_1;
	}
	private JTextField getTextField_4() {
		if (tfStrangth == null) {
			tfStrangth = new JTextField();
			tfStrangth.setBounds(180, 190, 257, 21);
			tfStrangth.setColumns(10);
		}
		return tfStrangth;
	}
	private JLabel getLblIntroduce_1() {
		if (lblIntroduce_1 == null) {
			lblIntroduce_1 = new JLabel("한줄 자기소개 :");
			lblIntroduce_1.setBounds(36, 223, 91, 15);
		}
		return lblIntroduce_1;
	}
	private JTextField getTextField_5() {
		if (tfIntroduce == null) {
			tfIntroduce = new JTextField();
			tfIntroduce.setColumns(10);
			tfIntroduce.setBounds(126, 218, 311, 21);
		}
		return tfIntroduce;
	}
	private JScrollPane getScrollPane_Project() {
		if (scrollPane_Project == null) {
			scrollPane_Project = new JScrollPane();
			scrollPane_Project.setBounds(36, 271, 401, 74);
			scrollPane_Project.setViewportView(getProjectTable());
		}
		return scrollPane_Project;
	}
	private JTable getProjectTable() {
		if (ProjectTable == null) {
			ProjectTable = new JTable();
			ProjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ProjectTable.setModel(Outer_Table); // <--***************************************************
			ProjectTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			ProjectTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			
		}
		return ProjectTable;
	}
	private JLabel getLbl_1() {
		if (lbl_1 == null) {
			lbl_1 = new JLabel("Project");
			lbl_1.setFont(new Font("굴림", Font.BOLD, 18));
			lbl_1.setBounds(36, 249, 67, 21);
		}
		return lbl_1;
	}
	private JLabel getLbl_2() {
		if (lbl_2 == null) {
			lbl_2 = new JLabel("Teammate Review");
			lbl_2.setFont(new Font("굴림", Font.BOLD, 18));
			lbl_2.setBounds(36, 349, 170, 21);
		}
		return lbl_2;
	}
	private JScrollPane getScrollPane_TeammateReview() {
		if (scrollPane_TeammateReview == null) {
			scrollPane_TeammateReview = new JScrollPane();
			scrollPane_TeammateReview.setBounds(36, 369, 401, 74);
			scrollPane_TeammateReview.setViewportView(getTeammateReviewTable());
		}
		return scrollPane_TeammateReview;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("수정하기");
			btnNewButton.setBounds(180, 450, 97, 23);
		}
		return btnNewButton;
	}

	private JTable getTeammateReviewTable() {
		if (TeammateReviewTable == null) {
			TeammateReviewTable = new JTable();
			TeammateReviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TeammateReviewTable.setModel(Outer_Table1); // <--***************************************************
			TeammateReviewTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TeammateReviewTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TeammateReviewTable;
	}
	private JLabel getLblGithub_1_1_1() {
		if (lblGithub_1_1_1 == null) {
			lblGithub_1_1_1 = new JLabel("PhoneNo :");
			lblGithub_1_1_1.setBounds(180, 155, 61, 16);
		}
		return lblGithub_1_1_1;
	}
	private JTextField getTfPhoneNo() {
		if (tfPhoneNo == null) {
			tfPhoneNo = new JTextField();
			tfPhoneNo.setColumns(10);
			tfPhoneNo.setBounds(253, 150, 184, 21);
		}
		return tfPhoneNo;
	}
	
	
	
	@SuppressWarnings("static-access")
	private void CheckProfileTableProject(){
	    int i = Outer_Table.getRowCount();
	    Outer_Table.addColumn("Project Name");
	    Outer_Table.addColumn("TeaName");
	    Outer_Table.addColumn("결과물-Git Address");
	    Outer_Table.setColumnCount(3);
	    for(int j = 0 ; j < i ; j++){
	      Outer_Table.removeRow(0);
	    }
	    ProjectTable.setAutoResizeMode(ProjectTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    int width = 50;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);
	    
	}
	@SuppressWarnings("static-access")
	private void CheckProfileTableReview(){
	    int i = Outer_Table1.getRowCount();
	    Outer_Table1.addColumn("Signal Name");
	    Outer_Table1.addColumn("Project Name");
	    Outer_Table1.addColumn("Review");
	    Outer_Table1.setColumnCount(3);
	    for(int j = 0 ; j < i ; j++){
	      Outer_Table1.removeRow(0);
	    }
	    TeammateReviewTable.setAutoResizeMode(TeammateReviewTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    int width = 50;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);

	}
	private JPanel getPanelTeamReview() {
		if (panelTeamReview == null) {
			panelTeamReview = new JPanel();
			panelTeamReview.setBounds(300, 35, 470, 479);
			panelTeamReview.setLayout(null);
			panelTeamReview.add(getScrollPane_Project_1());
			panelTeamReview.add(getLbl_1_1());
			panelTeamReview.add(getLbl_2_1());
			panelTeamReview.add(getScrollPane_TeammateReview_1());
			panelTeamReview.add(getBtnOK());
		}
		return panelTeamReview;
	}
	private JScrollPane getScrollPane_Project_1() {
		if (scrollPane_Project_1 == null) {
			scrollPane_Project_1 = new JScrollPane();
			scrollPane_Project_1.setBounds(33, 67, 401, 116);
			scrollPane_Project_1.setViewportView(getTRProjectTable());
		}
		return scrollPane_Project_1;
	}
	private JLabel getLbl_1_1() {
		if (lbl_1_1 == null) {
			lbl_1_1 = new JLabel("Project");
			lbl_1_1.setFont(new Font("굴림", Font.BOLD, 18));
			lbl_1_1.setBounds(33, 45, 67, 21);
		}
		return lbl_1_1;
	}
	private JLabel getLbl_2_1() {
		if (lbl_2_1 == null) {
			lbl_2_1 = new JLabel("Teammate Review");
			lbl_2_1.setFont(new Font("굴림", Font.BOLD, 18));
			lbl_2_1.setBounds(33, 201, 170, 21);
		}
		return lbl_2_1;
	}
	private JScrollPane getScrollPane_TeammateReview_1() {
		if (scrollPane_TeammateReview_1 == null) {
			scrollPane_TeammateReview_1 = new JScrollPane();
			scrollPane_TeammateReview_1.setBounds(33, 221, 401, 156);
			scrollPane_TeammateReview_1.setViewportView(getTRTeammateReviewTable());
		}
		return scrollPane_TeammateReview_1;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("등록하기");
			btnOK.setBounds(337, 400, 97, 23);
		}
		return btnOK;
	}
	private JTable getTRProjectTable() {
		if (TRProjectTable == null) {
			TRProjectTable = new JTable();
			TRProjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TRProjectTable.setModel(Outer_Table); // <--***************************************************
			TRProjectTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TRProjectTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TRProjectTable;
	}
	private JTable getTRTeammateReviewTable() {
		if (TRTeammateReviewTable == null) {
			TRTeammateReviewTable = new JTable();
			TRTeammateReviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TRTeammateReviewTable.setModel(Outer_Table1); // <--***************************************************
			TRTeammateReviewTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TRTeammateReviewTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TRTeammateReviewTable;
	}
}
