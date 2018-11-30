package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTextField;

import eleme.layout;
import model.User;

import java.awt.Panel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;

public class login {

	public static void initialize() {
		JPanel login_panel = layout.loginPanel;
		login_panel.setLayout(null);
		login_panel.setBounds(0, 0, 455, 714);
		if(layout.u_id == 0){
		  //未登录
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{91, 281, 81, 0};
		gridBagLayout.rowHeights = new int[]{124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 279, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		login_panel.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\loginLogo.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		login_panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("手机号");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		login_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		login_panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 8;
		login_panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		

		JPasswordField passwordField  = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 9;
		login_panel.add(passwordField, gbc_passwordField);
		
		Button button = new Button(" sign in");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int u_id = User.signIn(textField.getText(), String.copyValueOf(passwordField.getPassword()));
					if(u_id != 0){
						layout.user = User.getUserByID(u_id);
						layout.u_id = u_id;
//						layout.tabbedPane.remove(3);
//						layout.initialize(22);
						
//						layout.frame.repaint();
					}else{
						JOptionPane.showMessageDialog(
								login_panel,
		                        "用户名或密码错误",
		                        "biu",
		                        JOptionPane.WARNING_MESSAGE
		                );
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		button.setActionCommand("");
		button.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		button.setBackground(new Color(0, 255, 0));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 11;
		login_panel.add(button, gbc_button);
	}else {
		//已经登陆

		
		login_panel.setBounds(0, 0, 474, 842);
		login_panel.setLayout(null);

		JPanel upanel_1 = new JPanel();
		upanel_1.setBackground(new Color(0,153,255));
		upanel_1.setBounds(0, 0, 471, 147);
		login_panel.add(upanel_1);
		upanel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("用户名");
		label_1.setBounds(141, 25, 60, 27);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		upanel_1.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(23, 20, 90, 90);
		label.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\shuiguo.jpg"));
		upanel_1.add(label);
		
		JLabel label_2 = new JLabel("手机号");
		label_2.setBounds(141, 77, 45, 18);
		label_2.setForeground(Color.WHITE);
		upanel_1.add(label_2);
		
		JLabel lblNewLabel = new JLabel(" >");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("个人信息修改页面");
			}
		});
		lblNewLabel.setBounds(392, 48, 34, 34);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 29));
		upanel_1.add(lblNewLabel);
		
		JPanel upanel_2 = new JPanel();
		upanel_2.setBackground(Color.WHITE);
		upanel_2.setBounds(0, 147, 474, 116);
		upanel_1.add(upanel_2);
		upanel_2.setLayout(null);
		
		JLabel label_3 = new JLabel("0.00元");
		label_3.setBounds(38, 28, 76, 27);
		label_3.setFont(new Font("SimSun", Font.BOLD, 23));
		label_3.setForeground(new Color(0,153,255));
		upanel_2.add(label_3);
		
		JLabel label_5 = new JLabel("1个");
		label_5.setBounds(216, 28, 37, 27);
		label_5.setForeground(new Color(255, 69, 0));
		label_5.setFont(new Font("SimSun", Font.BOLD, 23));
		upanel_2.add(label_5);
		
		JLabel label_7 = new JLabel("65个");
		label_7.setBounds(364, 28, 50, 27);
		label_7.setForeground(new Color(50, 205, 50));
		label_7.setFont(new Font("SimSun", Font.BOLD, 23));
		upanel_2.add(label_7);
		
		JLabel label_4 = new JLabel("钱包");
		label_4.setBounds(61, 72, 30, 18);
		upanel_2.add(label_4);
		
		JLabel label_6 = new JLabel("红包");
		label_6.setBounds(219, 72, 30, 18);
		upanel_2.add(label_6);
		
		JLabel label_8 = new JLabel("金币");
		label_8.setBounds(374, 72, 30, 18);
		upanel_2.add(label_8);
		
		JPanel upanel_3 = new JPanel();
		upanel_3.setBackground(new Color(255, 255, 255));
		upanel_3.setBounds(0, 289, 471, 56);
		login_panel.add(upanel_2);
		upanel_3.setLayout(null);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(49, 17, 16, 16);
		label_9.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\地址.png"));
		upanel_3.add(label_9);
		
		JLabel label_10 = new JLabel("我的地址");
		label_10.setBounds(100, 15, 60, 20);
		label_10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		upanel_3.add(label_10);
		
		JLabel label_11 = new JLabel(" > ");
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("修改地址");
			}
		});
		label_11.setBounds(428, 15, 30, 21);
		label_11.setFont(new Font("SimSun", Font.BOLD, 18));
		upanel_3.add(label_11);
		login_panel.add(upanel_3);

		
		JPanel upanel_4 = new JPanel();
		upanel_4.setBackground(Color.WHITE);
		upanel_4.setBounds(0, 358, 474, 56);
		login_panel.add(upanel_4);
		upanel_4.setLayout(null);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(51, 17, 16, 16);
		label_12.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\商城.png"));
		upanel_4.add(label_12);
		
		JLabel label_13 = new JLabel("金币商城");
		label_13.setBounds(102, 15, 60, 20);
		label_13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		upanel_4.add(label_13);
		
		JLabel label_14 = new JLabel(" > ");
		label_14.setBounds(430, 15, 30, 21);
		label_14.setFont(new Font("SimSun", Font.BOLD, 18));
		upanel_4.add(label_14);
		
		JPanel upanel_5 = new JPanel();
		upanel_5.setBackground(Color.WHITE);
		upanel_5.setBounds(0, 415, 474, 56);
		login_panel.add(upanel_5);
		upanel_5.setLayout(null);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(51, 17, 16, 16);
		label_15.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\新手礼包.png"));
		upanel_5.add(label_15);
		
		JLabel label_16 = new JLabel("分享得10元现金");
		label_16.setBounds(102, 15, 108, 20);
		label_16.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		upanel_5.add(label_16);
		
		JLabel label_17 = new JLabel(" > ");
		label_17.setBounds(430, 15, 30, 21);
		label_17.setFont(new Font("SimSun", Font.BOLD, 18));
		upanel_5.add(label_17);
		
		JPanel upanel_6 = new JPanel();
		upanel_6.setBackground(Color.WHITE);
		upanel_6.setBounds(0, 543, 471, 56);
		login_panel.add(upanel_6);
		upanel_6.setLayout(null);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(41, 10, 32, 32);
		label_18.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\饿了么 (2).png"));
		upanel_6.add(label_18);
		
		JLabel lblapp = new JLabel("下载饿了么APP");
		lblapp.setBounds(108, 16, 104, 20);
		lblapp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		upanel_6.add(lblapp);
		
		JLabel label_20 = new JLabel(" > ");
		label_20.setBounds(436, 15, 30, 21);
		label_20.setFont(new Font("SimSun", Font.BOLD, 18));
		upanel_6.add(label_20);
		
		JPanel upanel_7 = new JPanel();
		upanel_7.setBackground(Color.WHITE);
		upanel_7.setBounds(0, 486, 471, 56);
		login_panel.add(upanel_7);
		upanel_7.setLayout(null);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(49, 17, 16, 16);
		label_21.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\客服.png"));
		upanel_7.add(label_21);
		
		JLabel label_22 = new JLabel("我的客服");
		label_22.setBounds(100, 15, 60, 20);
		label_22.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		upanel_7.add(label_22);
		
		JLabel label_23 = new JLabel(" > ");
		label_23.setBounds(428, 15, 30, 21);
		label_23.setFont(new Font("SimSun", Font.BOLD, 18));
		upanel_7.add(label_23);
		
		JPanel upanel_8 = new JPanel();
		upanel_8.setBounds(14, 734, 457, 95);
		login_panel.add(upanel_8);
		upanel_8.setLayout(null);
	}

		
	}
}
