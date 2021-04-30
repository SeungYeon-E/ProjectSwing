/* //GridPanel.java//
 * GridPanel -> CommentPanel로 이름 변경
 * 본 프로젝트로 복붛
 * [1.0] 2021-04-28 윤재필
 * 
 */

package com.swing.teammatereview;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CommentPanel extends JPanel {
	String loginedId;
	//bean 갯수 카운트
	int panelItemCount = 0;
	
	//최초 생성시 db에서 데이터를 받아와 bean의 갯수대로 CommentPanelItem을 생성, 부착
	public CommentPanel(String loginedId) {
		this.loginedId = loginedId;
		//bean 배열 생성 및 db로부터 데이터 가져와 채움
		DBAction dba = new DBAction();
		ArrayList<CommentBean> cbs = dba.getCommentPanelData(loginedId);
		panelItemCount = cbs.size();
		
		//반환된 bean 개수에 맞춰 row 생성
		setLayout(new GridLayout(panelItemCount,1));
		
		//반환된 bean으로 CommentPanelItem 생성
	    for (int i = 0; i < panelItemCount; i++) {
	    	CommentPanelItem customListViewItem 
	    		= new CommentPanelItem(loginedId, cbs.get(i).id, cbs.get(i).name, cbs.get(i).photo, cbs.get(i).content);
	    	add(customListViewItem);
	    }
	}
	
	public CommentPanel get() {
		return this;
	}
	
}