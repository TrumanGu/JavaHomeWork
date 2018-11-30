package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Merchant {
	private int m_id;
	private String m_name;
	private String m_notice;
	private int merchant_category_id;
	
	public static ArrayList<Merchant> getMerchantList() throws SQLException{
		String sql = "SELECT * FROM merchant";
		ResultSet rs = JDBC.query(sql);
		ArrayList<Merchant> list = new ArrayList<Merchant>();
		while(rs.next()){
			Merchant merchant = new Merchant();
			merchant.setM_id(rs.getInt("m_id"));
			merchant.setM_name(rs.getString("m_name"));
			merchant.setM_notice(rs.getString("m_notice"));
			merchant.setMerchant_category_id(rs.getInt("merchant_category_id"));
			list.add(merchant);
		}
		return list;
	}
	public static Merchant getMerchantById(int ID) throws SQLException{
		String sql = "SELECT * FROM merchant WHERE m_id="+ID+";";
		ResultSet rs = JDBC.query(sql);
		Merchant merchant = new Merchant();
		while(rs.next()){
			merchant.setM_id(rs.getInt("m_id"));
			merchant.setM_name(rs.getString("m_name"));
			merchant.setM_notice(rs.getString("m_notice"));
			merchant.setMerchant_category_id(rs.getInt("merchant_category_id"));
		}
		return merchant;
	}
	public static ArrayList<Merchant> getMerchantByCategoryID(int id) throws SQLException{
		String sql = "SELECT * FROM Merchant where merchant_category_id = "+id+";";
		ResultSet rs = JDBC.query(sql);
		ArrayList<Merchant> list = new ArrayList<Merchant>();
		while(rs.next()){
			Merchant merchant = new Merchant();
			merchant.setM_id(rs.getInt("m_id"));
			merchant.setM_name(rs.getString("m_name"));
			merchant.setM_notice(rs.getString("m_notice"));
			merchant.setMerchant_category_id(rs.getInt("merchant_category_id"));
			list.add(merchant);
		}
		return list;
	}
	
//	public static ArrayList<>getCategoryByMID
	
	
	public static void main(String[] args){
//		try {
//			JDBC j = new JDBC();
//			 ArrayList<GoodCategory> g = GoodCategory.getCategoryByMID(1);
//			for(GoodCategory item : g){
//				System.out.println(item.getName());
//			}
////			Merchant m = Merchant.getMerchantById(1);
////			System.out.println(m.getM_name());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_notice() {
		return m_notice;
	}
	public void setM_notice(String m_notice) {
		this.m_notice = m_notice;
	}
	public int getMerchant_category_id() {
		return merchant_category_id;
	}
	public void setMerchant_category_id(int merchant_category_id) {
		this.merchant_category_id = merchant_category_id;
	}
}




