package com.swing.login;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.swing.utility.TextFieldHint;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminSignUp {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnImportImage;
	private JLabel lblAdminId;
	private JTextField tfAdminId;
	private JLabel lblAdminPw;
	private JLabel lblAdminPwRe;
	private JButton btnIdCheck;
	private JButton btnPwCheck;
	private JLabel lblGithubId;
	private JTextField tfAdminGithub;
	private JLabel lblAdminMbti;
	private JTextField tfAdminMbti;
	private JButton btnAdminSubmit;
	private JLabel lblAdminName;
	private JTextField tfAdminName;
	private JLabel lblAdminPhone;
	private JTextField tfAdminPhone;
	private JPasswordField pfAdminPw;
	private JPasswordField pfAdminPwRe;
	String imagePath = "";

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignUp window = new AdminSignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 536, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnImportImage());
		frame.getContentPane().add(getLblAdminId());
		frame.getContentPane().add(getTfAdminId());
		frame.getContentPane().add(getLblAdminPw());
		frame.getContentPane().add(getLblAdminPwRe());
		frame.getContentPane().add(getBtnIdCheck());
		frame.getContentPane().add(getBtnPwCheck());
		frame.getContentPane().add(getLblGithubId());
		frame.getContentPane().add(getTfAdminGithub());
		frame.getContentPane().add(getLblAdminMbti());
		frame.getContentPane().add(getTfAdminMbti());
		frame.getContentPane().add(getBtnAdminSubmit());
		frame.getContentPane().add(getLblAdminName());
		frame.getContentPane().add(getTfAdminName());
		frame.getContentPane().add(getLblAdminPhone());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getPfAdminPw());
		frame.getContentPane().add(getPfAdminPwRe());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Photo");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(6, 6, 109, 112);
		}
		return lblNewLabel;
	}
	private JButton getBtnImportImage() {
		if (btnImportImage == null) {
			btnImportImage = new JButton("Import Image");
			btnImportImage.setBackground(Color.WHITE);
			btnImportImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					importImageAction();
					
				}
			});
			btnImportImage.setBounds(6, 127, 109, 26);
		}
		return btnImportImage;
	}
	private JLabel getLblAdminId() {
		if (lblAdminId == null) {
			lblAdminId = new JLabel("ID :");
			lblAdminId.setBounds(248, 42, 33, 17);
		}
		return lblAdminId;
	}
	private JTextField getTfAdminId() {
		if (tfAdminId == null) {
			tfAdminId = new JTextField();
			tfAdminId.setBounds(282, 37, 130, 26);
			tfAdminId.setColumns(10);
		}
		return tfAdminId;
	}
	private JLabel getLblAdminPw() {
		if (lblAdminPw == null) {
			lblAdminPw = new JLabel("Password :");
			lblAdminPw.setBounds(205, 73, 76, 17);
		}
		return lblAdminPw;
	}
	private JLabel getLblAdminPwRe() {
		if (lblAdminPwRe == null) {
			lblAdminPwRe = new JLabel("Recheck Password :");
			lblAdminPwRe.setBounds(150, 102, 130, 17);
		}
		return lblAdminPwRe;
	}
	private JButton getBtnIdCheck() {
		if (btnIdCheck == null) {
			btnIdCheck = new JButton("ID Check");
			btnIdCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					adminIdCheck();
					
				}
			});
			btnIdCheck.setBounds(413, 37, 117, 29);
		}
		return btnIdCheck;
	}
	private JButton getBtnPwCheck() {
		if (btnPwCheck == null) {
			btnPwCheck = new JButton("PW Check");
			btnPwCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					adminPwCheck();
					
				}
			});
			btnPwCheck.setBounds(413, 97, 117, 29);
		}
		return btnPwCheck;
	}
	private JLabel getLblGithubId() {
		if (lblGithubId == null) {
			lblGithubId = new JLabel("Github ID :");
			lblGithubId.setBounds(267, 193, 76, 17);
		}
		return lblGithubId;
	}
	private JTextField getTfAdminGithub() {
		if (tfAdminGithub == null) {
			tfAdminGithub = new JTextField();
			tfAdminGithub.setBounds(344, 188, 130, 26);
			tfAdminGithub.setColumns(10);
		}
		return tfAdminGithub;
	}
	private JLabel getLblAdminMbti() {
		if (lblAdminMbti == null) {
			lblAdminMbti = new JLabel("MBTI :");
			lblAdminMbti.setBounds(297, 232, 45, 17);
		}
		return lblAdminMbti;
	}
	private JTextField getTfAdminMbti() {
		if (tfAdminMbti == null) {
			tfAdminMbti = new TextFieldHint("MBTI 입력해주세요");
			tfAdminMbti.setBounds(344, 227, 130, 26);
			tfAdminMbti.setColumns(10);
		}
		return tfAdminMbti;
	}
	private JButton getBtnAdminSubmit() {
		if (btnAdminSubmit == null) {
			btnAdminSubmit = new JButton("Submit");
			btnAdminSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					adminSignUpAction();
					
				}
			});
			btnAdminSubmit.setBackground(Color.BLUE);
			btnAdminSubmit.setBounds(376, 278, 154, 38);
		}
		return btnAdminSubmit;
	}
	private JLabel getLblAdminName() {
		if (lblAdminName == null) {
			lblAdminName = new JLabel("Name :");
			lblAdminName.setBounds(51, 198, 51, 17);
		}
		return lblAdminName;
	}
	private JTextField getTfAdminName() {
		if (tfAdminName == null) {
			tfAdminName = new JTextField();
			tfAdminName.setBounds(103, 193, 130, 26);
			tfAdminName.setColumns(10);
		}
		return tfAdminName;
	}
	private JLabel getLblAdminPhone() {
		if (lblAdminPhone == null) {
			lblAdminPhone = new JLabel("Phone :");
			lblAdminPhone.setBounds(51, 236, 51, 17);
		}
		return lblAdminPhone;
	}
	private JTextField getTextField_1() {
		if (tfAdminPhone == null) {
			tfAdminPhone = new TextFieldHint("01011112222");
			tfAdminPhone.setColumns(10);
			tfAdminPhone.setBounds(103, 231, 130, 26);
		}
		return tfAdminPhone;
	}
	private JPasswordField getPfAdminPw() {
		if (pfAdminPw == null) {
			pfAdminPw = new JPasswordField();
			pfAdminPw.setBounds(282, 71, 130, 26);
		}
		return pfAdminPw;
	}
	private JPasswordField getPfAdminPwRe() {
		if (pfAdminPwRe == null) {
			pfAdminPwRe = new JPasswordField();
			pfAdminPwRe.setBounds(282, 102, 130, 26);
		}
		return pfAdminPwRe;
	}

	private void adminSignUpAction(){
			if(btnIdCheck.getText().equals("Check") && btnPwCheck.getText().equals("Check") && btnImportImage.getText().equals("Done!")) {
			
			if(btnIdCheck.getText().equals("Enter Your Name")) {
				JOptionPane.showMessageDialog(null, "이름은 필수 입력란입니다.");
			}else if(tfAdminMbti.getText().equals("01011112222")) {
				JOptionPane.showMessageDialog(null, "전화번호는 필수 입력란입니다.");
			}else {
			
			
			String id = tfAdminId.getText().trim();
			char[] pw = pfAdminPw.getPassword();
			String strPw = String.copyValueOf(pw);
			String name = tfAdminName.getText().trim();
			String mbti = tfAdminMbti.getText().trim();
			String phone = tfAdminPhone.getText().trim();
			String github_id = tfAdminGithub.getText().trim();
			String photo = imagePath;
			
			System.out.println(photo);

			AdminSignUpDBAction adminSignUpDbAction = new AdminSignUpDBAction(id, strPw , name, mbti,  phone, github_id, photo);
		
			boolean msg = adminSignUpDbAction.insertAction();
		
			if ( msg ){
				JOptionPane.showMessageDialog(null, "Sign Up Success! "+" \n Welcome "+ tfAdminName.getText());
				frame.setVisible(false);
				
				}else {
					JOptionPane.showMessageDialog(null,"회원가입중 에러가 발생했습니다!",
							"Critical Error!", 
							JOptionPane.ERROR_MESSAGE);    
				}	
			}
//			btnPwCheck.getText().equals("Check") && btnPwCheck.getText().equals("Check") 
		}else if( btnIdCheck.getText().equals("Done!") == false){
			JOptionPane.showConfirmDialog(null, "Please Import your Photo to identify you");
		}else {
			JOptionPane.showConfirmDialog(null, " Please Check the ID or Check the PassWord");
		}
		
	}
	
	private void adminIdCheck() {
		
		String id = tfAdminId.getText().trim();
		
		AdminSignUpDBAction adminSignUpDbAction = new AdminSignUpDBAction(id);
		
		if(tfAdminId.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"ID 를 입력해주세요");
		}else if(adminSignUpDbAction.idCheckInDB()){
			JOptionPane.showMessageDialog(null, "이미 존재하거나 유효하지 않은 아이디 입니다.");
			tfAdminId.setText("");
		}else {
			btnIdCheck.setText("Check");
			tfAdminId.setEditable(false);
		}
		
		
	}
	private void adminPwCheck() {
		String id = tfAdminId.getText().trim();
		char[] firstPw = pfAdminPw.getPassword();
		String strFirstPw = String.copyValueOf(firstPw);
		
		char[] secondPw = pfAdminPwRe.getPassword();
		String strSecondPw = String.copyValueOf(secondPw);
		
		if(strFirstPw.equals("") || strSecondPw.equals("")) {
			
			JOptionPane.showMessageDialog(null,"Please Check Password");
			
		} else if(strFirstPw.equals(strSecondPw)) {
			
			String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$";
			Matcher matcher = Pattern.compile(pwPattern).matcher(strFirstPw);
			
			pwPattern = "(.)\\1\\1\\1";
			Matcher matcher2 = Pattern.compile(pwPattern).matcher(strFirstPw);
			
			if(strFirstPw.contains(id)){
				
				JOptionPane.showMessageDialog(null, "Password 에 ID 가 포함되었습니다. 비밀번호를 다시 입력해주세요");
				pfAdminPw.setText("");
				pfAdminPwRe.setText("");
				return;
				
			}
			if(strFirstPw.contains(" ")){
				 JOptionPane.showMessageDialog(null, "Password 에 공백이 포함되었습니다. 비밀번호를 다시 입력해주세요");
				 pfAdminPw.setText("");
				 pfAdminPwRe.setText("");
				 return;
				
			}
			if(!matcher.matches() || matcher2.find()){
				btnPwCheck.setText("Check");
				pfAdminPw.setEditable(false);
				pfAdminPwRe.setEditable(false);
			
			}
			
			if(matcher.matches() == true) {
				JOptionPane.showMessageDialog(null,"영문, 숫자, 특수문자 조합, 9~12자리로 비밀번호를 작성해주세요");
				pfAdminPw.setText("");
				pfAdminPwRe.setText("");
			}
			if(matcher2.find()) {
				JOptionPane.showMessageDialog(null,"같은 문자 4개이상 사용 불가입니다.");
				pfAdminPw.setText("");
				pfAdminPwRe.setText("");
			}
			
		}
		
		
	
		
		
	}
	
	
	

	
public void importImageAction() {
		
		
		JFileChooser browseImageFile = new JFileChooser();
		
		FileNameExtensionFilter fnef = new FileNameExtensionFilter("Image","png","jpg","jpeg");
		browseImageFile.addChoosableFileFilter(fnef);
		
		int showOpenDialogue = browseImageFile.showOpenDialog(null);
		
		if(showOpenDialogue == JFileChooser.APPROVE_OPTION) {
			File selectedImageFile = browseImageFile.getSelectedFile();
			String selectedImagePath = selectedImageFile.getAbsolutePath();
			imagePath = selectedImagePath;
			System.out.println(selectedImagePath);
//			JOptionPane.showMessageDialog(null, selectedImagePath);
			
			btnImportImage.setText("Done!");
			ImageIcon imageIcon = new ImageIcon(selectedImagePath);
			
			Image image = imageIcon.getImage().getScaledInstance(lblNewLabel.getWidth()+17, lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
			lblNewLabel.setIcon(new ImageIcon(image));
			}
	}
}