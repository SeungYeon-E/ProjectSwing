package com.test.design;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.test.layout.Login;

public class ControlCenter {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login loginwindow = new Login();
					loginwindow.run();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
