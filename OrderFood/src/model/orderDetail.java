package model;

import java.io.Serializable;

public class orderDetail implements Serializable{
	private String	 numberTable;
	private String foodName;
	private double quantity;
	private double price;
	public orderDetail() {
		super();
	}
	public orderDetail(String numberTable, String foodName, double quantity, double price) {
		super();
		this.numberTable = numberTable;
		this.foodName = foodName;
		this.quantity = quantity;
		this.price = price;
	}
	public String getNumberTable() {
		return numberTable;
	}
	public void setNumberTable(String numberTable) {
		this.numberTable = numberTable;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
