package eleme;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JMenuItem;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.view.M_Detail;
import com.view.MerchantList;
import com.view.index;
import com.view.login;
import com.view.order;

import model.JDBC;
import model.Merchant;
import model.User;

import javax.swing.JTabbedPane;

public class layout {

	public static JFrame frame;
	public static JTabbedPane tabbedPane;
	
	public static JPanel indexPanel = new JPanel();
	public static JPanel loginPanel = new JPanel();
	public static JPanel MerchantPanel = new JPanel();
	public static JPanel orderPanel = new JPanel();
	
	public static User user;
	public static int u_id = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDBC j = new JDBC();
					layout window = new layout();
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
	public layout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 483, 841);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		int w = 80,h = 80;
		ImageIcon icon1 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\changyonglogo40.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\caigou.png");
		ImageIcon icon3 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\dingdan.png");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\Administrator\\Desktop\\static\\gerensvg.png");
		icon1.setImage(icon1.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT));
		icon2.setImage(icon2.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT));
		icon3.setImage(icon3.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT));
		icon4.setImage(icon4.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT));

		tabbedPane.addTab("",icon1,indexPanel);
		tabbedPane.addTab("",icon2,MerchantPanel);
		tabbedPane.addTab("",icon3,orderPanel);
		tabbedPane.addTab("",icon4,loginPanel);

		
		// 初始化监听器
		tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
                loginPanel.removeAll();
                MerchantPanel.removeAll();
                indexPanel.removeAll();
                orderPanel.removeAll();
                
                index.initialize();
                login.initialize();
                MerchantList.initialize();
                order.initialize();
            }
        });
		frame.setContentPane(tabbedPane);
		}

}




