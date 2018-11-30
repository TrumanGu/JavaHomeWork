package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Order {
	private int order_id;
	private int u_id;
	private String created_time;
	private String finish_time;
	private int m_id;
	private int status;
	
	public static ArrayList<Order> getOrderByUserID(int u_id) throws SQLException{
		String sql = "SELECT * FROM `user` a,`order` b where a.u_id = b.u_id AND a.u_id = "+ u_id +" order by created_time desc;";
		ResultSet rs = JDBC.query(sql);
		ArrayList<Order> list = new ArrayList<Order>();
		while(rs.next()){
			Order order = new Order();
			order.setOrder_id(rs.getInt("order_id"));
			order.setU_id(rs.getInt("u_id"));
			order.setCreated_time(rs.getString("created_time"));
			order.setFinish_time(rs.getString("finish_time"));
			order.setStatus(rs.getInt("status"));
			list.add(order);
		}
		return list;
	}
	
	
	public static void initOrder(int u_id,int m_id){
		//先生成一条order记录
		
		String sql0 = "INSERT INTO `order`(u_id,created_time,status,m_id) VALUES ("+ u_id +",TIMESTAMP(now()),0,"+m_id+")";
		int rs = JDBC.update(sql0);

		
	}
	
	public static void initData(int order_id){
		// 再生成数据
		for(Map.Entry<Integer, Integer> goodItem : OrderContent.goodMap.entrySet()){
			String sql1 = "INSERT INTO `order_content`(good_id,good_num,order_id) values("+ goodItem.getKey() +","+goodItem.getValue()+","+order_id+")";
			int rs = JDBC.update(sql1);

		}
	}

//	public static ArrayList<>
	
	public static void main(String[] args){
		JDBC j = new JDBC();

		try {
			ArrayList<Order> list = Order.getOrderByUserID(1);
			for(Order item: list){
				System.out.println(item.getCreated_time());
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
		
	
	
	
	
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}






