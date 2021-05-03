/* //TeammateReview//
 * 
 * projectTableSetItem()으로 테이블 데이터 불러오기 부착
 * [1.0] 2021-04-29 윤재필
 * 
 */

package com.swing.teammatereview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TeammateReview extends JPanel {
	
	private String loginedId;
	private JPanel panelTeamReview;
	private JScrollPane scrollPane_Project_1;
	private JLabel lblTeamReviewProject;
	private JLabel lblTeamReviewTeammateReview;
	private JScrollPane scrollPane_TeammateReview_1;
	private JTable TRProjectTable;
	private final DefaultTableModel Outer_Table_ProjectTable = new DefaultTableModel();
	private JButton btnInsert;
	private JPanel initPanel;
	private JLabel lblNewLabel;
	private JTextField tfProjectGithubAddress;
	

	
	
	public void initialiser() {
		scrollPane_TeammateReview_1.setViewportView(initPanel);
		
		teammateReviewTableProject();
		projectTableSetItem();
		btnInsert.setVisible(false);
		tfProjectGithubAddress.setVisible(false);
	}
	

	public TeammateReview(String loginedId) {
		this.loginedId = loginedId;
		
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(300, 45, 490, 497);

		add(getLblTeamReviewProject());
		add(getLblTeamReviewTeammateReview());
		
		add(getScrollPane_Project_1());
		add(getScrollPane_TeammateReview_1());
		add(getBtnInsert());
		add(getTfProjectGithubAddress());
		
	}
	
	public JPanel getTeamReview() {
		if (panelTeamReview == null) {
			panelTeamReview = new JPanel();
			panelTeamReview.setBackground(Color.WHITE);
			panelTeamReview.setBounds(300, 45, 490, 497);
			panelTeamReview.setLayout(null);
			
			panelTeamReview.add(getScrollPane_Project_1());
			panelTeamReview.add(getScrollPane_TeammateReview_1());
			
			panelTeamReview.add(getLblTeamReviewProject());
			panelTeamReview.add(getLblTeamReviewTeammateReview());
			
			panelTeamReview.add(getBtnInsert());
			

		}
		return panelTeamReview;
	}
	private JScrollPane getScrollPane_Project_1() {
		if (scrollPane_Project_1 == null) {
			scrollPane_Project_1 = new JScrollPane();
			scrollPane_Project_1.setBounds(33, 53, 415, 124);
			scrollPane_Project_1.setViewportView(getTRProjectTable());
		}
		return scrollPane_Project_1;
	}
	private JLabel getLblTeamReviewProject() {
		if (lblTeamReviewProject == null) {
			lblTeamReviewProject = new JLabel("Project");
			lblTeamReviewProject.setForeground(Color.GRAY);
			lblTeamReviewProject.setFont(new Font("굴림", Font.BOLD, 18));
			lblTeamReviewProject.setBounds(33, 20, 67, 21);
		}
		return lblTeamReviewProject;
	}
	private JLabel getLblTeamReviewTeammateReview() {
		if (lblTeamReviewTeammateReview == null) {
			lblTeamReviewTeammateReview = new JLabel("Teammate Review");
			lblTeamReviewTeammateReview.setForeground(Color.GRAY);
			lblTeamReviewTeammateReview.setFont(new Font("굴림", Font.BOLD, 18));
			lblTeamReviewTeammateReview.setBounds(33, 232, 170, 21);
		}
		return lblTeamReviewTeammateReview;
	}
	private JScrollPane getScrollPane_TeammateReview_1() {
		if (scrollPane_TeammateReview_1 == null) {
			scrollPane_TeammateReview_1 = new JScrollPane();
			scrollPane_TeammateReview_1.setBounds(33, 265, 415, 180);
			scrollPane_TeammateReview_1.setViewportView(getInitPanel());
		}
		return scrollPane_TeammateReview_1;
	}
	private JTable getTRProjectTable() {
		if (TRProjectTable == null) {
			TRProjectTable = new JTable();
			TRProjectTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClicked();
				}
			});
			TRProjectTable.setForeground(new Color(0, 102, 204));
			TRProjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			TRProjectTable.setModel(Outer_Table_ProjectTable); // <--***************************************************
			TRProjectTable.getTableHeader().setReorderingAllowed(false);  // 컬럼들 이동 불가
			TRProjectTable.getTableHeader().setResizingAllowed(false);  // 컬럼 크기 조절 불가
		}
		return TRProjectTable;
	}
	
	private JPanel getInitPanel() {
		if (initPanel == null) {
			initPanel = new JPanel();
			initPanel.setBackground(Color.WHITE);
			initPanel.setLayout(null);
			initPanel.add(getLblNewLabel());
		}
		return initPanel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("팀을 선택해 주세요.");
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(87, 49, 229, 75);
		}
		return lblNewLabel;
	}

	
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("Update");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					projectInsert();
				}
			});
			btnInsert.setBackground(Color.WHITE);
			btnInsert.setForeground(new Color(0, 102, 153));
			btnInsert.setBounds(371, 181, 79, 29);
			btnInsert.setVisible(false);
		}
		return btnInsert;
	}
	
	private JTextField getTfProjectGithubAddress() {
		if (tfProjectGithubAddress == null) {
			tfProjectGithubAddress = new JTextField();
			tfProjectGithubAddress.setBounds(33, 181, 336, 26);
			tfProjectGithubAddress.setColumns(10);
			tfProjectGithubAddress.setVisible(false);
		}
		return tfProjectGithubAddress;
	}
	
	public void teammateReviewTableProject(){
	    int i = Outer_Table_ProjectTable.getRowCount();
	    Outer_Table_ProjectTable.addColumn("Team no");
	    Outer_Table_ProjectTable.addColumn("Project name");
	    Outer_Table_ProjectTable.addColumn("Team name (조)");
	    Outer_Table_ProjectTable.addColumn("project git Address");
	    Outer_Table_ProjectTable.setColumnCount(4);
	    for(int j = 0 ; j < i ; j++){
	    	Outer_Table_ProjectTable.removeRow(0);
	    }
	    TRProjectTable.setAutoResizeMode(TRProjectTable.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    int width = 70;
	    vColIndex = 1;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 3;
	    col = TRProjectTable.getColumnModel().getColumn(vColIndex);
	    width = 300;
	    col.setPreferredWidth(width);
	}
	
	
	//project table data 부착
	public void projectTableSetItem() {
		

	    int rowCount = Outer_Table_ProjectTable.getRowCount();
	    for(int i = 0 ; i < rowCount ; i++){
	    	Outer_Table_ProjectTable.removeRow(0);
	    }
		
		DBAction dba = new DBAction();
		ArrayList<String[]> rsArr = dba.teamReviewProjectTableDataSelect(loginedId);
		for (int i = 0; i <= rsArr.size() - 1; i++) {
			Outer_Table_ProjectTable.addRow(rsArr.get(i));
		}
	}
	
	//테이블 클릭 : 0번째 컬럼값 (tema no)를 가져와서 아래 다이나믹뷰 출력
	public void tableClicked(){
		//프로젝트 등록 버튼 활성화
		btnInsert.setVisible(true);
		//프로젝트 입력 텍스트필드 활성화
		tfProjectGithubAddress.setVisible(true);
		
		int row = TRProjectTable.getSelectedRow();
		String getTeamNoToString = (String) TRProjectTable.getValueAt(row, 0);
		int teamNoParsedInt = Integer.parseInt(getTeamNoToString);
		System.out.println("선택된 열 : " + row + " // 팀번호 :" + teamNoParsedInt);
		
		tfProjectGithubAddress.setText((String) TRProjectTable.getValueAt(row, 3));
		
		CommentPanel cp = new CommentPanel(loginedId, teamNoParsedInt);
		// Dimensio없으면 스크롤바 생성이 불가능하므로, 필히 부착
		Dimension size = new Dimension();
		size.setSize(300, 80 * cp.panelItemCount);
		cp.setPreferredSize(size);
		scrollPane_TeammateReview_1.remove(initPanel);
		scrollPane_TeammateReview_1.setViewportView(cp);
	}
	
	public void projectInsert() {
		int row = TRProjectTable.getSelectedRow();
		String getTeamNoToString = (String) TRProjectTable.getValueAt(row, 0);
		int teamNoParsedInt = Integer.parseInt(getTeamNoToString);
		String githubAddress = tfProjectGithubAddress.getText();
		System.out.println("선택된 열 : " + row + " //팀번호 :" + teamNoParsedInt);
		
		DBAction dba = new DBAction();

		System.out.println("선택된 열 : " + row + " //깃주소 :" + githubAddress);
		dba.updateProjectGitAddress(teamNoParsedInt, githubAddress);
		TRProjectTable.setValueAt(githubAddress, row, 3);

	}

}