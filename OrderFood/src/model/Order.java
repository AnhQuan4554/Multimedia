package model;

import java.io.Serializable;

public class Order implements Serializable{
	private String	 numberTable;
	private String clientName;
	private double totalPrice;
	public Order() {
		super();
	}
	public Order(String numberTable, String clientName, double totalPrice) {
		super();
		this.numberTable = numberTable;
		this.clientName = clientName;
		this.totalPrice = totalPrice;
	}
	public String getNumberTable() {
		return numberTable;
	}
	public void setNumberTable(String numberTable) {
		this.numberTable = numberTable;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
