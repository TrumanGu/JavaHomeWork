package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private int c_id;
	private int u_id;
	private double total_price;
	
	
	public static Cart getCartByUserID(int id,int m_id) throws SQLException{
		String sql = "SELECT * FROM cart WHERE u_id="+id+" and m_id = "+ m_id+";";
		ResultSet rs = JDBC.query(sql);
		Cart cart = new Cart();
			rs.next();
			cart.setU_id(rs.getInt("u_id"));
			cart.setC_id(rs.getInt("c_id"));
			cart.setTotal_price(rs.getDouble("total_price"));
		return cart;
	}
	
	
	public static Map<String, Integer> getGoodsByUID_MID(int u_id, int m_id){
		ResultSet rrss = JDBC.query("SELECT t3.g_name,count(t3.g_name) as num FROM `cart` t1, `cart_goods` t2, `goods` t3 WHERE t1.m_id = "
				+ m_id
				+ " AND t1.u_id = "
				+ u_id
				+ "AND t2.cart_id = t1.c_id AND t3.g_id = t2.good_id");
		Map<String, Integer> map = new HashMap<String,Integer>();
		try {
			while(rrss.next()){
				map.put(rrss.getString("g_name"), rrss.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public static void CheckOutByUID(int u_id,int m_id){
		
		//拿到购物车中的物品id
		String sql1 = "SELECT * FROM cart_goods t1, cart t2 WHERE t2.c_id = t1.cart_id AND t2.m_id = "+m_id+" AND t2.u_id = "+u_id;
		ResultSet rrs = JDBC.query(sql1);
		try {
			while(rrs.next()){
				OrderContent.initOrderContent(rrs.getInt("good_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//生成订单 并查询到id
		Order.initOrder(u_id, m_id);
		int order_id = 0;
		ResultSet rrss = JDBC.query("SELECT order_id from `order` where u_id="+u_id+" and m_id="+m_id+";");
		try {
			rrss.next();
			order_id = rrss.getInt("order_id");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//生成订单数据
		Order.initData(order_id);
		
		
		
		// 删除购物车中的物品
		String sql = "DELETE FROM cart_goods where cart_id=("
				+ "	SELECT c_id FROM cart WHERE u_id = "+u_id+" and m_id="+m_id
				+ ")";
		int rs = JDBC.update(sql);	

	}
	
	
	
	
	
	public static void main(String[] args){
		JDBC j = new JDBC();

//			Cart m = Cart.getCartByUserID(1,1);
		Cart.CheckOutByUID(1,2);
//			System.out.println(m.getC_id());
}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public int getU_id() {
		return u_id;
	}


	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


	public double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
}