package com.swing.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.adminProject.AdminProjectManagement;
import com.swing.adminannouncement.AdminAnnouncement;
import com.swing.adminstudentlist.AdminStudentList;
import com.swing.adminteamstatus.AdminTeamStatus;
import com.swing.adminteamstatus.AdminTeamStatusDBAction;
import com.swing.login.Login;
import com.swing.mainpage.FixedPanelDBAction;
import com.swing.mainpage.MainPage;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class AdminMainPage {

	private JFrame frame;
	private JPanel fixedpanel;
	private JLabel lblBgLeftPanel;
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
	private JButton btnStudentList;
	private JButton btnTeamStatus;
	private JLabel lblImageDefaultLabel;
	private JLabel lblTitle;
	private JLabel lblLogout;
	private JButton btnProject;
	
	Login getBrief = new Login();
	String[] getTeacherBriefInfo = getBrief.getTeacherBriefInfo(Login.tfLoginUserId.getText());
	
	AdminFixedPanelDBAction fpdba = new AdminFixedPanelDBAction(Login.tfLoginUserId.getText());
	ImageIcon imageIcon = new ImageIcon(fpdba.getTeacherImage());
	
	AdminAnnouncement adminAnnouncement = new AdminAnnouncement();
	AdminStudentList adminStudentList = new AdminStudentList();
	AdminTeamStatus adminTeamStatus = new AdminTeamStatus();
	AdminProjectManagement adminProjectManagement = new AdminProjectManagement();
	
	
	/**
	 * Launch the application.
	 */
	
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AdminMainPage window = new AdminMainPage();
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
	
	public AdminMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				adminAnnouncement.AdminAnnouncementTable();
				adminAnnouncement.searchAction();
				adminAnnouncement.setVisible(true);
				adminStudentList.setVisible(false);
				adminTeamStatus.setVisible(false);
				adminProjectManagement.setVisible(false);
			}
		});
		frame.setBounds(100, 100,790, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
		frame.getContentPane().add(getfixedPanel());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(adminAnnouncement.getAnnouncement());

		

	}
	private JPanel getfixedPanel() {
		if (fixedpanel== null) {
			fixedpanel= new JPanel();
			fixedpanel.setBackground(new Color(51, 102, 153));
			fixedpanel.setBounds(0, 0, 300, 542);
			fixedpanel.setLayout(null);
			fixedpanel.add(getImagePanel());
			fixedpanel.add(getLblId());
			fixedpanel.add(getLblName());
			fixedpanel.add(getLblMbti());
			fixedpanel.add(getLblGithub());
			fixedpanel.add(getLblShowId());
			fixedpanel.add(getLblShowName());
			fixedpanel.add(getLblShowGithub());
			fixedpanel.add(getLblShowMbti());
			fixedpanel.add(getBtnAnnounce());
			fixedpanel.add(getBtnStudentList());
			fixedpanel.add(getBtnTeamStatus());
			fixedpanel.add(getBtnProject());
			fixedpanel.add(getLblLogout());
			fixedpanel.add(getLblBgLeftPanel());
		}
		return fixedpanel;
	}
	private JLabel getLblBgLeftPanel() {
		if (lblBgLeftPanel == null) {
			lblBgLeftPanel = new JLabel("");
			lblBgLeftPanel.setForeground(Color.WHITE);
			lblBgLeftPanel.setBounds(0, 0, 300, 542);
			lblBgLeftPanel.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/leftPanel_Main.png")));
		}
		return lblBgLeftPanel;
	}

	private JPanel getImagePanel() {
		if (ImagePanel == null) {
			ImagePanel = new JPanel();
			ImagePanel.setBounds(23, 54, 99, 132);
			ImagePanel.setLayout(null);
			ImagePanel.add(getLblImageDefaultLabel());
		}
		return ImagePanel;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setForeground(Color.WHITE);
			lblId.setBounds(137, 70, 61, 16);
		}
		return lblId;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setForeground(Color.WHITE);
			lblName.setBounds(134, 98, 61, 16);
		}
		return lblName;
	}
	private JLabel getLblMbti() {
		if (lblMbti == null) {
			lblMbti = new JLabel("MBTI");
			lblMbti.setForeground(Color.WHITE);
			lblMbti.setBounds(134, 126, 37, 16);
		}
		return lblMbti;
	}
	private JLabel getLblGithub() {
		if (lblGithub == null) {
			lblGithub = new JLabel("Github");
			lblGithub.setForeground(Color.WHITE);
			lblGithub.setBounds(134, 154, 47, 16);
		}
		return lblGithub;
	}

	private JLabel getLblShowGithub() {
		if (lblShowGithub == null) {
			lblShowGithub = new JLabel(getTeacherBriefInfo[3]);
			lblShowGithub.setForeground(Color.WHITE);
			lblShowGithub.setBounds(194, 154, 101, 16);
		}
		return lblShowGithub;
	}
	private JLabel getLblShowName() {
		if (lblShowName == null) {
			lblShowName = new JLabel(getTeacherBriefInfo[1]);
			lblShowName.setForeground(Color.WHITE);
			lblShowName.setBounds(194, 98, 61, 16);
		}
		return lblShowName;
	}
	private JLabel getLblShowMbti() {
		if (lblShowMbti == null) {
			lblShowMbti = new JLabel(getTeacherBriefInfo[2]);
			lblShowMbti.setForeground(Color.WHITE);
			lblShowMbti.setBounds(194, 126, 61, 16);
		}
		return lblShowMbti;
	}
	private JLabel getLblShowId() {
		if (lblShowId == null) {
			lblShowId = new JLabel(getTeacherBriefInfo[0]);
			lblShowId.setForeground(Color.WHITE);
			lblShowId.setBounds(197, 70, 61, 16);
		}
		return lblShowId;
	}
	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("Logout");
			lblLogout.setFont(new Font("Lucida Grande", Font.BOLD, 11));
			lblLogout.setForeground(Color.WHITE);
			lblLogout.setBounds(6, 5, 100, 26);
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					logoutActionEvent();
				}
			});
		}
		return lblLogout;
	}
	private JButton getBtnAnnounce() {
		if (btnAnnounce == null) {
			btnAnnounce = new JButton("Announcement");
			btnAnnounce.setForeground(new Color(0, 102, 204));
			btnAnnounce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					CheckAnnouncementUIAction();
				}
			});
			btnAnnounce.setBounds(23, 240, 246, 43);
		}
		return btnAnnounce;
	}
	private JButton getBtnStudentList() {
		if (btnStudentList == null) {
			btnStudentList = new JButton("Student List");
			btnStudentList.setForeground(new Color(0, 102, 204));
			btnStudentList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkStudentListTableUIAction();
				}
			});
			btnStudentList.setBounds(23, 310, 246, 43);
		}
		return btnStudentList;
	}
	private JButton getBtnTeamStatus() {
		if (btnTeamStatus == null) {
			btnTeamStatus = new JButton("Team Status");
			btnTeamStatus.setForeground(new Color(0, 102, 204));
			btnTeamStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkTeamStatusUIAction();
				}
			});
			btnTeamStatus.setBounds(23, 380, 246, 43);
		}
		return btnTeamStatus;
	}
	private JLabel getLblImageDefaultLabel() {
		if (lblImageDefaultLabel == null) {
			lblImageDefaultLabel = new JLabel("Image");
			lblImageDefaultLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblImageDefaultLabel.setBounds(0, 0, 99, 132);
			Image image = imageIcon.getImage().getScaledInstance(lblImageDefaultLabel.getWidth()+17, lblImageDefaultLabel.getHeight(), Image.SCALE_SMOOTH);
			lblImageDefaultLabel.setIcon(new ImageIcon(image));
		}
		return lblImageDefaultLabel;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("Announcement");
			lblTitle.setForeground(new Color(128, 128, 128));
			lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblTitle.setBounds(325, 10, 327, 36);
		}
		return lblTitle;
	}
	
	private void logoutActionEvent() {
		
		Login login = new Login();
		login.run();
		
		frame.setVisible(false);
		
	}
	
	// ---------------------
	// button action method
	// ---------------------
	
	private void CheckAnnouncementUIAction(){
//		frame.getContentPane().add(adminAnnouncement.getAnnouncement());
		lblTitle.setText("Announcement");
		adminAnnouncement.getAnnouncement().setVisible(true);
		adminAnnouncement.clearColumn();
		adminStudentList.getStudentList().setVisible(false);
		adminTeamStatus.getTeamStatus().setVisible(false);
		adminProjectManagement.setVisible(false);
		
	}
	
	private void checkStudentListTableUIAction() {
		frame.getContentPane().add(adminStudentList.getStudentList());
		lblTitle.setText("Student List");
		adminAnnouncement.getAnnouncement().setVisible(false);
		adminStudentList.getStudentList().setVisible(true);
		adminTeamStatus.getTeamStatus().setVisible(false);
		adminProjectManagement.setVisible(false);
		adminStudentList.SLStudentListTable();
		adminStudentList.searchAction();
	}
	
	private void checkTeamStatusUIAction(){
		
		frame.getContentPane().add(adminTeamStatus.getTeamStatus());
		lblTitle.setText("Team Status");
		
		adminTeamStatus.getTeamStatus().setVisible(true);
		adminAnnouncement.getAnnouncement().setVisible(false);
		adminStudentList.getStudentList().setVisible(false);
		adminProjectManagement.setVisible(false);
		adminTeamStatus.TSStudentListTable();
		adminTeamStatus.SearchAction();
		adminTeamStatus.showTeammateStatusAction();
		adminTeamStatus.dbAction = new AdminTeamStatusDBAction();

	}
	
	
	// 21.04.30 Manage Project button--------------------------
	// Manage Project -----------------
	private JButton getBtnProject() {
		if (btnProject == null) {
			btnProject = new JButton("Project Management");
			btnProject.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkManageProjectUIAction();
				}
			});
			btnProject.setBackground(Color.WHITE);
			btnProject.setForeground(new Color(0, 102, 204));
			btnProject.setBounds(23, 450, 246, 43);
		}
		return btnProject;
	}
	
	// Manage Project btn action
	private void checkManageProjectUIAction() {
		
		lblTitle.setText("Project Management");
		frame.getContentPane().add(adminProjectManagement); //-----> add projectUI 
		
		adminAnnouncement.getAnnouncement().setVisible(false);
		adminStudentList.getStudentList().setVisible(false);
		adminTeamStatus.getTeamStatus().setVisible(false);
		
		adminProjectManagement.initialiser();
		adminProjectManagement.setVisible(true);
		
	}

}