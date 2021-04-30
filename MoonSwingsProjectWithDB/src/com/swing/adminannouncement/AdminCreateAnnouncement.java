package com.swing.adminannouncement;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class AdminCreateAnnouncement {

	private JFrame frmCreate;
	
	// Outer Table for Project
	private final DefaultTableModel Outer_Table_ProjectTable = new DefaultTableModel();
	// Outer Table for Teammate Review
	private final DefaultTableModel Outer_Table_TeammateReviewTable = new DefaultTableModel();
	private JTextArea textArea;
	private JSeparator separator;
	private JEditorPane dtrpnTitle;
	private JButton btnCreate;

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCreateAnnouncement window = new AdminCreateAnnouncement();
					window.frmCreate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminCreateAnnouncement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreate = new JFrame();
		frmCreate.setTitle("Create Announcement");
		frmCreate.getContentPane().setBackground(Color.WHITE);
		frmCreate.setBounds(100, 100, 500, 350);
		
//		frmProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreate.getContentPane().setLayout(null);
		frmCreate.getContentPane().add(getTextArea());
		frmCreate.getContentPane().add(getSeparator());
		frmCreate.getContentPane().add(getDtrpnTitle());
		frmCreate.getContentPane().add(getBtnCreate());
		


	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(Color.WHITE);
			textArea.setForeground(Color.GRAY);
			textArea.setText("");
			textArea.setRows(20);
			textArea.setBounds(37, 76, 415, 165);
		}
		return textArea;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.LIGHT_GRAY);
			separator.setBounds(27, 50, 438, 19);
		}
		return separator;
	}
	private JEditorPane getDtrpnTitle() {
		if (dtrpnTitle == null) {
			dtrpnTitle = new JEditorPane();
			dtrpnTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			dtrpnTitle.setForeground(Color.GRAY);
			dtrpnTitle.setText("");
			dtrpnTitle.setBounds(37, 18, 415, 30);
		}
		return dtrpnTitle;
	}
	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton("Create");
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int i_chk = insertFieldCheck();
					if(i_chk == 0) {
						insertAction();
						AdminAnnouncement adminAnnouncement = new AdminAnnouncement();
						adminAnnouncement.searchAction();
					}else {
						JOptionPane.showMessageDialog(null, "내용을 입력해주세요.");
					}
//					adminAnnouncement.clearColumn();

				}
			});
			btnCreate.setBackground(Color.WHITE);
			btnCreate.setForeground(new Color(0, 102, 204));
			btnCreate.setBounds(348, 267, 117, 40);
		}
		return btnCreate;
	}
	
	private void insertAction() {
		
		String title = dtrpnTitle.getText();
		String content = textArea.getText();
		
		DbAction dbAction = new DbAction(title, content);
		boolean msg = dbAction.insertAction();
		
		if(msg == true) {
			JOptionPane.showMessageDialog(null, "게시물이 등록되었습니다.");
			frmCreate.dispose();	                
		}else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
					"Critical Error!", 
					JOptionPane.ERROR_MESSAGE);                    
		}
		
	}
	
	private int insertFieldCheck() {
		int i = 0;
		String title = dtrpnTitle.getText().trim();
		String content = textArea.getText().trim();
		
		if(title.length() == i && content.length() ==i) {
			i++;
		}
		return i;
	}
	
} // End Line