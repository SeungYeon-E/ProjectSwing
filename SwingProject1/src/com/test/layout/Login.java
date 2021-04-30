package com.test.layout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmteam;
	private JPanel panel;
	private JLabel lblMake;
	private JLabel lblNewLabel;
	private JLabel lblBun;
	private JLabel lblNewLabel_1;
	private JLabel lblUserId;
	private JTextField tfUserId;
	private JLabel lblPassword;
	private JTextField tfPassword;
	private JButton btnSignIn;
	private JButton btnSignUp;
	private JButton btnFindIdPw;
	

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
		frmteam.setTitle("작TEAM3분");
		frmteam.setBounds(100, 100, 790, 570);
		frmteam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmteam.getContentPane().setLayout(null);
		frmteam.getContentPane().add(getPanel());
		frmteam.getContentPane().add(getLblNewLabel_1());
		frmteam.getContentPane().add(getLblUserId());
		frmteam.getContentPane().add(getTfUserId());
		frmteam.getContentPane().add(getLblPassword());
		frmteam.getContentPane().add(getTfPassword());
		frmteam.getContentPane().add(getBtnSignIn());
		frmteam.getContentPane().add(getBtnSignUp());
		frmteam.getContentPane().add(getBtnFindIdPw());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(51, 102, 153));
			panel.setBounds(0, 0, 363, 542);
			panel.setLayout(null);
			panel.add(getLblMake());
			panel.add(getLblNewLabel());
			panel.add(getLblBun());
		}
		return panel;
	}
	private JLabel getLblMake() {
		if (lblMake == null) {
			lblMake = new JLabel("作");
			lblMake.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
			lblMake.setBounds(71, 118, 45, 44);
		}
		return lblMake;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("TEAM3");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 33));
			lblNewLabel.setBounds(90, 192, 156, 44);
		}
		return lblNewLabel;
	}
	private JLabel getLblBun() {
		if (lblBun == null) {
			lblBun = new JLabel("BUN");
			lblBun.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblBun.setBounds(185, 274, 61, 29);
		}
		return lblBun;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("SIGN IN");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(434, 50, 83, 31);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblUserId() {
		if (lblUserId == null) {
			lblUserId = new JLabel("User ID");
			lblUserId.setForeground(new Color(0, 51, 102));
			lblUserId.setBounds(434, 146, 61, 16);
		}
		return lblUserId;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBackground(SystemColor.window);
			tfUserId.setBounds(434, 174, 319, 52);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(0, 51, 102));
			lblPassword.setBounds(434, 258, 61, 16);
		}
		return lblPassword;
	}
	private JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setBackground(SystemColor.window);
			tfPassword.setColumns(10);
			tfPassword.setBounds(434, 286, 319, 52);
		}
		return tfPassword;
	}
	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("Sign In");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
					Announcement announcement = new Announcement();
					announcement.run();
					frmteam.setVisible(false);
		
				}
			});
			btnSignIn.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			btnSignIn.setBounds(434, 399, 319, 43);
			btnSignIn.setForeground(new Color(0, 51, 102));
			btnSignIn.setBackground(new Color(51, 102, 153));
		}
		return btnSignIn;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("Sign Up");
			btnSignUp.setForeground(new Color(0, 51, 102));
			btnSignUp.setBackground(new Color(51, 102, 153));
			btnSignUp.setBounds(434, 454, 159, 43);
		}
		return btnSignUp;
	}
	private JButton getBtnFindIdPw() {
		if (btnFindIdPw == null) {
			btnFindIdPw = new JButton("Find ID / PW");
			btnFindIdPw.setBounds(594, 454, 159, 43);
		}
		return btnFindIdPw;
	}
}
