package com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import eleme.layout;
import model.Merchant;

public class index {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		JPanel index_panel = layout.indexPanel;
		index_panel.setBounds(0, 0, 455, 900);
		index_panel.setBackground(Color.BLACK);		
		index_panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 455, 714);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 432, 99);
		panel_3.setBackground(new Color(0, 153, 255));
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		JTextField textField;

		textField = new JTextField();
		textField.setForeground(new Color(153, 153, 153));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u641C\u7D22\u997F\u4E86\u4E48\u5546\u5BB6\u3001\u5546\u54C1\u540D\u79F0");
		textField.setBounds(14, 38, 295, 48);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("南京市");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 23));
		lblNewLabel.setBounds(14, 0, 381, 43);
		panel_3.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.setBounds(320, 38, 75, 48);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 100, 432, 178);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 87, 64);
		
		
		ImageIcon icon=new ImageIcon("C:/Users/Administrator/Desktop/meishi.jpg");
		panel.setLayout(null);
		
		
		panel_4.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\wancanjpg.jpg"));
		lblNewLabel_2.setBounds(0, 0, 87, 64);
		panel.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(86, 0, 87, 64);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\wancan.jpg"));
		lblNewLabel_1.setBounds(0, 0, 87, 64);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(173, 0, 87, 64);
		panel_4.add(panel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\chaoshi.jpg"));
		lblNewLabel_3.setBounds(0, 0, 87, 64);
		panel_6.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(257, 0, 87, 64);
		panel_4.add(panel_7);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\shuiguo.jpg"));
		lblNewLabel_4.setBounds(0, 0, 87, 64);
		panel_7.add(lblNewLabel_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(345, 0, 87, 64);
		panel_4.add(panel_8);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\yiyao.jpg"));
		label_10.setBounds(0, 0, 87, 64);
		panel_8.add(label_10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(345, 88, 87, 64);
		panel_4.add(panel_9);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\zhaji.jpg"));
		label_14.setBounds(0, 0, 87, 64);
		panel_9.add(label_14);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(257, 88, 87, 64);
		panel_4.add(panel_10);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\yinpin.jpg"));
		label_13.setBounds(0, 0, 87, 64);
		panel_10.add(label_13);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(173, 88, 87, 64);
		panel_4.add(panel_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\daigou.jpg"));
		label_12.setBounds(0, 0, 87, 64);
		panel_11.add(label_12);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBounds(86, 88, 87, 64);
		panel_4.add(panel_12);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\shengxian.jpg"));
		label_11.setBounds(0, 0, 87, 64);
		panel_12.add(label_11);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(0, 88, 87, 64);
		panel_4.add(panel_13);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\xianhua.jpg"));
		lblNewLabel_5.setBounds(0, 0, 87, 64);
		panel_13.add(lblNewLabel_5);
		
		JLabel label = new JLabel("\u7F8E\u98DF");
		label.setForeground(new Color(51, 51, 51));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 66, 87, 18);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("\u665A\u9910");
		label_1.setForeground(new Color(51, 51, 51));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(86, 66, 87, 18);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("\u6C34\u679C");
		label_2.setForeground(new Color(51, 51, 51));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(259, 66, 87, 18);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("\u8D85\u5E02\u4FBF\u5229");
		label_3.setForeground(new Color(51, 51, 51));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(173, 66, 87, 18);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("\u533B\u836F\u5065\u5EB7");
		label_4.setForeground(new Color(51, 51, 51));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(345, 66, 87, 18);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("\u70B8\u9E21\u70B8\u4E32");
		label_5.setForeground(new Color(51, 51, 51));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(345, 160, 87, 18);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("\u6D6A\u6F2B\u9C9C\u82B1");
		label_6.setForeground(new Color(51, 51, 51));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 160, 87, 18);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("\u53A8\u623F\u751F\u9C9C");
		label_7.setForeground(new Color(51, 51, 51));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(86, 160, 87, 18);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("\u8DD1\u817F\u4EE3\u8D2D");
		label_8.setForeground(new Color(51, 51, 51));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(173, 160, 87, 18);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("\u751C\u54C1\u996E\u54C1");
		label_9.setForeground(new Color(51, 51, 51));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(259, 160, 87, 18);
		panel_4.add(label_9);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 279, 209, 172);
		panel_14.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_15 = new JLabel("\u54C1\u8D28\u5957\u9910");
		label_15.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		label_15.setBounds(14, 13, 90, 27);
		panel_14.add(label_15);
		
		JLabel label_16 = new JLabel("\u642D\u914D\u9F50\u5168\u5403\u5F97\u597D");
		label_16.setForeground(new Color(51, 51, 51));
		label_16.setBounds(14, 44, 120, 18);
		panel_14.add(label_16);
		
		JLabel label_17 = new JLabel("\u7ACB\u5373\u62A2\u8D2D >");
		label_17.setFont(new Font("SimSun", Font.BOLD, 15));
		label_17.setForeground(new Color(204, 153, 0));
		label_17.setBounds(14, 67, 101, 18);
		panel_14.add(label_17);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\pingzhitaocan.jpg"));
		lblNewLabel_6.setBounds(38, 61, 240, 160);
		panel_14.add(lblNewLabel_6);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(223, 279, 209, 172);
		panel_15.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\xianliang.jpg"));
		lblNewLabel_7.setBounds(103, 72, 106, 100);
		panel_15.add(lblNewLabel_7);
		
		JLabel label_18 = new JLabel("\u9650\u91CF\u62A2\u8D2D");
		label_18.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		label_18.setBounds(14, 13, 123, 26);
		panel_15.add(label_18);
		
		JLabel label_30 = new JLabel("\u8D85\u503C\u7F8E\u54739.9\u5143\u8D77");
		label_30.setBounds(14, 41, 123, 18);
		panel_15.add(label_30);
		
		JLabel label_31 = new JLabel("\u7ACB\u5373\u62A2\u8D2D >");
		label_31.setForeground(new Color(204, 153, 0));
		label_31.setFont(new Font("SimSun", Font.BOLD, 15));
		label_31.setBounds(14, 61, 101, 18);
		panel_15.add(label_31);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(0, 464, 432, 104);
		panel_2.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\banner.jpg"));
		label_19.setBounds(0, 0, 432, 103);
		panel_16.add(label_19);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(0, 581, 432, 33);
		panel_17.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel label_21 = new JLabel("-   \u63A8\u8350\u5546\u5BB6   -");
		label_21.setFont(new Font("SimSun", Font.PLAIN, 18));
		label_21.setBounds(138, 0, 175, 33);
		panel_17.add(label_21);
		
		JLabel label_22 = new JLabel("\u7EFC\u5408\u6392\u5E8F ");
		label_22.setBounds(0, 613, 102, 33);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		panel_2.add(label_22);
		
		JLabel label_23 = new JLabel("\u8DDD\u79BB\u6700\u8FD1");
		label_23.setBounds(107, 613, 102, 33);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		panel_2.add(label_23);
		
		JLabel label_24 = new JLabel("\u54C1\u8D28\u8054\u76DF");
		label_24.setBounds(207, 613, 102, 33);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		panel_2.add(label_24);
		
		JLabel label_25 = new JLabel("\u7B5B\u9009");
		label_25.setBounds(316, 613, 102, 33);
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		panel_2.add(label_25);
		
		
		JPanel merchantListPanel = new JPanel();
		panel_2.add(merchantListPanel);
		merchantListPanel.setLayout(new BoxLayout(merchantListPanel, BoxLayout.Y_AXIS));
		int singleHeight = 0;
		for(JPanel item : M_item.getItemList()){
			merchantListPanel.add(item);
			singleHeight += 150;
		}
		merchantListPanel.setBounds(0, 680, 429,singleHeight);
		panel_2.setPreferredSize(new Dimension(500,singleHeight+800));
		scrollPane.setViewportView(panel_2);

		index_panel.add(scrollPane);
		index_panel.repaint();
	}

}




