package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodCategory{
	private int good_category_id;
	private String name;
	private int m_id;
	
	
	public static ArrayList<GoodCategory> getCategoryByMID(int m_id) throws SQLException{
		String sql = "SELECT * FROM `good_category` where m_id ="+ m_id+";";
		ResultSet rs = JDBC.query(sql);
		ArrayList<GoodCategory> list = new ArrayList<GoodCategory>();
		while(rs.next()){
			GoodCategory goodCategory = new GoodCategory();
			goodCategory.setGood_category_id(rs.getInt("good_category_id"));
			goodCategory.setM_id(rs.getInt("m_id"));
			goodCategory.setName(rs.getString("name"));
			list.add(goodCategory);
		}
		return list;
	}
	
	
	
	
	
	public int getGood_category_id() {
		return good_category_id;
	}
	public void setGood_category_id(int good_category_id) {
		this.good_category_id = good_category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	
	
	
	
	
	
	
}
