package com.swing.teamstatus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.swing.login.Login;
import com.swing.mainpage.MainPage;
import com.swing.teamstatus.TeamStatusBean;
import com.swing.teamstatus.TeamStatusDBAction;

public class TeamStatus extends JPanel {
	
	public TeamStatus() {
	}

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
	
	TeamStatusDBAction tsdbAction = new TeamStatusDBAction(Login.tfLoginUserId.getText());
	
	//팀원이름을 불러올 텍스트필드 집합
	ArrayList<JTextField[]> tfbeanList = new ArrayList<JTextField[]>();
	
	//라디오버튼 집합(처음에 이름불러오고 내가 속한 팀에 라디오버튼이 클릭되어 있도록하기위해)
	ArrayList<JRadioButton> rdbs = new ArrayList<JRadioButton>();
	
	//그 라디오버튼 번호를 저장하기 위한 객체
	int myteamcount = 888;
	
	//들어갈 팀의 번호를 저장하기 위한 객체
	int selectedrdb = 999;
	
	
	/**
	 * Create the panel.
	 */
	
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
					
				}
			return panelTeamStatus;
		}
	
	private JRadioButton getRbTeam1() {
		if (rbTeam1 == null) {
			rbTeam1 = new JRadioButton("Team 1");
			buttonGroup.add(rbTeam1);
			rbTeam1.setForeground(Color.GRAY);
			rbTeam1.setBounds(20, 29, 107, 23);
			
			rbTeam1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 1;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
				}
			});
			
		}
		rdbs.add(rbTeam1);
		return rbTeam1;
	}
	private JRadioButton getRbTeam2() {
		if (rbTeam2 == null) {
			rbTeam2 = new JRadioButton("Team 2");
			buttonGroup.add(rbTeam2);
			rbTeam2.setForeground(Color.GRAY);
			rbTeam2.setBounds(20, 93, 107, 23);
			
			rbTeam2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 2;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam2);
		return rbTeam2;
	}
	
	private JRadioButton getRbTeam3() {
		if (rbTeam3 == null) {
			rbTeam3 = new JRadioButton("Team 3");
			buttonGroup.add(rbTeam3);
			rbTeam3.setForeground(Color.GRAY);
			rbTeam3.setBounds(20, 156, 107, 23);
			
			rbTeam3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 3;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam3);
		return rbTeam3;
	}
	private JRadioButton getRbTeam4() {
		if (rbTeam4 == null) {
			rbTeam4 = new JRadioButton("Team 4");
			buttonGroup.add(rbTeam4);
			rbTeam4.setForeground(Color.GRAY);
			rbTeam4.setBounds(20, 219, 107, 23);
			
			rbTeam4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 4;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam4);
		return rbTeam4;
	}
	private JRadioButton getRbTeam5() {
		if (rbTeam5 == null) {
			rbTeam5 = new JRadioButton("Team 5");
			buttonGroup.add(rbTeam5);
			rbTeam5.setForeground(Color.GRAY);
			rbTeam5.setBounds(20, 282, 107, 23);
			
			rbTeam5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 5;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
				}
			});
		}
		rdbs.add(rbTeam5);
		return rbTeam5;
	}
	private JRadioButton getRbTeam6() {
		if (rbTeam6 == null) {
			rbTeam6 = new JRadioButton("Team 6");
			buttonGroup.add(rbTeam6);
			rbTeam6.setForeground(Color.GRAY);
			rbTeam6.setBounds(20, 352, 107, 23);
			
			rbTeam6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedrdb = 6;
					checkFull(selectedrdb);
					checkMyname(selectedrdb);
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
			tfmate1_1.setForeground(new Color(0, 102, 204));
			tfmate1_1.setColumns(10);
			tfmate1_1.setBounds(20, 51, 110, 30);
			tfmate1_1.setEditable(false);
		}
		return tfmate1_1;
	}
	private JTextField gettfmate1_2() {
		if (tfmate1_2 == null) {
			tfmate1_2 = new JTextField();
			tfmate1_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_2.setForeground(new Color(0, 102, 204));
			tfmate1_2.setColumns(10);
			tfmate1_2.setBounds(130, 51, 110, 30);
			tfmate1_2.setEditable(false);
		}
		return tfmate1_2;
	}
	private JTextField gettfmate1_3() {
		if (tfmate1_3 == null) {
			tfmate1_3 = new JTextField();
			tfmate1_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_3.setForeground(new Color(0, 102, 204));
			tfmate1_3.setColumns(10);
			tfmate1_3.setBounds(240, 51, 110, 30);
			tfmate1_3.setEditable(false);
		}
		return tfmate1_3;
	}
	private JTextField gettfmate1_4() {
		if (tfmate1_4 == null) {
			tfmate1_4 = new JTextField();
			tfmate1_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate1_4.setForeground(new Color(0, 102, 204));
			tfmate1_4.setColumns(10);
			tfmate1_4.setBounds(350, 51, 110, 30);
			tfmate1_4.setEditable(false);
		}
		return tfmate1_4;
	}
	private JTextField gettfmate2_1() {
		if (tfmate2_1 == null) {
			tfmate2_1 = new JTextField();
			tfmate2_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_1.setForeground(new Color(0, 102, 204));
			tfmate2_1.setColumns(10);
			tfmate2_1.setBounds(20, 118, 110, 30);
			tfmate2_1.setEditable(false);
		}
		return tfmate2_1;
	}
	private JTextField getTfmate2_2() {
		if (tfmate2_2 == null) {
			tfmate2_2 = new JTextField();
			tfmate2_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_2.setForeground(new Color(0, 102, 204));
			tfmate2_2.setColumns(10);
			tfmate2_2.setBounds(130, 118, 110, 30);
			tfmate2_2.setEditable(false);
		}
		return tfmate2_2;
	}
	private JTextField getTfmate2_3() {
		if (tfmate2_3 == null) {
			tfmate2_3 = new JTextField();
			tfmate2_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_3.setForeground(new Color(0, 102, 204));
			tfmate2_3.setColumns(10);
			tfmate2_3.setBounds(240, 118, 110, 30);
			tfmate2_3.setEditable(false);
		}
		return tfmate2_3;
	}
	private JTextField getTfmate2_4() {
		if (tfmate2_4 == null) {
			tfmate2_4 = new JTextField();
			tfmate2_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate2_4.setForeground(new Color(0, 102, 204));
			tfmate2_4.setColumns(10);
			tfmate2_4.setBounds(350, 118, 110, 30);
			tfmate2_4.setEditable(false);
		}
		return tfmate2_4;
	}
	

	private JTextField gettfmate3_1() {
		if (tfmate3_1 == null) {
			tfmate3_1 = new JTextField();
			tfmate3_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_1.setForeground(new Color(0, 102, 204));
			tfmate3_1.setColumns(10);
			tfmate3_1.setBounds(20, 177, 110, 30);
			tfmate3_1.setEditable(false);
		}
		return tfmate3_1;
	}
	private JTextField gettfmate3_2() {
		if (tfmate3_2 == null) {
			tfmate3_2 = new JTextField();
			tfmate3_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_2.setForeground(new Color(0, 102, 204));
			tfmate3_2.setColumns(10);
			tfmate3_2.setBounds(130, 177, 110, 30);
			tfmate3_2.setEditable(false);
		}
		return tfmate3_2;
	}
	private JTextField gettfmate3_3() {
		if (tfmate3_3 == null) {
			tfmate3_3 = new JTextField();
			tfmate3_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_3.setForeground(new Color(0, 102, 204));
			tfmate3_3.setColumns(10);
			tfmate3_3.setBounds(240, 177, 110, 30);
			tfmate3_3.setEditable(false);
		}
		return tfmate3_3;
	}
	private JTextField gettfmate3_4() {
		if (tfmate3_4 == null) {
			tfmate3_4 = new JTextField();
			tfmate3_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate3_4.setForeground(new Color(0, 102, 204));
			tfmate3_4.setColumns(10);
			tfmate3_4.setBounds(350, 177, 110, 30);
			tfmate3_4.setEditable(false);
		}
		return tfmate3_4;
	}
	private JTextField gettfmate4_1() {
		if (tfmate4_1 == null) {
			tfmate4_1 = new JTextField();
			tfmate4_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_1.setForeground(new Color(0, 102, 204));
			tfmate4_1.setColumns(10);
			tfmate4_1.setBounds(20, 240, 110, 30);
			tfmate4_1.setEditable(false);
		}
		return tfmate4_1;
	}
	private JTextField gettfmate4_2() {
		if (tfmate4_2 == null) {
			tfmate4_2 = new JTextField();
			tfmate4_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_2.setForeground(new Color(0, 102, 204));
			tfmate4_2.setColumns(10);
			tfmate4_2.setBounds(130, 240, 110, 30);
			tfmate4_2.setEditable(false);
		}
		return tfmate4_2;
	}
	private JTextField gettfmate4_3() {
		if (tfmate4_3 == null) {
			tfmate4_3 = new JTextField();
			tfmate4_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_3.setForeground(new Color(0, 102, 204));
			tfmate4_3.setColumns(10);
			tfmate4_3.setBounds(240, 240, 110, 30);
			tfmate4_3.setEditable(false);
		}
		return tfmate4_3;
	}
	private JTextField gettfmate4_4() {
		if (tfmate4_4 == null) {
			tfmate4_4 = new JTextField();
			tfmate4_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate4_4.setForeground(new Color(0, 102, 204));
			tfmate4_4.setColumns(10);
			tfmate4_4.setBounds(350, 240, 110, 30);
			tfmate4_4.setEditable(false);
		}
		return tfmate4_4;
	}
	private JTextField gettfmate5_1() {
		if (tfmate5_1 == null) {
			tfmate5_1 = new JTextField();
			tfmate5_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_1.setForeground(new Color(0, 102, 204));
			tfmate5_1.setColumns(10);
			tfmate5_1.setBounds(20, 310, 110, 30);
			tfmate5_1.setEditable(false);
		}
		return tfmate5_1;
	}
	private JTextField gettfmate5_2() {
		if (tfmate5_2 == null) {
			tfmate5_2 = new JTextField();
			tfmate5_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_2.setForeground(new Color(0, 102, 204));
			tfmate5_2.setColumns(10);
			tfmate5_2.setBounds(130, 310, 110, 30);
			tfmate5_2.setEditable(false);
		}
		return tfmate5_2;
	}
	private JTextField gettfmate5_3() {
		if (tfmate5_3 == null) {
			tfmate5_3 = new JTextField();
			tfmate5_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_3.setForeground(new Color(0, 102, 204));
			tfmate5_3.setColumns(10);
			tfmate5_3.setBounds(240, 310, 110, 30);
			tfmate5_3.setEditable(false);
		}
		return tfmate5_3;
	}
	private JTextField gettfmate5_4() {
		if (tfmate5_4 == null) {
			tfmate5_4 = new JTextField();
			tfmate5_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate5_4.setForeground(new Color(0, 102, 204));
			tfmate5_4.setColumns(10);
			tfmate5_4.setBounds(350, 310, 110, 30);
			tfmate5_4.setEditable(false);
		}
		return tfmate5_4;
	}

	private JTextField getTfmate6_1() {
		if (tfmate6_1 == null) {
			tfmate6_1 = new JTextField();
			tfmate6_1.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_1.setForeground(new Color(0, 102, 204));
			tfmate6_1.setColumns(10);
			tfmate6_1.setBounds(20, 377, 110, 30);
			tfmate6_1.setEditable(false);
		}
		return tfmate6_1;
	}
	private JTextField getTfmate6_2() {
		if (tfmate6_2 == null) {
			tfmate6_2 = new JTextField();
			tfmate6_2.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_2.setForeground(new Color(0, 102, 204));
			tfmate6_2.setColumns(10);
			tfmate6_2.setBounds(130, 377, 110, 30);
			tfmate6_2.setEditable(false);
		}
		return tfmate6_2;
	}
	private JTextField getTfmate6_3() {
		if (tfmate6_3 == null) {
			tfmate6_3 = new JTextField();
			tfmate6_3.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_3.setForeground(new Color(0, 102, 204));
			tfmate6_3.setColumns(10);
			tfmate6_3.setBounds(240, 377, 110, 30);
			tfmate6_3.setEditable(false);
		}
		return tfmate6_3;
	}
	private JTextField getTfmate6_4() {
		if (tfmate6_4 == null) {
			tfmate6_4 = new JTextField();
			tfmate6_4.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_4.setForeground(new Color(0, 102, 204));
			tfmate6_4.setColumns(10);
			tfmate6_4.setBounds(350, 377, 110, 30);
			tfmate6_4.setEditable(false);
		}
		return tfmate6_4;
	}
	private JTextField gettfmate6_5() {
		if (tfmate6_5 == null) {
			tfmate6_5 = new JTextField();
			tfmate6_5.setHorizontalAlignment(SwingConstants.CENTER);
			tfmate6_5.setForeground(new Color(0, 102, 204));
			tfmate6_5.setColumns(10);
			tfmate6_5.setBounds(20, 406, 110, 30);
			tfmate6_5.setEditable(false);
		}
		return tfmate6_5;
	}
	private JButton getBtnInTeamStatus() {
		if (btnInTeamStatus == null) {
			btnInTeamStatus = new JButton("IN");
			btnInTeamStatus.setBackground(Color.WHITE);
			btnInTeamStatus.setForeground(new Color(0, 102, 204));
			btnInTeamStatus.setBounds(70, 455, 150, 35);
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
			btnOutTeamStatus.setBackground(Color.WHITE);
			btnOutTeamStatus.setForeground(new Color(0, 102, 204));
			btnOutTeamStatus.setBounds(270, 455, 150, 35);
			btnOutTeamStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clickOutAction();
				}
			});
		}
		return btnOutTeamStatus;
	}
	// 텍스트 필드 집합에 저장하고 쿼리로 빈을 채움
	public void showTeammateStatusAction(){
		
		btnInTeamStatus.setEnabled(false);
		btnOutTeamStatus.setEnabled(false);
		
		//정리해주고 채워주기 위함
		for(JTextField[] tfarrays : tfbeanList) {
			clearTeamColumn(tfarrays);
		}
		
		ArrayList<TeamStatusBean> beanList =  tsdbAction.ShowTeammateStatus();
		
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
	
	//빈칸이면 출력해주고 내이름이 있다면 버튼 조작, 내가 속한 팀에 버튼의 번호를 보내주기위함
	public void insertstudentname(JTextField[] tfs, String name, int rdbcount) {
		
		for(int i=0;i<tfs.length;i++) {
			if(tfs[i].getText().equals("")) {
				tfs[i].setText(name);
				if(name.equals(tsdbAction.getIdInTeamStatus())) {
					rdbs.get(rdbcount).setSelected(true);
					btnInTeamStatus.setVisible(false);
					btnOutTeamStatus.setEnabled(true);
					myteamcount = rdbcount;
				}
				return;
			}
		}

	}
	
	//그팀에 텍스트필드가 빈자리가 없다면 in버튼 비활성화
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
	
	//그 필드에 내 이름있는지 확인하고 out버튼 활성화
	public void checkMyname(int num) {
		
		JTextField[] tfs =  tfbeanList.get(num-1);
		for(int i=0;i<tfs.length;i++) {
			
			if(tfs[i].getText().equals(tsdbAction.getIdInTeamStatus())) {
				btnInTeamStatus.setEnabled(false);
				btnOutTeamStatus.setEnabled(true);
				return;
			}
		}
		btnOutTeamStatus.setEnabled(false);
	}
	
	//out버튼 클릭 delete 쿼리 호출
	public void clickOutAction() {
		JTextField[] tfs = tfbeanList.get(myteamcount);
		for(int i=0;i<tfs.length;i++) {
			
			if(tfs[i].getText().equals(tsdbAction.getIdInTeamStatus())) {
				tsdbAction.teamStatusOutAction();
				showTeammateStatusAction();
				btnInTeamStatus.setVisible(true);
				btnInTeamStatus.setEnabled(false);
				
			}
		}
	}
	
	//in 버튼 클릭시 insert쿼리 호출
	public void clickInAction() {
		JTextField[] tfs = tfbeanList.get(selectedrdb-1);
		for(int i=0;i<tfs.length;i++) {
			if(tfs[i].getText().equals("")) {
				tsdbAction.teamStatusInAction(selectedrdb);
				showTeammateStatusAction();
				btnInTeamStatus.setVisible(false);
				return;
			}
		}
	}
	
	//텍스트필드 지워주기 위한 친구
	private void clearTeamColumn(JTextField[] tfs) {
		for(JTextField tf : tfs) {
			tf.setText("");
		}
	} 
	
}
