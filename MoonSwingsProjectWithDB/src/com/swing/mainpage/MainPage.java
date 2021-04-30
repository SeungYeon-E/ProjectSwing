package com.swing.mainpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.announcement.Announcement;
import com.swing.checkprofile.CheckProfile;
import com.swing.findteammate.FindTeammate;
import com.swing.login.Login;
import com.swing.teammatereview.TeammateReview;
import com.swing.teamstatus.TeamStatus;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage {

	private JFrame frame;
	private JPanel fixedpanel;
	private JPanel ImagePanel;
	private JLabel lblLogout;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblMbti;
	private JLabel lblGithub;
	private JLabel lblShowGithub;
	public static JLabel lblShowName;
	private JLabel lblShowMbti;
	private JLabel lblShowId;
	private JButton btnAnnounce;
	private JButton btnCheckProfile;
	private JButton btnFindTeammate;
	private JButton btnTeamReview;
	private JButton btnTeammateStatus;
	private JLabel lblImageDefaultLabel;
	private JLabel lblTitle;
	private JLabel lblBgLeftPanel;
	
	Login getBrief = new Login();
	
	String[] getBriefInfo = getBrief.getBriefInfo(Login.tfLoginUserId.getText());
	
	FixedPanelDBAction fpdba = new FixedPanelDBAction(Login.tfLoginUserId.getText());
	ImageIcon imageIcon = new ImageIcon(fpdba.getStudentImage());
	
	
	TeamStatus teamStatus = new TeamStatus();
	TeammateReview teammateReview = new TeammateReview(Login.tfLoginUserId.getText());	
	FindTeammate findTeammate = new FindTeammate();
	CheckProfile checkProfile = new CheckProfile();
	Announcement announcement = new Announcement();
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
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
				announcement.AnnouncementTable();
				announcement.searchAction();
				announcement.setVisible(true);
				teamStatus.setVisible(false);
				teammateReview.setVisible(false);
				checkProfile.setVisible(false);
				findTeammate.setVisible(false);
			}
		});
		frame.setBounds(100, 100,790, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(fixedPanel());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(announcement.getAnnouncement());

	}
	
	private JPanel fixedPanel() {
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
			fixedpanel.add(getBtnCheckProfile());
			fixedpanel.add(getBtnFindTeammate());
			fixedpanel.add(getBtnTeamReview());
			fixedpanel.add(getBtnTeammateStatus());
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
			lblBgLeftPanel.setIcon(new ImageIcon(MainPage.class.getResource("/images/leftPanel_Main.png")));
		}
		return lblBgLeftPanel;
	}

	private JPanel getImagePanel() {
		if (ImagePanel == null) {
			ImagePanel = new JPanel();
			ImagePanel.setBackground(new Color(245, 245, 245));
			ImagePanel.setBounds(23, 54, 99, 132);
			ImagePanel.setLayout(null);
			ImagePanel.add(getLblImageDefaultLabel());
		}
		return ImagePanel;
	}
	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("Logout");
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					logoutActionEvent();
				}
			});
			
			lblLogout.setFont(new Font("Lucida Grande", Font.BOLD, 11));
			lblLogout.setForeground(Color.WHITE);
			lblLogout.setBounds(6, 5, 100, 26);
		}
		return lblLogout;
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
			lblShowGithub = new JLabel(getBriefInfo[3]);
			lblShowGithub.setForeground(Color.WHITE);
			lblShowGithub.setBounds(183, 154, 101, 16);
		}
		return lblShowGithub;
	}
	private JLabel getLblShowName() {
		if (lblShowName == null) {
			lblShowName = new JLabel(getBriefInfo[1]);
			lblShowName.setForeground(Color.WHITE);
			lblShowName.setBounds(183, 98, 61, 16);
		}
		return lblShowName;
	}
	private JLabel getLblShowMbti() {
		if (lblShowMbti == null) {
			lblShowMbti = new JLabel(getBriefInfo[2]);
			lblShowMbti.setForeground(Color.WHITE);
			lblShowMbti.setBounds(183, 126, 61, 16);
		}
		return lblShowMbti;
	}
	private JLabel getLblShowId() {
		if (lblShowId == null) {
			lblShowId = new JLabel(getBriefInfo[0]);
			lblShowId.setForeground(Color.WHITE);
			lblShowId.setBounds(186, 70, 114, 16);
		}
		return lblShowId;
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
			btnAnnounce.setBounds(23, 234, 246, 43);
		}
		return btnAnnounce;
	}
	private JButton getBtnCheckProfile() {
		if (btnCheckProfile == null) {
			btnCheckProfile = new JButton("Check Profile");
			btnCheckProfile.setForeground(new Color(0, 102, 204));
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
			btnFindTeammate.setForeground(new Color(0, 102, 204));
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
			btnTeamReview.setForeground(new Color(0, 102, 204));
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
			btnTeammateStatus.setForeground(new Color(0, 102, 204));
			btnTeammateStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTeammateStatusAction();
				}
			});
			btnTeammateStatus.setBounds(23, 452, 246, 43);
		}
		return btnTeammateStatus;
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
		
		lblTitle.setText("Announcement");
		announcement.getAnnouncement().setVisible(true);
		teamStatus.getTeamStatus().setVisible(false);
		checkProfile.getCheckProfile().setVisible(false);
		teammateReview.setVisible(false);
		findTeammate.getFindTeammate().setVisible(false);

		
	}
	
	private void CheckProfileUIAction() {
		frame.getContentPane().add(checkProfile.getCheckProfile());
		lblTitle.setText("Check Profile");
		teammateReview.setVisible(false);
		announcement.getAnnouncement().setVisible(false);
		teamStatus.getTeamStatus().setVisible(false);
		checkProfile.getCheckProfile().setVisible(true);
		checkProfile.CheckProfileTableProject();
		checkProfile.showCheckprofileMyProject();
		checkProfile.CheckProfileTableReview();
		checkProfile.showCheckprofileTeammateReview();
		findTeammate.getFindTeammate().setVisible(false);
	}
	
	private void checkFindTeammateUIAction() {
		frame.getContentPane().add(findTeammate.getFindTeammate());
		lblTitle.setText("Find Teammate");
		teammateReview.setVisible(false);
		announcement.getAnnouncement().setVisible(false);
		teamStatus.getTeamStatus().setVisible(false);
		checkProfile.getCheckProfile().setVisible(false);
		findTeammate.FindTeammateTableFindTeammate();
		findTeammate.FindTeammateTableYouPickedBy();
		findTeammate.FindTeammateTableMyPick();
		findTeammate.getFindTeammate().setVisible(true);
		findTeammate.searchAction();
		
	}
	private void checkTeamReviewAction(){
		frame.getContentPane().add(teammateReview);
		lblTitle.setText("Team Review");
		teammateReview.initialiser();
		teammateReview.setVisible(true);
		announcement.getAnnouncement().setVisible(false);
		teamStatus.getTeamStatus().setVisible(false);
		checkProfile.getCheckProfile().setVisible(false);
		findTeammate.getFindTeammate().setVisible(false);

	}
	private void checkTeammateStatusAction(){
		frame.getContentPane().add(teamStatus.getTeamStatus());
		lblTitle.setText("Teammate Status");
		teammateReview.setVisible(false);
		announcement.getAnnouncement().setVisible(false);
		teamStatus.getTeamStatus().setVisible(true);
		checkProfile.getCheckProfile().setVisible(false);
		findTeammate.getFindTeammate().setVisible(false);
		teamStatus.showTeammateStatusAction();
		
	}

} 
