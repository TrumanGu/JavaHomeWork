package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import eleme.layout;
import model.JDBC;
import model.Merchant;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class MerchantList {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBC j = new JDBC();
					MerchantList window = new MerchantList();
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
	public MerchantList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 467, 680);
		layout.MerchantPanel.setLayout(null);
		layout.MerchantPanel.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		ArrayList<Merchant> list = null;
		try {
			list = Merchant.getMerchantList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int height = 140;
		for(Merchant m_item: list){

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel.add(panel_1);
			panel_1.setBounds(0, 0, 466, 140);
			panel_1.setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\daigou.jpg"));
			label.setBounds(29, 28, 90, 90);
			panel_1.add(label);
			
			JLabel label_1 = new JLabel(m_item.getM_name());
			label_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
			label_1.setBounds(149, 28, 179, 28);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("月售"+ m_item.hashCode() +"单");
			label_2.setForeground(Color.DARK_GRAY);
			label_2.setBounds(147, 81, 84, 18);
			panel_1.add(label_2);
			
			JLabel lblNewLabel = new JLabel("距离**km");
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setBounds(357, 81, 72, 18);
			panel_1.add(lblNewLabel);
			
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
//					System.out.println(m_item.getM_id());
					M_Detail.initialize(m_item.getM_id());
				}
			});
			
			height += 140;
		}
		panel.setPreferredSize(new Dimension(483,height));

	}
	
	
}