class M_item{
	static public ArrayList<JPanel> getItemList(){
		ArrayList<Merchant> list = null;
		try {
			list = Merchant.getMerchantList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<JPanel> panelList = new ArrayList<JPanel>();
		for(Merchant item:list){
			JPanel frame = new JPanel();
			frame.setBackground(Color.WHITE);
			frame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JPanel p = ((JPanel)arg0.getComponent());
					Component comp = p.getComponent(5);
					int m_id = Integer.parseInt((((JLabel) comp).getText()));
					System.out.println(m_id);
					M_Detail.initialize(m_id);
				}
			});
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{127, 174, 0, 0};
			gridBagLayout.rowHeights = new int[]{25, 5, 29, 0, 0, 32, 0};
			gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			frame.setLayout(gridBagLayout);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.gridheight = 3;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 0;
			frame.add(panel_1, gbc_panel_1);
			
			JLabel label = new JLabel(" ");
			label.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\daigou.jpg"));
			panel_1.add(label);
			
			JLabel label_1 = new JLabel(item.getM_name());
			label_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 0;
			frame.add(label_1, gbc_label_1);
			
			JLabel label_2 = new JLabel("月售****单");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 1;
			gbc_label_2.gridy = 1;
			frame.add(label_2, gbc_label_2);
			
			JLabel lblkm = new JLabel("**km");
			GridBagConstraints gbc_lblkm = new GridBagConstraints();
			gbc_lblkm.insets = new Insets(0, 0, 5, 0);
			gbc_lblkm.gridx = 2;
			gbc_lblkm.gridy = 1;
			frame.add(lblkm, gbc_lblkm);
			
			JLabel label_3 = new JLabel("￥**起送 配送费￥*");
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 1;
			gbc_label_3.gridy = 2;
			frame.add(label_3, gbc_label_3);
			
			JLabel lblNewLabel = new JLabel(""+item.getM_id());
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(Color.WHITE);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 3;
			frame.add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblfghjmngvhgyuihjkj = new JLabel("满FGHJMNGVHGYUIHJKJ");
			GridBagConstraints gbc_lblfghjmngvhgyuihjkj = new GridBagConstraints();
			gbc_lblfghjmngvhgyuihjkj.insets = new Insets(0, 0, 5, 5);
			gbc_lblfghjmngvhgyuihjkj.gridx = 1;
			gbc_lblfghjmngvhgyuihjkj.gridy = 4;
			frame.add(lblfghjmngvhgyuihjkj, gbc_lblfghjmngvhgyuihjkj);
			
			JLabel label_4 = new JLabel("超级会员蛄蛤经常洒出");
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.insets = new Insets(0, 0, 0, 5);
			gbc_label_4.gridx = 1;
			gbc_label_4.gridy = 5;
			frame.add(label_4, gbc_label_4);
//			System.out.println(frame);
			panelList.add(frame);
		}
		return panelList;
		
		
	}
}