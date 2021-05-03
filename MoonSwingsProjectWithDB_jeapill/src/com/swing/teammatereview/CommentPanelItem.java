/* //CustomListViewItem.java//
 * 
 * 토이프로젝트의 아이템 그대로 복붛 및 주석처리
 * [1.0] 2021-04-29 윤재필
 * 
 * 혼동없도록 id를 taget로 변경
 */
package com.swing.teammatereview;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommentPanelItem extends JPanel {
	private JLabel lblName;
	private JLabel lblImage;
	private JTextField tfContent;
	private JButton btnSubmit;
	
	//패널의 정보들을 저장
	String sender;
	int selectedTeamNo;
	String taget;
	String name;
	BufferedImage bufferedImage;
	String content = "";

	//생성시 패널의 아이템을 부착하고 id, name, photo, content를 저장
	public CommentPanelItem(String sender, int selectedTeamNo, String taget, String name, BufferedImage photo, String content) {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				tfMouseExited();
			}
		});
		this.sender = sender;
		this.selectedTeamNo = selectedTeamNo;
		this.taget = taget;
		this.name = name;
		this.bufferedImage = photo;
		this.content = content;
		
		setBorder(null);
		setLayout(null);
		setSize(390,80);
		add(getLblName());
		add(getLblImage());
		add(getTfContent());
		add(getBtnSubmit());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel(name);
			lblName.setForeground(new Color(0, 102, 204));
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(14, 58, 61, 16);
		}
		return lblName;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel();
			lblImage.setBounds(14, 6, 61, 48);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imageIcon = new ImageIcon(bufferedImage);
			Image image = imageIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
			lblImage.setIcon(new ImageIcon(image));
		}
		return lblImage;
	}
	private JTextField getTfContent() {
		if (tfContent == null) {
			tfContent = new JTextField();
			tfContent.setForeground(new Color(0, 102, 204));
			tfContent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfClieckEvnet();
				}
			});
			tfContent.setBounds(87, 6, 297, 48);
			tfContent.setColumns(10);
			tfContent.setText(content);
		}
		return tfContent;
	}
	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("등록");
			btnSubmit.setForeground(Color.WHITE);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					submitComment();
				}
			});
			btnSubmit.setOpaque(true);
			btnSubmit.setBorderPainted(false);
			btnSubmit.setBackground(new Color(0, 102, 204));
			btnSubmit.setBounds(305, 52, 75, 22);
			btnSubmit.setVisible(false);
		}
		return btnSubmit;
	}
	
	//text feild 클릭시 버튼 가시화
	private void tfClieckEvnet() {
		System.out.println("[해당 패널 정보]" + taget + " : " + content);		
		btnSubmit.setVisible(true);
	}
	
	//마우스가 패널 밖으로 갔을 시, content 초가화 및 등록버튼 비가시화
	private void tfMouseExited() {
		tfContent.setText(content);
		btnSubmit.setVisible(false);
	}
	
	//등록바튼 클릭시, 저장된 content값이 없다면 Insert, 있다면 update=
	private void submitComment() {
		DBAction gi = new DBAction();
		String input = tfContent.getText();
		System.out.println("taget : " + taget + ", comment = " + input);
		
		if (content == null) {
			System.out.println("run insert");
			gi.commentInsert(selectedTeamNo, taget, sender, input.trim());
			content = input.trim();
			tfContent.setText(input.trim());
			
		} else {
			System.out.println("[run update]");
			gi.commentUpdate(selectedTeamNo, taget, sender, input.trim());
			content = input.trim();
			tfContent.setText(input.trim());
			
		}
	}
}