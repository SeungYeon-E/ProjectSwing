package com.swing.adminannouncement;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


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

public class AdminUpdateAnnouncement {

	private JFrame frmUpdate;
	private JTextArea textArea;
	private JSeparator separator;
	private JEditorPane dtrpnTitle;
	private JButton btnUpdate;
	String no;
	String writing;
	String title;
	String content;

	/**
	 * Launch the application.
	 */

	public void run(String no, String writing, String title, String content) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateAnnouncement window = new AdminUpdateAnnouncement(no, writing, title, content);
					window.frmUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUpdateAnnouncement(String no, String writing, String title, String content) {
		this.no = no;
		this.writing = writing;
		this.title = title;
		this.content = content;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.setTitle("Update Annoucement");
		frmUpdate.getContentPane().setBackground(Color.WHITE);
		frmUpdate.setBounds(100, 100, 500, 350);		
		frmUpdate.getContentPane().setLayout(null);
		frmUpdate.getContentPane().add(getTextArea());
		frmUpdate.getContentPane().add(getSeparator());
		frmUpdate.getContentPane().add(getDtrpnTitle());
		frmUpdate.getContentPane().add(getBtnUpdate());
		


	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(Color.WHITE);
			textArea.setForeground(Color.GRAY);
			textArea.setText(content);
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
			dtrpnTitle.setText(title);
			dtrpnTitle.setBounds(37, 18, 415, 30);
		}
		return dtrpnTitle;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.setBackground(Color.WHITE);
			btnUpdate.setForeground(new Color(0, 102, 204));
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
									
					updateAction();
					AdminAnnouncement adminAnnouncement = new AdminAnnouncement();
					adminAnnouncement.searchAction();
				}
			});
			btnUpdate.setBounds(348, 267, 117, 40);
		}
		return btnUpdate;
	}
	
	
	private void updateAction() {
		
		int intno = Integer.parseInt(no);
		
//		Calendar cal = Calendar.getInstance();
//		int year = cal.get ( cal.YEAR );
//		int month = cal.get ( cal.MONTH ) + 1 ;
//		int date = cal.get ( cal.DATE ) ;
//		
//		String writing = year + "-" + month + "-" + date ;
		String title = dtrpnTitle.getText();
		String content = textArea.getText();
		
		DbAction dbAction = new DbAction(intno, title, content);
		dbAction.updateAction();           
		
		JOptionPane.showMessageDialog(null, intno + "번의 게시물이 수정되었습니다.");
		frmUpdate.dispose();	
	}
	
	
} // End Line