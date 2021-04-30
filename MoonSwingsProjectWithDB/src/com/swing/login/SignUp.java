package com.swing.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.swing.utility.TextFieldHint;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class SignUp {

	private JFrame frmSignUp;
	private JPanel panelSignUpImage;
	private JLabel lblSignUpImage;
	private JButton btnNewButton;
	private JLabel lblSignUpName;
	private JLabel lblSignUpId;
	private JLabel lblSignUpPw;
	private JLabel lblSignUpPwConfirm;
	private JLabel lblSignUpMbti;
	private JLabel lblSignUpAddress;
	private JLabel lblSignUpStrength;
	private JLabel lblSignUpPhoneNum;
	private JLabel lblSignUpGithub;
	private JLabel lblSignUpIntroduce;
	private JTextField tfSignUpId;
	private JPasswordField tfSignUpPw;
	private JPasswordField tfSignUpPwConfirm;
	private JTextField tfSignUpName;
	private JTextField tfSignUpPhone;
	private JTextField tfSignUpGithub;
	private JTextField txtJavacsql;
	private JTextField tfSignUpAddress;
	private JTextField tfSignUpBriefInfo;
	private JTextField tfSignUpMbti;
	private JButton btnSignUpSubmit;
	private JButton btnSignUpCancel;
	private JButton btnSignUpIdCheck;
	private JTextField txtJavacpython;
	private JTextField textField;
	private JTextField tfSignUpStrength;
	private JButton btnPwCheck;
	private JButton btnSignUp;
	private JLabel lblSignUpPasswordCheck;
	String imagePath = "";
	

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.getContentPane().setBackground(Color.WHITE);
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 500, 560);
//		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);
		frmSignUp.setResizable(false);
		frmSignUp.getContentPane().add(getPanelSignUpImage());
		frmSignUp.getContentPane().add(getBtnNewButton());
		frmSignUp.getContentPane().add(getLblSignUpName());
		frmSignUp.getContentPane().add(getLblSignUpId());
		frmSignUp.getContentPane().add(getLblSignUpPw());
		frmSignUp.getContentPane().add(getLblSignUpPwConfirm());
		frmSignUp.getContentPane().add(getLblSignUpMbti());
		frmSignUp.getContentPane().add(getLblSignUpAddress());
		frmSignUp.getContentPane().add(getLblSignUpStrength());
		frmSignUp.getContentPane().add(getLblSignUpPhoneNum());
		frmSignUp.getContentPane().add(getLblSignUpGithub());
		frmSignUp.getContentPane().add(getLblSignUpIntroduce());
		frmSignUp.getContentPane().add(getTfSignUpId());
		frmSignUp.getContentPane().add(getTfSignUpPw());
		frmSignUp.getContentPane().add(getTfSignUpPwConfirm());
		frmSignUp.getContentPane().add(getTfSignUpName());
		frmSignUp.getContentPane().add(getTfSignUpPhone());
		frmSignUp.getContentPane().add(getTfSignUpGithub());
		frmSignUp.getContentPane().add(getTfSignUpAddress());
		frmSignUp.getContentPane().add(getTfSignUpBriefInfo());
		frmSignUp.getContentPane().add(getTfSignUpMbti());
		frmSignUp.getContentPane().add(getBtnSignUpSubmit());
		frmSignUp.getContentPane().add(getBtnSignUpCancel());
		frmSignUp.getContentPane().add(getBtnSignUpIdCheck());
		frmSignUp.getContentPane().add(getTfSignUpStrength());
		frmSignUp.getContentPane().add(getBtnPwCheck());
		frmSignUp.getContentPane().add(getLblSignUpPasswordCheck());
	}
	private JPanel getPanelSignUpImage() {
		if (panelSignUpImage == null) {
			panelSignUpImage = new JPanel();
			panelSignUpImage.setBackground(new Color(0, 102, 204));
			panelSignUpImage.setBounds(35, 66, 100, 129);
			panelSignUpImage.setLayout(null);
			panelSignUpImage.add(getLblSignUpImage());
		}
		return panelSignUpImage;
	}
	private JLabel getLblSignUpImage() {
		if (lblSignUpImage == null) {
			lblSignUpImage = new JLabel("Image");
			lblSignUpImage.setForeground(Color.WHITE);
			lblSignUpImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblSignUpImage.setBounds(0, 0, 100, 129);
		}
		return lblSignUpImage;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Import Image");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					importImageAction();
				}
			});
			btnNewButton.setForeground(new Color(0, 102, 204));
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
			btnNewButton.setBounds(35, 195, 100, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblSignUpName() {
		if (lblSignUpName == null) {
			lblSignUpName = new JLabel("Name :");
			lblSignUpName.setForeground(Color.GRAY);
			lblSignUpName.setBounds(35, 243, 53, 16);
		}
		return lblSignUpName;
	}
	private JLabel getLblSignUpId() {
		if (lblSignUpId == null) {
			lblSignUpId = new JLabel("ID : ");
			lblSignUpId.setForeground(Color.GRAY);
			lblSignUpId.setBounds(147, 78, 53, 16);
		}
		return lblSignUpId;
	}
	private JLabel getLblSignUpPw() {
		if (lblSignUpPw == null) {
			lblSignUpPw = new JLabel("Password :");
			lblSignUpPw.setForeground(Color.GRAY);
			lblSignUpPw.setBounds(147, 106, 75, 16);
		}
		return lblSignUpPw;
	}
	private JLabel getLblSignUpPwConfirm() {
		if (lblSignUpPwConfirm == null) {
			lblSignUpPwConfirm = new JLabel("ReCheck pw :");
			lblSignUpPwConfirm.setForeground(Color.GRAY);
			lblSignUpPwConfirm.setBounds(147, 135, 100, 16);
		}
		return lblSignUpPwConfirm;
	}
	private JLabel getLblSignUpMbti() {
		if (lblSignUpMbti == null) {
			lblSignUpMbti = new JLabel("MBTI :");
			lblSignUpMbti.setForeground(Color.GRAY);
			lblSignUpMbti.setBounds(35, 278, 61, 16);
		}
		return lblSignUpMbti;
	}
	private JLabel getLblSignUpAddress() {
		if (lblSignUpAddress == null) {
			lblSignUpAddress = new JLabel("Address (Nearby Station) :");
			lblSignUpAddress.setForeground(Color.GRAY);
			lblSignUpAddress.setBounds(35, 313, 178, 16);
		}
		return lblSignUpAddress;
	}
	private JLabel getLblSignUpStrength() {
		if (lblSignUpStrength == null) {
			lblSignUpStrength = new JLabel("Strength (language skill) :");
			lblSignUpStrength.setForeground(Color.GRAY);
			lblSignUpStrength.setBounds(35, 348, 164, 16);
		}
		return lblSignUpStrength;
	}
	private JLabel getLblSignUpPhoneNum() {
		if (lblSignUpPhoneNum == null) {
			lblSignUpPhoneNum = new JLabel("Phone :");
			lblSignUpPhoneNum.setForeground(Color.GRAY);
			lblSignUpPhoneNum.setBounds(224, 243, 61, 16);
		}
		return lblSignUpPhoneNum;
	}
	private JLabel getLblSignUpGithub() {
		if (lblSignUpGithub == null) {
			lblSignUpGithub = new JLabel("Github ID :");
			lblSignUpGithub.setForeground(Color.GRAY);
			lblSignUpGithub.setBounds(224, 278, 75, 16);
		}
		return lblSignUpGithub;
	}
	private JLabel getLblSignUpIntroduce() {
		if (lblSignUpIntroduce == null) {
			lblSignUpIntroduce = new JLabel("Tell us About Yourself !");
			lblSignUpIntroduce.setForeground(Color.GRAY);
			lblSignUpIntroduce.setBounds(36, 387, 164, 16);
		}
		return lblSignUpIntroduce;
	}
	private JTextField getTfSignUpId() {
		if (tfSignUpId == null) {
			tfSignUpId = new TextFieldHint("Enter Your ID");
			tfSignUpId.setForeground(new Color(0, 102, 204));
			tfSignUpId.setBounds(239, 68, 150, 30);
			tfSignUpId.setColumns(10);
		}
		return tfSignUpId;
	}
	private JPasswordField getTfSignUpPw() {
		if (tfSignUpPw == null) {
			tfSignUpPw = new JPasswordField();
			tfSignUpPw.setForeground(new Color(0, 102, 204));
			tfSignUpPw.setBounds(239, 98, 150, 30);
			
		}
		return tfSignUpPw;
	}
	private JPasswordField getTfSignUpPwConfirm() {
		if (tfSignUpPwConfirm == null) {
			tfSignUpPwConfirm = new JPasswordField();
			tfSignUpPwConfirm.setForeground(new Color(0, 102, 204));
			tfSignUpPwConfirm.setBounds(239, 128, 150, 30);
		}
		return tfSignUpPwConfirm;
	}
	private JTextField getTfSignUpName() {
		if (tfSignUpName == null) {
			tfSignUpName = new TextFieldHint("Enter Your Name");
			tfSignUpName.setForeground(new Color(0, 102, 204));
			tfSignUpName.setBounds(86, 236, 127, 30);
			tfSignUpName.setColumns(10);
		}
		return tfSignUpName;
	}
	private JTextField getTfSignUpPhone() {
		if (tfSignUpPhone == null) {
			tfSignUpPhone = new TextFieldHint("01011112222");
			tfSignUpPhone.setForeground(new Color(0, 102, 204));
			tfSignUpPhone.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfSignUpPhone.setText(null);
				}
			});
			tfSignUpPhone.setColumns(10);
			tfSignUpPhone.setBounds(275, 236, 190, 30);
		}
		return tfSignUpPhone;
	}
	private JTextField getTfSignUpGithub() {
		if (tfSignUpGithub == null) {
			tfSignUpGithub = new JTextField();
			tfSignUpGithub.setForeground(new Color(0, 102, 204));
			tfSignUpGithub.setColumns(10);
			tfSignUpGithub.setBounds(301, 271, 164, 30);
		}
		return tfSignUpGithub;
	}

	
	private JTextField getTfSignUpAddress() {
		if (tfSignUpAddress == null) {
			tfSignUpAddress = new TextFieldHint("Nearby Subway Station");
			tfSignUpAddress.setForeground(new Color(0, 102, 204));
			tfSignUpAddress.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfSignUpAddress.setText(null);
				}
			});
			
			tfSignUpAddress.setColumns(10);
			tfSignUpAddress.setBounds(225, 306, 240, 30);
		}
		return tfSignUpAddress;
	}
	private JTextField getTfSignUpBriefInfo() {
		if (tfSignUpBriefInfo == null) {
			tfSignUpBriefInfo = new TextFieldHint("One sentence to know about you!");
			tfSignUpBriefInfo.setForeground(new Color(0, 102, 204));
			tfSignUpBriefInfo.setBackground(Color.WHITE);
			tfSignUpBriefInfo.setBounds(35, 405, 430, 45);
			tfSignUpBriefInfo.setColumns(10);
		}
		return tfSignUpBriefInfo;
	}
	private JTextField getTfSignUpMbti() {
		if (tfSignUpMbti == null) {
			tfSignUpMbti = new JTextField();
			tfSignUpMbti.setForeground(new Color(0, 102, 204));
			tfSignUpMbti.setBounds(86, 271, 127, 30);
			tfSignUpMbti.setColumns(10);
		}
		return tfSignUpMbti;
	}
	
	private JTextField getTfSignUpStrength() {
		if (tfSignUpStrength == null) {
			tfSignUpStrength = new TextFieldHint("Java, Python, Kotlin..Max 5 Min 1");
			tfSignUpStrength.setForeground(new Color(0, 102, 204));
			tfSignUpStrength.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfSignUpStrength.setText(null);
				}
			});
			tfSignUpStrength.setBounds(225, 341, 240, 30);
			tfSignUpStrength.setColumns(10);
		}
		return tfSignUpStrength;
	}
	
	private JButton getBtnSignUpSubmit() {
		if (btnSignUpSubmit == null) {
			btnSignUpSubmit = new JButton("Submit");
			btnSignUpSubmit.setBackground(new Color(0, 102, 204));
			btnSignUpSubmit.setForeground(Color.WHITE);
			btnSignUpSubmit.setOpaque(true);
			btnSignUpSubmit.setBorderPainted(false);
			btnSignUpSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					signUpAction();
				}
			});
			btnSignUpSubmit.setBounds(350, 462, 117, 45);
		}
		return btnSignUpSubmit;
	}
	private JButton getBtnSignUpCancel() {
		if (btnSignUpCancel == null) {
			btnSignUpCancel = new JButton("Cancel");
			btnSignUpCancel.setForeground(Color.GRAY);
			btnSignUpCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					frmSignUp.setVisible(false);
				}
			});
			btnSignUpCancel.setBounds(220 , 462, 117, 45);
		}
		return btnSignUpCancel;
	}
	private JButton getBtnSignUpIdCheck() {
		if (btnSignUpIdCheck == null) {
			btnSignUpIdCheck = new JButton("ID Check");
			btnSignUpIdCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					idCheckAction();
				}
			});
			btnSignUpIdCheck.setFont(new Font("Lucida Grande", Font.BOLD, 10));
			btnSignUpIdCheck.setForeground(new Color(0, 102, 204));
			btnSignUpIdCheck.setBounds(390, 68, 85, 29);
		}
		return btnSignUpIdCheck;
	}
	private JLabel getLblSignUpPasswordCheck() {
		if (lblSignUpPasswordCheck == null) {
			lblSignUpPasswordCheck = new JLabel("Password에 Id 포함불가,대소문자 포함,특수기호 포함, 5~12자리 비밀번호 , 공백 사용불가");
			lblSignUpPasswordCheck.setForeground(Color.LIGHT_GRAY);
			lblSignUpPasswordCheck.setFont(new Font("Lucida Grande", Font.BOLD, 12));
			lblSignUpPasswordCheck.setBounds(147, 163, 322, 16);
		}
		return lblSignUpPasswordCheck;
	}
	
	private void signUpAction() {
	
		if(btnSignUpIdCheck.getText().equals("Check") && btnPwCheck.getText().equals("Check") && btnNewButton.getText().equals("Done!")) {
			
			if(tfSignUpName.getText().equals("Enter Your Name")) {
				JOptionPane.showMessageDialog(null, "이름은 필수 입력란입니다.");
			}else if(tfSignUpPhone.getText().equals("01011112222")) {
				JOptionPane.showMessageDialog(null, "전화번호는 필수 입력란입니다.");
			}else {
			
			
			String id = tfSignUpId.getText().trim();
			char[] pw = tfSignUpPw.getPassword();
			String strPw = String.copyValueOf(pw);
			String name = tfSignUpName.getText().trim();
			String mbti = tfSignUpMbti.getText().toUpperCase().trim();
			String phone = tfSignUpPhone.getText().trim();
			String github_id = tfSignUpGithub.getText().trim();
			String introduce = tfSignUpBriefInfo.getText();
			String subway = tfSignUpAddress.getText();
			
//			Strength 받아오기
			String strength = tfSignUpStrength.getText();
			String photo = imagePath;
			
			System.out.println(photo);

			SignUpDBAction signUpDbAction = new SignUpDBAction(id, strPw , name, mbti,  phone, github_id, introduce, subway, strength ,photo);
		
			boolean msg = signUpDbAction.insertAction();
		
			if ( msg ){
				JOptionPane.showMessageDialog(null, "Sign Up Success! "+" \n Welcome "+ tfSignUpName.getText());
				frmSignUp.setVisible(false);
				
				}else {
					JOptionPane.showMessageDialog(null,"회원가입중 에러가 발생했습니다!",
							"Critical Error!", 
							JOptionPane.ERROR_MESSAGE);    
				}	
			}

//			btnPwCheck.getText().equals("Check") && btnPwCheck.getText().equals("Check") 
		}else if( btnNewButton.getText().equals("Done!") == false){
			JOptionPane.showConfirmDialog(null, "Please Import your Photo to identify you");
		}else {
			JOptionPane.showConfirmDialog(null, " Please Check the ID or Check the PassWord");
		}
	}
