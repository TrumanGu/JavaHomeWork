package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import eleme.layout;
import model.Merchant;
import model.Order;

public class order {
	public static void initialize(){
	JPanel order_panel = layout.orderPanel;
	order_panel.setLayout(null);
	order_panel.setBounds(0, 0, 455, 900);
			
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane.setBounds(0, 0, 456, 795);
	
	JPanel panel = new JPanel();

	scrollPane.setViewportView(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	panel.setPreferredSize(new Dimension(470,600));
	ArrayList<Order> orderList = new ArrayList<Order>();
	try {
		orderList = Order.getOrderByUserID(layout.u_id);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	if(layout.u_id == 0){
		order_panel.setLayout(new FlowLayout());
		order_panel.add(new JLabel("您还没有登录"));
	}
	
	for(Order item : orderList){
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(100, 100, 474, 477);
		JPanel panel9 = new JPanel();
		panel9.setBounds(0, 0, 456, 124);
		orderPanel.add(panel9);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 264, 0, 0};
		gbl_panel.rowHeights = new int[]{46, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel9.setLayout(gbl_panel);
		int m_id = item.getM_id();
		Merchant m = new Merchant();
		try {
			m = Merchant.getMerchantById(m_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel(m.getM_name());
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\chaoshi.jpg"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel9.add(lblNewLabel, gbc_lblNewLabel);
		
		
		
		JLabel label = new JLabel(m.getM_name());
		label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel9.add(label, gbc_label);
		
		JLabel label_2 = new JLabel(item.getStatus()==0? "未送达":"已送达");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		panel9.add(label_2, gbc_label_2);
		
		JLabel lblNewLabel_1 = new JLabel(item.getCreated_time());
		lblNewLabel_1.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel9.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel label_1 = new JLabel("***等商品");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		panel9.add(label_1, gbc_label_1);
		
		JLabel label_3 = new JLabel("￥"+ "测试"+"总价");
		label_3.setFont(new Font("SimSun", Font.BOLD, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 3;
		panel9.add(label_3, gbc_label_3);

		panel.add(orderPanel);
	}
	order_panel.add(scrollPane);

		
	}
}
