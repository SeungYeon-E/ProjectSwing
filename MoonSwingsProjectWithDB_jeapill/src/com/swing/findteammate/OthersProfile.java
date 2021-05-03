package com.swing.findteammate;


import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.checkprofile.CheckProfileBean;
import com.swing.checkprofile.CheckProfileDBAction;
import com.swing.login.Login;
import com.swing.mainpage.MainPage;

import javax.swing.ImageIcon;
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
import java.util.ArrayList;

public class OthersProfile {

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
	private JButton btnPTWMOtherProfile;
	private JTable TeammateReviewTable;
	private JLabel lblOtherProfilePhone;
	private JTextField tfStudentPhone;
	private JButton btnClose;
	private JLabel lblStudentProfile;
	private JLabel lblPhoto;
	private String id;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void run(String id, String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OthersProfile window = new OthersProfile(id, name);
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
	public OthersProfile(String id, String name) {
		this.id = id;
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfile = new JFrame();
		frmProfile.getContentPane().setBackground(Color.WHITE);
		frmProfile.setBounds(100, 100, 500, 600);
		frmProfile.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				showStudentProject();
				showTeammateReview();
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
		frmProfile.getContentPane().add(getBtnPTWMOtherProfile());
		frmProfile.getContentPane().add(getLblOtherProfilePhone());
		frmProfile.getContentPane().add(getTfStudentPhone());
		frmProfile.getContentPane().add(getBtnClose());
		frmProfile.getContentPane().add(getLblStudentProfile());
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
			tfStudentId.setBounds(207, 59, 230, 21);
			tfStudentId.setColumns(10);
			tfStudentId.setText(id);
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
			tfStudentName.setBounds(207, 87, 230, 21);
			tfStudentName.setText(name);
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
		}
		return tfStudentGithub;
	}
	private JLabel getLblOtherProfileStrength() {
		if (lblOtherProfileStrength == null) {
			lblOtherProfileStrength = new JLabel("Strength :");
			lblOtherProfileStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileStrength.setForeground(Color.GRAY);
			lblOtherProfileStrength.setBounds(36, 226, 74, 15);
		}
		return lblOtherProfileStrength;
	}
	private JTextField getTextField_4() {
		if (tfStudentStrength == null) {
			tfStudentStrength = new JTextField();
			tfStudentStrength.setEditable(false);
			tfStudentStrength.setForeground(new Color(0, 102, 204));
			tfStudentStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			tfStudentStrength.setBounds(126, 223, 311, 21);
			tfStudentStrength.setColumns(10);
		}
		return tfStudentStrength;
	}
	private JLabel getLblOtherProfileIntroduce() {
		if (lblOtherProfileIntroduce == null) {
			lblOtherProfileIntroduce = new JLabel("한줄 자기소개 :");
			lblOtherProfileIntroduce.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblOtherProfileIntroduce.setForeground(Color.GRAY);
			lblOtherProfileIntroduce.setBounds(36, 253, 91, 15);
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
			tfStudentIntroduce.setBounds(126, 248, 311, 21);
		}
		return tfStudentIntroduce;
	}
	private JScrollPane getScrollPane_Project() {
		if (scrollPane_Project == null) {
			scrollPane_Project = new JScrollPane();
			scrollPane_Project.setBounds(36, 303, 401, 74);
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
			lblOtherProfileProject.setBounds(36, 281, 67, 21);
		}
		return lblOtherProfileProject;
	}
	private JLabel getLblOtherTeammateReview() {
		if (lblOtherTeammateReview == null) {
			lblOtherTeammateReview = new JLabel("Teammate Review");
			lblOtherTeammateReview.setForeground(Color.GRAY);
			lblOtherTeammateReview.setFont(new Font("Dialog", Font.BOLD, 13));
			lblOtherTeammateReview.setBounds(36, 389, 170, 21);
		}
		return lblOtherTeammateReview;
	}
	private JScrollPane getScrollPane_TeammateReview() {
		if (scrollPane_TeammateReview == null) {
			scrollPane_TeammateReview = new JScrollPane();
			scrollPane_TeammateReview.setBounds(36, 409, 401, 93);
			scrollPane_TeammateReview.setViewportView(getTeammateReviewTable());
		}
		return scrollPane_TeammateReview;
	}
	private JButton getBtnPTWMOtherProfile() {
		if (btnPTWMOtherProfile == null) {
			btnPTWMOtherProfile = new JButton("Please Team with Me!");
			btnPTWMOtherProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkDipAction();
					
				}
			});
			btnPTWMOtherProfile.setBackground(new Color(0, 102, 204));
			btnPTWMOtherProfile.setForeground(Color.WHITE);
			btnPTWMOtherProfile.setOpaque(true);
			btnPTWMOtherProfile.setBorderPainted(false);
			btnPTWMOtherProfile.setBounds(36, 514, 190, 33);
		}
		return btnPTWMOtherProfile;
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
			lblOtherProfilePhone.setBounds(36, 200, 61, 16);
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
			tfStudentPhone.setBounds(126, 198, 311, 21);
		}
		return tfStudentPhone;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmProfile.dispose();
				}
			});
			btnClose.setOpaque(true);
			btnClose.setForeground(new Color(0, 102, 204));
			btnClose.setBackground(Color.WHITE);
			btnClose.setBounds(247, 514, 190, 33);
		}
		return btnClose;
	}
	private JLabel getLblStudentProfile() {
		if (lblStudentProfile == null) {
			lblStudentProfile = new JLabel();
			lblStudentProfile.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblStudentProfile.setForeground(Color.GRAY);
			lblStudentProfile.setBounds(30, 17, 401, 30);
			lblStudentProfile.setText(name + "'s Profile");
		}
		return lblStudentProfile;
	}
	private JLabel getLblPhoto() {
		if (lblPhoto == null) {
			lblPhoto = new JLabel("");
			lblPhoto.setIcon(null);
			lblPhoto.setBounds(30, 59, 102, 136);
		}
		return lblPhoto;
	}
	
