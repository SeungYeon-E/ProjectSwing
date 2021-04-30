package com.swing.adminstudentlist;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.swing.findteammate.Bean;
import com.swing.findteammate.DbAction2;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdminStudentProfile {

	private JFrame frmProfile;
	private JLabel lblOtherProfileId;
	private JLabel lblOtherProfileName;
	private JLabel lblOtherProfileMbti;
	private JLabel lblOtherProfileGithub;
	private JLabel lblOtherProfileAddress;
	private JTextField tfStudentId;
	private JTextField tfStudentName;
	private JTextField tfStudentAddress;
	private JTextField tfStudentMbti;
	private JTextField tfStudentGithub;
	private JLabel lblOtherProfileStrength;
	private JTextField tfStudentStrength;
	private JLabel lblOtherProfileIntroduce;
	private JTextField tfStudentIntroduce;
	private JScrollPane scrollPane_Project;
	private JTable ProjectTable;
	
	// Outer Table for Project
	private final DefaultTableModel Outer_Table_ProjectTable = new DefaultTableModel();
	// Outer Table for Teammate Review
	private final DefaultTableModel Outer_Table_TeammateReviewTable = new DefaultTableModel();
	
	private JLabel lblOtherProfileProject;
	private JLabel lblOtherTeammateReview;
	private JScrollPane scrollPane_TeammateReview;
	private JTable TeammateReviewTable;
	private JLabel lblOtherProfilePhone;
	private JTextField tfStudentPhone;
	private JLabel lblStudentTitle;
	private JTextField tfStudentDipCount;
	private JLabel lblSignal;
	String id;
	String name;
	String dipCount;
	private JButton btnClose;
	private JLabel lblPhoto;
	

	/**
	 * Launch the application.
	 */
	public static void run(String id, String name, String dipCount) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStudentProfile window = new AdminStudentProfile(id, name, dipCount);
					window.frmProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminStudentProfile(String id, String name, String dipCount) {
		this.id = id;
		this.name = name;
		this.dipCount = dipCount;
		initialize();
	}
	
//	DbAction2 dbAction = new DbAction2(id);
//	Bean bean = dbAction.TableClick();
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfile = new JFrame();
		frmProfile.getContentPane().setBackground(Color.WHITE);
		frmProfile.setBounds(100, 100, 480, 600);
		frmProfile.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setText();
				
			}
		});
		
