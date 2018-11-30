package model;

import java.util.HashMap;
import java.util.Map;

public class OrderContent {
	private int order_content_id;
	private int good_id;
	private int good_num;
	private int order_id;
	
	public static Map<Integer,Integer> goodMap = new HashMap<Integer,Integer>();
	
	
	public static void initOrderContent(int good_id){
		goodMap.put(good_id,  goodMap.containsKey(good_id)? goodMap.get(good_id)+1 : 1);
	}
		
	
	public int getOrder_content_id() {
		return order_content_id;
	}
	public void setOrder_content_id(int order_content_id) {
		this.order_content_id = order_content_id;
	}
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public int getGood_num() {
		return good_num;
	}
	public void setGood_num(int good_num) {
		this.good_num = good_num;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
}
