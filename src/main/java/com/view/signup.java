package com.view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.JDBC;
import model.User;


public class signup extends JFrame {
	private JLabel ZCaccount = new JLabel("请输入新的用户名");
	private JTextField ZCacc = new JTextField(10);
	private JLabel ZCpassword = new JLabel("请输入密码");
	private JPasswordField ZCpass= new JPasswordField(10);
	private JLabel ZCphone = new JLabel("请输入手机号码");
	private JTextField ZCph= new JTextField(10);
	private JButton QD2 = new JButton("确定");
	private JButton QX2 = new JButton("取消");
	ImageIcon backGround;
	
	public signup()
	{
		 backGround = new ImageIcon("D:/123.jpg");
	       JPanel p = new JPanel();
		   JPanel p2 = new JPanel();
		   p2.setLayout(new GridLayout(4, 1));
		   JLabel b = new JLabel(backGround);
		   
		   b.setBounds(0, 0, backGround.getIconWidth(), backGround.getIconHeight());
		   p = (JPanel) this.getContentPane();
		   p2.add(ZCaccount);
		   ZCaccount.setFont(new Font("宋体", Font.BOLD + Font.ITALIC,16));
		   p2.add(ZCacc);
		   p2.add(ZCpassword);
		   ZCpassword.setFont(new Font("宋体", Font.BOLD + Font.ITALIC,16));
		   p2.add(ZCpass);
		   p2.add(ZCphone);
		   ZCphone.setFont(new Font("宋体", Font.BOLD + Font.ITALIC,16));
		   p2.add(ZCph);
		   p2.add(QD2);
		   p2.add(QX2);
		   p.setOpaque(false);
		   p.setLayout(new FlowLayout());
		   this.getLayeredPane().setLayout(null);
		   this.getContentPane().add(b,new Integer(Integer.MIN_VALUE));
		   p.add(p2);
		   this.setTitle("注册");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setBounds(700, 400, backGround.getIconWidth(),380);
		   this.setVisible(true);
		   
		   QD2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String account = ZCacc.getText();
					String password = String.valueOf(ZCpass.getPassword());
					String phone = ZCph.getText();
					if(chaxun(ZCph.getText())==null) {
					String sql="insert into user (name,password,phone) values('"+account+"','"+password+"','"+phone+"')";
					JDBC.update(sql);
					JOptionPane.showMessageDialog(null, "注册成功");}
					else {
						JOptionPane.showMessageDialog(null, "注册失败");
				}
				}
	        });
			       QX2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.exit(0);
						}
					});
	}
	public User chaxun(String phone)
    {
//    	Connection conn = JDBCdatabase.getConn();
    	User pass = null;
    	try {

 //   		PreparedStatement ps1 = null;
    		String sql = "select * from user where phone = "+phone;
    		if(JDBC.query(sql).next())
    		{
    			pass = new User();
    			pass.setName(JDBC.query(sql).getString("name")); 
    			pass.setU_id(JDBC.query(sql).getInt("u_id"));
    		}
//    		ps1.close();
    	}
    	catch(SQLException e)
    	{
   		e.printStackTrace();
    	}
    	return pass;
    }

public static void main(String[] args) {
	new JDBC();
	new signup();
}

}