//		frmProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfile.getContentPane().setLayout(null);
		frmProfile.getContentPane().add(getLblOtherProfileId());
		frmProfile.getContentPane().add(getLblOtherProfileName());
		frmProfile.getContentPane().add(getLblOtherProfileMbti());
		frmProfile.getContentPane().add(getLblOtherProfileGithub());
		frmProfile.getContentPane().add(getLblOtherProfileAddress());
		frmProfile.getContentPane().add(getTfStudentId());
		frmProfile.getContentPane().add(getTfStudentName());
		frmProfile.getContentPane().add(getTfStudentAddress());
		frmProfile.getContentPane().add(getTfStudentMbti());
		frmProfile.getContentPane().add(getTfStudentGithub());
		frmProfile.getContentPane().add(getLblOtherProfileStrength());
		frmProfile.getContentPane().add(getTextField_4());
		frmProfile.getContentPane().add(getLblOtherProfileIntroduce());
		frmProfile.getContentPane().add(getTextField_5());
		frmProfile.getContentPane().add(getScrollPane_Project());
		frmProfile.getContentPane().add(getLblOtherProfileProject());
		frmProfile.getContentPane().add(getLblOtherTeammateReview());
		frmProfile.getContentPane().add(getScrollPane_TeammateReview());
		frmProfile.getContentPane().add(getLblOtherProfilePhone());
		frmProfile.getContentPane().add(getTfStudentPhone());
		frmProfile.getContentPane().add(getLblStudentTitle());
		frmProfile.getContentPane().add(getTfStudentDipCount());
		frmProfile.getContentPane().add(getLblSignal());
		frmProfile.getContentPane().add(getBtnClose());
		frmProfile.getContentPane().add(getLblPhoto());
		


	}
	private JLabel getLblOtherProfileId() {
		if (lblOtherProfileId == null) {
			lblOtherProfileId = new JLabel("ID :");
			lblOtherProfileId.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileId.setForeground(Color.GRAY);
			lblOtherProfileId.setBounds(144, 59, 61, 16);
		}
		return lblOtherProfileId;
	}
	private JLabel getLblOtherProfileName() {
		if (lblOtherProfileName == null) {
			lblOtherProfileName = new JLabel("Name :");
			lblOtherProfileName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileName.setForeground(Color.GRAY);
			lblOtherProfileName.setBounds(144, 87, 61, 16);
		}
		return lblOtherProfileName;
	}
	private JLabel getLblOtherProfileMbti() {
		if (lblOtherProfileMbti == null) {
			lblOtherProfileMbti = new JLabel("MBTI :");
			lblOtherProfileMbti.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileMbti.setForeground(Color.GRAY);
			lblOtherProfileMbti.setBounds(144, 115, 47, 16);
		}
		return lblOtherProfileMbti;
	}
	private JLabel getLblOtherProfileGithub() {
		if (lblOtherProfileGithub == null) {
			lblOtherProfileGithub = new JLabel("Github :");
			lblOtherProfileGithub.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileGithub.setForeground(Color.GRAY);
			lblOtherProfileGithub.setBounds(144, 143, 61, 16);
		}
		return lblOtherProfileGithub;
	}
	
	private JLabel getLblOtherProfileAddress() {
		if (lblOtherProfileAddress == null) {
			lblOtherProfileAddress = new JLabel("Address :");
			lblOtherProfileAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileAddress.setForeground(Color.GRAY);
			lblOtherProfileAddress.setBounds(144, 173, 61, 16);
		}
		return lblOtherProfileAddress;
	}
	private JTextField getTfStudentId() {
		if (tfStudentId == null) {
			tfStudentId = new JTextField();
			tfStudentId.setEditable(false);
			tfStudentId.setForeground(new Color(0, 102, 204));
			tfStudentId.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentId.setText(id);
			tfStudentId.setBounds(207, 59, 230, 21);
			tfStudentId.setColumns(10);
		}
		return tfStudentId;
	}
	private JTextField getTfStudentName() {
		if (tfStudentName == null) {
			tfStudentName = new JTextField();
			tfStudentName.setEditable(false);
			tfStudentName.setForeground(new Color(0, 102, 204));
			tfStudentName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentName.setColumns(10);
			tfStudentName.setText(name);
			tfStudentName.setBounds(207, 87, 230, 21);
		}
		return tfStudentName;
	}
	private JTextField getTfStudentAddress() {
		if (tfStudentAddress == null) {
			tfStudentAddress = new JTextField();
			tfStudentAddress.setEditable(false);
			tfStudentAddress.setForeground(new Color(0, 102, 204));
			tfStudentAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentAddress.setColumns(10);
			tfStudentAddress.setBounds(207, 171, 230, 21);
//			tfStudentAddress.setText(bean.getSubway());
		}
		return tfStudentAddress;
	}
	private JTextField getTfStudentMbti() {
		if (tfStudentMbti == null) {
			tfStudentMbti = new JTextField();
			tfStudentMbti.setEditable(false);
			tfStudentMbti.setForeground(new Color(0, 102, 204));
			tfStudentMbti.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentMbti.setColumns(10);
			tfStudentMbti.setBounds(207, 115, 230, 21);
//			tfStudentMbti.setText(bean.getMbti());
		}
		return tfStudentMbti;
	}
	private JTextField getTfStudentGithub() {
		if (tfStudentGithub == null) {
			tfStudentGithub = new JTextField();
			tfStudentGithub.setEditable(false);
			tfStudentGithub.setForeground(new Color(0, 102, 204));
			tfStudentGithub.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentGithub.setColumns(10);
			tfStudentGithub.setBounds(207, 143, 230, 21);
//			tfStudentGithub.setText(bean.getGithub_id());

		}
		return tfStudentGithub;
	}
	private JLabel getLblOtherProfileStrength() {
		if (lblOtherProfileStrength == null) {
			lblOtherProfileStrength = new JLabel("Strength :");
			lblOtherProfileStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileStrength.setForeground(Color.GRAY);
			lblOtherProfileStrength.setBounds(30, 235, 74, 15);
		}
		return lblOtherProfileStrength;
	}
	private JTextField getTextField_4() {
		if (tfStudentStrength == null) {
			tfStudentStrength = new JTextField();
			tfStudentStrength.setEditable(false);
			tfStudentStrength.setForeground(new Color(0, 102, 204));
			tfStudentStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentStrength.setBounds(120, 232, 317, 21);
			tfStudentStrength.setColumns(10);
//			tfStudentStrength.setText(bean.getStrength());

		}
		return tfStudentStrength;
	}
	private JLabel getLblOtherProfileIntroduce() {
		if (lblOtherProfileIntroduce == null) {
			lblOtherProfileIntroduce = new JLabel("한줄 자기소개 :");
			lblOtherProfileIntroduce.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileIntroduce.setForeground(Color.GRAY);
			lblOtherProfileIntroduce.setBounds(30, 262, 91, 15);
			
		}
		return lblOtherProfileIntroduce;
	}
	private JTextField getTextField_5() {
		if (tfStudentIntroduce == null) {
			tfStudentIntroduce = new JTextField();
			tfStudentIntroduce.setEditable(false);
			tfStudentIntroduce.setForeground(new Color(0, 102, 204));
			tfStudentIntroduce.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentIntroduce.setColumns(10);
			tfStudentIntroduce.setBounds(120, 257, 317, 21);
//			tfStudentIntroduce.setText(bean.getIntroduce());

		}
		return tfStudentIntroduce;
	}
	private JScrollPane getScrollPane_Project() {
		if (scrollPane_Project == null) {
			scrollPane_Project = new JScrollPane();
			scrollPane_Project.setBounds(36, 352, 401, 74);
			scrollPane_Project.setViewportView(getProjectTable());
		}
		return scrollPane_Project;
	}
	private JTable getProjectTable() {
		if (ProjectTable == null) {
			ProjectTable = new JTable();
			ProjectTable.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			ProjectTable.setForeground(new Color(0, 102, 204));
			ProjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ProjectTable.setModel(Outer_Table_ProjectTable); // <--***************************************************
			ProjectTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			ProjectTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
			
		}
		return ProjectTable;
	}
	private JLabel getLblOtherProfileProject() {
		if (lblOtherProfileProject == null) {
			lblOtherProfileProject = new JLabel("Project");
			lblOtherProfileProject.setForeground(Color.GRAY);
			lblOtherProfileProject.setFont(new Font("Dialog", Font.BOLD, 13));
			lblOtherProfileProject.setBounds(36, 330, 67, 21);
		}
		return lblOtherProfileProject;
	}
	private JLabel getLblOtherTeammateReview() {
		if (lblOtherTeammateReview == null) {
			lblOtherTeammateReview = new JLabel("Teammate Review");
			lblOtherTeammateReview.setForeground(Color.GRAY);
			lblOtherTeammateReview.setFont(new Font("Dialog", Font.BOLD, 13));
			lblOtherTeammateReview.setBounds(36, 438, 170, 21);
		}
		return lblOtherTeammateReview;
	}
	private JScrollPane getScrollPane_TeammateReview() {
		if (scrollPane_TeammateReview == null) {
			scrollPane_TeammateReview = new JScrollPane();
			scrollPane_TeammateReview.setBounds(36, 458, 401, 93);
			scrollPane_TeammateReview.setViewportView(getTeammateReviewTable());
		}
		return scrollPane_TeammateReview;
	}
	
	private JTable getTeammateReviewTable() {
		if (TeammateReviewTable == null) {
			TeammateReviewTable = new JTable();
			TeammateReviewTable.setForeground(new Color(0, 102, 204));
			TeammateReviewTable.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			TeammateReviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TeammateReviewTable.setModel(Outer_Table_TeammateReviewTable); // <--***************************************************
			TeammateReviewTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TeammateReviewTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TeammateReviewTable;
	}
	private JLabel getLblOtherProfilePhone() {
		if (lblOtherProfilePhone == null) {
			lblOtherProfilePhone = new JLabel("Phone :");
			lblOtherProfilePhone.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfilePhone.setForeground(Color.GRAY);
			lblOtherProfilePhone.setBounds(30, 209, 61, 16);
			
		}
		return lblOtherProfilePhone;
	}
	private JTextField getTfStudentPhone() {
		if (tfStudentPhone == null) {
			tfStudentPhone = new JTextField();
			tfStudentPhone.setEditable(false);
			tfStudentPhone.setForeground(new Color(0, 102, 204));
			tfStudentPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentPhone.setColumns(10);
			tfStudentPhone.setBounds(120, 207, 317, 21);
//			tfStudentPhone.setText(bean.getPhone());
		}
		return tfStudentPhone;
	}
	private JLabel getLblStudentTitle() {
		if (lblStudentTitle == null) {
			lblStudentTitle = new JLabel();
			lblStudentTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblStudentTitle.setForeground(Color.GRAY);
			lblStudentTitle.setText(name + "'s Profile");
			lblStudentTitle.setBounds(30, 17, 401, 30);
		}
		return lblStudentTitle;
	}
	private JTextField getTfStudentDipCount() {
		if (tfStudentDipCount == null) {
			tfStudentDipCount = new JTextField();
			tfStudentDipCount.setEditable(false);
			tfStudentDipCount.setForeground(new Color(0, 102, 204));
			tfStudentDipCount.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentDipCount.setText(dipCount);
			tfStudentDipCount.setColumns(10);
			tfStudentDipCount.setBounds(120, 286, 317, 21);
		}
		return tfStudentDipCount;
	}
	private JLabel getLblSignal() {
		if (lblSignal == null) {
			lblSignal = new JLabel("Signal Count :");
			lblSignal.setForeground(Color.GRAY);
			lblSignal.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblSignal.setBounds(30, 291, 91, 15);
		}
		return lblSignal;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmProfile.dispose();
				}
			});
			btnClose.setForeground(new Color(0, 102, 204));
			btnClose.setBackground(Color.WHITE);
			btnClose.setBounds(400, 6, 70, 29);
		}
		return btnClose;
	}
	
	//----------------------
	// 21.04.28 hyokyeong
	//----------------------
	
	// click 한 id의 data 보여주기
	//photo, mbti, github_id, subway, phone, strength, introduce
	private void setText() {
		
		DbAction2 dbAction = new DbAction2(tfStudentId.getText());
		Bean bean = dbAction.TableClick();
		
//		lblPhoto.setIcon(bean.getPhoto());
		tfStudentMbti.setText(bean.getMbti());
		tfStudentGithub.setText(bean.getGithub_id());
		tfStudentAddress.setText(bean.getSubway());
		tfStudentPhone.setText(bean.getPhone());
		tfStudentStrength.setText(bean.getStrength());
		tfStudentIntroduce.setText(bean.getIntroduce());
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("");
			lblPhoto.setIcon(null);
			lblPhoto.setBounds(30, 59, 102, 136);
		}
		return lblPhoto;
	}
} // End Line