//	signUpAction end
	
	private JButton getBtnPwCheck() {
		if (btnPwCheck == null) {
			btnPwCheck = new JButton("PW Check");
			btnPwCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					passwordCheckAction();
				}
			});
			btnPwCheck.setForeground(new Color(0, 102, 204));
			btnPwCheck.setFont(new Font("Lucida Grande", Font.BOLD, 10));
			btnPwCheck.setBounds(390, 130, 85, 29);
		}
		return btnPwCheck;
	}
	
	private void idCheckAction() {
		String id = tfSignUpId.getText().trim();
		
		SignUpDBAction signUpDbAction = new SignUpDBAction(id);
		
		if(tfSignUpId.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"ID 를 입력해주세요");
		}else if(signUpDbAction.idCheckInDB()){
			JOptionPane.showMessageDialog(null, "이미 존재하거나 유효하지 않은 아이디 입니다.");
			tfSignUpId.setText("");
		}else {
			btnSignUpIdCheck.setText("Check");
			tfSignUpId.setEditable(false);
		}
		
	}
	
	private void passwordCheckAction() {
		
		String id = tfSignUpId.getText().trim();
		char[] firstPw = tfSignUpPw.getPassword();
		String strFirstPw = String.copyValueOf(firstPw);
		
		char[] secondPw = tfSignUpPwConfirm.getPassword();
		String strSecondPw = String.copyValueOf(secondPw);
		
		if(strFirstPw.equals("") || strSecondPw.equals("")) {
			
			JOptionPane.showMessageDialog(null,"Please Check Password");
			
		} else if(strFirstPw.equals(strSecondPw)) {
			
			String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{5,12}$";
			Matcher matcher = Pattern.compile(pwPattern).matcher(strFirstPw);
			
			if(strFirstPw.contains(id)){
				
				JOptionPane.showMessageDialog(null, "Password 에 ID 가 포함되었습니다. 비밀번호를 다시 입력해주세요");
			    tfSignUpPw.setText("");
				tfSignUpPwConfirm.setText("");
				return;
				
			}
			if(strFirstPw.contains(" ")){
				 JOptionPane.showMessageDialog(null, "Password 에 공백이 포함되었습니다. 비밀번호를 다시 입력해주세요");
				 tfSignUpPw.setText("");
				 tfSignUpPwConfirm.setText("");
				 return;
				
			}
			
			
			if(!matcher.matches()){
				btnPwCheck.setText("Check!");
				return;
				
			}else {
				JOptionPane.showMessageDialog(null,"영문, 숫자, 특수문자 조합, 5~12자리로 비밀번호를 작성해주세요");
				tfSignUpPw.setText("");
				tfSignUpPwConfirm.setText("");
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
			
			btnNewButton.setText("Done!");
			ImageIcon imageIcon = new ImageIcon(selectedImagePath);
			
			Image image = imageIcon.getImage().getScaledInstance(lblSignUpImage.getWidth()+17, lblSignUpImage.getHeight(), Image.SCALE_SMOOTH);
			lblSignUpImage.setIcon(new ImageIcon(image));
			}
	}
}






