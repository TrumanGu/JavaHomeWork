package com.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class cartUnit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cartUnit window = new cartUnit();
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
	public cartUnit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(32, 203, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(254, 203, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 50, 379, 138);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		
		for(int i = 0 ; i<10 ;i++){
//
//			JPanel panel_1 = new JPanel();
//			panel.add(panel_1);
//			panel_1.setLayout(null);
//			
//			JLabel lblNewLabel = new JLabel("New label");
//			lblNewLabel.setBounds(14, 13, 402, 30);
			panel.add(new JLabel("New label"));
			
		}
		panel.setPreferredSize(new Dimension(402, 200));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("您的购物车里有如下商品          确定结帐吗？");
		lblNewLabel_1.setBounds(14, 13, 393, 18);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
