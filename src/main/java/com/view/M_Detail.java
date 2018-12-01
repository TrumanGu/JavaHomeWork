package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import eleme.layout;
import model.Cart;
import model.CartGood;
import model.GoodCategory;
import model.Goods;
import model.Merchant;
import model.Order;

public class M_Detail {
	public static void handleOrder(int u_id, int m_id){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(32, 203, 113, 27);
//		frame.getContentPane().add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("New button");
//		btnNewButton_1.setBounds(254, 203, 113, 27);
//		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 50, 379, 138);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		Map<String, Integer> goodList = Cart.getGoodsByUID_MID(layout.u_id, m_id);
		for(Map.Entry<String, Integer> entry : goodList.entrySet()){
			
			panel.add(new JLabel(entry.getKey()+ " : "+ entry.getValue()));
			
		}
		panel.setPreferredSize(new Dimension(402, 200));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("您的购物车里有如下商品          确定结帐吗？");
		lblNewLabel_1.setBounds(14, 13, 393, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		panel.add(new JLabel("确定要结帐吗？"));
		JButton jb1 = new JButton("结帐");
		JButton jb2 = new JButton("取消");
		jb1.setBounds(32, 203, 113, 27);
		jb2.setBounds(254, 203, 113, 27);

		frame.getContentPane().add(jb1);
		frame.getContentPane().add(jb2);

		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO:账户余额检查
				Cart.CheckOutByUID(layout.u_id, m_id);

				//TODO：关闭当前窗口
				frame.dispose();
			}
		});
		
		
		

	}
	public static void initialize(int m_id) {
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 474, 842);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 456, 704);
		panel.add(scrollPane);
		

		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 433, 213);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\daigou.jpg"));
		label.setBounds(162, 45, 90, 69);
		panel_2.add(label);
		
		Merchant m = new Merchant();
		try {
			m = Merchant.getMerchantById(m_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel label_1 = new JLabel(m.getM_name());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("SimSun", Font.BOLD, 20));
		label_1.setBounds(0, 116, 419, 35);
		panel_2.add(label_1);
		
		JLabel lblNewLabel = new JLabel("商家公告");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 153, 433, 18);
		panel_2.add(lblNewLabel);
		
		
		JButton button_1 = new JButton("下单");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(layout.u_id == 0){
					JOptionPane.showMessageDialog(
							panel_1,
	                        "您还没有登录",
	                        "biu",
	                        JOptionPane.WARNING_MESSAGE
	                );
					
				}else{
				handleOrder(layout.u_id,m_id);
			}
				}
		});
		button_1.setBounds(0, 0, 113, 42);
		panel_1.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 212, 433, 490);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(0, 0, 433, 490);
		panel_3.add(tabbedPane);
		ArrayList<GoodCategory> list = new ArrayList<GoodCategory>();
		try {
			Merchant merchant =  Merchant.getMerchantById(m_id);
			list = GoodCategory.getCategoryByMID(m_id); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(GoodCategory item: list){
			JPanel goodListPanel = new JPanel();
			goodListPanel.setLayout(new BoxLayout(goodListPanel, BoxLayout.Y_AXIS));
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(0, 0, 319, 477);
			goodListPanel.setPreferredSize(new Dimension(500,800));
			scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane1.setViewportView(goodListPanel);
			System.out.println(item.getGood_category_id());

			for( JPanel jpItem : initGoodItem(item.getGood_category_id(),m_id)){
				goodListPanel.add(jpItem);
			}
			
	        tabbedPane.addTab(item.getName(), scrollPane1);
		}
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setBounds(100, 100, 483, 841);
	}
	
	public static ArrayList<JPanel> initGoodItem(int cactegory_id, int m_id){
		
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			list = Goods.getGoodsByCategoryID(cactegory_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<JPanel> panelList = new ArrayList<JPanel>();
		for( Goods item : list){
			JPanel good_item = new JPanel();
			good_item.setBounds(0, 0, 319, 126);
			GridBagLayout gbl_good_item = new GridBagLayout();
			gbl_good_item.columnWidths = new int[]{54, 53, 162, 50, 0};
			gbl_good_item.rowHeights = new int[]{55, 45, 0, 0};
			gbl_good_item.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_good_item.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			good_item.setLayout(gbl_good_item);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\chaoshi.jpg"));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.gridheight = 2;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 0;
			good_item.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			JLabel label_2 = new JLabel(item.getG_name());
			label_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.WEST;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 2;
			gbc_label_2.gridy = 0;
			good_item.add(label_2, gbc_label_2);
			
			JLabel label_3 = new JLabel("月售"+ item.getG_sell_num()+"份");
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.anchor = GridBagConstraints.WEST;
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 2;
			gbc_label_3.gridy = 1;
			good_item.add(label_3, gbc_label_3);
			
			
			
			
			JButton button = new JButton("+");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(layout.u_id == 0){
						JOptionPane.showMessageDialog(
								good_item,
		                        "您还没有登录",
		                        "biu",
		                        JOptionPane.WARNING_MESSAGE
		                );
						
					}else{
						CartGood.addGoodByID(item.getG_id(),m_id);
					}
				}
			});
			button.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
			button.setBackground(UIManager.getColor("TextField.selectionBackground"));
			button.setForeground(new Color(255, 255, 255));
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 5, 0);
			gbc_button.gridx = 3;
			gbc_button.gridy = 1;
			good_item.add(button, gbc_button);
			
			JLabel label_4 = new JLabel("￥"+ item.getG_price()+"起");
			label_4.setForeground(new Color(255, 69, 0));
			label_4.setFont(new Font("SimSun", Font.BOLD, 16));
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.anchor = GridBagConstraints.WEST;
			gbc_label_4.insets = new Insets(0, 0, 0, 5);
			gbc_label_4.gridx = 2;
			gbc_label_4.gridy = 2;
			good_item.add(label_4, gbc_label_4);
			
			panelList.add(good_item);
		}
		
		return panelList;
	}
}
