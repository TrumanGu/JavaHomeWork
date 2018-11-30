package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Goods {
	private int g_id;
	private int good_category_id;
	private int g_sell_num;
	private String g_name;
	private double g_price ;
	
	public static ArrayList<Goods> getGoodsByOrderID(int order_id) throws SQLException{
		String sql = "SELECT * FROM `goods` a,`order_content` b where a.g_id = b.good_id AND b.order_id= "+ order_id +";";
		ResultSet rs = JDBC.query(sql);
		ArrayList<Goods> list = new ArrayList<Goods>();
		while(rs.next()){
			Goods good = new Goods();
			good.setG_id(rs.getInt("g_id"));
			good.setG_name(rs.getString("g_name"));
			good.setG_price(rs.getDouble("g_price"));
			good.setG_sell_num(rs.getInt("g_sell_num"));
			good.setGood_category_id(rs.getInt("good_category_id"));
			list.add(good);
		}
		return list;
	}
	
	public static ArrayList<Goods> getGoodsByCategoryID(int good_category_id) throws SQLException{
		String sql = "SELECT * FROM `goods` a where a.good_category_id = "+ good_category_id +";";
		ResultSet rs = JDBC.query(sql);
		ArrayList<Goods> list = new ArrayList<Goods>();
		while(rs.next()){
			Goods good = new Goods();
			good.setG_id(rs.getInt("g_id"));
			good.setG_name(rs.getString("g_name"));
			good.setG_price(rs.getDouble("g_price"));
			good.setG_sell_num(rs.getInt("g_sell_num"));
			good.setGood_category_id(rs.getInt("good_category_id"));
			list.add(good);
		}
		return list;
	}
	
	public static Goods getGoodsByID(int g_id) throws SQLException{
		String sql = "SELECT * FROM `goods` where g_id=" + g_id +";";
		ResultSet rs = JDBC.query(sql);
		rs.next();
		Goods good = new Goods();
		good.setG_id(rs.getInt("g_id"));
		good.setG_name(rs.getString("g_name"));
		good.setG_price(rs.getDouble("g_price"));
		good.setG_sell_num(rs.getInt("g_sell_num"));
		good.setGood_category_id(rs.getInt("good_category_id"));
		return good;
	}
	
	
	
	
	
//	public static ArrayList<>
	
	public static void main(String[] args){
		JDBC j = new JDBC();

		try {
			ArrayList<Goods> list = Goods.getGoodsByOrderID(1);
			for(Goods item: list){
				System.out.println(item.getG_name());
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getGood_category_id() {
		return good_category_id;
	}

	public void setGood_category_id(int good_category_id) {
		this.good_category_id = good_category_id;
	}

	public int getG_sell_num() {
		return g_sell_num;
	}

	public void setG_sell_num(int g_sell_num) {
		this.g_sell_num = g_sell_num;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public double getG_price() {
		return g_price;
	}

	public void setG_price(double g_price) {
		this.g_price = g_price;
	}
}


