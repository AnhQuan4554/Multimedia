package model;

import java.io.Serializable;

public class Food implements Serializable{
	private String	 idFood;
	private String foodName;
	private String des;
	private double price;
	
	public Food() {
		super();
	}

	public Food(String idFood, String foodName, String des, double price) {
		super();
		this.idFood = idFood;
		this.foodName = foodName;
		this.des = des;
		this.price = price;
	}

	public String getIdFood() {
		return idFood;
	}

	public void setIdFood(String idFood) {
		this.idFood = idFood;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
