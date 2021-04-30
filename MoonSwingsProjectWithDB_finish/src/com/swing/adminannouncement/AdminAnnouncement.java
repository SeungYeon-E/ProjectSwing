package com.swing.adminannouncement;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
//import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.swing.login.FindIdPw;
public class AdminAnnouncement extends JPanel {
	
	public AdminAnnouncement() {
	}
	
	
	private JPanel panelAnnouncement;
	private JScrollPane scrollPane;
	private final DefaultTableModel Outer_Table_Announcement = new DefaultTableModel();
	private JTable tableAnnouncement;
	private JLabel lblAnnoucementNo;
	private JLabel lblAnnoucementTitle;
	private JLabel lblAnnoucementDate;
	private JSeparator separator;
	private JTextArea txtrAnnouncementContent;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnUpdate;
	
	
	/**
	 * Create the panel.
	 */
	public JPanel getAnnouncement() {
		if (panelAnnouncement == null) {
			panelAnnouncement = new JPanel();
			panelAnnouncement.setBackground(Color.white);
			panelAnnouncement.setBounds(300, 45, 490, 497);
			panelAnnouncement.setLayout(null);
			panelAnnouncement.add(getScrollPane());
			panelAnnouncement.add(getLblAnnoucementNo());
			panelAnnouncement.add(getLblAnnoucementTitle());
			panelAnnouncement.add(getLblAnnoucementDate());
			panelAnnouncement.add(getSeparator());
			panelAnnouncement.add(getTxtrAnnouncementContent());
			panelAnnouncement.add(getBtnCreate());
			panelAnnouncement.add(getBtnDelete());
			panelAnnouncement.add(getBtnUpdate());
		}

		return panelAnnouncement;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 16, 450, 200);
			scrollPane.setViewportView(gettableAnnouncement());
		}
		return scrollPane;
	}
	private JTable gettableAnnouncement() {
		if (tableAnnouncement == null) {
			tableAnnouncement = new JTable();
			tableAnnouncement.setForeground(new Color(0, 102, 204));
			tableAnnouncement.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						
						clickCount();
						TableClick();
						AdminAnnouncementTable();
						searchAction();
					}
				}
			});
			tableAnnouncement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableAnnouncement.getTableHeader().setReorderingAllowed(false);
			tableAnnouncement.setModel(Outer_Table_Announcement); 
		}
		return tableAnnouncement;
	}
	
	public void AdminAnnouncementTable(){
		
	    int i = Outer_Table_Announcement.getRowCount();
	    Outer_Table_Announcement.addColumn("No");
	    Outer_Table_Announcement.addColumn("Date");
	    Outer_Table_Announcement.addColumn("Title");
	    Outer_Table_Announcement.addColumn("Count");
	    Outer_Table_Announcement.setColumnCount(4);
	    
	    for(int j = 0 ; j < i ; j++){
	      Outer_Table_Announcement.removeRow(0);
	    }
	    tableAnnouncement.setAutoResizeMode(tableAnnouncement.AUTO_RESIZE_OFF);
	    int vColIndex = 0;
	    TableColumn col = tableAnnouncement.getColumnModel().getColumn(vColIndex);
	    int width = 30;
	    col.setPreferredWidth(width);
	    
	    vColIndex = 1;
	    col = tableAnnouncement.getColumnModel().getColumn(vColIndex);
	    width = 100;
	    col.setPreferredWidth(width);
	    vColIndex = 2;
	    col = tableAnnouncement.getColumnModel().getColumn(vColIndex);
	    width = 250;
	    col.setPreferredWidth(width);
	    vColIndex = 3;
	    col = tableAnnouncement.getColumnModel().getColumn(vColIndex);
	    width = 50;
	    col.setPreferredWidth(width);
		}
	
	private JLabel getLblAnnoucementNo() {
		if (lblAnnoucementNo == null) {
			lblAnnoucementNo = new JLabel("");
			lblAnnoucementNo.setBounds(30, 233, 20, 38);
			lblAnnoucementNo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblAnnoucementNo.setForeground(new Color(0, 102, 204));
		}
		return lblAnnoucementNo;
	}
	private JLabel getLblAnnoucementTitle() {
		if (lblAnnoucementTitle == null) {
			lblAnnoucementTitle = new JLabel("");
			lblAnnoucementTitle.setBounds(60, 233, 295, 38);
			lblAnnoucementTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblAnnoucementTitle.setForeground(new Color(0, 102, 204));
		}
		return lblAnnoucementTitle;
	}
	private JLabel getLblAnnoucementDate() {
		if (lblAnnoucementDate == null) {
			lblAnnoucementDate = new JLabel("");
			lblAnnoucementDate.setBounds(350, 233, 110, 38);
			lblAnnoucementDate.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblAnnoucementDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAnnoucementDate.setForeground(new Color(153, 153, 153));
		}
		return lblAnnoucementDate;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(20, 267, 450, 12);
			separator.setForeground(new Color(204, 204, 204));
		}
		return separator;
	}
	private JTextArea getTxtrAnnouncementContent() {
		if (txtrAnnouncementContent == null) {
			txtrAnnouncementContent = new JTextArea();
			txtrAnnouncementContent.setBounds(30, 283, 430, 141);
			txtrAnnouncementContent.setRows(20);
			txtrAnnouncementContent.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			txtrAnnouncementContent.setForeground(new Color(0, 102, 204));
			txtrAnnouncementContent.setText("");
			txtrAnnouncementContent.setEditable(false);
		}
		return txtrAnnouncementContent;
	}
	
	// button
	private JButton getBtnCreate() {
		if (btnCreate == null) {
			btnCreate = new JButton("Create");
			btnCreate.setForeground(new Color(0, 102, 204));
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdminCreateAnnouncement create = new AdminCreateAnnouncement() ;
					create.run();
					clearColumn();
				}
			});
			btnCreate.setBounds(25, 435, 140, 35);
		}
		return btnCreate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setForeground(new Color(0, 102, 204));
			btnDelete.setEnabled(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						deleteAction();
						searchAction();
						clearColumn();
					
				}
			});
			btnDelete.setBounds(325, 435, 140, 35);
		}
		return btnDelete;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.setForeground(new Color(0, 102, 204));
			btnUpdate.setEnabled(false);
			btnUpdate.setBounds(175, 435, 140, 35);
			btnUpdate.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					updateAction();
				
				}
			});
		}
		return btnUpdate;
	}
	
	// --------------------------------
	// 21.04.27 Hyokyeong 
	// ---------------------------------
	
	//DB to Table
	public void searchAction(){
        DbAction dbAction = new DbAction();
        ArrayList<Bean> beanList = dbAction.selectAnnouncementList();
        
        int listCount = beanList.size();
        
        for(int i=0; i<listCount; i++) {
        	String anNo = Integer.toString(beanList.get(i).getNo());
        	String anVi = Integer.toString(beanList.get(i).getViews());
        	String[] qTxt = {anNo, beanList.get(i).getWriting(), beanList.get(i).getTitle(), anVi};
        	Outer_Table_Announcement.addRow(qTxt);	
        	
        }
	}
	
	// click시 내용 띄우기
	private void TableClick() {
		int i = tableAnnouncement.getSelectedRow();
		String anNo = (String)tableAnnouncement.getValueAt(i, 0);
		int wkNo = Integer.parseInt(anNo);
		
		DbAction dbAction = new DbAction(wkNo);		
		Bean bean = dbAction.TableClick();
		String stNo = Integer.toString(bean.getNo());
	
		
		lblAnnoucementNo.setText(stNo+".");
		lblAnnoucementTitle.setText(bean.getTitle());
		lblAnnoucementDate.setText(bean.getWriting());
		txtrAnnouncementContent.setText(bean.getContent());
		
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
	}
	
	// Table Click시 Count ++
	private void clickCount() {
		
		int i = tableAnnouncement.getSelectedRow();
		String anNo = (String)tableAnnouncement.getValueAt(i, 0);
		int wkNo = Integer.parseInt(anNo);
		
		String anViews = (String)tableAnnouncement.getValueAt(i , 3);
		int wkViews = Integer.parseInt(anViews);
		
		DbAction dbAction = new DbAction(wkNo, wkViews);
		dbAction.clickCount();           
	}
	
	// Announcement data field Clear
	public void clearColumn() {
		lblAnnoucementNo.setText("");
		lblAnnoucementTitle.setText("");
		lblAnnoucementDate.setText("");
		txtrAnnouncementContent.setText("");
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	
	// delete Announcement
	private void deleteAction() {		
		
		String stno = lblAnnoucementNo.getText();
		String no = stno.substring(0, stno.length()-1);
		int wkNo = Integer.parseInt(no);
		
		DbAction dbAction = new DbAction(wkNo);
		dbAction.deleteAction();
		
		JOptionPane.showMessageDialog(this, "게시글을 삭제하였습니다. ",
				"Delete Announcement", 
				JOptionPane.INFORMATION_MESSAGE);  
	}
	
	public void updateAction() {
		
		String stno = lblAnnoucementNo.getText();
		String no = stno.substring(0, stno.length()-1);

		String writing = lblAnnoucementDate.getText();
		String title = lblAnnoucementTitle.getText();
		String content = txtrAnnouncementContent.getText();

		AdminUpdateAnnouncement update = new AdminUpdateAnnouncement(no, writing, title, content) ;
		update.run(no, writing, title, content);
		
		clearColumn();
		
	}
	
	
} // end line