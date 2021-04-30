package com.swing.login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.swing.admin.AdminFixedPanelDBAction;
import com.swing.admin.AdminMainPage;
import com.swing.checkprofile.CheckProfileDBAction;
import com.swing.mainpage.FixedPanelDBAction;
import com.swing.mainpage.MainPage;

import javax.swing.JTextField;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login {

	private JFrame frmteam;
	private JPanel panel;
	private JLabel lblBgLogin;
	private JLabel lblSignIn;
	private JLabel lblLoginUserId;
	public static JTextField tfLoginUserId;
	private JLabel lblLoginPassword;
	private JButton btnLoginSignIn;
	private JButton btnLoginSignUp;
	private JButton btnLoginFindIdPw;
	private JPasswordField pfLoginPassword;
	private JComboBox cbCheckStudentTeacher;
	

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Login loginWindow = new Login();
					loginWindow.frmteam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmteam = new JFrame();
		frmteam.getContentPane().setBackground(Color.WHITE);
		frmteam.setTitle("작TEAM3분");
		frmteam.setBounds(100, 100, 790, 570);
		frmteam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmteam.getContentPane().setLayout(null);
		frmteam.setResizable(false);
		frmteam.getContentPane().add(getPanel());
		frmteam.getContentPane().add(getLblSignIn());
		frmteam.getContentPane().add(getLblLoginUserId());
		frmteam.getContentPane().add(getTfLoginUserId());
		frmteam.getContentPane().add(getLblLoginPassword());
		frmteam.getContentPane().add(getPfLoginPassword());
		frmteam.getContentPane().add(getBtnLoginSignIn());
		frmteam.getContentPane().add(getBtnLoginSignUp());
		frmteam.getContentPane().add(getBtnLoginFindIdPw());
		frmteam.getContentPane().add(getCBCheckStudentTeacher());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(51, 102, 153));
			panel.setBounds(0, 0, 363, 542);
			panel.setLayout(null);
			panel.add(getLblBgLogin());
		}
		return panel;
	}
	private JLabel getLblBgLogin() {
		if (lblBgLogin == null) {
			lblBgLogin = new JLabel("");
			lblBgLogin.setBounds(0, 0, 363, 542);
			lblBgLogin.setIcon(new ImageIcon(Login.class.getResource("/images/leftPanel_login.png")));
			lblBgLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		}
		return lblBgLogin;
	}
	
	
	private JLabel getLblSignIn() {
		if (lblSignIn == null) {
			lblSignIn = new JLabel("SIGN IN");
			lblSignIn.setForeground(new Color(128, 128, 128));
			lblSignIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblSignIn.setBounds(434, 50, 83, 31);
		}
		return lblSignIn;
	}
	private JLabel getLblLoginUserId() {
		if (lblLoginUserId == null) {
			lblLoginUserId = new JLabel("User ID");
			lblLoginUserId.setForeground(Color.GRAY);
			lblLoginUserId.setBounds(434, 146, 61, 16);
		}
		return lblLoginUserId;
	}
	private JTextField getTfLoginUserId() {
		if (tfLoginUserId == null) {
			tfLoginUserId = new JTextField();
			tfLoginUserId.setHorizontalAlignment(SwingConstants.LEFT);
			tfLoginUserId.setForeground(new Color(0, 102, 204));
			tfLoginUserId.setBackground(Color.WHITE);
			tfLoginUserId.setBounds(434, 174, 319, 52);
			tfLoginUserId.setColumns(10);
		}
		return tfLoginUserId;
	}
	private JLabel getLblLoginPassword() {
		if (lblLoginPassword == null) {
			lblLoginPassword = new JLabel("Password");
			lblLoginPassword.setForeground(Color.GRAY);
			lblLoginPassword.setBounds(434, 258, 61, 16);
		}
		return lblLoginPassword;
	}
	private JPasswordField getPfLoginPassword() {
		if (pfLoginPassword == null) {
			pfLoginPassword = new JPasswordField();
			pfLoginPassword.setForeground(new Color(0, 102, 204));
			pfLoginPassword.setBackground(Color.WHITE);
			pfLoginPassword.setBounds(434, 286, 319, 52);
		}
		return pfLoginPassword;
	}
	private JComboBox getCBCheckStudentTeacher() {
		if (cbCheckStudentTeacher == null) {
			cbCheckStudentTeacher = new JComboBox();
			cbCheckStudentTeacher.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher"}));
			cbCheckStudentTeacher.setBounds(648, 140, 105, 30);
		}
		return cbCheckStudentTeacher;
	}
	
	
	private JButton getBtnLoginSignIn() {
		if (btnLoginSignIn == null) {
			btnLoginSignIn = new JButton("Sign In");
			btnLoginSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println(cbCheckStudentTeacher.getSelectedIndex());
					
					if(cbCheckStudentTeacher.getSelectedIndex() == 0) {	
						String userId = tfLoginUserId.getText();
						getBriefInfo(userId);
						loginAction();
					}
					if(cbCheckStudentTeacher.getSelectedIndex() == 1) {
						String userId = tfLoginUserId.getText();
						getTeacherBriefInfo(userId);
						teacherLoginAction();
					}
				}
			});
			btnLoginSignIn.setForeground(Color.WHITE);
			btnLoginSignIn.setBackground(new Color(0, 102, 204));
			btnLoginSignIn.setOpaque(true);
			btnLoginSignIn.setBorderPainted(false);
			btnLoginSignIn.setBounds(434, 399, 319, 43);
		}
		return btnLoginSignIn;
	}
	
	
	private JButton getBtnLoginSignUp() {
		if (btnLoginSignUp == null) {
			btnLoginSignUp = new JButton("Sign Up");
			btnLoginSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(cbCheckStudentTeacher.getSelectedIndex() == 0) {	
						SignUp signUp = new SignUp();
						signUp.run();
					}else if(cbCheckStudentTeacher.getSelectedIndex() == 1) {
						AdminSignUp adminSignUp = new AdminSignUp();
						adminSignUp.run();
					}
				}
			});
			btnLoginSignUp.setForeground(new Color(0, 102, 204));
			btnLoginSignUp.setBackground(Color.WHITE);
			btnLoginSignUp.setBounds(434, 454, 159, 43);
		}
		return btnLoginSignUp;
	}
	
	
	private JButton getBtnLoginFindIdPw() {
		if (btnLoginFindIdPw == null) {
			btnLoginFindIdPw = new JButton("Find ID / PW");
			btnLoginFindIdPw.setBackground(Color.WHITE);
			btnLoginFindIdPw.setForeground(new Color(0, 102, 204));
			btnLoginFindIdPw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(cbCheckStudentTeacher.getSelectedIndex() == 0) {
						FindIdPw findIdPw = new FindIdPw();
						findIdPw.run();
					}else if(cbCheckStudentTeacher.getSelectedIndex() == 1) {
						AdminFindIdPw adminFindIdPw = new AdminFindIdPw();
						adminFindIdPw.run();
					}
				}
			});
			btnLoginFindIdPw.setBounds(594, 454, 159, 43);
		}
		return btnLoginFindIdPw;
	}
	
	
	private void loginAction() {
		
		String logInId = tfLoginUserId.getText();
		char[] logInPw = pfLoginPassword.getPassword();
		String strLoginPw = String.copyValueOf(logInPw);
		
		
		SignInDBAction signInDbAction = new SignInDBAction(logInId,strLoginPw);
		
		if(signInDbAction.CheckLoginAction()) {
			frmteam.setVisible(false);
			MainPage mainPage= new MainPage();
			mainPage.run();
		}else{
			JOptionPane.showMessageDialog(null, "ID 와 PW 를 다시 체크해 주세요");
			tfLoginUserId.setText("");
			pfLoginPassword.setText("");
		}
	}
	
	
	private void teacherLoginAction() {
		String logInId = tfLoginUserId.getText();
		char[] logInPw = pfLoginPassword.getPassword();
		String strLoginPw = String.copyValueOf(logInPw);
		
		SignInDBAction signInDbAction = new SignInDBAction(logInId,strLoginPw);
		
		if(signInDbAction.CheckTeacherLoginAction()) {
			frmteam.setVisible(false);
			AdminMainPage adminMainPage = new AdminMainPage();
			adminMainPage.run();
		}else {
			JOptionPane.showMessageDialog(null, "ID 와 PW 를 다시 체크해 주세요");
			tfLoginUserId.setText("");
			pfLoginPassword.setText("");
		}
		
	}
	
	public String[] getBriefInfo(String logInId) {

		FixedPanelDBAction fixedPanelInfo = new FixedPanelDBAction(logInId);
		
		String[] briefInfo = fixedPanelInfo.getFixedPanelInfo();
		System.out.println("GetBriefInfo");

		return briefInfo;
	}
	
	public String[] getTeacherBriefInfo(String logInId) {
		
		AdminFixedPanelDBAction fixedAdminPanelInfo = new AdminFixedPanelDBAction(logInId);
		
		String[] adminBriefInfo = fixedAdminPanelInfo.getFixedPanelTeacherInfo();
		System.out.println("getTeacherBriefInfo");

		return adminBriefInfo;
	}
}