// Student Profile Project and teammate review table
	public void studentProjectTable(){
	    int i = Outer_Table_ProjectTable.getRowCount();
	    Outer_Table_ProjectTable.addColumn("Project Name");
	    Outer_Table_ProjectTable.addColumn("TeamName");
	    Outer_Table_ProjectTable.addColumn("결과물-Git Address");
	    Outer_Table_ProjectTable.setColumnCount(3);
	    for(int j = 0 ; j < i ; j++){
	    	Outer_Table_ProjectTable.removeRow(0);
	    }
	    ProjectTable.setAutoResizeMode(ProjectTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    int width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = ProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);
	}
	@SuppressWarnings("static-access")
	public void studentReviewTable(){
	    int i = Outer_Table_TeammateReviewTable.getRowCount();
	    Outer_Table_TeammateReviewTable.addColumn("Project Name");
	    Outer_Table_TeammateReviewTable.addColumn("Teammate Name");
	    Outer_Table_TeammateReviewTable.addColumn("Review");
	    Outer_Table_TeammateReviewTable.setColumnCount(3);
	    for(int j = 0 ; j < i ; j++){
	    	Outer_Table_TeammateReviewTable.removeRow(0);
	    }
	    TeammateReviewTable.setAutoResizeMode(TeammateReviewTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    int width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 1;
	    col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = TeammateReviewTable.getColumnModel().getColumn(vColIndex);
	    width = 200;
	    col.setPreferredWidth(width);

	}// Student Profile Project and teammate review table end
	
	
	
	
	//----------------------
	// 21.04.28 hyokyeong
	//----------------------
	
	// click 한 id의 data 보여주기
	//photo, mbti, github_id, subway, phone, strength, introduce
	private void setText() {
		
		DbAction2 dbAction = new DbAction2(tfStudentId.getText());
		Bean bean = dbAction.TableClick();
		
		
//		lblPhoto.setIcon(bean.getPhoto());
		Image image = bean.photo.getScaledInstance(lblPhoto.getWidth()+17, lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(image));
		tfStudentMbti.setText(bean.getMbti());
		tfStudentGithub.setText(bean.getGithub_id());
		tfStudentAddress.setText(bean.getSubway());
		tfStudentPhone.setText(bean.getPhone());
		tfStudentStrength.setText(bean.getStrength());
		tfStudentIntroduce.setText(bean.getIntroduce());
		
	} // setText end
	
	
	//----------------------
	// 21.04.29 hyokyeong - pick (dip)
	//----------------------
	
	/*
	 * btnPTWMOtherProfile click 시 action insert into Dip
	 */
	private void pleaseTeamWithMe() {
//		MainPage mp = new MainPage();
//		String loginedId = mp.lblId();
		DbAction2 dbAction = new DbAction2(Login.tfLoginUserId.getText(), id); // testLogin id change to Login Id***
		
		boolean msg = dbAction.insertDip();
		
		if(msg == true) {
			JOptionPane.showMessageDialog(null, tfStudentName.getText()+ "님이 My Pick에 등록되었습니다.");
			frmProfile.dispose();
			
		}else {
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
					"Critical Error!", 
					JOptionPane.ERROR_MESSAGE);                    
		}
	}
	
//	/*
//	 * Dip 현황 체크, 이미 pick한 학생 중복 pick 불가
//	 */
	private void checkDipAction() {
		
		
		String loginedId = Login.tfLoginUserId.getText();		
		DbAction2 dbAction = new DbAction2();
		ArrayList<Bean> beanDipList = dbAction.checkDipList();
		
		int listCount = beanDipList.size();
		
		String wkSender = "";
		String wkTarget = "";
		
		for(int j = 0; j < listCount; j++) {
			wkSender = beanDipList.get(j).getSender();
			wkTarget = beanDipList.get(j).getTarget();
			
			if(loginedId.equals(wkSender) && id.equals(wkTarget)) {
				JOptionPane.showMessageDialog(null, "이미 Pick한 사람입니다.");
				return;
			}
			
		}
		pleaseTeamWithMe();
		
		
	}
	
	// Student Project Tabel 보여주기
	public void showStudentProject(){
		studentProjectTable();
        
		DbAction2 dbAction  = new DbAction2(id);
		ArrayList<Bean> projectList = dbAction.selectStudentProjectList();
		
		int listCount = projectList.size();
		
		for(int i =0 ; i < listCount;i++) {
			
			String teamName = Integer.toString(projectList.get(i).getTeamName());
			
			String[] qTxt = {projectList.get(i).getProjectName(), 
							teamName , 
							projectList.get(i).getTeamGitAddress()};
			
			Outer_Table_ProjectTable.addRow(qTxt);
			
		}

	}
	// Project Teammate들의 review 보여주기
	public void showTeammateReview(){
		studentReviewTable();
		DbAction2 dbAction = new DbAction2(id);
		
		ArrayList<Bean> teamReviewList = dbAction.selectStudentReviewList();
		
		int listCount = teamReviewList.size();
		
		for( int i =0 ; i < listCount;i++) {
			
			String[] qTxt = {teamReviewList.get(i).getProjectName(),
							teamReviewList.get(i).getSender(), 
							teamReviewList.get(i).getComment()};

			Outer_Table_TeammateReviewTable.addRow(qTxt);

		}
	}
	
	
} // End Line