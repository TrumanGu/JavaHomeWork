package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
	private int u_id;
	private String phone;
	private String address;
	private String name;
	private String password;
	
	public static User getUserByID(int u_id) throws SQLException{
		String sql = "SELECT * FROM user where u_id = "+ u_id +";";
		ResultSet rs = JDBC.query(sql);
		rs.next();
			User user = new User();
			user.setU_id(rs.getInt("u_id"));
			user.setAddress(rs.getString("address"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			return user;
		}
	
	public static int signIn(String phone, String password) throws SQLException{
		String sql = "SELECT * FROM `user` where phone = '"+ phone + "' and password = '"+password+"';";
		ResultSet rs = JDBC.query(sql);
		int flag = 0;
		if(rs.next()){
			flag = rs.getInt("u_id");
		}
		return flag;
	}
	
	public boolean save(){
		String sql = 
				"UPDATE user SET phone='"	+ this.phone 	+ "'," +
								"address='"	+ this.address	+ "'," +
								"name='"		+ this.name 	+ "'," +
								"password='" + this.password	+ "'"+
							"WHERE u_id =" 	+ this.u_id 	+ ";";
		try{
			int rs = JDBC.update(sql);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	public static void main(String[] args){
		try {
			JDBC j = new JDBC();
			int m = User.signIn("18851768021", "123qaz...");
//			m.signIn("");
//			m.save();
//			User s = User.getUserByID(1);
			System.out.println(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
