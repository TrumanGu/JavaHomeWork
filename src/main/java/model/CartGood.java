package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import eleme.layout;

public class CartGood {

	private int cart_goods_id;
	private int good_id;
	private int cart_id;
	private double price;
	
	public static void addGoodByID(int good_id,int m_id){
		//检查商户和个人是否存在购物车
		String sql0 = "SELECT * FROM cart WHERE u_id = "+layout.u_id+" AND m_id = "+ m_id+" ;";
		
		ResultSet rss = JDBC.query(sql0);
		try {
			if(!rss.next()){
				//没有购物车就新建购物车
				String sql1 = "INSERT INTO cart(u_id,m_id) VALUES ("+layout.u_id+","+m_id+")";
				int rs1 = JDBC.update(sql1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//往购物车加商品
		Cart cart = new Cart();
		Goods good = new Goods();
		try {
			cart = Cart.getCartByUserID(layout.u_id,m_id);
			 good = Goods.getGoodsByID(good_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cart_id = cart.getC_id();
		double good_price = good.getG_price();
		
		
		String sql = "INSERT INTO `cart_goods`(good_id, cart_id,price)VALUES("+good_id+","+cart_id+","+good_price+");";
		int rs = JDBC.update(sql);
		
	}
	
	
	public static void main(String[] args){
		CartGood.addGoodByID(1,1);
	}
	
	
	
	
	public int getCart_goods_id() {
		return cart_goods_id;
	}

	public void setCart_goods_id(int cart_goods_id) {
		this.cart_goods_id = cart_goods_id;
	}

	public int getGood_id() {
		return good_id;
	}

	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
